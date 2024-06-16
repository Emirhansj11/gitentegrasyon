package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class Onboarding2 extends AppCompatActivity {
    Button skipbutton;
    Button premiumbutton;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);

        getWindow().setStatusBarColor(ContextCompat.getColor(Onboarding2.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Onboarding2.this, R.color.gri));

        skipbutton=findViewById(R.id.buttonskip);
        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Onboarding2.this,Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });

        premiumbutton=findViewById(R.id.buttonpremium);
        premiumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Onboarding2.this, "Premium sürümü bir sonraki güncelleme ile aktifleşecektir", Toast.LENGTH_LONG).show();
            }
        });

        fragmentManager=getSupportFragmentManager();


        final PaperOnboardingFragment paperOnboardingFragment=PaperOnboardingFragment.newInstance(getPaperOnboardingPages());
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.onboarding,paperOnboardingFragment);
        fragmentTransaction.commit();
    }

    private ArrayList<PaperOnboardingPage> getPaperOnboardingPages() {

        PaperOnboardingPage src1= new PaperOnboardingPage("Premium Ayrıcalıklarını Keşfedin","Bi Zam Premium'dan faydalanmaya başlayın",
                Color.parseColor("#FF737373"),R.drawable.discovery,R.drawable.discovery);

        PaperOnboardingPage src2= new PaperOnboardingPage("Reklam Yok","Bi Zam Premium'da reklam derdine son.",
                Color.parseColor("#FF737373"),R.drawable.reklam,R.drawable.reklam);

        PaperOnboardingPage src3= new PaperOnboardingPage("Geleceğe Yönelik Fiyat Tahminleri",
                "Ürünlerin bir,üç ve beş yıl sonraki ortalama fiyat tahminlerine erişim",
                Color.parseColor("#FF737373"),R.drawable.gelecek,R.drawable.gelecek);

        PaperOnboardingPage src4= new PaperOnboardingPage("Yurtdışı Fiyatlarına Erişim",
                "Ürünlerin yurtdışındaki ortalama fiyatları ve zam oranlarına erişim",
                Color.parseColor("#FF737373"),R.drawable.dolarandeuro,R.drawable.dolarandeuro);

        PaperOnboardingPage src5= new PaperOnboardingPage("Marka Fiyatlarına Erişim",
                "İlgili ürünün marka fiyatlarına erişim",
                Color.parseColor("#FF737373"),R.drawable.brand,R.drawable.brand);

        PaperOnboardingPage src6= new PaperOnboardingPage("Bi Zam Yatırım Araçları",
                "Bi Zam Yatırım Araçları kategorisine erişim",
                Color.parseColor("#FF737373"),R.drawable.timetable128,R.drawable.timetable128);

        PaperOnboardingPage src7= new PaperOnboardingPage("Arttırılmış Ürün Çeşitliliği",
                "Normale göre %40 ila %60 arasında fazladan ürün",
                Color.parseColor("#FF737373"),R.drawable.arttirmak,R.drawable.arttirmak);


        PaperOnboardingPage src8= new PaperOnboardingPage("Zam Şampiyonları Bölümü",
                "Zam Şampiyonları bölümünün tamamına erişim",
                Color.parseColor("#FF737373"),R.drawable.zam,R.drawable.zam);




        ArrayList<PaperOnboardingPage> elements= new ArrayList<>();
        elements.add(src1);
        elements.add(src2);
        elements.add(src3);
        elements.add(src4);
        elements.add(src5);
        elements.add(src6);
        elements.add(src7);
        elements.add(src8);
        return  elements;

    }


}