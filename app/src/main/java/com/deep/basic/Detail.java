package com.deep.basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    TextView firstname1, lastname1, email1, number1, password1, repaitpassword1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        firstname1 = findViewById(R.id.fname);
        lastname1 =findViewById(R.id.lname);
        email1 = findViewById(R.id.email3);
        number1 = findViewById(R.id.number2);
        password1 = findViewById(R.id.password1);
        repaitpassword1 = findViewById(R.id.repaitpassword1);

        String firstname = getIntent().getStringExtra("fiestname");
        String lastname = getIntent().getStringExtra("lastname");
        String email = getIntent().getStringExtra("email");
        String number = getIntent().getStringExtra("number");
        String password = getIntent().getStringExtra("password");
        String repaitpassword = getIntent().getStringExtra("repaitpassword");

        firstname1.setText(firstname);
        firstname1.setText(lastname);
        firstname1.setText(email);
        firstname1.setText(number);
        firstname1.setText(password);
        firstname1.setText(repaitpassword);


    }
}