package com.example.ti_barcodescan;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String uname, pass, database, port, ip;

    @SuppressLint("NewApi")

    public Connection connectionClass() {
      //  ip = "192.168.0.108";
      // ip = "192.168.174.57";
       //uname = "atif";
       // pass = "atif";

       ip = "10.0.23.81";
        uname = "TIMES";
        pass = "TIMES@123";
        port = "1433";
        database = "TI3WEV_MES";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String ConnectionURL = null;
        Connection connection = null;

        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";" + "databasename=" + database + ";user=" + uname + ";password=" + pass + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());

        }


        return connection;


    }

}
