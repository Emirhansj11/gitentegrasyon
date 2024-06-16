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

public class EtUrunleri extends AppCompatActivity {

    private ListView listView;
    TextView back1;
    private String[] mİcecekler = {"Kıyma", "Sucuk", "Salam", "Sosis", "Pastırma", "Tavuk Baget", "Hamsi", "Levrek","Palamut"};
    int mresim[] = {R.drawable.mince, R.drawable.sucuk, R.drawable.salami, R.drawable.sausage,
            R.drawable.bacon,R.drawable.chickenleg, R.drawable.hamsi, R.drawable.levrek, R.drawable.palamut,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et_urunleri);

        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EtUrunleri.this, GidaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(EtUrunleri.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(EtUrunleri.this, R.color.gri));

        listView=(ListView) findViewById(R.id.listview);
        benimadapter adapter =new benimadapter(this,mİcecekler,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(EtUrunleri.this,kiyma.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==1){
                    Intent intent= new Intent(EtUrunleri.this,sucuk.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==2){
                    Intent intent= new Intent(EtUrunleri.this,salam.class);
                    startActivity(intent);
                    finish();

                }
                else if (position==3){
                    Intent intent= new Intent(EtUrunleri.this,sosis.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==4){
                    Intent intent= new Intent(EtUrunleri.this,pastirma.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==5){
                    Intent intent= new Intent(EtUrunleri.this,tavukbaget.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==6){
                    Intent intent= new Intent(EtUrunleri.this,hamsi.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==7){
                    Intent intent= new Intent(EtUrunleri.this,levrek.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==8){
                    Intent intent= new Intent(EtUrunleri.this,palamut.class);
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
