package com.example.ti_barcodescan;

import android.app.ProgressDialog;
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

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NOK_inspection extends AppCompatActivity {
    Button save, info;
    TextView date, vin, inspection_name, inspec_id, defect_id,reworktype_id;
    Spinner spinner,spinner_2;
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


        spinner_2  =(Spinner) findViewById(R.id.spinner_2);
       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.rework, android.R.layout.simple_spinner_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner_2.setAdapter(adapter);


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


        remark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                get_info();

            }
        });


        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToDefectLog = new SaveToDefectLog();
                saveToDefectLog.execute();
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
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

    public void get_info() {

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query_1 = "select * from Rework_Type where ReworkTypeName ='"+spinner_2.getSelectedItem().toString()+"'";
                String query_2 = "select * from Config_Defect where DefectName ='" + spinner.getSelectedItem().toString() + "'";

                Statement st_1 = connect.createStatement();
                ResultSet rs_1 = st_1.executeQuery(query_1);

                Statement st_2 = connect.createStatement();
                ResultSet rs_2 = st_2.executeQuery(query_2);

                while(rs_1.next()){
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

    public void insert() {
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String query_3 = "insert into DefectLog (LogTimestamp,Serial_No,InspectionId,DefectId,Status,Remarks,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + inspec_id.getText() + "','" + defect_id.getText() + "',2,'" + remark.getText() + "',getdate())";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {


        }

    }

    public void progress(){
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
        }, 3000);

    }


    public void Assign_reworkbay_sp(){
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String query_3 = "Exec [dbo].[AssignReworkBay] '"+vin.getText().toString()+"', '"+reworktype_id.getText().toString()+"'";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            Log.e("msg","ERRORE");

        }

    }



    private class  SaveToDefectLog extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progress();

        }

        @Override
        protected String doInBackground(String... params) {


            return null; }

        @Override
        protected void onPostExecute(String result) {
            insert();
            Assign_reworkbay_sp();

        }
    }





}