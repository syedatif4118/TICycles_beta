package com.example.ti_barcodescan;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inspection extends AppCompatActivity {

    Button home_btn, save, click;
    ProgressDialog progressDialog;
    Connection connect, wms_connect;

    Switch nok_1;
    TextView date_ins, vin, inspec_list, model_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_inspection);
        vin = (TextView) findViewById(R.id.vin_ins);
        home_btn = findViewById(R.id.home_btn_ins);
        inspec_list = findViewById(R.id.inspec_list_name);
        nok_1 = findViewById(R.id.nok_1);
        save = findViewById(R.id.ins_save);
        model_code = findViewById(R.id.model_code);
        click = findViewById(R.id.click);


        //vin textView
        Intent receive = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);


        //Date and Time
        date_ins = findViewById(R.id.date_ins);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                long datet = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                String dateString = sdf.format(datet);
                                date_ins.setText(dateString);
                            }
                        });
                    }

                } catch (Exception e) {

                }
            }
        };
        t.start();

        //Calling the listview and Displaying it
        ListAdapter adap = GetInspList();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch_model_code();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                click.performClick();
            }
        }, 1000);


        //Home Button
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_q();
            }
        });

        //save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
                defect_check();
                Toast.makeText(Inspection.this, "Saved", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });


    }

    // Dynamically adding Inspection Names to Listview and performing onCLick on Switch
    public ListAdapter GetInspList() {
        ArrayList<Integer> pos = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.inspection_listview_1);
        List<Map<String, String>> MyDataList = getinspectionlist();

        // String[] f = {"Inspection_Name", "Button"};
        //int[] i = {R.id.inspec_list_name, R.id.nok_1};

        String[] f = {"Inspection_Name"};
        int[] i = {R.id.inspec_list_name};


        final int[] popo = {0};
        SimpleAdapter ad = new SimpleAdapter(this, MyDataList, R.layout.inspection_listview, f, i) {
            @Override

            public int getViewTypeCount() {

                return getCount();
            }

            @Override
            public int getItemViewType(int position) {

                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                nok_1 = v.findViewById(R.id.nok_1);
               // nok_1.setTextOff("1");
                //nok_1.setTextOn("2");

                nok_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            Log.e("here", MyDataList.get(position).get("Inspection_Name"));


                            String d = (String) MyDataList.get(position).get("Inspection_Name");

                            String vinno = vin.getText().toString().trim();

                            String inspname = d;


                            Bundle bundle = new Bundle();
                            bundle.putString("vinno", vinno);
                            bundle.putString("inspname", inspname);
                            Intent intent = new Intent(Inspection.this, NOK_inspection.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            progress();
                        }
                        else{
                            Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                return v;

            }
        };
        listView.setAdapter(ad);
        ad.notifyDataSetChanged();


        return listView.getAdapter();
    }


    // Fetching Inspection Names from the database
    public List<Map<String, String>> getinspectionlist() {

        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query = "select * from Config_Inspection";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Map<String, String> dtname = new HashMap<String, String>();
                    dtname.put("Inspection_Name", rs.getString("InspectionName"));
                    // dtname.put("Inspection_Id", rs.getString(2));
                    // dtname.put("Activity_Value", rs.getString(7));

                    data.add(dtname);
                }
            }

        } catch (Exception ex) {
        }
        return data;

    }


    // Home Button Method
    public void home_q() {
        if (!nok_1.isClickable()) {

            onBackPressed();

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(Inspection.this);
            builder.setMessage("Complete the Inspection!!!").
                    setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).setTitle("Alert!")
                    .setIcon(R.drawable.warning);
            AlertDialog alert = builder.create();
           // alert.show();
            builder.show();
        }
    }

    // saving to MES Database
    public void save() {
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String query_3 = "Exec [dbo].[EOLSave] '" + vin.getText().toString() + "'";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (Exception e) {
            Log.e("msg", "ERROR in save");

        }
    }

    // Progress Dialog
    public void progress() {
        progressDialog = new ProgressDialog(Inspection.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog_load);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 1000);

    }

    //Fetching ModelCode from ProductionOrderWIP table
    public void fetch_model_code() {
        try {
             //Connection_WMS connection_wms = new Connection_WMS();
          //  wms_connect = connection_wms.wms_connection();

           ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            String query = "select * from ProductionOrderWIP where Serial_No ='" + vin.getText().toString() + "'";
            //String query = "select * from Genealogy";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                model_code.setText(rs.getString(4));
            }

        } catch (Exception e) {
            Log.e("here", "Error in Fetching to WMS");
        }

    }


    //Method to save in WMS Database
    public void save_to_WMS() {
        try {
            Connection_WMS connection_wms = new Connection_WMS();
            wms_connect = connection_wms.wms_connectionClass();
           // ConnectionHelper connectionHelper = new ConnectionHelper();
           // connect = connectionHelper.connectionClass();

            String query_3 = "insert into WMSShopWiseFG (VINNumber,ShopId,FG_Model_Code,Quantity,Status) values('" + vin.getText().toString() + "',6,'" + model_code.getText().toString() + "',1,0)";
            //String query_3 = "Select * from WMSShopWiseFG";
            PreparedStatement preparedStatement = wms_connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //Log.e("here",get(query_3));

        } catch (Exception e) {
            Log.e("here", e.toString());
        }
    }


    // Method to check if there are active defects before saving it to WMS Database
    public void defect_check() {
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query = "SELECT count(*) FROM DefectLog where Status = 2 and Serial_No ='" + vin.getText().toString() + "' ";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                rs.next();
                int count = rs.getInt(1);
                rs.close();
                if (count == 0) {
                    save_to_WMS();

                } else {
                }
            }
        } catch (Exception ex) {

        }


    }
}