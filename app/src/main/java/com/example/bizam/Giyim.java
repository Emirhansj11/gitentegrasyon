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

public class Giyim extends AppCompatActivity {
    private ListView listView;
    TextView back1;
    private String[] mİcecekler = {"Hırka", "Sweatshirt", "Eşofman", "Mont", "Etek", "Elbise", "Pantalon", "Şort","Gömlek",
            "T-shirt","Ceket","Pijama","Ayakkabı"};
    int mresim[] = {R.drawable.cardigan, R.drawable.sweatshirt, R.drawable.tracksuit, R.drawable.coat,
            R.drawable.skirt,R.drawable.dress, R.drawable.trousers, R.drawable.shorts,
            R.drawable.shirt,R.drawable.tshirt2,R.drawable.jacket,R.drawable.pyjamas,R.drawable.shoes};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giyim);

        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Giyim.this, Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(Giyim.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Giyim.this, R.color.gri));

        listView=(ListView) findViewById(R.id.listview);
        benimadapter adapter =new benimadapter(this,mİcecekler,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(Giyim.this,hirka.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==1){
                    Intent intent= new Intent(Giyim.this,sweatshirt.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==2){
                    Intent intent= new Intent(Giyim.this,esofman.class);
                    startActivity(intent);
                    finish();

                }
                else if (position==3){
                    Intent intent= new Intent(Giyim.this,mont.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==4){
                    Intent intent= new Intent(Giyim.this,etek.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==5){
                    Intent intent= new Intent(Giyim.this,elbise.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==6){
                    Intent intent= new Intent(Giyim.this,pantalon.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==7){
                    Intent intent= new Intent(Giyim.this,sort.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==8){
                    Intent intent= new Intent(Giyim.this,gomlek.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==9){
                    Intent intent= new Intent(Giyim.this,tshirt.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==10){
                    Intent intent= new Intent(Giyim.this,ceket.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==11){
                    Intent intent= new Intent(Giyim.this,pijama.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==12){
                    Intent intent= new Intent(Giyim.this,ayakkabi.class);
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
