package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NDBSAC500 extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndbsac500);





    }
    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsNDBSAC500DailyActivity.class);
        startActivity(intent);


    }

   public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsNDBSAC500WeeklyActivity.class);
        startActivity(intent);


    }



    public void monthlyClicked (View view){


        Intent intent = new Intent(getApplicationContext(), NavAidsNDBSAC500MonthlyActivity.class);
        startActivity(intent);

    }



    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsNDBSAC500QuarterlyActivity.class);
        startActivity(intent);

    }


}

