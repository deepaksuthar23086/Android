package com.deep.basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    TextView firstname1, lastname1, email1, number1, password1, repaitpassword1, loginemail, loginpass;

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
        loginemail = findViewById(R.id.loginemail);
        loginpass = findViewById(R.id.loginpass);

        String fname = getIntent().getStringExtra("keyfname");
        String lname = getIntent().getStringExtra("keylname");
        String mobileemail = getIntent().getStringExtra("keyemail");
        String mobilenumber = getIntent().getStringExtra("keynumber");
        String pass = getIntent().getStringExtra("keypassword");
        String repaitpass = getIntent().getStringExtra("keyrepaitpassword");
        String loginmemail = getIntent().getStringExtra("keyloginemial");
        String loginpassword = getIntent().getStringExtra("keyloginpass");

        firstname1.setText(fname);
        lastname1.setText(lname);
        email1.setText(mobileemail);
        number1.setText(mobilenumber);
        password1.setText(pass);
        repaitpassword1.setText(repaitpass);
        loginemail.setText(loginmemail);
        loginpass.setText(loginpassword);


    }
}