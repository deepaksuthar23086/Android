package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    SQLDatabase sqlDatabase;
    ArrayList<String> fname, lname, email, number;
    CustomAdepter customAdepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddStudent.class);
                startActivity(intent);
            }
        });
        sqlDatabase = new SQLDatabase(MainActivity.this);
        fname = new ArrayList<>();
        lname = new ArrayList<>();
        email = new ArrayList<>();
        number = new ArrayList<>();
        storeDataInArray();
        customAdepter = new CustomAdepter(MainActivity.this, fname, lname, email, number);
        recyclerView.setAdapter(customAdepter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    public void storeDataInArray(){
        Cursor cursor = sqlDatabase.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                fname.add(cursor.getString(0));
                lname.add(cursor.getString(1));
                email.add(cursor.getString(2));
                number.add(cursor.getString(3));
            }
        }
    }
}