package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inspection extends AppCompatActivity {
 Button ok_1,home_btn, nok_1,nok_2,nok_3,nok_4,nok_5,nok_6,nok_7,nok_8,nok_9,nok_10; //ok_2,ok_3,ok_4,ok_5,ok_6,ok_7
 TextView date,vin,serial_number_punching,boat_tight,rear,hotwater,degreasing_spray,degreasing_dip,rinse_1,rinse_2,phosphating_dip,rinse_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);
        vin = (TextView) findViewById(R.id.vin_ins);
        home_btn = findViewById(R.id.home_btn_ins);
        serial_number_punching = (TextView) findViewById(R.id.serial_number_punching);
        boat_tight = (TextView) findViewById(R.id.boat_tight);
        rear = (TextView) findViewById(R.id.rear);
        nok_1 = findViewById(R.id.nok_1);
        ok_1 = findViewById(R.id.ok_1);
        hotwater = (TextView) findViewById(R.id.hotwater);
        degreasing_spray = findViewById(R.id.degreasing_spray);
        degreasing_dip = findViewById(R.id.degreasing_dip);
        rinse_1 = findViewById(R.id.rinse_1);
        rinse_2 = findViewById(R.id.rinse_2);
        phosphating_dip = findViewById(R.id.phosphating_dip);
        rinse_3 = findViewById(R.id.rinse_3);



        ok_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ok_1.setBackgroundColor(getResources().getColor(R.color.ok_button_color));


            }
        });

        //vin textView
        Intent receive  = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);


        //Date and Time
        date = findViewById(R.id.date_ins);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");
        String currentDateandTime = sdf.format(new Date());
        date.setText(currentDateandTime);

        //Home Button
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

        nok_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_1.setBackgroundColor(getResources().getColor(R.color.nok_button_color));

                nok_inspec_1();

            }
        });

        nok_2 = findViewById(R.id.nok_2);
        nok_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_2.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_2();

            }
        });

        nok_3  = findViewById(R.id.nok_3);
        nok_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_3.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_3();
            }
        });


        nok_4 = findViewById(R.id.nok_4);
        nok_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_4.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_4();
            }
        });

        nok_5 = findViewById(R.id.nok_5);
        nok_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_5.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_5();
            }
        });

        nok_6 =findViewById(R.id.nok_6);
        nok_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_6.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_6();
            }
        });

        nok_7 = findViewById(R.id.nok_7);
        nok_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_7.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_7();
            }
        });

        nok_8 = findViewById(R.id.nok_8);
        nok_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_8.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_8();
            }
        });

        nok_9 = findViewById(R.id.nok_9);
        nok_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_9.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_9();
            }
        });

        nok_10 = findViewById(R.id.nok_10);
        nok_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_10.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_10();
            }
        });



    }

//home button
    private void home() {
        Intent send = new Intent(Inspection.this,BarcodeScan.class);
        send.putExtra("KEY_SEND", vin.getText().toString());
        startActivity(send);
    }
//No_ok inspection 1
    private void nok_inspec_1() {

        String vinno = vin.getText().toString().trim();
        String inspname = serial_number_punching.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }


    private  void nok_inspec_2(){
        String vinno = vin.getText().toString().trim();
        String inspname = boat_tight.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }


    public void nok_inspec_3() {
       String vinno = vin.getText().toString().trim();
       String inspname = rear.getText().toString().trim();
       Bundle bundle = new Bundle();
       bundle.putString("vinno",vinno);
       bundle.putString("inspname",inspname);
       Intent intent = new Intent(Inspection.this,NOK_inspection.class);
       intent.putExtras(bundle);
       startActivity(intent);
    }


    public void nok_inspec_4() {
        String vinno = vin.getText().toString().trim();
        String inspname= hotwater.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    public void nok_inspec_5(){
        String vinno = vin.getText().toString().trim();
        String inspname= degreasing_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    public void nok_inspec_6(){
        String vinno = vin.getText().toString().trim();
        String inspname= degreasing_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void nok_inspec_7(){
        String vinno = vin.getText().toString().trim();
        String inspname= rinse_1.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void nok_inspec_8(){
        String vinno = vin.getText().toString().trim();
        String inspname= rinse_2.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_9(){
        String vinno = vin.getText().toString().trim();
        String inspname= phosphating_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_10(){
        String vinno = vin.getText().toString().trim();
        String inspname= rinse_3.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}