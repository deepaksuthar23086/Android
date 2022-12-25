package com.example.jsonstring;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    String url = "https://run.mocky.io/v3/b14d41f9-d357-4e48-ae62-4239946be56c";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
    }
    public void OnClick(View view){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @SuppressLint("ShowToast")
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response.toString());
                        button.setText("Success Full");
                        Toast.makeText(getApplicationContext(), "Response", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @SuppressLint("ShowToast")
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        button.setText("Error");
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(stringRequest);

    }
}