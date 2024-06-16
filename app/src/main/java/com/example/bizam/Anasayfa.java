package com.example.bizam;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.StatusBarManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.api.Distribution;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;

import kotlinx.coroutines.channels.ChannelResult;


public class Anasayfa extends AppCompatActivity {
    private InterstitialAd mIn;

    private AdRequest adRequest;
    private void init(){
        e=findViewById(R.id.e);
        adRequest=new AdRequest.Builder().build();
        loadAds();
    }



    private SharedPreferences sharedPreferences;
    CardView gida, giyim, evesyalari, elektronik;
    CardView cardcay,cardsarap,cardkahve,cardakillisaat,
    cardhavuc,cardbrokoli,cardkabak,cardbiber,carduzum,cardmuz,
    cardpantalon,cardgomlek,
    cardhamsi,
    cardtv;

    private SharedPreferences.Editor editor;
    TextView ilginiziçekebilecekurunler;
    EditText searchText;
    TextView searchtextview,yazdir;
    ImageView menu;
    RelativeLayout navrelative,popuprelative;
    LinearLayout soruncikartanlinear,a, b,c,d,e,f,p,gidaa,giyimm,elektronikk,premiumm;
    HorizontalScrollView soruncikartanhorizantal;

    String gog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Alt menüdeki butonların çalışmasıyla ilgili sorumlu kodlar

        setContentView(R.layout.activity_anasayfa);
     


        init();
        cardcay=findViewById(R.id.cardcay);
        cardkahve=findViewById(R.id.cardkahve);
        cardsarap=findViewById(R.id.cardsarap);
        cardakillisaat=findViewById(R.id.cardakillisaat);
        cardhavuc=findViewById(R.id.cardhavuc);
        cardbrokoli=findViewById(R.id.cardbrokoli);
        cardkabak=findViewById(R.id.cardkabak);
        cardbiber=findViewById(R.id.cardbiber);
        carduzum=findViewById(R.id.carduzum);
        cardmuz=findViewById(R.id.cardmuz);
        cardgomlek=findViewById(R.id.cardgomlek);
        cardpantalon=findViewById(R.id.cardpantalon);
        cardhamsi=findViewById(R.id.cardhamsi);
        cardtv=findViewById(R.id.cardtv);
        ilginiziçekebilecekurunler=findViewById(R.id.ilginiziçekebilecekurunler);
        soruncikartanlinear=findViewById(R.id.soruncikartanlinear);
        soruncikartanhorizantal=findViewById(R.id.soruncikartanhorizantal);
        ArrayList<CardView>cardViews=new ArrayList<>();
        cardViews.add(cardakillisaat);
        cardViews.add(cardcay);
        cardViews.add(cardkahve);
        cardViews.add(cardsarap);
        cardViews.add(cardhavuc);
        cardViews.add(cardbrokoli);
        cardViews.add(cardkabak);
        cardViews.add(cardbiber);
        cardViews.add(carduzum);
        cardViews.add(cardmuz);
        cardViews.add(cardpantalon);
        cardViews.add(cardgomlek);
        cardViews.add(cardhamsi);
        cardViews.add(cardtv);

        Collections.shuffle(cardViews);
        soruncikartanlinear.removeAllViews();
        for (CardView cardView:cardViews){
            soruncikartanlinear.addView(cardView);
        }


        getWindow().setStatusBarColor(ContextCompat.getColor(Anasayfa.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Anasayfa.this, R.color.gri));
        searchText = (EditText) findViewById(R.id.search);
        searchtextview = (TextView) findViewById(R.id.searchtextview);
        menu = (ImageView) findViewById(R.id.menu);
        navrelative = (RelativeLayout) findViewById(R.id.navrelative);
        popuprelative=findViewById(R.id.popuprelative);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c=findViewById(R.id.c);
        d=findViewById(R.id.d);
        e=findViewById(R.id.e);
        f=findViewById(R.id.f);
        p=findViewById(R.id.p);
        gidaa=findViewById(R.id.gidaa);
        giyimm=findViewById(R.id.giyimm);
        elektronikk=findViewById(R.id.elektronikk);
        premiumm=findViewById(R.id.premiumm);

