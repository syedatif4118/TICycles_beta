package com.example.ti_barcodescan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class Inspection extends AppCompatActivity {

    Button  home_btn,save;
    ProgressDialog progressDialog;
    SaveToDatabase saveToDatabase;
    Connection connect;

    Switch nok_1, nok_2, nok_3, nok_4, nok_5, nok_6, nok_7, nok_8, nok_9, nok_10, nok_11, nok_12, nok_13, nok_14, nok_15, nok_16, nok_17, nok_18, nok_19, nok_20, nok_21, nok_22, nok_23, nok_24, nok_25, nok_26, nok_27, nok_28, nok_29, nok_30,
         nok_31, nok_32, nok_33, nok_34, nok_35, nok_36, nok_37, nok_38, nok_39, nok_40, nok_41, nok_42, nok_43, nok_44, nok_45, nok_46, nok_47, nok_48, nok_49, nok_50, nok_51, nok_52, nok_53, nok_54,
         nok_55, nok_56, nok_57, nok_58, nok_59, nok_60, nok_61, nok_62, nok_63, nok_64, nok_65, nok_66, nok_67, nok_68;

    TextView date_ins, vin, serial_number_punching,serialnumber_id, boat_tight,boat_id, rear,rear_id, hotwater,hotwater_id, degreasing_spray,degreasing_spray_id, degreasing_dip,degreasing_dip_id, rinse_1,rinse_1_id, rinse_2,rinse_2_id, phosphating_dip,phosphating_id, rinse_3,rinse_3_id, rinse_4,rinse_4_id, water_dip,water_dip_id, ed_process,ed_process_id,
            filteration_spray,filteration_spray_id, filteratin_dip,filteration_dip_id, sanding_process,sanding_process_id, sealer_process,sealer_process_id, tack_rag,tack_rag_id, robo_spray,robo_spray_id, manual_spray,manual_spray_id, head_cup,head_cup_id, vpunch_no,vpunch_no_id, wiring,wiring_id, hand_brake,hand_brake_id, hydraulic,hydraulic_id, routing,routing_id,
            shock_absorber,shock_absorber_id, unloading_chassis,unloading_chasis_id, control_fixing,control_fixing_id, converter_fixing,converter_fixing_id, small_aux,small_aux_id, main_battery,main_battery_id, tail_gate,tail_gate_id, rear_LH,rear_LH_id, rear_RH,rear_RH_id, foot_pedal,foot_pedal_id, cylinder,cylinder_id, brake_hose,brake_hose_id, brake_oil,brake_oil_id,
            driver_floor,driver_id, parking_lever,parking_lever_id, foot_pedal_assem,foot_pedal_assem_id, windshield,windshield_id, horn_assem,horn_assem_id, ignition_lock,ignition_lock_id, fork_assem,fork_assem_id, rear_wheel,rear_wheel_id, brake_cable,brake_cable_id, front_mud,front_mud_id, wiper,wiper_id, wiring_harness,wiring_harness_id, relay,relay_id, windshield_panel,windshield_panel_id,
            top_cladding,top_cladding_id, dashboard,dashboard_id, handlebar,handlebar_id, partition,partition_id, spare_wheel,spare_wheel_id, driver_seat,driver_seat_id, driver_seat_assem,driver_seat_assem_id, rigid,rigid_id, boat_sub,boat_sub_id, tail_gate_sub,tail_gate_sub_id, master_cylinder,master_cylinder_id, dashboard_sub,dashboard_sub_id, windshield_sub,windshield_sub_id, handlebar_set,handlebar_set_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_inspection);
        vin = (TextView) findViewById(R.id.vin_ins);
        home_btn = findViewById(R.id.home_btn_ins);
        serial_number_punching = (TextView) findViewById(R.id.serial);
        serialnumber_id = findViewById(R.id.serial_id);
        boat_tight = (TextView) findViewById(R.id.boat_tight);
        boat_id = findViewById(R.id.boat_id);
        rear_id = findViewById(R.id.rearside_id);
        rear = (TextView) findViewById(R.id.rear);
        nok_1 = findViewById(R.id.nok_1);
        hotwater = (TextView) findViewById(R.id.hotwater);
        hotwater_id = findViewById(R.id.hotwater_id);
        degreasing_spray = findViewById(R.id.degreasing_spray);
        degreasing_spray_id = findViewById(R.id.spray_id);
        degreasing_dip = findViewById(R.id.degreasing_dip);
        degreasing_dip_id = findViewById(R.id.dipping_id);
        rinse_1 = findViewById(R.id.rinse_1);
        rinse_1_id = findViewById(R.id.industrial_id);
        rinse_2 = findViewById(R.id.rinse_2);
        rinse_2_id = findViewById(R.id.industrialdipping_id);
        phosphating_dip = findViewById(R.id.phosphating_dip);
        phosphating_id = findViewById(R.id.phosphating_dip_id);
        rinse_3 = findViewById(R.id.rinse_3);
        rinse_3_id = findViewById(R.id.waterrinse3_id);
        rinse_4 = findViewById(R.id.rinse_4);
        rinse_4_id = findViewById(R.id.waterrinse4_id);
        water_dip = findViewById(R.id.water_dip);
        water_dip_id = findViewById(R.id.DMwaterdip_id);
        ed_process = findViewById(R.id.ed_process);
        ed_process_id = findViewById(R.id.EDprocess_id);
        filteration_spray = findViewById(R.id.filteration_spray);
        filteration_spray_id = findViewById(R.id.ultrafilter_id);
        filteratin_dip = findViewById(R.id.filtration_dip);
        filteration_dip_id = findViewById(R.id.filterationdip_id);
        sanding_process = findViewById(R.id.sanding_process);
        sanding_process_id = findViewById(R.id.sanding_id);
        sealer_process = findViewById(R.id.sealer_process);
        sealer_process_id = findViewById(R.id.sealer_id);
        tack_rag = findViewById(R.id.tack_rag);
        tack_rag_id = findViewById(R.id.tackrag_id);
        robo_spray = findViewById(R.id.robo_spray);
        robo_spray_id = findViewById(R.id.topcoat_id);
        manual_spray = findViewById(R.id.manual_spray);
        manual_spray_id = findViewById(R.id.manual_spray_id);
        head_cup_id = findViewById(R.id.head_cup_id);
        head_cup = findViewById(R.id.head_cup);
        vpunch_no = findViewById(R.id.vpunch_appno);
        vpunch_no_id = findViewById(R.id.vpunch_appno_id);
        wiring = findViewById(R.id.wiring);
        wiring_id = findViewById(R.id.wiring_id);
        hand_brake = findViewById(R.id.hand_brake);
        hand_brake_id = findViewById(R.id.hand_brake_id);
        hydraulic = findViewById(R.id.hydraulic_brake);
        hydraulic_id = findViewById(R.id.hydraulic_brake_id);
        routing = findViewById(R.id.routing);
        routing_id = findViewById(R.id.routing_id);
        shock_absorber = findViewById(R.id.shock_absorber);
        shock_absorber_id = findViewById(R.id.shock_absorber_id);
        unloading_chassis = findViewById(R.id.unloadin_chasis);
        unloading_chasis_id = findViewById(R.id.unloadin_chasis_id);
        control_fixing = findViewById(R.id.control_fixing);
        control_fixing_id = findViewById(R.id.control_fixing_id);
        converter_fixing = findViewById(R.id.converter_fixing);
        converter_fixing_id = findViewById(R.id.converter_fixing_id);
        small_aux = findViewById(R.id.small_aux);
        small_aux_id = findViewById(R.id.small_aux_id);
        main_battery = findViewById(R.id.main_battery);
        main_battery_id = findViewById(R.id.main_battery_id);
        tail_gate = findViewById(R.id.tail_gate);
        tail_gate_id = findViewById(R.id.tail_gate_id);
        rear_LH = findViewById(R.id.rear_LH);
        rear_LH_id = findViewById(R.id.rear_LH_id);
        rear_RH = findViewById(R.id.rear_RH);
        rear_RH_id = findViewById(R.id.rear_RH_id);
        foot_pedal = findViewById(R.id.foot_pedal);
        foot_pedal_id = findViewById(R.id.foot_pedal_id);
        cylinder = findViewById(R.id.cylinder);
        cylinder_id = findViewById(R.id.cylinder_id);
        brake_hose = findViewById(R.id.brake_hose);
        brake_hose_id = findViewById(R.id.brake_hose_id);
        brake_oil = findViewById(R.id.brake_oil);
        brake_oil_id = findViewById(R.id.brake_oil_id);
        driver_floor = findViewById(R.id.driver_floor);
        driver_id = findViewById(R.id.driver_id);
        parking_lever = findViewById(R.id.parking_lever);
        parking_lever_id = findViewById(R.id.parking_lever_id);
        foot_pedal_assem = findViewById(R.id.foot_pedal_assem);
        foot_pedal_assem_id = findViewById(R.id.foot_pedal_assem_id);
        windshield = findViewById(R.id.windshield);
        windshield_id = findViewById(R.id.windshield_id);
        horn_assem = findViewById(R.id.horn_asem);
        horn_assem_id = findViewById(R.id.horn_asem_id);
        ignition_lock = findViewById(R.id.ignition_lock);
        ignition_lock_id = findViewById(R.id.ignition_lock_id);
        fork_assem = findViewById(R.id.fork_assem);
        fork_assem_id = findViewById(R.id.fork_assem_id);
        rear_wheel = findViewById(R.id.rear_wheel);
        rear_wheel_id = findViewById(R.id.rear_wheel_id);
        brake_cable = findViewById(R.id.brake_cable);
        brake_cable_id = findViewById(R.id.brake_cable_id);
        front_mud = findViewById(R.id.front_mud);
        front_mud_id = findViewById(R.id.front_mud_id);
        wiper = findViewById(R.id.wiper);
        wiper_id = findViewById(R.id.wiper_id);
        wiring_harness = findViewById(R.id.wiring_harness);
        wiring_harness_id = findViewById(R.id.wiring_harness_id);
        relay = findViewById(R.id.relay);
        relay_id = findViewById(R.id.relay_id);
        windshield_panel = findViewById(R.id.windshield_panel);
        windshield_panel_id = findViewById(R.id.windshield_panel_id);
        top_cladding = findViewById(R.id.top_cladding);
        top_cladding_id = findViewById(R.id.top_cladding_id);
        dashboard = findViewById(R.id.dashboard);
        dashboard_id = findViewById(R.id.dashboard_id);
        handlebar = findViewById(R.id.handlebar);
        handlebar_id = findViewById(R.id.handlebar_id);
        partition = findViewById(R.id.partition);
        partition_id = findViewById(R.id.partition_id);
        spare_wheel = findViewById(R.id.spare_wheel);
        spare_wheel_id = findViewById(R.id.spare_wheel_id);
        driver_seat = findViewById(R.id.driver_seat);
        driver_seat_id = findViewById(R.id.driver_seat_id);
        driver_seat_assem = findViewById(R.id.driver_seat_assem);
        driver_seat_assem_id = findViewById(R.id.driver_seat_assem_id);
        rigid = findViewById(R.id.rigid);
        rigid_id = findViewById(R.id.rigid_id);
        boat_sub = findViewById(R.id.boat_sub);
        boat_sub_id = findViewById(R.id.boat_sub_id);
        tail_gate_sub = findViewById(R.id.tail_gate_sub);
        tail_gate_sub_id = findViewById(R.id.tail_gate_sub_id);
        master_cylinder = findViewById(R.id.master_cylinder);
        master_cylinder_id = findViewById(R.id.master_cylinder_id);
        dashboard_sub = findViewById(R.id.dashboard_sub);
        dashboard_sub_id = findViewById(R.id.dashboard_sub_id);
        windshield_sub = findViewById(R.id.windshield_sub);
        windshield_sub_id = findViewById(R.id.windshield_sub_id);
        handlebar_set = findViewById(R.id.handlebar_set);
        handlebar_set_id = findViewById(R.id.handlebar_set_id);

        save = findViewById(R.id.ins_save);




        //vin textView
        Intent receive = getIntent();
        String receiveValue = receive.getStringExtra("KEY_SENDER");
        vin.setText(receiveValue);


        //Date and Time
        date_ins = findViewById(R.id.date_ins);
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
                                date_ins.setText(dateString);
                            }
                        });
                    }

                } catch (Exception e) {

                }
            }
        };
        t.start();


        //Home Button
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

        //Save Button

        save.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

            saveToDatabase = new SaveToDatabase();
            saveToDatabase.execute();
                Toast.makeText(Inspection.this, "Saved Successfully", Toast.LENGTH_LONG).show();
            }
        });






        // Not Ok btns
        nok_1 = findViewById(R.id.nok_1);
        nok_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nok_1.isChecked()) {
                    nok_inspec_1();
                    nok_1.setTextOn("2");
                    nok_1.setTextOff("1");

                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_2 = findViewById(R.id.nok_2);
        nok_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_2.isChecked()) {
                    nok_inspec_2();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_3 = findViewById(R.id.nok_3);
        nok_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_3.isChecked()) {
                    nok_inspec_3();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });


        nok_4 = findViewById(R.id.nok_4);
        nok_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_4.isChecked()) {
                    nok_inspec_4();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_5 = findViewById(R.id.nok_5);
        nok_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_5.isChecked()) {
                    nok_inspec_5();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_6 = findViewById(R.id.nok_6);
        nok_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_6.isChecked()) {
                    nok_inspec_6();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_7 = findViewById(R.id.nok_7);
        nok_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_7.isChecked()) {
                    nok_inspec_7();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_8 = findViewById(R.id.nok_8);
        nok_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_8.isChecked()) {
                    nok_inspec_8();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_9 = findViewById(R.id.nok_9);
        nok_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_9.isChecked()) {
                    nok_inspec_9();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_10 = findViewById(R.id.nok_10);
        nok_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_10.isChecked()) {
                    nok_inspec_10();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_11 = findViewById(R.id.nok_11);
        nok_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_11.isChecked()) {
                    nok_inspec_11();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_12 = findViewById(R.id.nok_12);
        nok_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_12.isChecked()) {
                    nok_inspec_12();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_13 = findViewById(R.id.nok_13);
        nok_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_13.isChecked()) {
                    nok_inspec_13();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_14 = findViewById(R.id.nok_14);
        nok_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_14.isChecked()) {
                    nok_inspec_14();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_15 = findViewById(R.id.nok_15);
        nok_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_15.isChecked()) {
                    nok_inspec_15();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_16 = findViewById(R.id.nok_16);
        nok_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_16.isChecked()) {
                    nok_inspec_16();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_17 = findViewById(R.id.nok_17);
        nok_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_17.isChecked()) {
                    nok_inspec_17();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_18 = findViewById(R.id.nok_18);
        nok_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_18.isChecked()) {
                    nok_inspec_18();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_19 = findViewById(R.id.nok_19);
        nok_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_19.isChecked()) {
                    nok_inspec_19();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nok_20 = findViewById(R.id.nok_20);
        nok_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_20.isChecked()) {
                    nok_inspec_20();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_21 = findViewById(R.id.nok_21);
        nok_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_21.isChecked()) {
                    nok_inspec_21();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_22 = findViewById(R.id.nok_22);
        nok_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_22.isChecked()) {
                    nok_inspec_22();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_23 = findViewById(R.id.nok_23);
        nok_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_23.isChecked()) {
                    nok_inspec_23();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_24 = findViewById(R.id.nok_24);
        nok_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_24.isChecked()) {
                    nok_inspec_24();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_25 = findViewById(R.id.nok_25);
        nok_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_25.isChecked()) {
                    nok_inspec_25();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_26 = findViewById(R.id.nok_26);
        nok_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_26.isChecked()) {
                    nok_inspec_26();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_27 = findViewById(R.id.nok_27);
        nok_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_27.isChecked()) {
                    nok_inspec_27();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_28 = findViewById(R.id.nok_28);
        nok_28.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_28.isChecked()) {
                    nok_inspec_28();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        }));

        nok_29 = findViewById(R.id.nok_29);
        nok_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_29.isChecked()) {
                    nok_inspec_29();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_30 = findViewById(R.id.nok_30);
        nok_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_30.isChecked()) {
                    nok_inspec_30();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
                nok_30.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_31 = findViewById(R.id.nok_31);
        nok_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_31.isChecked()) {
                    nok_inspec_31();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_32 = findViewById(R.id.nok_32);
        nok_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_32.isChecked()) {
                    nok_inspec_32();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_33 = findViewById(R.id.nok_33);
        nok_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_33.isChecked()) {
                    nok_inspec_33();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_34 = findViewById(R.id.nok_34);
        nok_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_34.isChecked()) {
                    nok_inspec_34();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_35 = findViewById(R.id.nok_35);
        nok_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_35.isChecked()) {
                    nok_inspec_35();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_36 = findViewById(R.id.nok_36);
        nok_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_36.isChecked()) {
                    nok_inspec_36();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_37 = findViewById(R.id.nok_37);
        nok_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_37.isChecked()) {
                    nok_inspec_37();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_38 = findViewById(R.id.nok_38);
        nok_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_38.isChecked()) {
                    nok_inspec_38();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_39 = findViewById(R.id.nok_39);
        nok_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_39.isChecked()) {
                    nok_inspec_39();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_40 = findViewById(R.id.nok_40);
        nok_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_40.isChecked()) {
                    nok_inspec_40();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_41 = findViewById(R.id.nok_41);
        nok_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_41.isChecked()) {
                    nok_inspec_41();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
                nok_41.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_42 = findViewById(R.id.nok_42);
        nok_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_42.isChecked()) {
                    nok_inspec_42();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_43 = findViewById(R.id.nok_43);
        nok_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_43.isChecked()) {
                    nok_inspec_43();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_44 = findViewById(R.id.nok_44);
        nok_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_44.isChecked()) {
                    nok_inspec_44();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_45 = findViewById(R.id.nok_45);
        nok_45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_45.isChecked()) {
                    nok_inspec_45();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_46 = findViewById(R.id.nok_46);
        nok_46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_46.isChecked()) {
                    nok_inspec_46();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_47 = findViewById(R.id.nok_47);
        nok_47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_47.isChecked()) {
                    nok_inspec_47();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_48 = findViewById(R.id.nok_48);
        nok_48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_48.isChecked()) {
                    nok_inspec_48();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_49 = findViewById(R.id.nok_49);
        nok_49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_49.isChecked()) {
                    nok_inspec_49();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
                ;

            }
        });

        nok_50 = findViewById(R.id.nok_50);
        nok_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_50.isChecked()) {
                    nok_inspec_50();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_51 = findViewById(R.id.nok_51);
        nok_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_51.isChecked()) {
                    nok_inspec_51();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_52 = findViewById(R.id.nok_52);
        nok_52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_52.isChecked()) {
                    nok_inspec_52();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_53 = findViewById(R.id.nok_53);
        nok_53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_53.isChecked()) {
                    nok_inspec_53();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_54 = findViewById(R.id.nok_54);
        nok_54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_54.isChecked()) {
                    nok_inspec_54();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_55 = findViewById(R.id.nok_55);
        nok_55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_55.isChecked()) {
                    nok_inspec_55();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
                nok_55.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_56 = findViewById(R.id.nok_56);
        nok_56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_56.isChecked()) {
                    nok_inspec_56();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_57 = findViewById(R.id.nok_57);
        nok_57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_57.isChecked()) {
                    nok_inspec_57();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_58 = findViewById(R.id.nok_58);
        nok_58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_58.isChecked()) {
                    nok_inspec_58();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_59 = findViewById(R.id.nok_59);
        nok_59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_59.isChecked()) {
                    nok_inspec_59();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }
                nok_59.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_60 = findViewById(R.id.nok_60);
        nok_60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_60.isChecked()) {
                    nok_inspec_60();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_61 = findViewById(R.id.nok_61);
        nok_61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_61.isChecked()) {
                    nok_inspec_61();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_62 = findViewById(R.id.nok_62);
        nok_62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_62.isChecked()) {
                    nok_inspec_62();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_63 = findViewById(R.id.nok_63);
        nok_63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_63.isChecked()) {
                    nok_inspec_63();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_64 = findViewById(R.id.nok_64);
        nok_64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_64.isChecked()) {
                    nok_inspec_64();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_65 = findViewById(R.id.nok_65);
        nok_65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_65.isChecked()) {
                    nok_inspec_65();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nok_66 = findViewById(R.id.nok_66);
        nok_66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_66.isChecked()) {
                    nok_inspec_66();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });


        nok_68 = findViewById(R.id.nok_68);
        nok_68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nok_68.isChecked()) {
                    nok_inspec_68();
                } else {
                    Toast.makeText(Inspection.this, "OK", Toast.LENGTH_SHORT).show();
                }

            }
        });







    }
