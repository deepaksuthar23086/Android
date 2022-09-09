package com.deep.basic;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoadingHomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

//        This is working, and write code.
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this, LoadingHomeActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 3000);
//        Toast.makeText(this, "Wallcome", Toast.LENGTH_SHORT).show();

    }

}