package com.example.bizam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Elektronik extends AppCompatActivity {
    private ListView listView;
    TextView back1;
    private String[] mİcecekler = {"Televizyon", "Bilgisayar", "Telefon", "Tablet", "Akıllı Saat", "Kulaklık", "Mikrofon",
            "Oyun Konsolu","Yazıcı","Fırın","Buzdolabı","Ütü","Çamaşır Makinesi","Bulaşık Makinesi","Süpürge"};
    int mresim[] = {R.drawable.televisions, R.drawable.computer,R.drawable.phone, R.drawable.tablet, R.drawable.smartwatch,
            R.drawable.headphones, R.drawable.microphone, R.drawable.console,
            R.drawable.printer,R.drawable.oven,R.drawable.freezer,R.drawable.iron,R.drawable.washingmachine,
            R.drawable.dishwasher,R.drawable.vacuumcleaner};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elektronik);
        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Elektronik.this, Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(Elektronik.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Elektronik.this, R.color.gri));

        listView=(ListView) findViewById(R.id.listview);
        benimadapter adapter =new benimadapter(this,mİcecekler,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(Elektronik.this,televizyon.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==1){
                    Intent intent= new Intent(Elektronik.this,bilgisayar.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==2){
                    Intent intent= new Intent(Elektronik.this,telefon.class);
                    startActivity(intent);
                    finish();

                }
                else if (position==3){
                    Intent intent= new Intent(Elektronik.this,tablet.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==4){
                    Intent intent= new Intent(Elektronik.this,akillisaat.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==5){
                    Intent intent= new Intent(Elektronik.this,kulaklik.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==6){
                    Intent intent= new Intent(Elektronik.this,mikrofon.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==7){
                    Intent intent= new Intent(Elektronik.this,oyunkonsolu.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==8){
                    Intent intent= new Intent(Elektronik.this,yazici.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==9){
                    Intent intent= new Intent(Elektronik.this,firin.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==10){
                    Intent intent= new Intent(Elektronik.this,buzdolabi.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==11){
                    Intent intent= new Intent(Elektronik.this,utu.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==12){
                    Intent intent= new Intent(Elektronik.this,camasirmak.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==13){
                    Intent intent= new Intent(Elektronik.this,bulasikmak.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==14){
                    Intent intent= new Intent(Elektronik.this,supurge.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
    class benimadapter extends ArrayAdapter<String> {
        Context context;
        String rİcecekler[];
        int rResim[];

        benimadapter(Context c, String icecekler[], int resim[]) {
            super(c, R.layout.listview, R.id.text10, icecekler);
            this.context = c;
            this.rİcecekler = icecekler;
            this.rResim = resim;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View satir=layoutInflater.inflate(R.layout.listview,parent,false);
            ImageView resim= satir.findViewById(R.id.listviewresim1);
            TextView benimİcecekler=satir.findViewById(R.id.text10);
            resim.setImageResource(rResim[position]);
            benimİcecekler.setText(rİcecekler[position]);
            return satir;
        }


    }



}
