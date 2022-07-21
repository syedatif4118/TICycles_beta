package com.example.ti_barcodescan;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

// Date and Time
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


// Genealogy OnClick
        genealogy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genealogy();
            }
        });

// Inspection OnClick
        inspection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inspection();
            }
        });

// Clear OnClick
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();

            }
        });

// Defect list OnClick
        defect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defect();
            }
        });

        // Logout OnClick
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });



        Intent receive = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SEND");
        scantxt.setText(receiveValue);


// Edit Text Vin Number Scan Operation while scan
        scantxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                check_inspec_veh();

            }

            @Override
            public void afterTextChanged(Editable editable) {
                check_vin();
                clear_reworkbay_sp();
                check_defect();


            }
        });


    }


    //Genealogy Button

    private void genealogy() {

        Bundle bundle = new Bundle();
        Intent send = new Intent(BarcodeScan.this, Genealogy.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        send.putExtras(bundle);
        startActivity(send);
        progress();



    }

    // Progress Dialog
    public void progress() {
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

    // Inspection Button
    private void inspection() {

        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String query_1 = "select count(*) from Genealogy where Serial_No = '"+scantxt.getText().toString()+"' and ActivityId = 20001";
            Statement st_1 = connect.createStatement();
            ResultSet rs_1 = st_1.executeQuery(query_1);

            rs_1.next();
            int count_1 = rs_1.getInt(1);
            rs_1.close();


            String query = "SELECT count(*) FROM DefectLog where Status = 2 and Serial_No ='" + scantxt.getText().toString() + "' ";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                rs.next();
                int count = rs.getInt(1);
                rs.close();

                if (count == 0 && count_1==0 && scantxt.getText().toString().length()>0) {
                    Intent send = new Intent(BarcodeScan.this, Inspection.class);
                    send.putExtra("KEY_SENDER", scantxt.getText().toString());
                    startActivity(send);
                    progress();
                }


                   else if(count_1>0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScan.this);
                    builder.setMessage("Vehicle has already been Inspected").
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

                   else if(scantxt.getText().toString().length()==0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScan.this);
                    builder.setMessage("Scan the VIN to proceed further").
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

                    AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScan.this);
                    builder.setMessage("Clear the previous defects to move forward").
                            setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setTitle("Alert!")
                            .setIcon(R.drawable.warning);
                    AlertDialog alert = builder.create();
                    //alert.show();
                    builder.show();


                }





        }
        catch (Exception ex) {

        }


    }

    // Logout Button
    private void logout() {
        Intent send = new Intent(BarcodeScan.this, Login.class);
        startActivity(send);
        finish();
    }

    // Clear Button
    private void clear() {
        scantxt.getText().clear();
        Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
    }

    // Defect Button
    private void defect() {
        Intent send = new Intent(BarcodeScan.this, Defect_list.class);
        send.putExtra("KEY_SENDER", scantxt.getText().toString());
        startActivity(send);
        progress();
    }


    // Clear Rework Stored Procedure while scanning the vin number
    public void clear_reworkbay_sp() {

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            String query_3 = "Exec [dbo].[ClearReworkBay] '" + scantxt.getText().toString() + "'";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            Log.e("msg", "ERROR");

        }
    }

    //Conditional Method to check if there are active defects before proceeding to Inspection

    @SuppressLint("ResourceAsColor")
    public void check_defect(){
        //int count = 0;
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if (connect != null) {
                String query = "SELECT count(*) FROM DefectLog where Status = 2 and Serial_No ='"+scantxt.getText().toString()+"' ";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                rs.next();
                int count = rs.getInt(1);
                rs.close();

                if(count>0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScan.this);
                    builder.setMessage("Please Check the Defect List Before Proceeding Further").
                            setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setTitle("Alert!")
                            .setIcon(R.drawable.warning);
                    AlertDialog alert = builder.create();
                  //  alert.show();
                    builder.show();

                    defect_btn.setBackgroundColor(getResources().getColor(R.color.change));
                    Animation anim = new AlphaAnimation(0.0f, 1.0f);
                    anim.setDuration(50); //You can manage the blinking time with this parameter
                    anim.setStartOffset(20);
                    anim.setRepeatMode(Animation.REVERSE);
                    anim.setRepeatCount(60);
                    defect_btn.startAnimation(anim);

                }
                else{
                  //  Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }

            }
        }
        catch (Exception ex) {

        }


}

// Method to check if the vehicle is already inspected or not

public void check_inspec_veh(){
    try {

        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();
        if (connect != null) {
            String query = "select count(*) from Genealogy where Serial_No = '"+scantxt.getText().toString()+"' and ActivityId = 20001";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();
            int count = rs.getInt(1);
            rs.close();

            if(count>0){
                AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScan.this);
                builder.setMessage("Vehicle has already been Inspected").
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
               // Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
            }

        }
    }
    catch (Exception ex) {

    }


}

public void check_vin(){
    try {

        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();
        if (connect != null) {
            String query = "select count(*) from ProductionOrderWIP where Serial_No = '"+scantxt.getText().toString()+"' and LineId = 6";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();
            int count = rs.getInt(1);
            rs.close();

            if(count==0 && scantxt.getText().toString().length()>0){
                clear();
                AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScan.this);
                builder.setMessage("Incorrect VIN Scanned").
                        setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                // Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
            }

        }
    }
    catch (Exception ex) {

    }




}

}


