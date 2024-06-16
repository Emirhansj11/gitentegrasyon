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

public class MeyveSebze extends AppCompatActivity {
    TextView back1;

    private String[] mİcecekler = {"Domates", "Patates", "Salatalık", "Soğan", "Ispanak", "Havuç", "Pırasa", "Karnabahar","Brokoli",
            "Marul","Fasulye","Bezelye","Kabak","Patlıcan","Biber","Karpuz","Üzüm","Elma","Şeftali","Muz","Armut",
            "Kiraz","Portakal","Limon","Kayısı","Çilek","Nar"};
    int mresim[] = {R.drawable.tomato, R.drawable.potato, R.drawable.cucumber, R.drawable.onion,
            R.drawable.spinach, R.drawable.carrot, R.drawable.leek, R.drawable.cauliflower,R.drawable.brocoli,R.drawable.lettuce,
            R.drawable.bean,R.drawable.pea,R.drawable.courgette,R.drawable.aubergine,R.drawable.pepper,R.drawable.watermelone,
            R.drawable.grape,R.drawable.apple,R.drawable.peach,R.drawable.banana,R.drawable.pear,
            R.drawable.cherry,R.drawable.orange,R.drawable.lemon,R.drawable.apricot,R.drawable.strawberry,R.drawable.pomegranate};
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyve_sebze);

        back1=(TextView)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MeyveSebze.this,GidaActivity.class);
                startActivity(intent);

            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(MeyveSebze.this,R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MeyveSebze.this,R.color.gri));


        listView=(ListView) findViewById(R.id.listview);
        benimadapter adapter=new benimadapter(this,mİcecekler,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(MeyveSebze.this,domates.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==1){
                    Intent intent= new Intent(MeyveSebze.this,patates.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==2){
                    Intent intent= new Intent(MeyveSebze.this,salatalik.class);
                    startActivity(intent);
                    finish();

                }
                else if (position==3){
                    Intent intent= new Intent(MeyveSebze.this,sogan.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==4){
                    Intent intent= new Intent(MeyveSebze.this,ispanak.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==5){
                    Intent intent= new Intent(MeyveSebze.this,havuc.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==6){
                    Intent intent= new Intent(MeyveSebze.this,pirasa.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==7){
                    Intent intent= new Intent(MeyveSebze.this,karnabahar.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==8){
                    Intent intent= new Intent(MeyveSebze.this,brokoli.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==9){
                    Intent intent= new Intent(MeyveSebze.this,marul.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==10){
                    Intent intent= new Intent(MeyveSebze.this,fasulye.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==11){
                    Intent intent= new Intent(MeyveSebze.this,bezelye.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==12){
                    Intent intent= new Intent(MeyveSebze.this,kabak.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==13){
                    Intent intent= new Intent(MeyveSebze.this,patlican.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==14){
                    Intent intent= new Intent(MeyveSebze.this,biber.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==15){
                    Intent intent= new Intent(MeyveSebze.this,karpuz.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==16){
                    Intent intent= new Intent(MeyveSebze.this,uzum.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==17){
                    Intent intent= new Intent(MeyveSebze.this,elma.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==18){
                    Intent intent= new Intent(MeyveSebze.this,seftali.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==19){
                    Intent intent= new Intent(MeyveSebze.this,muz.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==20){
                    Intent intent= new Intent(MeyveSebze.this,armut.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==21){
                    Intent intent= new Intent(MeyveSebze.this,kiraz.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==22){
                    Intent intent= new Intent(MeyveSebze.this,portakal.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==23){
                    Intent intent= new Intent(MeyveSebze.this,limon.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==24){
                    Intent intent= new Intent(MeyveSebze.this,kayisi.class);
                    startActivity(intent);
                    finish();
                }

                else if (position==25){
                    Intent intent= new Intent(MeyveSebze.this,cilek.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==26){
                    Intent intent= new Intent(MeyveSebze.this,nar.class);
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













