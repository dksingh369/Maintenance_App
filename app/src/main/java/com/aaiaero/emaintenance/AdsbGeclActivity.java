package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class AdsbGeclActivity extends AppCompatActivity {

    Button daily, monthly, quarterly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adsb_gecl);

        setTitle("ADS-B GECL Maintenance");

        daily = (Button) findViewById(R.id.daily);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        miscellaneous = (Button) findViewById(R.id.miscellaneous);

        Intent intent = getIntent();

    }

    public void dailyClicked (View view){
        // Launch the VHF Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(), SurAdsbGeclDailyActivity.class);
        startActivity(intent);


    }


    public void monthlyClicked (View view){
        // Launch the VCS Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),SurAdsbGeclMonthlyActivity.class);
        startActivity(intent);

    }

    public void quaterlyClicked (View view){
        // Launch the RCAG Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),SurAdsbGeclQuarterlyActivity.class);
        startActivity(intent);

    }


    public void miscellaneousClicked (View view){
        // Launch the Others Equipment Room Activity



    }
}
