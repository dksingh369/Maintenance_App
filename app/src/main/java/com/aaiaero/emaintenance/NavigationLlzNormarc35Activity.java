package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationLlzNormarc35Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_normarc35);
    }
    public void dailyClicked (View view){
        // Launch the VHF Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(), LlzNormarc35DailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzNormarc35WeeklyActivity.class);
        startActivity(intent);


    }

    public void monthlyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),LlzNormarc35MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzNormarc35QuarterlyActivity.class);
        startActivity(intent);


    }

    public void sixmonthlyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),LlzNormarc35SixActivity.class);
        startActivity(intent);

    }

    public void annualClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzNormarc35AnnualActivity.class);
        startActivity(intent);

    }

    public void dfrClicked (View view){


        Intent intent = new Intent(getApplicationContext(),LlzNormarc35DfrActivity.class);
        startActivity(intent);

    }

    public void mfrClicked (View view){

       // Intent intent = new Intent(getApplicationContext(),LlzNormarc7000MfrActivity.class);
      //  startActivity(intent);

    }

}