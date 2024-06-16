package com.example.bizam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class Icecekler extends AppCompatActivity {
    private ListView listView;
    TextView back1;
    private String[] mİcecekler = {"Çay", "Kahve", "Kola", "Bira", "Şarap", "Süt", "Su", "Ayran"};
    int mresim[] = {R.drawable.tea, R.drawable.coffee, R.drawable.kola, R.drawable.beer,
            R.drawable.wine, R.drawable.milk, R.drawable.water, R.drawable.ayran,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icecekler);
        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Icecekler.this, GidaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(Icecekler.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Icecekler.this, R.color.gri));

        listView=(ListView) findViewById(R.id.listview);
        benimadapter adapter =new benimadapter(this,mİcecekler,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(Icecekler.this,cay.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==3){
                    Intent intent= new Intent(Icecekler.this,bira.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==4){
                    Intent intent= new Intent(Icecekler.this,sarap.class);
                    startActivity(intent);
                    finish();

                }
                else if (position==7){
                    Intent intent= new Intent(Icecekler.this,ayran.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==1){
                    Intent intent= new Intent(Icecekler.this,kahve.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==5){
                    Intent intent= new Intent(Icecekler.this,sut.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==2){
                    Intent intent= new Intent(Icecekler.this,kola.class);
                    startActivity(intent);
                    finish();
                }
                else if (position==6){
                    Intent intent= new Intent(Icecekler.this,su.class);
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




