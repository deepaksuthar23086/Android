package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class SQLDatabase extends SQLiteOpenHelper {
    private Context context;
    public static final String DSName = "student.db";
    private static final String TABLE_NAME = "student_table";
    private static final String FIRST_NAME = "fName";
    private static final String LAST_NAME = "lName";
    private static final String EMAIL = "mail";
    private static final String NUMBER = "number";
    private static final String ID_NUMBER = "id";
    public SQLDatabase(@Nullable Context context) {
        super(context, DSName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + ID_NUMBER + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIRST_NAME + " TEXT, " +
                LAST_NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                NUMBER + " TEXT);";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }
    public void addStudent(String fName, String lName, String email, String number){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FIRST_NAME, fName);
        cv.put(LAST_NAME, lName);
        cv.put(EMAIL, email);
        cv.put(NUMBER, number);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1)
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Success Full", Toast.LENGTH_SHORT).show();
    }
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
