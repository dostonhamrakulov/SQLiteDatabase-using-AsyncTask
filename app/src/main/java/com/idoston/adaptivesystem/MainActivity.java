package com.idoston.adaptivesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView welcome, starter;
    Button btn_insert, btn_search, btn_adaptive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView)findViewById(R.id.welcome);
        starter = (TextView) findViewById(R.id.starter);
        btn_insert = (Button) findViewById(R.id.btn_moveInsert);
        btn_search = (Button) findViewById(R.id.btn_moveSearch);
        btn_adaptive = (Button) findViewById(R.id.btn_search);


        welcome.setVisibility(View.INVISIBLE);
        btn_search.setVisibility(View.INVISIBLE);
        btn_insert.setVisibility(View.INVISIBLE);
        btn_adaptive.setVisibility(View.INVISIBLE);

        starter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        welcome.setVisibility(View.VISIBLE);
                        btn_insert.setVisibility(View.VISIBLE);
                        btn_search.setVisibility(View.VISIBLE);
                        starter.setVisibility(View.INVISIBLE);
                        btn_adaptive.setVisibility(View.VISIBLE);
                    }
                }
        );
    }

    public void MoveInsert(View view){
        startActivity(new Intent(MainActivity.this, Inserting.class));
        Toast.makeText(MainActivity.this, "Moving to Insert activity", Toast.LENGTH_LONG).show();
    }
    public void MoveView(View view){
        startActivity(new Intent(MainActivity.this, Displaying.class));
        Toast.makeText(MainActivity.this, "Moving to View activity", Toast.LENGTH_LONG).show();
    }
    public void MoveAdaptive(View view){
        startActivity(new Intent(MainActivity.this, Adaptive.class));
        Toast.makeText(MainActivity.this, "Moving to Adaptive system!!", Toast.LENGTH_LONG).show();
    }
}
