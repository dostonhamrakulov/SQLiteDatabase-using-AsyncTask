package com.idoston.adaptivesystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    Button btn_insert, btn_search, btn_adaptive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView)findViewById(R.id.welcome);

        btn_insert = (Button) findViewById(R.id.btn_moveInsert);
        btn_search = (Button) findViewById(R.id.btn_moveSearch);
        btn_adaptive = (Button) findViewById(R.id.btn_search);

        //To enable "add up button in actionBar" 'back button'
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    public void MoveInsert(View view){
        startActivity(new Intent(MainActivity.this, Inserting.class));
        Toast.makeText(MainActivity.this, "Moving to Insert activity", Toast.LENGTH_SHORT).show();
    }
    public void MoveView(View view){
        startActivity(new Intent(MainActivity.this, Displaying.class));
        Toast.makeText(MainActivity.this, "Moving to View activity", Toast.LENGTH_SHORT).show();
    }
    public void MoveAdaptive(View view){
        startActivity(new Intent(MainActivity.this, Adaptive.class));
        Toast.makeText(MainActivity.this, "Moving to Adaptive system!!", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(MainActivity.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                Toast.makeText(MainActivity.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(MainActivity.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(MainActivity.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_exit_app:
                Exit_alert();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Exit_alert(){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage("Do you want to close this app?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Good bye!!!", Toast.LENGTH_SHORT).show();
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = alert_builder.create();
        alert.setTitle("Alert!!!");
        alert.show();
    }
}
