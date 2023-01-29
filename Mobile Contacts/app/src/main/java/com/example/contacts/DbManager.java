package com.example.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

class DbManager extends SQLiteOpenHelper{

    public static final String dbName = "contact.db";
    public DbManager(Context context) {
        super(context,dbName,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table contact_number(id integer primary key autoincrement, firstName text, lastName text, email text, number text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_number");
        onCreate(sqLiteDatabase);
    }
    public Boolean addRecord(String firstName, String lastName, String number, String email){

        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("number", number);
        contentValues.put("email", email);
        Long contain = sqLiteDatabase.insert("contact_number", null, contentValues);
        if (contain==0){
            Log.d("addRecord", "false ");
            return false;
        }else {
            Log.d("addRecord", "true ");
            return true;
        }

    }
    public Cursor readRecord(){

        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
//order by id desc
        String quy = "select * from contact_number";
        Cursor cursor = sqLiteDatabase.rawQuery(quy, null);
        return cursor;
    }

}
