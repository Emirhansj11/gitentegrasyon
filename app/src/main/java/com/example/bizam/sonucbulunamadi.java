package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sonucbulunamadi extends AppCompatActivity {
    TextView back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonucbulunamadi);

        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sonucbulunamadi.this, Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(sonucbulunamadi.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(sonucbulunamadi.this, R.color.gri));
    }
}