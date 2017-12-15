package com.idoston.adaptivesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inserting extends AppCompatActivity {

    EditText name1, ranking1, fee1, program1, city1, country1, continent1;
    Button insert;
    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);

        myDatabaseHelper =  new MyDatabaseHelper(this);

        name1 = (EditText)findViewById(R.id.edit_name);
        ranking1 = (EditText)findViewById(R.id.edit_ranking);
        fee1 = (EditText)findViewById(R.id.edit_tuition_fee);
        program1 = (EditText)findViewById(R.id.edit_program);
        city1 = (EditText)findViewById(R.id.edit_city);
        country1 = (EditText)findViewById(R.id.edit_country);
        continent1 = (EditText)findViewById(R.id.edit_continent);

        insert = (Button)findViewById(R.id.btn_insert);

        insert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDatabaseHelper.insertData(name1.getText().toString(), ranking1.getText().toString(),
                                fee1.getText().toString(), program1.getText().toString(), city1.getText().toString(),
                                country1.getText().toString(), continent1.getText().toString());

                        Toast.makeText(Inserting.this, "New data inserted!", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
