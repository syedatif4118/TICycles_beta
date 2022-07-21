package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Defect_list extends AppCompatActivity {

    // SimpleAdapter ad;
    ListView defect_listview;
    ImageView trash;


    Connection connect;
    Button home_btn_dft, click, clear;
    TextView date, vin, dcol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_defect_list);

        date = findViewById(R.id.date_dft);
        dcol = findViewById(R.id.dcol_2);
        defect_listview = findViewById(R.id.defect_listview);

        //vin textView
        vin = findViewById(R.id.vin_dft);
        Intent receive = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);

        //date and time
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
                                date.setText(dateString);
                            }
                        });
                    }

                } catch (Exception e) {

                }
            }
        };
        t.start();


// Home Button OnClick
        home_btn_dft = findViewById(R.id.home_btn_dft);
        home_btn_dft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

// Auto Click
        ListAdapter adap = GetdefectList();

        click = findViewById(R.id.click);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                click.performClick();
            }
        }, 1000);


    }

    // Home Button
    private void home() {
        Intent send = new Intent(Defect_list.this, BarcodeScan.class);
        send.putExtra("KEY_SEND", vin.getText().toString());
        startActivity(send);

    }

    // Adding Table Columns in List View, Removing the list when clicked clear button and Updating the Database
    public ListAdapter GetdefectList() {
        ArrayList<Integer> pos = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.defect_listview);
        List<Map<String, String>> MyDataList = getdefectlist();

        String[] f = {"Defect_Id", "Defect_Name","Remarks","Button"};
        int[] i = {R.id.dcol_3, R.id.dcol_1,R.id.dcol_2, R.id.clear_1};
        SimpleAdapter ad;
        final int[] popo = {0};
        ad = new SimpleAdapter(this, MyDataList, R.layout.listview_defect, f, i) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                clear = v.findViewById(R.id.clear_1);
                clear.setText("Clear");
                clear.setOnClickListener(arg0 -> {
                    // TODO Auto-generated method stub
                    ListAdapter add = listView.getAdapter();
                    listView.setAdapter(add);
                 //   Log.e("here", MyDataList.get(position).get("Activity_Name"));
                    String d = MyDataList.get(position).get("Defect_Id");
                    Boolean j = clear_defects("Update DefectLog set Status = 1 where DefectId =" + d + "");
                    MyDataList.remove(position);
                    Toast.makeText(Defect_list.this, "Cleared", Toast.LENGTH_SHORT).show();
                });

                return v;
            }
        };
        listView.setAdapter(ad);
        ad.notifyDataSetChanged();


        return listView.getAdapter();
    }


    //Fetching Table Columns from the Database
    public List<Map<String, String>> getdefectlist() {

        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                //String query = "select * from DefectLog where Serial_No ='" + vin.getText().toString() + "' and Status = 2";
                String query = "select * from Config_Defect as Defect join DefectLog as DLog on Defect.DefectId = DLog.DefectId where DLog.Serial_No = '"+vin.getText().toString()+"' and Status =2";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Map<String, String> dtname = new HashMap<String, String>();
                    dtname.put("Defect_Name", rs.getString("DefectName"));
                    dtname.put("Remarks", rs.getString("Remarks"));
                    dtname.put("Defect_Id", rs.getString("DefectId"));

                    data.add(dtname);


                }


            }


        } catch (Exception ex) {

        }
        return data;

    }

    //Clear Button Method
    public Boolean clear_defects(String Query) {
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String sqlinsert = Query;
            Statement st = connect.createStatement();
            boolean rs = st.execute(sqlinsert);
            return rs;

        } catch (Exception e) {


        }
        return null;
    }


}