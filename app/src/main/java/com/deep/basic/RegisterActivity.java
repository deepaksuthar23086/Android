package com.deep.basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText firstname, lastname, number, password, email, repaitpassword;
    Button signup;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        number = findViewById(R.id.number);
        email = findViewById(R.id.email2);
        repaitpassword = findViewById(R.id.repaitpassword);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String mail = email.getText().toString();
                String mobile = number.getText().toString();
                String pass = password.getText().toString();
                String rpass = repaitpassword.getText().toString();

                Intent intent = new Intent(RegisterActivity.this, Detail.class);

                intent.putExtra("keyfname", fname);
                intent.putExtra("keylname", lname);
                intent.putExtra("keyemail", mail);
                intent.putExtra("keynumber", mobile);
                intent.putExtra("keypassword", pass);
                intent.putExtra("keyrepaitpassword", rpass);

                startActivity(intent);
                finish();
                Toast.makeText(RegisterActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}