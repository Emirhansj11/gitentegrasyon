package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

public class EvEsyalari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ev_esyalari);
        getWindow().setStatusBarColor(ContextCompat.getColor(EvEsyalari.this,R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(EvEsyalari.this,R.color.gri));
    }
}