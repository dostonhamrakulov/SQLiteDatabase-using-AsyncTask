package com.idoston.adaptivesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome, starter;
    Button btn_insert, btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView)findViewById(R.id.welcome);
        starter = (TextView) findViewById(R.id.starter);
        btn_insert = (Button) findViewById(R.id.btn_moveInsert);
        btn_search = (Button) findViewById(R.id.btn_moveSearch);

        welcome.setVisibility(View.INVISIBLE);
        btn_search.setVisibility(View.INVISIBLE);
        btn_insert.setVisibility(View.INVISIBLE);

        starter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        welcome.setVisibility(View.VISIBLE);
                        btn_insert.setVisibility(View.VISIBLE);
                        btn_search.setVisibility(View.VISIBLE);
                        starter.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    public void MoveInsert(View view){
        //startActivity(new Intent(MainActivity.this, InsertItem.class));
    }
}
