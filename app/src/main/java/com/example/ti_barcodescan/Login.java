package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_login);

        String Parent = getIntent().getStringExtra("ParentValue");

        Loginbtn = findViewById(R.id.login_btn);
        // Loginbtn.setOnClickListener(view -> {
        //   Intent i = new Intent(Login.this, BarcodeScan.class);
        // i.putExtra("Parent",Parent);
        //Log.e("Here", Parent);
        //startActivity(i);

        //});
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();
            }
        });


    }

    private void openNewActivity() {
        Intent intent = new Intent(Login.this, BarcodeScan.class);
        startActivity(intent);
    }
}