package com.example.alaramclock;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class Alarm extends Fragment {

    public ListView alarmList;
    public Button addAlarmButton;
    public ArrayAdapter<String> alarmAdapter;
    public ArrayList<String> alarmNames;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmList = view.findViewById(R.id.alarm_list);
        addAlarmButton = view.findViewById(R.id.add_alarm_button);

        alarmNames = new ArrayList<>();
        alarmAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, alarmNames);
        alarmList.setAdapter(alarmAdapter);

        addAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setFragment(new setalarm());
            }
        });

        alarmList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle alarm click
            }
        });

        return view;
    }

    public void addAlarm(String name) {
        alarmNames.add(name);
        alarmAdapter.notifyDataSetChanged();
    }
}

//public class Alarm extends Fragment {
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_alarm, container, false);
//    }
//}