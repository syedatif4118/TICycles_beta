package com.example.ti_barcodescan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NOK_inspection extends AppCompatActivity {
    Button save;
    TextView date,vin,inspection_name;
    Spinner spinner;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nok_inspection);
        inspection_name = findViewById(R.id.inspection_name);
        date = findViewById(R.id.date_nok);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");
        String currentDateandTime = sdf.format(new Date());
        date.setText(currentDateandTime);

        //vin textview
        vin = findViewById(R.id.vin_nok);
        /*Intent receive  = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);*/

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String vinno = bundle.getString("vinno");
            String inspname = bundle.getString("inspname");
            vin.setText(vinno);
            inspection_name.setText(inspname);
        }

        //DropDown
        spinner = findViewById(R.id.spinner);
        FillSpinner();




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
                while(rs.next()){
                    String name = rs.getString("DefectName");
                    data.add(name);

                }

                ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
                spinner.setAdapter(array);

            }

        }
        catch (Exception e){

        }

    }

}