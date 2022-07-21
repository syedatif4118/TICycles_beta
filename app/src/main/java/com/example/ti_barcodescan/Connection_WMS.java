package com.example.ti_barcodescan;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_WMS {
    Connection con;
    String wms_uname, wms_pass, wms_database, wms_port, wms_ip;

    @SuppressLint("NewApi")
public Connection wms_connectionClass()

    {
      /*  ip = "192.168.174.57";
        uname = "atif";
        pass = "atif";
        port = "1433";*/

      //  wms_ip = "192.168.0.108";
       // wms_ip = "192.168.174.57";
       // wms_uname = "atif";
       // wms_pass = "atif";

       wms_ip = "10.0.23.81";
        wms_uname = "WMSUSer";
        wms_pass = "MESWMS@123";
        wms_port = "1433";
        wms_database = "WMSInterface";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String ConnectionURL = null;
        Connection connection = null;

        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + wms_ip + ":" + wms_port + ";" + "databasename=" + wms_database + ";user=" + wms_uname + ";password=" + wms_pass + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());

        }


        return connection;


    }


}
