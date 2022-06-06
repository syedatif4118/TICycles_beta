package com.example.ti_barcodescan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Inspection extends AppCompatActivity {
 Button ok_1,rest_ok,home_btn, nok_1,nok_2,nok_3,nok_4,nok_5,nok_6,nok_7,nok_8,nok_9,nok_10,nok_11,nok_12,nok_13,nok_14,nok_15,nok_16,nok_17,nok_18,nok_19,nok_20,nok_21,nok_22,nok_23,nok_24,nok_25,nok_26,nok_27,nok_28,nok_29,nok_30,
         nok_31,nok_32,nok_33,nok_34,nok_35,nok_36,nok_37,nok_38,nok_39,nok_40,nok_41,nok_42,nok_43,nok_44,nok_45,nok_46,nok_47,nok_48,nok_49,nok_50,nok_51,nok_52,nok_53,nok_54,
         nok_55,nok_56,nok_57,nok_58,nok_59,nok_60,nok_61,nok_62,nok_63,nok_64,nok_65,nok_66,nok_67,nok_68,nok_69; //ok_2,ok_3,ok_4,ok_5,ok_6,ok_7
 TextView date,vin,serial_number_punching,boat_tight,rear,hotwater,degreasing_spray,degreasing_dip,rinse_1,rinse_2,phosphating_dip,rinse_3,rinse_4,water_dip,ed_process,
    filteration_spray, filteratin_dip, sanding_process,sealer_process,tack_rag,robo_spray,manual_spray,head_cup,vpunch_no,wiring,hand_brake,hydraulic,routing,
    shock_absorber,unloading_chassis,control_fixing,converter_fixing,small_aux,main_battery,tail_gate,rear_LH,rear_RH,foot_pedal,cylinder,brake_hose,brake_oil,
    driver_floor,parking_lever,foot_pedal_assem,windshield,horn_assem,ignition_lock,fork_assem,rear_wheel,brake_cable,front_mud,wiper,wiring_harness,relay,windshield_panel,
    top_cladding,dashboard,handlebar,partition,spare_wheel,driver_seat,driver_seat_assem,rigid,boat_sub,tail_gate_sub,master_cylinder,dashboard_sub,windshield_sub,sandin2,handlebar_set;

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
        rinse_4 = findViewById(R.id.rinse_4);
        water_dip = findViewById(R.id.water_dip);
        ed_process = findViewById(R.id.ed_process);
        filteration_spray = findViewById(R.id.filteration_spray);
        filteratin_dip = findViewById(R.id.filtration_dip);
        sanding_process = findViewById(R.id.sanding_process);
        sealer_process = findViewById(R.id.sealer_process);
        tack_rag = findViewById(R.id.tack_rag);
        robo_spray = findViewById(R.id.robo_spray);
        manual_spray = findViewById(R.id.manual_spray);
        head_cup = findViewById(R.id.head_cup);
        vpunch_no = findViewById(R.id.vpunch_appno);
        wiring = findViewById(R.id.wiring);
        hand_brake = findViewById(R.id.hand_brake);
        hydraulic = findViewById(R.id.hydraulic_brake);
        routing = findViewById(R.id.routing);
        shock_absorber = findViewById(R.id.shock_absorber);
        unloading_chassis = findViewById(R.id.unloadin_chasis);
        control_fixing = findViewById(R.id.control_fixing);
        converter_fixing = findViewById(R.id.converter_fixing);
        small_aux = findViewById(R.id.small_aux);
        main_battery = findViewById(R.id.main_battery);
        tail_gate = findViewById(R.id.tail_gate);
        rear_LH = findViewById(R.id.rear_LH);
        rear_RH = findViewById(R.id.rear_RH);
        foot_pedal = findViewById(R.id.foot_pedal);
        cylinder = findViewById(R.id.cylinder);
        brake_hose = findViewById(R.id.brake_hose);
        brake_oil = findViewById(R.id.brake_oil);
        driver_floor = findViewById(R.id.driver_floor);
        parking_lever =findViewById(R.id.parking_lever);
        foot_pedal_assem = findViewById(R.id.foot_pedal_assem);
        windshield = findViewById(R.id.windshield);
        horn_assem = findViewById(R.id.horn_asem);
        ignition_lock = findViewById(R.id.ignition_lock);
        fork_assem = findViewById(R.id.fork_assem);
        rear_wheel = findViewById(R.id.rear_wheel);
        brake_cable = findViewById(R.id.brake_cable);
        front_mud = findViewById(R.id.front_mud);
        wiper = findViewById(R.id.wiper);
        wiring_harness = findViewById(R.id.wiring_harness);
        relay = findViewById(R.id.relay);
        windshield_panel = findViewById(R.id.windshield_panel);
        top_cladding = findViewById(R.id.top_cladding);
        dashboard = findViewById(R.id.dashboard);
        handlebar = findViewById(R.id.handlebar);
        partition = findViewById(R.id.partition);
        spare_wheel = findViewById(R.id.spare_wheel);
        driver_seat = findViewById(R.id.driver_seat);
        driver_seat_assem = findViewById(R.id.driver_seat_assem);
        rigid = findViewById(R.id.rigid);
        boat_sub = findViewById(R.id.boat_sub);
        tail_gate_sub = findViewById(R.id.tail_gate_sub);
        master_cylinder = findViewById(R.id.master_cylinder);
        dashboard_sub = findViewById(R.id.dashboard_sub);
        windshield_sub = findViewById(R.id.windshield_sub);
        sandin2 = findViewById(R.id.sandin2);
        handlebar_set = findViewById(R.id.handlebar_set);
        rest_ok  =findViewById(R.id.rest_ok);





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

        nok_11 = findViewById(R.id.nok_11);
        nok_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_11.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_11();
            }
        });

        nok_12 = findViewById(R.id.nok_12);
        nok_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nok_12.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_12();
            }
        });

        nok_13 = findViewById(R.id.nok_13);
        nok_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_13.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_13();
            }
        });

        nok_14 = findViewById(R.id.nok_14);
        nok_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nok_14.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_14();
            }
        });

        nok_15 = findViewById(R.id.nok_15);
        nok_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nok_15.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_15();
            }
        });

        nok_16 = findViewById(R.id.nok_16);
        nok_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_16.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_16();
            }
        });

        nok_17 = findViewById(R.id.nok_17);
        nok_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_17.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
                nok_inspec_17();
            }
        });

        nok_18 = findViewById(R.id.nok_18);
        nok_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_18();
                nok_18.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_19 = findViewById(R.id.nok_19);
        nok_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_19();
                nok_19.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_20 = findViewById(R.id.nok_20);
        nok_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_20();
                nok_20.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_21 = findViewById(R.id.nok_21);
        nok_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_21();
                nok_21.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_22 = findViewById(R.id.nok_22);
        nok_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_22();
                nok_22.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_23 = findViewById(R.id.nok_23);
        nok_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_23();
                nok_23.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_24 = findViewById(R.id.nok_24);
        nok_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_24();
                nok_24.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_25 = findViewById(R.id.nok_25);
        nok_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_25();
                nok_25.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_26 = findViewById(R.id.nok_26);
        nok_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_26();
                nok_26.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_27 = findViewById(R.id.nok_27);
        nok_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_27();
                nok_27.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_28 = findViewById(R.id.nok_28);
        nok_28.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_28();
                nok_29.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        }));

        nok_29 = findViewById(R.id.nok_29);
        nok_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_29();
                nok_30.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_30 = findViewById(R.id.nok_30);
        nok_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_30();
                nok_30.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_31 = findViewById(R.id.nok_31);
        nok_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_31();
                nok_31.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_32 = findViewById(R.id.nok_32);
        nok_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_32();
                nok_32.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_33 = findViewById(R.id.nok_33);
        nok_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_33();
                nok_33.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_34 = findViewById(R.id.nok_34);
        nok_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_34();
                nok_34.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_35 = findViewById(R.id.nok_35);
        nok_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_35();
                nok_35.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_36 = findViewById(R.id.nok_36);
        nok_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_36();
                nok_36.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_37 = findViewById(R.id.nok_37);
        nok_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_37();
                nok_37.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_38 = findViewById(R.id.nok_38);
        nok_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_38();
                nok_38.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_39 = findViewById(R.id.nok_39);
        nok_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_39();
                nok_39.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_40 = findViewById(R.id.nok_40);
        nok_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_40();
                nok_40.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_41 = findViewById(R.id.nok_41);
        nok_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_41();
                nok_41.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_42 = findViewById(R.id.nok_42);
        nok_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_42();
                nok_42.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_43 = findViewById(R.id.nok_43);
        nok_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_43();
                nok_43.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_44 = findViewById(R.id.nok_44);
        nok_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_44();
                nok_44.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_45 = findViewById(R.id.nok_45);
        nok_45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_45();
                nok_45.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_46 = findViewById(R.id.nok_46);
        nok_46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_46();
                nok_46.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_47 = findViewById(R.id.nok_47);
        nok_47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_47();
                nok_47.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_48 = findViewById(R.id.nok_48);
        nok_48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_48();
                nok_48.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_49 = findViewById(R.id.nok_49);
        nok_49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_49();
                nok_49.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_50 = findViewById(R.id.nok_50);
        nok_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_50();
                nok_50.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_51 = findViewById(R.id.nok_51);
        nok_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_51();
                nok_51.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_52 = findViewById(R.id.nok_52);
        nok_52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_52();
                nok_52.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_53 = findViewById(R.id.nok_53);
        nok_53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_53();
                nok_53.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_54 = findViewById(R.id.nok_54);
        nok_54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_54();
                nok_54.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_55 = findViewById(R.id.nok_55);
        nok_55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_55();
                nok_55.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_56 = findViewById(R.id.nok_56);
        nok_56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_56();
                nok_56.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_57 = findViewById(R.id.nok_57);
        nok_57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_57();
                nok_57.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_58 = findViewById(R.id.nok_58);
        nok_58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_58();
                nok_58.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_59 = findViewById(R.id.nok_59);
        nok_59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_59();
                nok_59.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_60 = findViewById(R.id.nok_60);
        nok_60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_60();
                nok_60.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_61 = findViewById(R.id.nok_61);
        nok_61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_61();
                nok_61.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_62 = findViewById(R.id.nok_62);
        nok_62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_62();
                nok_62.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_63 = findViewById(R.id.nok_63);
        nok_63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_63();
                nok_63.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_64 = findViewById(R.id.nok_64);
        nok_64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_64();
                nok_64.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_65 = findViewById(R.id.nok_65);
        nok_65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_65();
                nok_65.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_66 = findViewById(R.id.nok_66);
        nok_66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_66();
                nok_66.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_67 = findViewById(R.id.nok_67);
        nok_67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_67();
                nok_67.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        nok_68 = findViewById(R.id.nok_68);
        nok_68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nok_inspec_68();
                nok_68.setBackgroundColor(getResources().getColor(R.color.nok_button_color));
            }
        });

        rest_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

