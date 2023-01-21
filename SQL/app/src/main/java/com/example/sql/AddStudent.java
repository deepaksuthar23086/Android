package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity {

    EditText firstName, lastName, email, number;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        firstName = findViewById(R.id.editTextTextFirstName);
        lastName = findViewById(R.id.editTextTextLastName);
        email = findViewById(R.id.editTextTextEmailAddress);
        number = findViewById(R.id.editTextPhoneNumber);
        save = findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLDatabase database = new SQLDatabase(AddStudent.this);
                database.addStudent(
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        email.getText().toString(),
                        number.getText().toString()
                        );
            }
        });
    }
}