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
        menuInflater.inflate(R.menu.menu_main, menu);

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
        if (id == R.id.id_exit_app_home) {

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