//home button
    private void home() {
        Intent send = new Intent(Inspection.this,BarcodeScan.class);
        send.putExtra("KEY_SEND", vin.getText().toString());
        startActivity(send);
    }

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.nok_1,
            R.id.nok_2,
            R.id.nok_3


    };


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

    public void nok_inspec_11(){
        String vinno = vin.getText().toString().trim();
        String inspname= rinse_4.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_12(){
        String vinno = vin.getText().toString().trim();
        String inspname= water_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_13(){
        String vinno = vin.getText().toString().trim();
        String inspname= ed_process.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_14(){
        String vinno = vin.getText().toString().trim();
        String inspname= filteration_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_15(){
        String vinno = vin.getText().toString().trim();
        String inspname= filteratin_dip.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_16(){
        String vinno = vin.getText().toString().trim();
        String inspname= sanding_process.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_17(){
        String vinno = vin.getText().toString().trim();
        String inspname= sealer_process.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void nok_inspec_18(){
        String vinno = vin.getText().toString().trim();
        String inspname= tack_rag.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_19(){
        String vinno = vin.getText().toString().trim();
        String inspname= robo_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_20(){
        String vinno = vin.getText().toString().trim();
        String inspname= manual_spray.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_21(){
        String vinno = vin.getText().toString().trim();
        String inspname= head_cup.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_22(){
        String vinno = vin.getText().toString().trim();
        String inspname= vpunch_no.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_23(){
        String vinno = vin.getText().toString().trim();
        String inspname= wiring.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_24(){
        String vinno = vin.getText().toString().trim();
        String inspname= hand_brake.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_25(){
        String vinno = vin.getText().toString().trim();
        String inspname= hydraulic.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_26(){
        String vinno = vin.getText().toString().trim();
        String inspname= routing.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_27(){
        String vinno = vin.getText().toString().trim();
        String inspname= shock_absorber.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_28(){
        String vinno = vin.getText().toString().trim();
        String inspname= unloading_chassis.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_29(){
        String vinno = vin.getText().toString().trim();
        String inspname= control_fixing.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_30(){
        String vinno = vin.getText().toString().trim();
        String inspname= converter_fixing.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_31(){
        String vinno = vin.getText().toString().trim();
        String inspname= small_aux.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_32(){
        String vinno = vin.getText().toString().trim();
        String inspname= main_battery.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_33(){
        String vinno = vin.getText().toString().trim();
        String inspname= tail_gate.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_34(){
        String vinno = vin.getText().toString().trim();
        String inspname= rear_LH.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_35(){
        String vinno = vin.getText().toString().trim();
        String inspname= rear_RH.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_36(){
        String vinno = vin.getText().toString().trim();
        String inspname= foot_pedal.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_37(){
        String vinno = vin.getText().toString().trim();
        String inspname= cylinder.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_38(){
        String vinno = vin.getText().toString().trim();
        String inspname= brake_hose.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_39(){
        String vinno = vin.getText().toString().trim();
        String inspname= brake_oil.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_40(){
        String vinno = vin.getText().toString().trim();
        String inspname= driver_floor.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_41(){
        String vinno = vin.getText().toString().trim();
        String inspname= parking_lever.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_42(){
        String vinno = vin.getText().toString().trim();
        String inspname= foot_pedal_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_43(){
        String vinno = vin.getText().toString().trim();
        String inspname= windshield.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_44(){
        String vinno = vin.getText().toString().trim();
        String inspname= horn_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_45(){
        String vinno = vin.getText().toString().trim();
        String inspname= ignition_lock.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_46(){
        String vinno = vin.getText().toString().trim();
        String inspname= fork_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_47(){
        String vinno = vin.getText().toString().trim();
        String inspname= rear_wheel.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_48(){
        String vinno = vin.getText().toString().trim();
        String inspname= brake_cable.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_49(){
        String vinno = vin.getText().toString().trim();
        String inspname= front_mud.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_50(){
        String vinno = vin.getText().toString().trim();
        String inspname= wiper.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_51(){
        String vinno = vin.getText().toString().trim();
        String inspname= wiring_harness.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_52(){
        String vinno = vin.getText().toString().trim();
        String inspname= relay.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_53(){
        String vinno = vin.getText().toString().trim();
        String inspname= windshield_panel.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_54(){
        String vinno = vin.getText().toString().trim();
        String inspname= top_cladding.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_55(){
        String vinno = vin.getText().toString().trim();
        String inspname= dashboard.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_56(){
        String vinno = vin.getText().toString().trim();
        String inspname= handlebar.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_57(){
        String vinno = vin.getText().toString().trim();
        String inspname= partition.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_58(){
        String vinno = vin.getText().toString().trim();
        String inspname= spare_wheel.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_59(){
        String vinno = vin.getText().toString().trim();
        String inspname= driver_seat.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_60(){
        String vinno = vin.getText().toString().trim();
        String inspname= driver_seat_assem.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_61(){
        String vinno = vin.getText().toString().trim();
        String inspname= rigid.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_62(){
        String vinno = vin.getText().toString().trim();
        String inspname= boat_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_63(){
        String vinno = vin.getText().toString().trim();
        String inspname= tail_gate_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_64(){
        String vinno = vin.getText().toString().trim();
        String inspname= master_cylinder.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_65(){
        String vinno = vin.getText().toString().trim();
        String inspname= dashboard_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_66(){
        String vinno = vin.getText().toString().trim();
        String inspname= windshield_sub.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void nok_inspec_67(){
        String vinno = vin.getText().toString().trim();
        String inspname= sandin2.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void nok_inspec_68(){
        String vinno = vin.getText().toString().trim();
        String inspname= handlebar_set.getText().toString().trim();
        Bundle bundle = new Bundle();
        bundle.putString("vinno", vinno);
        bundle.putString("inspname",inspname);
        Intent intent = new Intent(Inspection.this,NOK_inspection.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }




}