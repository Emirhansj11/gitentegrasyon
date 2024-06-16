package com.example.bizam;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Kaydedilenler extends AppCompatActivity {
    private AdRequest adRequest;
    private AdView adView;
    private void init(){
        adView=findViewById(R.id.banner1);
        adRequest= new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    TextView back1;
    ImageView armutImageview,ayakkabiImageview,ayranImageview,bezelyeImageview;
    CardView cardview1;
    String icon;
    SharedPreferences sharedpref;
    LinearLayout linear15;
    AdView banner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydedilenler);
        init();
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

            }
        });





       linear15=findViewById(R.id.linear15);
       armutImageview= new ImageView(this);
       ayakkabiImageview= new ImageView(this);
       ayranImageview= new ImageView(this);
       bezelyeImageview=new ImageView(this);
       sharedpref=getSharedPreferences(getString(R.string.preference_file_key),MODE_PRIVATE);
       boolean armut=sharedpref.getBoolean("armut",false);
       boolean ayakkabi=sharedpref.getBoolean("ayakkabi",false);
       boolean ayran=sharedpref.getBoolean("ayran",false);
       boolean bezelye=sharedpref.getBoolean("bezelye",false);
       if (armut){
           armutImageview.setImageResource(R.drawable.pear);
           linear15.addView(armutImageview);
       }
       if (ayakkabi){
           ayakkabiImageview.setImageResource(R.drawable.shoes);
           linear15.addView(ayakkabiImageview);
       }
       if (ayran){
           ayranImageview.setImageResource(R.drawable.ayran);
           linear15.addView(ayranImageview);
       }
       if (bezelye){
           bezelyeImageview.setImageResource(R.drawable.pea);
           linear15.addView(bezelyeImageview);

       }
        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kaydedilenler.this, Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });



        getWindow().setStatusBarColor(ContextCompat.getColor(Kaydedilenler.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Kaydedilenler.this, R.color.gri));




    }



}