// Progress Dialog
    public void progress(){
        progressDialog = new ProgressDialog(Inspection.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 3000);

    }


    //home button
    private void home() {
        Intent send = new Intent(Inspection.this, BarcodeScan.class);
        send.putExtra("KEY_SEND", vin.getText().toString());
        startActivity(send);
    }



// Save Methods to Insert all the Inspections into Database
    public void save_1(){
        nok_1.setTextOn("2");
        nok_1.setTextOff("1");

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_1.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + serialnumber_id.getText() + "','" + nok_1.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + serialnumber_id.getText() + "','" + nok_1.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();


            }
        }
        catch (Exception e) {
            Log.e("as","1001");
        }


    }

    public void save_2(){
        //1002
        nok_2.setTextOff("1");
        nok_2.setTextOn("2");

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_2.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + boat_id.getText() + "','" + nok_2.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + boat_id.getText() + "','" + nok_2.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_3(){
        //1003
        nok_3.setTextOff("1");
        nok_3.setTextOn("2");

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_3.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_id.getText() + "','" + nok_3.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_id.getText() + "','" + nok_3.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

public void save_4(){
    nok_4.setTextOff("1");
    nok_4.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_4.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + hotwater_id.getText() + "','" + nok_4.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + hotwater_id.getText() + "','" + nok_4.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}


public void save_5(){
    nok_5.setTextOff("1");
    nok_5.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_5.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + degreasing_spray_id.getText() + "','" + nok_5.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + degreasing_spray_id.getText() + "','" + nok_5.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_6(){
    nok_6.setTextOff("1");
    nok_6.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_6.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + degreasing_dip_id.getText() + "','" + nok_6.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + degreasing_dip_id.getText() + "','" + nok_6.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_7(){
    nok_7.setTextOff("1");
    nok_7.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_7.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_1_id.getText() + "','" + nok_7.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_1_id.getText() + "','" + nok_7.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_8(){
    nok_8.setTextOff("1");
    nok_8.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_8.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_2_id.getText() + "','" + nok_8.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_2_id.getText() + "','" + nok_8.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_9(){
    nok_9.setTextOff("1");
    nok_9.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_9.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + phosphating_id.getText() + "','" + nok_9.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + phosphating_id.getText() + "','" + nok_9.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_10(){
    nok_10.setTextOff("1");
    nok_10.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_10.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_3_id.getText() + "','" + nok_10.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_3_id.getText() + "','" + nok_10.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();


        }

    }
    catch (Exception e) {

    }

}
public void save_11(){
    nok_11.setTextOff("1");
    nok_11.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_11.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_4_id.getText() + "','" + nok_11.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rinse_4_id.getText() + "','" + nok_11.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_12(){
    nok_12.setTextOff("1");
    nok_12.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_12.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + water_dip_id.getText() + "','" + nok_12.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + water_dip_id.getText() + "','" + nok_12.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}


public void save_13(){
    nok_13.setTextOff("1");
    nok_13.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_13.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + ed_process_id.getText() + "','" + nok_13.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + ed_process_id.getText() + "','" + nok_13.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}

public void save_14(){
    nok_14.setTextOff("1");
    nok_14.setTextOn("2");
    try {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionClass();

        if(nok_14.isChecked()) {
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + filteration_spray_id.getText() + "','" + nok_14.getTextOn() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else{
            String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + filteration_spray_id.getText() + "','" + nok_14.getTextOff() + "',getdate());";
            PreparedStatement preparedStatement = connect.prepareStatement(query_3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }
    }
    catch (Exception e) {

    }

}


    public void save_15(){
        nok_15.setTextOff("1");
        nok_15.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_15.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + filteration_dip_id.getText() + "','" + nok_15.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + filteration_dip_id.getText() + "','" + nok_15.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_16(){
        nok_16.setTextOff("1");
        nok_16.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_16.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + sanding_process_id.getText() + "','" + nok_16.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + sanding_process_id.getText() + "','" + nok_16.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_17(){
        nok_17.setTextOff("1");
        nok_17.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_17.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + sealer_process_id.getText() + "','" + nok_17.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + sealer_process_id.getText() + "','" + nok_17.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_18(){
        nok_18.setTextOff("1");
        nok_18.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_18.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + tack_rag_id.getText() + "','" + nok_18.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + tack_rag_id.getText() + "','" + nok_18.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_19(){
        nok_19.setTextOff("1");
        nok_19.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_19.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + robo_spray_id.getText() + "','" + nok_19.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + robo_spray_id.getText() + "','" + nok_19.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_20(){
        nok_20.setTextOff("1");
        nok_20.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_20.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + manual_spray_id.getText() + "','" + nok_20.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + manual_spray_id.getText() + "','" + nok_20.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_21(){
        nok_21.setTextOff("1");
        nok_21.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_21.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + head_cup_id.getText() + "','" + nok_21.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + head_cup_id.getText() + "','" + nok_21.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_22(){
        nok_22.setTextOff("1");
        nok_22.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_22.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + vpunch_no_id.getText() + "','" + nok_22.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + vpunch_no_id.getText() + "','" + nok_22.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_23(){
        nok_23.setTextOff("1");
        nok_23.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_23.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + wiring_id.getText() + "','" + nok_23.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + wiring_id.getText() + "','" + nok_23.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {
            Log.e("as","23");

        }

    }

    public void save_24(){
        nok_24.setTextOff("1");
        nok_24.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_24.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + hand_brake_id.getText() + "','" + nok_24.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + hand_brake_id.getText() + "','" + nok_24.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_25(){
        nok_25.setTextOff("1");
        nok_25.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_25.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + hydraulic_id.getText() + "','" + nok_25.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + hydraulic_id.getText() + "','" + nok_25.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_26(){
        nok_26.setTextOff("1");
        nok_26.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_26.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + routing_id.getText() + "','" + nok_26.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + routing_id.getText() + "','" + nok_26.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {
            Log.e("as","26");

        }

    }

    public void save_27(){
        nok_27.setTextOff("1");
        nok_27.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_27.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + shock_absorber_id.getText() + "','" + nok_27.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + shock_absorber_id.getText() + "','" + nok_27.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_28(){
        nok_28.setTextOff("1");
        nok_28.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_28.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + unloading_chasis_id.getText() + "','" + nok_28.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + unloading_chasis_id.getText() + "','" + nok_28.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_29(){
        nok_29.setTextOff("1");
        nok_29.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_29.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + control_fixing_id.getText() + "','" + nok_29.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + control_fixing_id.getText() + "','" + nok_29.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_30(){
        nok_30.setTextOff("1");
        nok_30.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_30.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + converter_fixing_id.getText() + "','" + nok_30.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + converter_fixing_id.getText() + "','" + nok_30.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_31(){
        nok_31.setTextOff("1");
        nok_31.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_31.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + small_aux_id.getText() + "','" + nok_31.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + small_aux_id.getText() + "','" + nok_31.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_32(){
        nok_32.setTextOff("1");
        nok_32.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_32.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + main_battery_id.getText() + "','" + nok_32.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + main_battery_id.getText() + "','" + nok_32.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_33(){
        nok_33.setTextOff("1");
        nok_33.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_33.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + tail_gate_id.getText() + "','" + nok_33.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + tail_gate_id.getText() + "','" + nok_33.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_34(){
        nok_34.setTextOff("1");
        nok_34.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_34.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_LH_id.getText() + "','" + nok_34.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_LH_id.getText() + "','" + nok_34.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_35(){
        nok_35.setTextOff("1");
        nok_35.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_35.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_RH_id.getText() + "','" + nok_35.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_RH_id.getText() + "','" + nok_35.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_36(){
        nok_36.setTextOff("1");
        nok_36.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_36.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + foot_pedal_id.getText() + "','" + nok_36.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + foot_pedal_id.getText() + "','" + nok_36.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_37(){
        nok_37.setTextOff("1");
        nok_37.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_37.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + cylinder_id.getText() + "','" + nok_37.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + cylinder_id.getText() + "','" + nok_37.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_38(){
        nok_38.setTextOff("1");
        nok_38.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_38.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + brake_hose_id.getText() + "','" + nok_38.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + brake_hose_id.getText() + "','" + nok_38.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_39(){
        nok_39.setTextOff("1");
        nok_39.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_39.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + brake_oil_id.getText() + "','" + nok_39.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + brake_oil_id.getText() + "','" + nok_39.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_40(){
        nok_40.setTextOff("1");
        nok_40.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_40.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + driver_id.getText() + "','" + nok_40.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + driver_id.getText() + "','" + nok_40.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_41(){
        nok_41.setTextOff("1");
        nok_41.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_41.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + parking_lever_id.getText() + "','" + nok_41.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + parking_lever_id.getText() + "','" + nok_41.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_42(){
        nok_42.setTextOff("1");
        nok_42.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_42.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + foot_pedal_assem_id.getText() + "','" + nok_42.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + foot_pedal_assem_id.getText() + "','" + nok_42.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_43(){
        nok_43.setTextOff("1");
        nok_43.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_43.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + windshield_id.getText() + "','" + nok_43.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + windshield_id.getText() + "','" + nok_43.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_44(){
        nok_44.setTextOff("1");
        nok_44.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_44.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + horn_assem_id.getText() + "','" + nok_44.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + horn_assem_id.getText() + "','" + nok_44.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_45(){
        nok_45.setTextOff("1");
        nok_45.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_45.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + ignition_lock_id.getText() + "','" + nok_45.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + ignition_lock_id.getText() + "','" + nok_45.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_46(){
        nok_46.setTextOff("1");
        nok_46.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_46.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + fork_assem_id.getText() + "','" + nok_46.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + fork_assem_id.getText() + "','" + nok_46.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_47(){
        nok_47.setTextOff("1");
        nok_47.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_47.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_wheel_id.getText() + "','" + nok_47.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rear_wheel_id.getText() + "','" + nok_47.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_48(){
        nok_48.setTextOff("1");
        nok_48.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_48.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + brake_cable_id.getText() + "','" + nok_48.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + brake_cable_id.getText() + "','" + nok_48.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_49(){
        nok_49.setTextOff("1");
        nok_49.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_49.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + front_mud_id.getText() + "','" + nok_49.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + front_mud_id.getText() + "','" + nok_49.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_50(){
        nok_50.setTextOff("1");
        nok_50.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_50.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + wiper_id.getText() + "','" + nok_50.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + wiper_id.getText() + "','" + nok_50.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_51(){
        nok_51.setTextOff("1");
        nok_51.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_51.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + wiring_harness_id.getText() + "','" + nok_51.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + wiring_harness_id.getText() + "','" + nok_51.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_52(){
        nok_52.setTextOff("1");
        nok_52.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_52.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + relay_id.getText() + "','" + nok_52.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + relay_id.getText() + "','" + nok_52.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_53(){
        nok_53.setTextOff("1");
        nok_53.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_53.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + windshield_panel_id.getText() + "','" + nok_53.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + windshield_panel_id.getText() + "','" + nok_53.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_54(){
        nok_54.setTextOff("1");
        nok_54.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_54.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + top_cladding_id.getText() + "','" + nok_54.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + top_cladding_id.getText() + "','" + nok_54.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_55(){
        nok_55.setTextOff("1");
        nok_55.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_55.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + dashboard_id.getText() + "','" + nok_55.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + dashboard_id.getText() + "','" + nok_55.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_56(){
        nok_56.setTextOff("1");
        nok_56.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_56.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + handlebar_id.getText() + "','" + nok_56.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + handlebar_id.getText() + "','" + nok_56.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_57(){
        nok_57.setTextOff("1");
        nok_57.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_57.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + partition_id.getText() + "','" + nok_57.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + partition_id.getText() + "','" + nok_57.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_58(){
        nok_58.setTextOff("1");
        nok_58.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_58.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + spare_wheel_id.getText() + "','" + nok_58.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + spare_wheel_id.getText() + "','" + nok_58.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_59(){
        nok_59.setTextOff("1");
        nok_59.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_59.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + driver_seat_id.getText() + "','" + nok_59.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + driver_seat_id.getText() + "','" + nok_59.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_60(){
        nok_60.setTextOff("1");
        nok_60.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_60.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + driver_seat_assem_id.getText() + "','" + nok_60.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + driver_seat_assem_id.getText() + "','" + nok_60.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }


    public void save_61(){
        nok_61.setTextOff("1");
        nok_61.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_61.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rigid_id.getText() + "','" + nok_61.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + rigid_id.getText() + "','" + nok_61.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_62(){
        nok_62.setTextOff("1");
        nok_62.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_62.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + boat_sub_id.getText() + "','" + nok_62.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + boat_sub_id.getText() + "','" + nok_62.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_63(){
        nok_63.setTextOff("1");
        nok_63.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_63.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + tail_gate_sub_id.getText() + "','" + nok_63.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + tail_gate_sub_id.getText() + "','" + nok_63.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_64(){
        nok_64.setTextOff("1");
        nok_64.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_64.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + master_cylinder_id.getText() + "','" + nok_64.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + master_cylinder_id.getText() + "','" + nok_64.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_65(){
        nok_65.setTextOff("1");
        nok_65.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_65.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + dashboard_sub_id.getText() + "','" + nok_65.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + dashboard_sub_id.getText() + "','" + nok_65.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }

    public void save_66(){
        nok_66.setTextOff("1");
        nok_66.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_66.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + windshield_sub_id.getText() + "','" + nok_66.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + windshield_sub_id.getText() + "','" + nok_66.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {

        }

    }
    public void save_68(){
        nok_68.setTextOff("1");
        nok_68.setTextOn("2");
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();

            if(nok_68.isChecked()) {
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + handlebar_set_id.getText() + "','" + nok_68.getTextOn() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            else{
                String query_3 = "insert into QualityLog (LogTimestamp,Serial_No,InspectionId,Status,LastUpdatedOn) values(getdate(),'" + vin.getText() + "','" + handlebar_set_id.getText() + "','" + nok_68.getTextOff() + "',getdate());";
                PreparedStatement preparedStatement = connect.prepareStatement(query_3);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        }
        catch (Exception e) {
            Log.e("error","o");

        }

    }
// Progress Dialog (Loading...)
public void progress_2(){
    progressDialog = new ProgressDialog(Inspection.this);
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


    //ALl No_Ok Switch Click
    private void nok_inspec_1() {

        String vinno = vin.getText().toString().trim();
        String inspname = serial_number_punching.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();


    }


    private void nok_inspec_2() {
        String vinno = vin.getText().toString().trim();
        String inspname = boat_tight.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();

    }


    public void nok_inspec_3() {
        String vinno = vin.getText().toString().trim();
        String inspname = rear.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }


    public void nok_inspec_4() {
        String vinno = vin.getText().toString().trim();
        String inspname = hotwater.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();


    }

    public void nok_inspec_5() {
        String vinno = vin.getText().toString().trim();
        String inspname = degreasing_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();


    }

    public void nok_inspec_6() {
        String vinno = vin.getText().toString().trim();
        String inspname = degreasing_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();


    }

    public void nok_inspec_7() {
        String vinno = vin.getText().toString().trim();
        String inspname = rinse_1.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();

    }

    public void nok_inspec_8() {
        String vinno = vin.getText().toString().trim();
        String inspname = rinse_2.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_9() {
        String vinno = vin.getText().toString().trim();
        String inspname = phosphating_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_10() {
        String vinno = vin.getText().toString().trim();
        String inspname = rinse_3.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_11() {
        String vinno = vin.getText().toString().trim();
        String inspname = rinse_4.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_12() {
        String vinno = vin.getText().toString().trim();
        String inspname = water_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_13() {
        String vinno = vin.getText().toString().trim();
        String inspname = ed_process.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_14() {
        String vinno = vin.getText().toString().trim();
        String inspname = filteration_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_15() {
        String vinno = vin.getText().toString().trim();
        String inspname = filteratin_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_16() {
        String vinno = vin.getText().toString().trim();
        String inspname = sanding_process.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_17() {
        String vinno = vin.getText().toString().trim();
        String inspname = sealer_process.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();

    }

    public void nok_inspec_18() {
        String vinno = vin.getText().toString().trim();
        String inspname = tack_rag.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_19() {
        String vinno = vin.getText().toString().trim();
        String inspname = robo_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_20() {
        String vinno = vin.getText().toString().trim();
        String inspname = manual_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_21() {
        String vinno = vin.getText().toString().trim();
        String inspname = head_cup.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_22() {
        String vinno = vin.getText().toString().trim();
        String inspname = vpunch_no.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_23() {
        String vinno = vin.getText().toString().trim();
        String inspname = wiring.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_24() {
        String vinno = vin.getText().toString().trim();
        String inspname = hand_brake.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_25() {
        String vinno = vin.getText().toString().trim();
        String inspname = hydraulic.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_26() {
        String vinno = vin.getText().toString().trim();
        String inspname = routing.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_27() {
        String vinno = vin.getText().toString().trim();
        String inspname = shock_absorber.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_28() {
        String vinno = vin.getText().toString().trim();
        String inspname = unloading_chassis.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_29() {
        String vinno = vin.getText().toString().trim();
        String inspname = control_fixing.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_30() {
        String vinno = vin.getText().toString().trim();
        String inspname = converter_fixing.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_31() {
        String vinno = vin.getText().toString().trim();
        String inspname = small_aux.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_32() {
        String vinno = vin.getText().toString().trim();
        String inspname = main_battery.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_33() {
        String vinno = vin.getText().toString().trim();
        String inspname = tail_gate.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_34() {
        String vinno = vin.getText().toString().trim();
        String inspname = rear_LH.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_35() {
        String vinno = vin.getText().toString().trim();
        String inspname = rear_RH.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_36() {
        String vinno = vin.getText().toString().trim();
        String inspname = foot_pedal.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_37() {
        String vinno = vin.getText().toString().trim();
        String inspname = cylinder.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_38() {
        String vinno = vin.getText().toString().trim();
        String inspname = brake_hose.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_39() {
        String vinno = vin.getText().toString().trim();
        String inspname = brake_oil.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_40() {
        String vinno = vin.getText().toString().trim();
        String inspname = driver_floor.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_41() {
        String vinno = vin.getText().toString().trim();
        String inspname = parking_lever.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_42() {
        String vinno = vin.getText().toString().trim();
        String inspname = foot_pedal_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_43() {
        String vinno = vin.getText().toString().trim();
        String inspname = windshield.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_44() {
        String vinno = vin.getText().toString().trim();
        String inspname = horn_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_45() {
        String vinno = vin.getText().toString().trim();
        String inspname = ignition_lock.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_46() {
        String vinno = vin.getText().toString().trim();
        String inspname = fork_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_47() {
        String vinno = vin.getText().toString().trim();
        String inspname = rear_wheel.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_48() {
        String vinno = vin.getText().toString().trim();
        String inspname = brake_cable.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_49() {
        String vinno = vin.getText().toString().trim();
        String inspname = front_mud.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_50() {
        String vinno = vin.getText().toString().trim();
        String inspname = wiper.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_51() {
        String vinno = vin.getText().toString().trim();
        String inspname = wiring_harness.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_52() {
        String vinno = vin.getText().toString().trim();
        String inspname = relay.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_53() {
        String vinno = vin.getText().toString().trim();
        String inspname = windshield_panel.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_54() {
        String vinno = vin.getText().toString().trim();
        String inspname = top_cladding.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_55() {
        String vinno = vin.getText().toString().trim();
        String inspname = dashboard.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_56() {
        String vinno = vin.getText().toString().trim();
        String inspname = handlebar.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_57() {
        String vinno = vin.getText().toString().trim();
        String inspname = partition.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_58() {
        String vinno = vin.getText().toString().trim();
        String inspname = spare_wheel.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_59() {
        String vinno = vin.getText().toString().trim();
        String inspname = driver_seat.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_60() {
        String vinno = vin.getText().toString().trim();
        String inspname = driver_seat_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_61() {
        String vinno = vin.getText().toString().trim();
        String inspname = rigid.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_62() {
        String vinno = vin.getText().toString().trim();
        String inspname = boat_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_63() {
        String vinno = vin.getText().toString().trim();
        String inspname = tail_gate_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_64() {
        String vinno = vin.getText().toString().trim();
        String inspname = master_cylinder.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_65() {
        String vinno = vin.getText().toString().trim();
        String inspname = dashboard_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    public void nok_inspec_66() {
        String vinno = vin.getText().toString().trim();
        String inspname = windshield_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();

    }



    public void nok_inspec_68() {
        String vinno = vin.getText().toString().trim();
        String inspname = handlebar_set.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname", inspname);
        Intent intent = new Intent(Inspection.this, NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
        progress_2();
    }

    // AsyncTask private class to execute all the save methods and progress dialog
    private class  SaveToDatabase extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progress();
        }

        @Override
        protected String doInBackground(String... params) {


            return null; }

        @Override
        protected void onPostExecute(String result) {
            save_1();
            save_2();
            save_3();
            save_4();
            save_5();
            save_6();
            save_7();
            save_8();
            save_9();
            save_10();
            save_11();
            save_12();
            save_13();
            save_14();
            save_15();
            save_16();
            save_17();
            save_18();
            save_19();
            save_20();
            save_21();
            save_22();
            save_23();
            save_24();
            save_25();
            save_26();
            save_27();
            save_28();
            save_29();
            save_30();
            save_31();
            save_32();
            save_33();
            save_34();
            save_35();
            save_36();
            save_37();
            save_38();
            save_39();
            save_40();
            save_41();
            save_42();
            save_43();
            save_44();
            save_45();
            save_46();
            save_47();
            save_48();
            save_49();
            save_50();
            save_51();
            save_52();
            save_53();
            save_54();
            save_55();
            save_56();
            save_57();
            save_58();
            save_59();
            save_60();
            save_61();
            save_62();
            save_63();
            save_64();
            save_65();
            save_66();
            save_68();

        }
    }




}