        gida = (CardView) findViewById(R.id.gida);
        giyim = (CardView) findViewById(R.id.giyim);
        elektronik = (CardView) findViewById(R.id.elektronik);
        evesyalari = (CardView) findViewById(R.id.evesyalari);


        searchtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchclick();
            }

            public void searchclick() {
                String text = searchText.getText().toString();
                if (text.equals("çay")) {
                    startActivity(new Intent(Anasayfa.this, cay.class));
                }
                else if (text.equals("Çay")) {
                    startActivity(new Intent(Anasayfa.this, cay.class));
                }
                else if (text.equals("kahve")) {
                    startActivity(new Intent(Anasayfa.this, kahve.class));
                }
                else if (text.equals("Kahve")) {
                    startActivity(new Intent(Anasayfa.this, kahve.class));
                }
                else if (text.equals("kola")) {
                    startActivity(new Intent(Anasayfa.this, kola.class));
                }
                else if (text.equals("Kola")) {
                    startActivity(new Intent(Anasayfa.this, kola.class));
                }
                else if (text.equals("bira")) {
                    startActivity(new Intent(Anasayfa.this, bira.class));
                }
                else if (text.equals("Bira")) {
                    startActivity(new Intent(Anasayfa.this, bira.class));
                }
                else if (text.equals("şarap")) {
                    startActivity(new Intent(Anasayfa.this, sarap.class));
                }
                else if (text.equals("Şarap")) {
                    startActivity(new Intent(Anasayfa.this, sarap.class));
                }
                else if (text.equals("süt")) {
                    startActivity(new Intent(Anasayfa.this, sut.class));
                }
                else if (text.equals("Süt")) {
                    startActivity(new Intent(Anasayfa.this, sut.class));
                }
                else if (text.equals("su")) {
                    startActivity(new Intent(Anasayfa.this, su.class));
                }
                else if (text.equals("Su")) {
                    startActivity(new Intent(Anasayfa.this, su.class));
                }
                else if (text.equals("ayran")) {
                    startActivity(new Intent(Anasayfa.this, ayran.class));
                }
                else if (text.equals("Ayran")) {
                    startActivity(new Intent(Anasayfa.this, ayran.class));
                }
                else if (text.equals("domates")) {
                    startActivity(new Intent(Anasayfa.this, domates.class));
                }
                else if (text.equals("Domates")) {
                    startActivity(new Intent(Anasayfa.this, domates.class));
                }
                else if (text.equals("patates")) {
                    startActivity(new Intent(Anasayfa.this, patates.class));
                }
                else if (text.equals("Patates")) {
                    startActivity(new Intent(Anasayfa.this, patates.class));
                }
                else if (text.equals("salatalık")) {
                    startActivity(new Intent(Anasayfa.this, salatalik.class));
                }
                else if (text.equals("Salatalık")) {
                    startActivity(new Intent(Anasayfa.this, salatalik.class));
                }
                else if (text.equals("soğan")) {
                    startActivity(new Intent(Anasayfa.this, sogan.class));
                }
                else if (text.equals("Soğan")) {
                    startActivity(new Intent(Anasayfa.this, sogan.class));
                }
                else if (text.equals("ıspanak")) {
                    startActivity(new Intent(Anasayfa.this, ispanak.class));
                }
                else if (text.equals("Ispanak")) {
                    startActivity(new Intent(Anasayfa.this, ispanak.class));
                }
                else if (text.equals("havuç")) {
                    startActivity(new Intent(Anasayfa.this, havuc.class));
                }
                else if (text.equals("Havuç")) {
                    startActivity(new Intent(Anasayfa.this, havuc.class));
                }
                else if (text.equals("pırasa")) {
                    startActivity(new Intent(Anasayfa.this, pirasa.class));
                }
                else if (text.equals("Pırasa")) {
                    startActivity(new Intent(Anasayfa.this, pirasa.class));
                }
                else if (text.equals("karnabahar")) {
                    startActivity(new Intent(Anasayfa.this, karnabahar.class));
                }
                else if (text.equals("Karnabahar")) {
                    startActivity(new Intent(Anasayfa.this, karnabahar.class));
                }
                else if (text.equals("brokoli")) {
                    startActivity(new Intent(Anasayfa.this, brokoli.class));
                }
                else if (text.equals("Brokoli")) {
                    startActivity(new Intent(Anasayfa.this, brokoli.class));
                }
                else if (text.equals("marul")) {
                    startActivity(new Intent(Anasayfa.this, marul.class));
                }
                else if (text.equals("Marul")) {
                    startActivity(new Intent(Anasayfa.this, marul.class));
                }
                else if (text.equals("fasulye")) {
                    startActivity(new Intent(Anasayfa.this, fasulye.class));
                }
                else if (text.equals("Fasulye")) {
                    startActivity(new Intent(Anasayfa.this, fasulye.class));
                }
                else if (text.equals("bezelye")) {
                    startActivity(new Intent(Anasayfa.this, bezelye.class));
                }
                else if (text.equals("Bezelye")) {
                    startActivity(new Intent(Anasayfa.this, bezelye.class));
                }
                else if (text.equals("kabak")) {
                    startActivity(new Intent(Anasayfa.this, kabak.class));
                }
                else if (text.equals("Kabak")) {
                    startActivity(new Intent(Anasayfa.this, kabak.class));
                }
                else if (text.equals("patlıcan")) {
                    startActivity(new Intent(Anasayfa.this, patlican.class));
                }
                else if (text.equals("Patlıcan")) {
                    startActivity(new Intent(Anasayfa.this, patlican.class));
                }
                else if (text.equals("biber")) {
                    startActivity(new Intent(Anasayfa.this, biber.class));
                }
                else if (text.equals("Biber")) {
                    startActivity(new Intent(Anasayfa.this, biber.class));
                }
                else if (text.equals("karpuz")) {
                    startActivity(new Intent(Anasayfa.this, karpuz.class));
                }
                else if (text.equals("Karpuz")) {
                    startActivity(new Intent(Anasayfa.this, karpuz.class));
                }
                else if (text.equals("üzüm")) {
                    startActivity(new Intent(Anasayfa.this, uzum.class));
                }
                else if (text.equals("Üzüm")) {
                    startActivity(new Intent(Anasayfa.this, uzum.class));
                }
                else if (text.equals("elma")) {
                    startActivity(new Intent(Anasayfa.this, elma.class));
                }
                else if (text.equals("Elma")) {
                    startActivity(new Intent(Anasayfa.this, elma.class));
                }
                else if (text.equals("şeftali")) {
                    startActivity(new Intent(Anasayfa.this, seftali.class));
                }
                else if (text.equals("Şeftali")) {
                    startActivity(new Intent(Anasayfa.this, seftali.class));
                }
                else if (text.equals("muz")) {
                    startActivity(new Intent(Anasayfa.this, muz.class));
                }
                else if (text.equals("Muz")) {
                    startActivity(new Intent(Anasayfa.this, muz.class));
                }
                else if (text.equals("armut")) {
                    startActivity(new Intent(Anasayfa.this, armut.class));
                }
                else if (text.equals("Armut")) {
                    startActivity(new Intent(Anasayfa.this, armut.class));
                }
                else if (text.equals("kiraz")) {
                    startActivity(new Intent(Anasayfa.this, kiraz.class));
                }
                else if (text.equals("Kiraz")) {
                    startActivity(new Intent(Anasayfa.this, kiraz.class));
                }
                else if (text.equals("portakal")) {
                    startActivity(new Intent(Anasayfa.this, portakal.class));
                }
                else if (text.equals("Portakal")) {
                    startActivity(new Intent(Anasayfa.this, portakal.class));
                }
                else if (text.equals("limon")) {
                    startActivity(new Intent(Anasayfa.this, limon.class));
                }
                else if (text.equals("Limon")) {
                    startActivity(new Intent(Anasayfa.this, limon.class));
                }
                else if (text.equals("kayısı")) {
                    startActivity(new Intent(Anasayfa.this, kayisi.class));
                }
                else if (text.equals("Kayısı")) {
                    startActivity(new Intent(Anasayfa.this, kayisi.class));
                }
                else if (text.equals("çilek")) {
                    startActivity(new Intent(Anasayfa.this, cilek.class));
                }
                else if (text.equals("Çilek")) {
                    startActivity(new Intent(Anasayfa.this, cilek.class));
                }
                else if (text.equals("nar")) {
                    startActivity(new Intent(Anasayfa.this, nar.class));
                }
                else if (text.equals("Nar")) {
                    startActivity(new Intent(Anasayfa.this, nar.class));
                }
                else if (text.equals("kıyma")) {
                    startActivity(new Intent(Anasayfa.this, kiyma.class));
                }
                else if (text.equals("Kıyma")) {
                    startActivity(new Intent(Anasayfa.this, kiyma.class));
                }
                else if (text.equals("sucuk")) {
                    startActivity(new Intent(Anasayfa.this, sucuk.class));
                }
                else if (text.equals("Sucuk")) {
                    startActivity(new Intent(Anasayfa.this, sucuk.class));
                }
                else if (text.equals("salam")) {
                    startActivity(new Intent(Anasayfa.this, salam.class));
                }
                else if (text.equals("Salam")) {
                    startActivity(new Intent(Anasayfa.this, salam.class));
                }
                else if (text.equals("sosis")) {
                    startActivity(new Intent(Anasayfa.this, sosis.class));
                }
                else if (text.equals("Sosis")) {
                    startActivity(new Intent(Anasayfa.this, sosis.class));
                }
                else if (text.equals("pastırma")) {
                    startActivity(new Intent(Anasayfa.this, pastirma.class));
                }
                else if (text.equals("Pastırma")) {
                    startActivity(new Intent(Anasayfa.this, pastirma.class));
                }
                else if (text.equals("tavuk baget")) {
                    startActivity(new Intent(Anasayfa.this, tavukbaget.class));
                }
                else if (text.equals("Tavuk Baget")) {
                    startActivity(new Intent(Anasayfa.this, tavukbaget.class));
                }
                else if (text.equals("hamsi")) {
                    startActivity(new Intent(Anasayfa.this, hamsi.class));
                }
                else if (text.equals("Hamsi")) {
                    startActivity(new Intent(Anasayfa.this, hamsi.class));
                }
                else if (text.equals("levrek")) {
                    startActivity(new Intent(Anasayfa.this, levrek.class));
                }
                else if (text.equals("Levrek")) {
                    startActivity(new Intent(Anasayfa.this, levrek.class));
                }
                else if (text.equals("palamut")) {
                    startActivity(new Intent(Anasayfa.this, palamut.class));
                }
                else if (text.equals("Palamut")) {
                    startActivity(new Intent(Anasayfa.this, palamut.class));
                }
                else if (text.equals("hırka")) {
                    startActivity(new Intent(Anasayfa.this, hirka.class));
                }
                else if (text.equals("Hırka")) {
                    startActivity(new Intent(Anasayfa.this, hirka.class));
                }
                else if (text.equals("sweatshirt")) {
                    startActivity(new Intent(Anasayfa.this, sweatshirt.class));
                }
                else if (text.equals("Sweatshirt")) {
                    startActivity(new Intent(Anasayfa.this, sweatshirt.class));
                }
                else if (text.equals("eşofman")) {
                    startActivity(new Intent(Anasayfa.this, esofman.class));
                }
                else if (text.equals("Eşofman")) {
                    startActivity(new Intent(Anasayfa.this, esofman.class));
                }
                else if (text.equals("mont")) {
                    startActivity(new Intent(Anasayfa.this, mont.class));
                }
                else if (text.equals("Mont")) {
                    startActivity(new Intent(Anasayfa.this, mont.class));
                }
                else if (text.equals("etek")) {
                    startActivity(new Intent(Anasayfa.this, etek.class));
                }
                else if (text.equals("Etek")) {
                    startActivity(new Intent(Anasayfa.this, etek.class));
                }
                else if (text.equals("elbise")) {
                    startActivity(new Intent(Anasayfa.this, elbise.class));
                }
                else if (text.equals("Elbise")) {
                    startActivity(new Intent(Anasayfa.this, elbise.class));
                }
                else if (text.equals("pantalon")) {
                    startActivity(new Intent(Anasayfa.this, pantalon.class));
                }
                else if (text.equals("Pantalon")) {
                    startActivity(new Intent(Anasayfa.this, pantalon.class));
                }
                else if (text.equals("şort")) {
                    startActivity(new Intent(Anasayfa.this, sort.class));
                }
                else if (text.equals("Şort")) {
                    startActivity(new Intent(Anasayfa.this, sort.class));
                }
                else if (text.equals("gömlek")) {
                    startActivity(new Intent(Anasayfa.this, gomlek.class));
                }
                else if (text.equals("Gömlek")) {
                    startActivity(new Intent(Anasayfa.this, gomlek.class));
                }
                else if (text.equals("tshirt")) {
                    startActivity(new Intent(Anasayfa.this, tshirt.class));
                }
                else if (text.equals("Tshirt")) {
                    startActivity(new Intent(Anasayfa.this, tshirt.class));
                }
                else if (text.equals("ceket")) {
                    startActivity(new Intent(Anasayfa.this, ceket.class));
                }
                else if (text.equals("Ceket")) {
                    startActivity(new Intent(Anasayfa.this, ceket.class));
                }
                else if (text.equals("pijama")) {
                    startActivity(new Intent(Anasayfa.this, pijama.class));
                }
                else if (text.equals("Pijama")) {
                    startActivity(new Intent(Anasayfa.this, pijama.class));
                }
                else if (text.equals("ayakkabı")) {
                    startActivity(new Intent(Anasayfa.this, ayakkabi.class));
                }
                else if (text.equals("Ayakkabı")) {
                    startActivity(new Intent(Anasayfa.this, ayakkabi.class));
                }
                else if (text.equals("televizyon")) {
                    startActivity(new Intent(Anasayfa.this, televizyon.class));
                }
                else if (text.equals("Televizyon")) {
                    startActivity(new Intent(Anasayfa.this, televizyon.class));
                }
                else if (text.equals("bilgisayar")) {
                    startActivity(new Intent(Anasayfa.this, bilgisayar.class));
                }
                else if (text.equals("Bilgisayar")) {
                    startActivity(new Intent(Anasayfa.this, bilgisayar.class));
                }
                else if (text.equals("telefon")) {
                    startActivity(new Intent(Anasayfa.this, telefon.class));
                }
                else if (text.equals("Telefon")) {
                    startActivity(new Intent(Anasayfa.this, telefon.class));
                }
                else if (text.equals("tablet")) {
                    startActivity(new Intent(Anasayfa.this, tablet.class));
                }
                else if (text.equals("Tablet")) {
                    startActivity(new Intent(Anasayfa.this, tablet.class));
                }
                else if (text.equals("akıllı saat")) {
                    startActivity(new Intent(Anasayfa.this, akillisaat.class));
                }
                else if (text.equals("Akıllı Saat")) {
                    startActivity(new Intent(Anasayfa.this, akillisaat.class));
                }
                else if (text.equals("kulaklık")) {
                    startActivity(new Intent(Anasayfa.this, kulaklik.class));
                }
                else if (text.equals("Kulaklık")) {
                    startActivity(new Intent(Anasayfa.this, kulaklik.class));
                }
                else if (text.equals("mikrofon")) {
                    startActivity(new Intent(Anasayfa.this, mikrofon.class));
                }
                else if (text.equals("Mikrofon")) {
                    startActivity(new Intent(Anasayfa.this, mikrofon.class));
                }
                else if (text.equals("oyun konsolu")) {
                    startActivity(new Intent(Anasayfa.this, oyunkonsolu.class));
                }
                else if (text.equals("Oyun Konsolu")) {
                    startActivity(new Intent(Anasayfa.this, oyunkonsolu.class));
                }
                else if (text.equals("yazıcı")) {
                    startActivity(new Intent(Anasayfa.this, yazici.class));
                }
                else if (text.equals("Yazıcı")) {
                    startActivity(new Intent(Anasayfa.this, yazici.class));
                }
                else if (text.equals("fırın")) {
                    startActivity(new Intent(Anasayfa.this, firin.class));
                }
                else if (text.equals("Fırın")) {
                    startActivity(new Intent(Anasayfa.this, firin.class));
                }
                else if (text.equals("buzdolabı")) {
                    startActivity(new Intent(Anasayfa.this, buzdolabi.class));
                }
                else if (text.equals("Buzdolabı")) {
                    startActivity(new Intent(Anasayfa.this, buzdolabi.class));
                }
                else if (text.equals("ütü")) {
                    startActivity(new Intent(Anasayfa.this, utu.class));
                }
                else if (text.equals("Ütü")) {
                    startActivity(new Intent(Anasayfa.this, utu.class));
                }
                else if (text.equals("çamaşır makinesi")) {
                    startActivity(new Intent(Anasayfa.this, camasirmak.class));
                }
                else if (text.equals("Çamaşır Makinesi")) {
                    startActivity(new Intent(Anasayfa.this, camasirmak.class));
                }
                else if (text.equals("bulaşık makinesi")) {
                    startActivity(new Intent(Anasayfa.this, bulasikmak.class));
                }
                else if (text.equals("Bulaşık Makinesi")) {
                    startActivity(new Intent(Anasayfa.this, bulasikmak.class));
                }
                else if (text.equals("süpürge")) {
                    startActivity(new Intent(Anasayfa.this, supurge.class));

                }
                else if (text.equals("Süpürge")) {

                    startActivity(new Intent(Anasayfa.this, supurge.class));

                }
                else if (text.isEmpty()) {
                    startActivity(new Intent(Anasayfa.this, sonucbulunamadi.class));
                }else{
                    startActivity(new Intent(Anasayfa.this, sonucbulunamadi.class));
                }


            }

        });


        gida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giyim.setClickable(false);
                elektronik.setClickable(false);
                evesyalari.setClickable(false);
                Intent intent = new Intent(Anasayfa.this, GidaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        giyim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gida.setClickable(false);
                elektronik.setClickable(false);
                evesyalari.setClickable(false);
                Intent intent = new Intent(Anasayfa.this, Giyim.class);
                startActivity(intent);
                finish();
            }
        });
        elektronik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giyim.setClickable(false);
                gida.setClickable(false);
                evesyalari.setClickable(false);
                Intent intent = new Intent(Anasayfa.this, Elektronik.class);
                startActivity(intent);
                finish();
            }
        });
        evesyalari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Anasayfa.this, "Premium Gereklidir", Toast.LENGTH_SHORT).show();
            }
        });







        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navrelative.setVisibility(View.VISIBLE);
                navrelative.setClickable(true);
                searchText.setVisibility(View.INVISIBLE);
                searchtextview.setVisibility(View.INVISIBLE);
                giyim.setClickable(false);
                elektronik.setClickable(false);
                gida.setClickable(false);
                evesyalari.setClickable(false);
                soruncikartanhorizantal.setVisibility(View.INVISIBLE);
                ilginiziçekebilecekurunler.setVisibility(View.INVISIBLE);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, Onboarding.class);
                startActivity(intent);
                finish();
            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               popuprelative.setVisibility(View.INVISIBLE);
                giyim.setClickable(true);
                elektronik.setClickable(true);
                gida.setClickable(true);
                evesyalari.setClickable(true);
                searchtextview.setVisibility(View.VISIBLE);
                searchText.setVisibility(View.VISIBLE);
                a.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);
                c.setVisibility(View.VISIBLE);
                d.setVisibility(View.VISIBLE);
                e.setVisibility(View.VISIBLE);
                f.setVisibility(View.VISIBLE);
                menu.setVisibility(View.VISIBLE);

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, Sohbet.class);
                startActivity(intent);
                finish();

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, ZamSampiyonlari.class);
                startActivity(intent);
                finish();

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mIn !=null){
                   mIn.show(Anasayfa.this);
                   Toast.makeText(Anasayfa.this, "Reklam için özür dilerim", Toast.LENGTH_SHORT).show();
                   mIn=null;
               }
               else if (mIn==null){
                   Intent intent=new Intent(Anasayfa.this,Kaydedilenler.class);
                   startActivity(intent);
               }
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navrelative.setVisibility(View.INVISIBLE);
                searchText.setVisibility(View.VISIBLE);
                searchtextview.setVisibility(View.VISIBLE);
                giyim.setClickable(true);
                elektronik.setClickable(true);
                gida.setClickable(true);
                evesyalari.setClickable(true);
                soruncikartanhorizantal.setVisibility(View.VISIBLE);
                ilginiziçekebilecekurunler.setVisibility(View.VISIBLE);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popuprelative.setVisibility(View.VISIBLE);
                giyim.setClickable(false);
                elektronik.setClickable(false);
                gida.setClickable(false);
                evesyalari.setClickable(false);
                searchtextview.setVisibility(View.INVISIBLE);
                searchText.setVisibility(View.INVISIBLE);
                a.setVisibility(View.INVISIBLE);
                b.setVisibility(View.INVISIBLE);
                c.setVisibility(View.INVISIBLE);
                d.setVisibility(View.INVISIBLE);
                e.setVisibility(View.INVISIBLE);
                f.setVisibility(View.INVISIBLE);
                menu.setVisibility(View.INVISIBLE);



            }

        });
        gidaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, GidaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        giyimm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, Giyim.class);
                startActivity(intent);
                finish();
            }
        });
        elektronikk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, Elektronik.class);
                startActivity(intent);
                finish();
            }
        });
        premiumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this, Onboarding2.class);
                startActivity(intent);
                finish();
            }
        });

        cardcay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,cay.class);
                startActivity(intent);
                finish();
            }
        });
        cardkahve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,kahve.class);
                startActivity(intent);
                finish();
            }
        });
        cardsarap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,sarap.class);
                startActivity(intent);
                finish();
            }
        });
        cardbrokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,brokoli.class);
                startActivity(intent);
                finish();
            }
        });
        cardhavuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,havuc.class);
                startActivity(intent);
                finish();
            }
        });
        cardkabak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,kabak.class);
                startActivity(intent);
                finish();
            }
        });
        cardbiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,biber.class);
                startActivity(intent);
                finish();
            }
        });
        cardmuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,muz.class);
                startActivity(intent);
                finish();
            }
        });
        carduzum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,uzum.class);
                startActivity(intent);
                finish();
            }
        });
        cardpantalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,pantalon.class);
                startActivity(intent);
                finish();
            }
        });
        cardgomlek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,gomlek.class);
                startActivity(intent);
                finish();
            }
        });
        cardtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,televizyon.class);
                startActivity(intent);
                finish();
            }
        });
        cardakillisaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,akillisaat.class);
                startActivity(intent);
                finish();
            }
        });
        cardhamsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Anasayfa.this,hamsi.class);
                startActivity(intent);
                finish();
            }
        });






    }    private void openLogin () {
            startActivity(new Intent(Anasayfa.this, MainActivity2.class));
        }


        @Override
        protected void onResume () {
            super.onResume();
            gida.setClickable(true);
            giyim.setClickable(true);
            elektronik.setClickable(true);
            evesyalari.setClickable(true);
        }
        private void loadAds(){
            InterstitialAd.load(this, getString(R.string.testAdsIdGecis), adRequest, new InterstitialAdLoadCallback() {

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    System.out.println(loadAdError.getMessage());
                    mIn=null;



                }

                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    mIn=interstitialAd;
                    System.out.println("Reklam yüklendi");


                }


            });

        }

    }
















        





