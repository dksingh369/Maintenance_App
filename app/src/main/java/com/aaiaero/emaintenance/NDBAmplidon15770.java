package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NDBAmplidon15770 extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndbamplidon15770);





    }
    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsNDBAmplidon15770Daily.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsNDBAmplidon15770Weekly.class);
        startActivity(intent);


    }



    public void monthlyClicked (View view){


        Intent intent = new Intent(getApplicationContext(), NavAidsNDBAmplidon15770Monthly.class);
        startActivity(intent);

    }





}