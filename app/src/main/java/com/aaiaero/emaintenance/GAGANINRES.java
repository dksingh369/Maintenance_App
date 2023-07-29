package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GAGANINRES extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaganinres);



    }

    public void dailyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),GAGANINRESDaily.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),GAGANINRESWeekly.class);
        startActivity(intent);


    }






    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(),GAGANINRESMonthly.class);
        startActivity(intent);

    }


    public void premonsoon (View view){

        Intent intent = new Intent(getApplicationContext(),GAGANINRESpremonsoon.class);
        startActivity(intent);

    }


    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GAGANINRESSixMonthly.class);
        startActivity(intent);


    }



}