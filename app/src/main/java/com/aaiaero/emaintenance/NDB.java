package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NDB extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndb);





    }
    public void ndbsac (View view){

        Intent intent = new Intent(getApplicationContext(), NDBSAC.class);
        startActivity(intent);


    }

    public void amplidon15770 (View view){

        Intent intent = new Intent(getApplicationContext(),NDBAmplidon15770.class);
        startActivity(intent);


    }




}