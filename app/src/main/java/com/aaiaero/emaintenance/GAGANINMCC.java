package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GAGANINMCC extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaganinmcc);



    }

    public void dailyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),GAGANINMCCDaily.class);
        startActivity(intent);


    }




    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(),GAGANINMCCMonthly.class);
        startActivity(intent);

    }


    public void premonsoon (View view){

        Intent intent = new Intent(getApplicationContext(),GAGANINMCCpremonsoon.class);
        startActivity(intent);

    }


    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GAGANINMCCSixMonthly.class);
        startActivity(intent);


    }



}

