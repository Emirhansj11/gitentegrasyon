package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GidaActivity extends AppCompatActivity {
    CardView icecekler;
    CardView meyvesebze;
    CardView eturunleri;
    TextView back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gida);
        back2=(TextView)findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GidaActivity.this,Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(GidaActivity.this,R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(GidaActivity.this,R.color.gri));
        icecekler=(CardView)findViewById(R.id.icecekler);
        meyvesebze=(CardView)findViewById(R.id.meyvesebze);
        eturunleri=(CardView)findViewById(R.id.eturunleri);

        icecekler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GidaActivity.this,Icecekler.class);
                startActivity(intent);
                finish();

            }
        });

        meyvesebze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GidaActivity.this,MeyveSebze.class);
                startActivity(intent);
                finish();
            }
        });

        eturunleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GidaActivity.this,EtUrunleri.class);
                startActivity(intent);
                finish();
            }
        });

    }
}