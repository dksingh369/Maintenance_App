package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationGpNormarc35Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_gp_normarc35);
    }
    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpNormarc35DailyActivity.class);
        startActivity(intent);

    }

    public void weeklyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), GpNormarc35WeeklyActivity.class);
        startActivity(intent);

    }


    public void quarterlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), GpNormarc35QuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), GpNormarc35SixActivity.class);
        startActivity(intent);

    }


}