package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment set_alarm_frag = new SetAlarmFragement();


        Button set_update_alarm = findViewById(R.id.changeAlarm);

        set_update_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Main Activity - Fragment", "==== Starting fragment ====");
                loadFragment(set_alarm_frag);

            }
        });

        Button remove_alarm = findViewById(R.id.removeAlarm);
        remove_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Main Activity - Fragment", "==== Removing fragment ====");
                removeFragment(set_alarm_frag);


            }
        });

        Button refresh_page = findViewById(R.id.refreshButton);

        refresh_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Main Activity - Fragment", "==== Removing fragment ====");
                removeFragment(set_alarm_frag);
            }
        });

    }

    private void removeFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // remove fragment
        fragmentTransaction.remove(fragment);

        fragmentTransaction.commit();
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.setAlarmLayout, fragment);

        //   fragmentTransaction.replace(R.id.framelayout1, fragment);
        fragmentTransaction.commit(); // save the changes
    }

}