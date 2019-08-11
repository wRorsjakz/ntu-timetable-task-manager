package com.example.ntu_timetable_calendar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ntu_timetable_calendar.Fragments.AboutAppFragment;
import com.example.ntu_timetable_calendar.Fragments.AddNewTaskFragment;
import com.example.ntu_timetable_calendar.Fragments.SavedTimetablesFragment;
import com.example.ntu_timetable_calendar.Fragments.TaskDetailFragment;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            String incomingIntentString = getIntent().getStringExtra(getString(R.string.SECOND_ACTIVITY_INTENT_KEY));
            initFragment(incomingIntentString);
        }
    }

    private void initFragment(String intentStr) {
        if (intentStr.equals(getString(R.string.SAVED_TIMETABLES_INTENT))) {
            getSupportFragmentManager().beginTransaction().replace(R.id.second_activity_fragment_container, new SavedTimetablesFragment(),
                    "saved_timetables_fragment").commit();
        } else if (intentStr.equals(getString(R.string.ABOUT_APP_INTENT))) {
            getSupportFragmentManager().beginTransaction().replace(R.id.second_activity_fragment_container, new AboutAppFragment(),
                    "about_app_fragment").commit();
        } else if (intentStr.equals(getString(R.string.ADD_NEW_TASK_INTENT))) {
            getSupportFragmentManager().beginTransaction().replace(R.id.second_activity_fragment_container, new AddNewTaskFragment(),
                    "add_new_task_fragment").commit();
        } else if (intentStr.equals(getString(R.string.TASK_DETAIL_INTENT))) {
            getSupportFragmentManager().beginTransaction().replace(R.id.second_activity_fragment_container,
                    new TaskDetailFragment(getIntent().getIntExtra(getString(R.string.TASK_ENTITY_ID), -1), getIntent().getBooleanExtra(
                            getString(R.string.EXTRA_INTENT_INFO_KEY), false)), "task_detail_fragment").commit();
        }
    }

}