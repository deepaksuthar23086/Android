package com.example.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    SearchView searchView;
    RecyclerView recyclerView;
    CustomAddepter customAddepter;
    ArrayList<String> fname,lname,number;
    FloatingActionButton floatingActionButton;
    DbManager DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recyclerview);

        DB = new DbManager(this);

        fname = new ArrayList<>();
        lname = new ArrayList<>();
        number = new ArrayList<>();

        customAddepter = new CustomAddepter(this,fname,lname,number);
        recyclerView.setAdapter(customAddepter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, contectinfomention.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "gnada bacha", Toast.LENGTH_LONG);
            }
        });



        Cursor cursor = new DbManager(this).readRecord();

        while (cursor.moveToNext()){
            fname.add(cursor.getString(0));
            lname.add(cursor.getString(1));
            number.add(cursor.getString(2));
        }





//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.crime)));

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        MenuItem menuItem = menu.findItem(R.id.searchItem);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint("Search here");
//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                return false;
//            }
//        });
//        inflater.inflate(R.menu.optionmenu, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        return super.onOptionsItemSelected(item);
//
//    }
}