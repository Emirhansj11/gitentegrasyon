package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    Handler h=new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MainActivity.this,R.color.gri));



        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent i=new Intent(MainActivity.this,Anasayfa.class);
                    startActivity(i);
                    finish();

            }

            },2000);
        }









    }





