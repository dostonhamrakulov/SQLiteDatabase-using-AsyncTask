package com.idoston.adaptivesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Adaptive extends AppCompatActivity {

    EditText take_min_ranking, take_max_ranking;
    Spinner spinner;
    Button get_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptive);

        take_min_ranking = (EditText)findViewById(R.id.take_min_ranking);
        take_max_ranking = (EditText)findViewById(R.id.take_max_ranking);
        spinner = (Spinner)findViewById(R.id.take_continent);
        get_result = (Button) findViewById(R.id.get_result);

        get_result.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Adaptive.this, Adaptive_display.class);
                        intent.putExtra("Minimum", take_min_ranking.getText().toString());
                        intent.putExtra("Maximum", take_max_ranking.getText().toString());
                        intent.putExtra("Continent", spinner.getSelectedItem().toString());
                        startActivity(intent);
                        Toast.makeText(Adaptive.this, "It is still in process!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}
