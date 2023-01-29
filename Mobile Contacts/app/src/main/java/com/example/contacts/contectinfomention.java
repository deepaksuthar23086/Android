package com.example.contacts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class contectinfomention extends AppCompatActivity {

    EditText firstName, lastNane,email, phoneNumber;
    Button save;
    DbManager DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contectinfomention);
        firstName = findViewById(R.id.editTextTextFirstName);
        lastNane = findViewById(R.id.editTextTextLastName);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);
        save = findViewById(R.id.saveButton);
        email = findViewById(R.id.editTextTextEmailAddress);
        DB = new DbManager(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Tag", "onClick: ");
                String fname = firstName.getText().toString();
                String lname =  lastNane.getText().toString();
                String mail = email.getText().toString();
                String number = phoneNumber.getText().toString();
                boolean checkData = DB.addRecord(fname, lname, number, mail);
                if (checkData != true){
                    Toast.makeText(contectinfomention.this,"Data Insert", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(contectinfomention.this, "Data Not Inset", Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}
