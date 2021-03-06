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
import android.widget.Toast;

public class MainActivity_0 extends AppCompatActivity {

    DefaultValues defaultValues = new DefaultValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_0);
    }
    public void Start(View view){

        startActivity(new Intent(MainActivity_0.this, MainActivity.class));
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
        } else if (id == R.id.id_default_values){
            for(int i = 0; i < 5; i++){
                BackgroundTask backgroundTask= new BackgroundTask(this);
                backgroundTask.execute("add_info", defaultValues.getNAME(i), defaultValues.getRANK(i),
                        defaultValues.getFEE(i), defaultValues.getPROGRAM(i),
                        defaultValues.getCITY(i), defaultValues.getCOUNTRY(i), defaultValues.getCONTINENT(i));
            }
            Toast.makeText(this, "All default values are loaded!", Toast.LENGTH_LONG).show();
        } else if (id == R.id.id_about_using){
            Toast.makeText(MainActivity_0.this, "I am Junior Android Developer. If you want, you can reach at me by doston2509@gmail.com",
                    Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MainActivity_0.this, "Good bye!!!", Toast.LENGTH_SHORT).show();
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
