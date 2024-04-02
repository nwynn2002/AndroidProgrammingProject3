package com.example.project3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class SetAlarmFragement extends Fragment implements AdapterView.OnItemSelectedListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_alarm_fragement, container, false);
        MainActivity m=(MainActivity) getActivity();

        long timeTilAlarm = System.currentTimeMillis();

        TextView confirmTime = view.findViewById(R.id.confirmTime);
        TimePicker tp = view.findViewById(R.id.timePicker1);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Calendar c=Calendar.getInstance();

            int hr = tp.getHour();
            int min = tp.getMinute();


            c.set(Calendar.HOUR_OF_DAY,hr);
            c.set(Calendar.MINUTE,min);

            timeTilAlarm = c.getTimeInMillis() - timeTilAlarm;
            Log.d("Set Alarm Frag", "===== time til alarm " + Long.toString(timeTilAlarm) + "=====");
        }


        Spinner spinner = view.findViewById(R.id.timeSpinner);
        String time[] = {"5", "10", "15"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(m.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, time);
        spinner.setAdapter(spinnerArrayAdapter);

        if (spinner != null) {  //if a spinner exists.
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   //Setting up a listener on the spinner
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {  //action for item selection.

                    String txtShow= "Your current time selection is: " + spinner.getSelectedItem().toString();
                    confirmTime.setText(txtShow);  //display the selected item in a textview.

                }

                public void onNothingSelected(AdapterView<?> parentView) {
                }
            });
        }
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}