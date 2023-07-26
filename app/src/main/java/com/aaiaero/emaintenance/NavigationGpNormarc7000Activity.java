package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationGpNormarc7000Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_gp_normarc7000);
    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpNormarc7000DailyActivity.class);
        startActivity(intent);

    }

    public void weeklyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), GpNormarc7000WeeklyActivity.class);
        startActivity(intent);

    }

    public void monthlyClicked (View view){
       // Intent intent = new Intent(getApplicationContext(), GpNormarc7000DailyActivity.class);
       // startActivity(intent);

    }

    public void quarterlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), GpNormarc7000QuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), GpNormarc7000SixActivity.class);
        startActivity(intent);

    }

    public void annualClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpNormarc7000AnnualActivity.class);
        startActivity(intent);
    }
}