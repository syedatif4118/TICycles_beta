package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BarcodeScan extends AppCompatActivity {
Button genealogy_btn,inspection_btn,defect_btn,logout_btn,clear_btn;
EditText scantxt;
TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scan);

        genealogy_btn = findViewById(R.id.genealogy_btn);
        inspection_btn = findViewById(R.id.inspection_btn);
        defect_btn = findViewById(R.id.defect_btn);
        logout_btn = findViewById(R.id.logout_btn);
        clear_btn = findViewById(R.id.clear_btn);

        scantxt = findViewById(R.id.scantxt);
        scantxt.requestFocus();






        date = findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");
        String currentDateandTime = sdf.format(new Date());
        date.setText(currentDateandTime);

        genealogy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                genealogy();


            }
        });

        inspection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inspection();
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        defect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defect();
            }
        });

        Intent receive  = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SEND");
        scantxt.setText(receiveValue);




    }




    //Genealogy Button

    private void genealogy() {
       // Intent intent = new Intent(BarcodeScan.this,Genealogy.class);
        //startActivity(intent);
        Bundle bundle = new Bundle();
        Intent send = new Intent(BarcodeScan.this,Genealogy.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        send.putExtras(bundle);
        startActivity(send);

       /*  Bundle bundle = new Bundle();
        bundle.putString("key", "value");
        Intent intent = new Intent(A.this, B.class);
        intent.putExtras(bundle);
        startActivity(intent);*/


    }

    private void inspection() {
        //Intent intent = new Intent(BarcodeScan.this,Inspection.class);
        //startActivity(intent);

        Intent send = new Intent(BarcodeScan.this,Inspection.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        startActivity(send);



    }

    private void clear() {
        //scantxt.setText("");
        scantxt.getText().clear();

    }

    private void defect() {
        Intent send = new Intent(BarcodeScan.this,Defect_list.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        startActivity(send);
    }

    }

