package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NDBSAC extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndbsac);





    }
    public void sac100 (View view){

        Intent intent = new Intent(getApplicationContext(), NDBSAC100.class);
        startActivity(intent);


    }

    public void sac500 (View view){

        Intent intent = new Intent(getApplicationContext(),NDBSAC500.class);
        startActivity(intent);


    }





}