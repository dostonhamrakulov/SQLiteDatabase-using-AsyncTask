package com.idoston.adaptivesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Doston on 12/15/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UNIVERSITY.DB";
    private static final String TABLE_NAME = "university_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "RANKING";
    private static final String COL_4= "TUITION_FEE";
    private static final String COL_5 = "PROGRAMS";
    private static final String COL_6 = "CITY";
    private static final String COL_7 = "COUNTRY";
    private static final String COL_8 = "CONTINENT";
    private static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" +
            COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_2 + " TEXT, " +
            COL_3 + " INTEGER, " +
            COL_4 + " TEXT, " +
            COL_5 + " TEXT, " +
            COL_6 + " TEXT, " +
            COL_7 + " TEXT, " +
            COL_8 + " TEXT);";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }
    public void insertData(String name, int ranking, String tuition_fee, String program, String city, String country, String continent){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, ranking);
        contentValues.put(COL_4, tuition_fee);
        contentValues.put(COL_5, program);
        contentValues.put(COL_6, city);
        contentValues.put(COL_7, country);
        contentValues.put(COL_8, continent);
        db.insert(TABLE_NAME, null, contentValues);

    }
    public Cursor getInformation(SQLiteDatabase sqLiteDatabase){

        String[] projections = {COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8};
        Cursor cursor =  sqLiteDatabase.query(TABLE_NAME, projections, null, null, null, null, null);

        return cursor;
    }

    public Cursor getAdaptiveData(SQLiteDatabase sqLiteDatabase, int min, int max, String continent){
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery(" select * from " + TABLE_NAME + " as U where (U.Ranking < " + max + " AND U.Ranking >  " + min + " AND U.Continent = '" + continent + "');", null);
        //sqLiteDatabase.query()
        //Cursor res = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);

        return res;
    }
}
