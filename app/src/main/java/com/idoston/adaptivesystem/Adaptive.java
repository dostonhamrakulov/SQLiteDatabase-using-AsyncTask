package com.idoston.adaptivesystem;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        //To add icon to actionBar

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayUseLogoEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setLogo(R.drawable.ic_phone_android_black_24dp);

        //To enable "add up button in actionBar" 'back button'
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_action, menu);

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(Adaptive.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                Toast.makeText(Adaptive.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(Adaptive.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(Adaptive.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_exit_app:
                finish();
                System.exit(0);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
