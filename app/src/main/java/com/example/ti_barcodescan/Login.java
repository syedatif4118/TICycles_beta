package com.example.ti_barcodescan;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AppCompatActivity {

    Button Loginbtn, logt;
    EditText userid, password;
    Connection connect;
    checkLogin checkLogin;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_login);

        String Parent = getIntent().getStringExtra("ParentValue");

        Loginbtn = findViewById(R.id.login_btn);
        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password);
       // logt = findViewById(R.id.templogin);




       /* logt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, BarcodeScan.class);
                startActivity(intent);
            }
        });*/


        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  checkLogin = new checkLogin();
                //checkLogin.execute();
                Intent intent = new Intent(Login.this, BarcodeScan.class);
                startActivity(intent);
            }
        });
    }



    // Progress Dialog
    public void progress() {
        progressDialog = new ProgressDialog(Login.this);
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

    private class checkLogin extends AsyncTask<String, Void, String> {

        String z = null;
        Boolean isSuccess = false;


        @Override
        protected void onPreExecute() {
            progress();


        }

        @Override
        protected String doInBackground(String... params) {


            return z;
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connectionClass();
                String query = "select * from Login_Sample where UserID ='" + userid.getText() + "' and Password ='" + password.getText() + "'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, BarcodeScan.class);
                    startActivity(intent);
                    finish();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Login failed!!! \nCheck UserId and Password").
                            setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                    //Toast.makeText(Login.this, "Login failed \nCheck UserId and Password", Toast.LENGTH_SHORT).show();
                    userid.setText("");
                    password.setText("");
                }
            } catch (Exception e) {
                Log.e("SQL Error", e.getMessage());
            }
        }

    }
}