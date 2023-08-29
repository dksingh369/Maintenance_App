package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GaganInlusWestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagan_inlus_west);

        setTitle("GAGAN INLUS West Maintenance");
    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GaganInlusWestDailyActivity.class);
        startActivity(intent);

    }

    public void weeklyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusWestWeeklyActivity.class);
        startActivity(intent);

    }


    public void monthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusWestMonthlyActivity.class);
        startActivity(intent);
    }
    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GaganInlusWestQuarterlyActivity.class);
        startActivity(intent);
    }
    public void sixMonthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusWestSixMonthlyActivity.class);
        startActivity(intent);


    }
    public void preMonsoonClicked (View view){
        Intent intent = new Intent(getApplicationContext(),GaganInlusWestPreMonsoonActivity.class);
        startActivity(intent);

    }

}