package com.idoston.adaptivesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Adaptive_display extends AppCompatActivity {

    private String minimum, maximum;
    private String continent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptive_display);

        Intent intent = getIntent();
        minimum = intent.getStringExtra("Minimum");
        maximum = intent.getStringExtra("Maximum");
        continent = intent.getStringExtra("Continent");

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.setAdaptiveParameters(Integer.parseInt(minimum), Integer.parseInt(maximum), continent);
        backgroundTask.execute("get_adaptive");
    }
}
