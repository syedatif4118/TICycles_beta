package com.example.ti_barcodescan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class BarcodeScan extends AppCompatActivity {
    Button genealogy_btn, inspection_btn, defect_btn, logout_btn, clear_btn;
    EditText scantxt;
    TextView date;
    ProgressDialog progressDialog;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_barcode_scan);

        genealogy_btn = findViewById(R.id.genealogy_btn);
        inspection_btn = findViewById(R.id.inspection_btn);
        defect_btn = findViewById(R.id.defect_btn);
        logout_btn = findViewById(R.id.logout_btn);
        clear_btn = findViewById(R.id.clear_btn);
        scantxt = findViewById(R.id.scantxt);
        scantxt.requestFocus();


        date = findViewById(R.id.date);
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





     // old date time format
       /* SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm  ");
        String currentDateandTime = sdf.format(new Date());
        date.setText(currentDateandTime);*/

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

        Intent receive = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SEND");
        scantxt.setText(receiveValue);


        scantxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                clear_reworkbay_sp();

            }
        });


    }


    //Genealogy Button

    private void genealogy() {
        // Intent intent = new Intent(BarcodeScan.this,Genealogy.class);
        //startActivity(intent);
        Bundle bundle = new Bundle();
        Intent send = new Intent(BarcodeScan.this, Genealogy.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        send.putExtras(bundle);
        startActivity(send);
        progress();


    }
    public void progress(){
        progressDialog = new ProgressDialog(BarcodeScan.this);
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

    private void inspection() {
        //Intent intent = new Intent(BarcodeScan.this,Inspection.class);
        //startActivity(intent);

        Intent send = new Intent(BarcodeScan.this, Inspection.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        startActivity(send);
        progress();



    }

    private void clear() {
        //scantxt.setText("");
        scantxt.getText().clear();

    }

    private void defect() {
        Intent send = new Intent(BarcodeScan.this, Defect_list.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        startActivity(send);

        progress();
    }

    public void clear_reworkbay_sp(){

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String query_3 = "Exec [dbo].[ClearReworkBay] '"+scantxt.getText().toString()+"'";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            Log.e("msg","ERRORE");

        }
    }



}


