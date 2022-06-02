package com.example.ti_barcodescan;

import android.widget.TextView;

import java.sql.Connection;

public class ListItems {

        TextView vin;

        Connection connect;
        String ConnectionResult="";
        Boolean isSuccess=false;


       /* public List<Map<String,String>> getlist(){



            List<Map<String,String>> data = null;
            data = new ArrayList<Map<String,String>>();
            try{

                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connectionClass();
                if(connect!=null){
                    //  String query = "select * from Genealogy where Serial_No ='" + vin.getText().toString() +"'";
                    String query = "select * from Genealogy";
                    Statement st = connect.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next())
                    {
                        Map<String,String> dtname = new HashMap<String,String>();
                        dtname.put("ActivityId",rs.getString(4));
                        dtname.put("Activity_Name",rs.getString(5));
                        dtname.put("Activity_Value",rs.getString(6));
                        dtname.put("Status",rs.getString(7));
                        data.add(dtname);



                    }
                    ConnectionResult="Success";
                    isSuccess=true;
                    connect.close();

                }


            }
            catch (Exception ex){

            }
            return data;

        }*/
    }

