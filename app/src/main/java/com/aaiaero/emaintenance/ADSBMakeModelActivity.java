package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ADSBMakeModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adsbmake_model);

        Button comsoft = (Button) findViewById(R.id.comsoft);
        Button gecl = (Button) findViewById(R.id.gecl);

        comsoft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ADSBActivity.class);
                startActivity(intent);
            }
        });

        gecl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),AdsbGeclActivity.class);
                startActivity(intent);

            }
        });
    }
}