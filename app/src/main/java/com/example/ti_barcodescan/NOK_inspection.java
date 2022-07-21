package com.example.ti_barcodescan;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NOK_inspection extends AppCompatActivity {
    Button save, info;
    TextView date, vin, inspection_name, inspec_id, defect_id, reworktype_id;
    Spinner spinner, spinner_2;
    Connection connect;
    EditText remark;
    SaveToDefectLog saveToDefectLog;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_nok_inspection);
        inspection_name = findViewById(R.id.inspection_name);
        date = findViewById(R.id.date_nok);

        inspec_id = findViewById(R.id.inspec_id);
        defect_id = findViewById(R.id.defect_id);
        reworktype_id = findViewById(R.id.reworktype_id);
        remark = findViewById(R.id.remark);

        //vin textview
        vin = findViewById(R.id.vin_nok);

// Second Drop Down
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rework, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_2.setAdapter(adapter);

// Receiving the Intent from other activity (TextViews)
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String vinno = bundle.getString("vinno");
            String inspname = bundle.getString("inspname");
            vin.setText(vinno);
            inspection_name.setText(inspname);
        }

        //DropDown
        spinner = findViewById(R.id.spinner);
        FillSpinner();


// Fetching InspectionID DefectID and ReworkTypeID while TextChange
        remark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               // get_info();

            }
        });

// Executing AsyncTask class on Button CLick
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveToDefectLog = new SaveToDefectLog();
                saveToDefectLog.execute();


            }

        });


        //date and time text view
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


    }


    // Fetching and Adding Defect Names in DropDown
    public void FillSpinner() {
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query = "select * from Config_Defect as Defect join Config_Inspection as Inspection on Defect.InspectionId = Inspection.InspectionId where Inspection.InspectionName ='" + inspection_name.getText().toString() + "'";
                // String query = " select DefectName from Config_Defect as Defect join Config_Inspection as Inspection on Defect.InspectionId = Inspection.InspectionId where Inspection.InspectionName = 'VIN PUNCHING NUMBER APPLICATION'";

                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);


                ArrayList<String> data = new ArrayList<String>();
                while (rs.next()) {
                    String name = rs.getString("DefectName");
                    data.add(name);

                }

                ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
                spinner.setAdapter(array);

            }

        } catch (Exception e) {

        }

    }


    //Fetching ReworkTypeID, InspectiontID, DefectID from Database and adding it to Textview
    public void get_info() {

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query_1 = "select * from Rework_Type where ReworkTypeName ='" + spinner_2.getSelectedItem().toString() + "'";
                String query_2 = "select InspectionId,DefectId from Config_Defect where DefectName ='" + spinner.getSelectedItem().toString() + "'";

                Statement st_1 = connect.createStatement();
                ResultSet rs_1 = st_1.executeQuery(query_1);

                Statement st_2 = connect.createStatement();
                ResultSet rs_2 = st_2.executeQuery(query_2);

                while (rs_1.next()) {
                    reworktype_id.setText(rs_1.getString(1));
                }

                while (rs_2.next()) {
                    inspec_id.setText(rs_2.getString(1));
                    defect_id.setText(rs_2.getString(2));

                }
            }
        } catch (Exception e) {

        }

    }


    // Insert Query method to save the Defects into DefectLog
    public void insert() {

        if (remark.getText().toString().trim().length() > 0) {
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();


             String query_3 = "Exec Inspection2DefectLog '"+vin.getText().toString()+"','"+inspection_name.getText().toString()+"','"+spinner.getSelectedItem().toString()+"','"+remark.getText().toString()+"'";
            // String query_3 = "insert into DefectLog (LogTimestamp,Serial_No,InspectionId,DefectId,Status,Remarks,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + inspec_id.getText() + "','" + defect_id.getText() + "',2,'" + remark.getText() + "',getdate())";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
               // Log.e("h",query_3.toString());
            Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
            onBackPressed();

            }


            catch(Exception e){
                Log.e("here","Error in DefectLog");

            }
        }

        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(NOK_inspection.this);
            builder.setMessage("Enter Remark before saving").
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




    // Progress Dialog
    public void progress() {
        progressDialog = new ProgressDialog(NOK_inspection.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
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

    // Assign Rework Bay Stored Procedure Method
    public void Assign_reworkbay_sp() {
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            String ReworkTypeAsString = spinner_2.getSelectedItem().toString();
            int ReworkType;
            if (ReworkTypeAsString.equals("Electrical"))
                ReworkType = 1;
            else if (ReworkTypeAsString.equals("Mechanical"))
                ReworkType = 2;
            else if (ReworkTypeAsString.equals("Paint"))
                ReworkType = 3;
            else
                ReworkType = 4;
            String query_3 = "Exec [dbo].[AssignReworkBay] '" + vin.getText().toString() + "'," + ReworkType;
            //"'"+reworktype_id.getText().toString()+"'";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            Log.e("msg", "ERRORE");

        }

    }




    // AsyncTask Class to execute insert method and Stored Procedure
    private class SaveToDefectLog extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progress();

        }

        @Override
        protected String doInBackground(String... params) {


            return null;
        }

        @Override
        protected void onPostExecute(String result) {
          //duplic_save();
            insert();
            Assign_reworkbay_sp();

        }
    }




    public void duplic_save(){
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {

                String query = "select count(*) from DefectLog as Dlog join Config_Defect as Defect on Dlog.DefectId = Defect.DefectId  where Serial_No = '"+vin.getText().toString()+"' and DefectName = '"+spinner.getSelectedItem().toString()+"' and Status = 2";
                Statement st_1 = connect.createStatement();
                ResultSet rs_1 = st_1.executeQuery(query);


                rs_1.next();
                int count = rs_1.getInt(1);
                rs_1.close();

                if(count>1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(NOK_inspection.this);
                    builder.setMessage("Defect already saved").
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
                else{
                    insert();

                }


            }
        } catch (Exception e) {

        }



    }


}