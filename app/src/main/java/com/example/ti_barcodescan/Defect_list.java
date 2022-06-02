package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Defect_list extends AppCompatActivity {

    SimpleAdapter ad;

    Connection connect;
Button home_btn_dft,click;
TextView date,vin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_list);

        date = findViewById(R.id.date_dft);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");
        String currentDateandTime = sdf.format(new Date());
        date.setText(currentDateandTime);

        //vin textView
        vin = findViewById(R.id.vin_dft);
        Intent receive  = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);

        home_btn_dft = findViewById(R.id.home_btn_dft);
       home_btn_dft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });


        click = findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetdefectList();
            }
        });
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                click.performClick();
            }
        }, 1000);

    }

    private void home() {
        Intent send = new Intent(Defect_list.this,BarcodeScan.class);
        send.putExtra("KEY_SEND", vin.getText().toString());
        startActivity(send);

    }



    public void GetdefectList()

    {
        ListView listView = (ListView) findViewById(R.id.defect_listview);
        List<Map<String, String>> MyDataList = getdefectlist();
        // ListItems mydata = new ListItems();
        //MyDataList = mydata.getlist();
        //  MyDataList.get(getlist());

        String[] f = {"ActivityId", "Activity_Name", "Activity_Value"};
        int[] i = {R.id.dcol_1, R.id.dcol_2, R.id.dcol_3};
        ad = new SimpleAdapter(Defect_list.this, MyDataList, R.layout.listview_defect, f, i);
        listView.setAdapter(ad);

    }

    public List<Map<String, String>> getdefectlist(){



        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try{

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if(connect!=null){
                String query = "select * from Genealogy where Serial_No ='" + vin.getText().toString() +"'";
                //String query = "select * from Genealogy";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                {
                    Map<String,String> dtname = new HashMap<String,String>();
                    dtname.put("ActivityId",rs.getString(4));
                    dtname.put("Activity_Name",rs.getString(5));
                    dtname.put("Activity_Value",rs.getString(6));

                    data.add(dtname);



                }


            }


        }
        catch (Exception ex){

        }
        return data;

    }








}