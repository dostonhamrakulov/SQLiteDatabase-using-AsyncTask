package com.idoston.adaptivesystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Doston on 12/15/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context context;
    MyDatabaseHelper myDatabaseHelper;
    BackgroundTask(Context ctx){
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {

        myDatabaseHelper = myDatabaseHelper =  new MyDatabaseHelper(context);

        String methos = voids[0];
        if (methos.equals("add_info")){
            String name = voids[1];
            String ranking = voids[2];
            String tuition = voids[3];
            String program = voids[4];
            String city = voids[5];
            String country = voids[6];
            String continent = voids[7];

            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
            myDatabaseHelper.insertData(name, ranking, tuition, program, city, country, continent);

            return "One row is inserted ... ";
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
