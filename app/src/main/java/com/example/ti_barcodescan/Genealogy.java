package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Genealogy extends AppCompatActivity {
    Button home_btn_gen, as;
    TextView Gdate, vin, textView;
    SimpleAdapter ad;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_genealogy);

        //Date and Time
        Gdate = findViewById(R.id.date_gen);
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
                                Gdate.setText(dateString);
                            }
                        });
                    }

                } catch (Exception e) {

                }
            }
        };
        t.start();


        // vin number textview
        vin = findViewById(R.id.vin);
        Intent receive = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);


        //Home Button
        home_btn_gen = findViewById(R.id.home_btn);
        home_btn_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });



        as = findViewById(R.id.as);
      /* as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetList();
            }
        });*/

        // Calling List Adapter
        ListAdapter adap = GetList();


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                as.performClick();
            }
        }, 1000);


    }
// Home Button
    private void home() {
       // Intent send = new Intent(Genealogy.this, BarcodeScan.class);
        //send.putExtra("KEY_SEND", vin.getText().toString());
        //startActivity(send);
        onBackPressed();
    }


// Adding Genalogy Table columns to List View
    public ListAdapter GetList() {
        ListView listView = (ListView) findViewById(R.id.list);
        List<Map<String, String>> MyDataList = getlist();
        // ListItems mydata = new ListItems();
        //MyDataList = mydata.getlist();
        //  MyDataList.get(getlist());

        String[] f = {"Activity_Name", "Activity_Value", "Status"};
        int[] i = { R.id.col_2, R.id.col_3, R.id.col_4};
        ad = new SimpleAdapter(Genealogy.this, MyDataList, R.layout.list_genealogy, f, i);
        listView.setAdapter(ad);

        return null;
    }



    // Fetching the Genealogy Table from the Database
    public List<Map<String, String>> getlist() {


        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query = "select Timestamp,Serial_No,ActivityId,ActivityName,ActivityValue,Case when Status =1 then 'OK' else 'NOK' end as Status from Genealogy where Serial_No ='" + vin.getText().toString() + "'";
                //String query = "select * from Genealogy";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Map<String, String> dtname = new HashMap<String, String>();
                   // dtname.put("ActivityId", rs.getString(4));
                    dtname.put("Activity_Name", rs.getString("ActivityName"));
                    dtname.put("Activity_Value", rs.getString("ActivityValue"));
                    dtname.put("Status", rs.getString("Status"));
                    data.add(dtname);
                }
            }

        } catch (Exception ex) {

        }
        return data;

    }


}










