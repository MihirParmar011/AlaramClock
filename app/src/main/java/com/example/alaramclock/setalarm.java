package com.example.alaramclock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class setalarm extends Fragment {

    private EditText alarmName;
    private TimePicker alarmTime;
    private Button setAlarmButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setalarm, container, false);

        alarmName = view.findViewById(R.id.alarm_name);
        alarmTime = view.findViewById(R.id.alarm_time);
        setAlarmButton = view.findViewById(R.id.set_alarm_button);

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = alarmName.getText().toString();
                int hour = alarmTime.getCurrentHour();
                int minute = alarmTime.getCurrentMinute();

                // Set alarm logic here

                ((MainActivity) getActivity()).setFragment(new Alarm());
                ((Alarm) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_alarm)).addAlarm(name);
            }
        });

        return view;
    }
}

//public class setalarm extends Fragment {
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_setalarm, container, false);
//    }
//}