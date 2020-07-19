package com.example.connectfourandcrisscross;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseClass {
    private SQLiteDatabase db;
    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_PASSWORD = "password";
    private static final String DB_NAME = "name_password_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A =
            "name_and_password";
    public DatabaseClass(Context context){
        CustomSQLiteOpenHelper helper = new
                CustomSQLiteOpenHelper(context);
        db=db = helper.getWritableDatabase();
    }
    public void insert(String name, String password){
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_PASSWORD +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + password + "'" +
                ");";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }
    public Cursor searchName(String name) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_PASSWORD +
                " from " +
                TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';";
        Log.i("searchName() = ", query);
        Cursor c = db.rawQuery(query, null);
        return c;
    }
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String newTableQueryString = "create table "
                    + TABLE_N_AND_A + " ("
                    + TABLE_ROW_ID
                    + " integer primary key"
                    +" autoincrement not null,"
                    + TABLE_ROW_NAME
                    + " text not null,"
                    + TABLE_ROW_PASSWORD
                    + " text not null);";
            db.execSQL(newTableQueryString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
