package com.idoston.adaptivesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adaptive extends AppCompatActivity {

    EditText take_min_ranking, take_max_ranking;
    Button get_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptive);

        take_min_ranking = (EditText)findViewById(R.id.take_min_ranking);
        take_max_ranking = (EditText)findViewById(R.id.take_max_ranking);

        get_result = (Button) findViewById(R.id.get_result);

        get_result.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Adaptive.this, "It is still in process!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
