package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.fonts.FontStyle;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class Onboarding extends AppCompatActivity {
    Button skipbutton;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        getWindow().setStatusBarColor(ContextCompat.getColor(Onboarding.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Onboarding.this, R.color.gri));

        skipbutton=findViewById(R.id.buttonskip);
        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Onboarding.this,Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });

        fragmentManager=getSupportFragmentManager();


        final PaperOnboardingFragment paperOnboardingFragment=PaperOnboardingFragment.newInstance(getPaperOnboardingPages());
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.onboarding,paperOnboardingFragment);
        fragmentTransaction.commit();
    }

    private ArrayList<PaperOnboardingPage> getPaperOnboardingPages() {

            PaperOnboardingPage src1= new PaperOnboardingPage("Hassas Arama Çubuğu","Arama çubuğunda arattığınız kelimeyi bulabilmek için" +
                    " lütfen boşluk bırakmadan ve küçük harflerle yazın",
                    Color.parseColor("#FF737373"),R.drawable.search128,R.drawable.search128);

            PaperOnboardingPage src2= new PaperOnboardingPage("Ürün Eksikliği","Ürün eksiklerimizin olduğunun farkındayız. " +
                    "Gelecek güncellemelerle birlikte eksiklerimizi tamamlayacağız ",
                    Color.parseColor("#FF737373"),R.drawable.eksik128,R.drawable.eksik128);

        PaperOnboardingPage src3= new PaperOnboardingPage("İletişim",
                "Bir problemle karşılaşırsanız bizimle iletişime geçiniz.İletişim ve işbirliği için bizamdestek@gmail.com",
                Color.parseColor("#FF737373"),R.drawable.gmail128,R.drawable.gmail128);

        PaperOnboardingPage src4= new PaperOnboardingPage("Tarih Seçimi",
                "Ortalama fiyatlar ve zam oranları yıl bazlı çalışır.Yıllık ortalamalar gözükür.",
                Color.parseColor("#FF737373"),R.drawable.timetable128,R.drawable.timetable128);




        ArrayList<PaperOnboardingPage> elements= new ArrayList<>();
            elements.add(src1);
            elements.add(src2);
            elements.add(src3);
            elements.add(src4);
            return  elements;

    }


}