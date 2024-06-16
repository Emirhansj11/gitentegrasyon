package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.bizam.Adapters.CustomViewPager;
import com.example.bizam.fragments.besyil;
import com.example.bizam.fragments.biryil;
import com.example.bizam.fragments.ucyil;
import com.google.android.material.tabs.TabLayout;

public class ZamSampiyonlari extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout mTabLayout;
    private CustomViewPager mAdapter;

    private void init(){
        viewPager=findViewById(R.id.viewpager);
        mTabLayout=findViewById(R.id.tablelayout);

        mAdapter= new CustomViewPager(getSupportFragmentManager());
        mAdapter.addFragment(new biryil(),"1 yıl");
        mAdapter.addFragment(new ucyil(),"3 yıl");
        mAdapter.addFragment(new besyil(),"5 yıl");
        viewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(viewPager);
    }
    TextView back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zam_sampiyonlari);
        init();


        back1 = (TextView) findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZamSampiyonlari.this, Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });



        getWindow().setStatusBarColor(ContextCompat.getColor(ZamSampiyonlari.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(ZamSampiyonlari.this, R.color.gri));

    }
}