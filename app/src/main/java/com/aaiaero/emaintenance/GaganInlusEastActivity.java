package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GaganInlusEastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagan_inlus_east);

        setTitle("GAGAN INLUS East Maintenance");
    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GaganInlusEastDailyActivity.class);
        startActivity(intent);

    }

    public void weeklyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusEastWeeklyActivity.class);
        startActivity(intent);

    }

    public void monthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusEastMonthlyActivity.class);
        startActivity(intent);
    }

    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GaganInlusEastQuarterlyActivity.class);
        startActivity(intent);
    }
    public void sixMonthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusEastSixMonthlyActivity.class);
        startActivity(intent);


    }
    public void preMonsoonClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusEastPreMonsoonActivity.class);
        startActivity(intent);

    }
}