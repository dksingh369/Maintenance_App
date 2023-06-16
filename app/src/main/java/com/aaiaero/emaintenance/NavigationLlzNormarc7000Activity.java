package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NavigationLlzNormarc7000Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_normarc7000);

        setTitle("Normarc 7000 LLZ Maintenance");


        Intent intent = getIntent();
    }

    public void dailyClicked (View view){
        // Launch the VHF Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(), LlzNormarc7000DailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){
        // Launch the DVR Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000WeeklyActivity.class);
        startActivity(intent);


    }

    public void monthlyClicked (View view){
        // Launch the VCS Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterlyClicked (View view){
        // Launch the RCAG Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000QuarterlyActivity.class);
        startActivity(intent);


    }

    public void sixmonthlyClicked (View view){
        // Launch the UAH Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000SixActivity.class);
        startActivity(intent);

    }

    public void annualClicked (View view){
        // Launch the ADSB Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000AnnualActivity.class);
        startActivity(intent);

    }

    public void wfrClicked (View view){
        // Launch the UAH Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000WfrActivity.class);
        startActivity(intent);

    }

    public void mfrClicked (View view){
        // Launch the ADSB Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),LlzNormarc7000MfrActivity.class);
        startActivity(intent);

    }

}