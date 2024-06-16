package com.example.bizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Calendar;

public class cay extends AppCompatActivity {

private DatePickerDialog datePickerDialog;
    TextView back1;
private Button datebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cay);
        back1=(TextView)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cay.this,Icecekler.class);
                startActivity(intent);
                finish();
            }
        });

        initDatePicker();
        datebutton=findViewById(R.id.datePickerButton);
        datebutton.setText(getTodaysDate());




        getWindow().setStatusBarColor(ContextCompat.getColor(cay.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(cay.this,R.color.gri));

    }

    private String getTodaysDate() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
         int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day,month,year);
                datebutton.setText(date);


            }
        };

        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;

        datePickerDialog= new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }

    private String makeDateString(int day, int month, int year) {
        TextView t=findViewById(R.id.sonucgösteren);
        TextView z=findViewById(R.id.zamoranı);
        String yirmiücfiyatı= String.valueOf(86.38);
        String yirmiikifiyatı=String.valueOf(82.56);
        String yirmibirfiyatı=String.valueOf(78.25);
        String yirmifiyatı=String.valueOf(51.75);
        String ondokuzfiyatı=String.valueOf(44.06);
        String onsekizfiyatı=String.valueOf(37.81);
        String onyedifiyatı=String.valueOf(32.69);
        String onaltıfiyatı=String.valueOf(23.47);
        String onbeşfiyatı=String.valueOf(21.14);
        String ondörtfiyatı=String.valueOf(19.2);
        String onüçfiyatı=String.valueOf(17.8);
        String onikifiyatı=String.valueOf(9.6);
        String onbirfiyatı=String.valueOf(8.4);
        String onfiyatı=String.valueOf(7.2);
        String dokuzfiyatı=String.valueOf(6.1);
        String sekizfiyatı=String.valueOf(5.1);
        String yedifiyatı=String.valueOf(4.5);
        String altıfiyatı=String.valueOf(4.1);
        String beşfiyatı=String.valueOf(3.8);
        String dörtfiyatı=String.valueOf(4.9);
        String ücfiyatı=String.valueOf(4.3);
        String ikifiyatı=String.valueOf(3.5);
        String birfiyatı=String.valueOf(3.2);
        String sıfırfiyatı=String.valueOf(3.1);

        String bilmiyorum=String.valueOf(0);


        String yirmiikizamoranı=String.valueOf(4);
        String yirmibirzamoranı=String.valueOf(10);
        String yirmizamoranı=String.valueOf(65);
        String ondokuzzamoranı=String.valueOf(95);
        String onsekizzamoranı=String.valueOf(126);
        String onyedizamoranı=String.valueOf(160);
        String onaltızamoranı=String.valueOf(273);
        String onbeşzamoranı=String.valueOf(309);
        String ondörtzamoranı=String.valueOf(352);
        String onüçzamoranı=String.valueOf(405);
        String onikizamoranı=String.valueOf(760);
        String onbirzamoranı=String.valueOf(975);
        String onzamoranı=String.valueOf(1128);
        String dokuzzamoranı=String.valueOf(1333);
        String sekizzamoranı=String.valueOf(1620);
        String yedizamoranı=String.valueOf(1811);
        String altızamoranı=String.valueOf(2050);
        String beşzamoranı=String.valueOf(2163);
        String dörtzamoranı=String.valueOf(1620);
        String üçzamoranı=String.valueOf(1900);
        String ikizamoranı=String.valueOf(2357);
        String birzamoranı=String.valueOf(2587);
        String sıfırzamoranı=String.valueOf(2766);



        boolean i = year == 2023;
        if (year==2023){
            t.setText(yirmiücfiyatı);
        }
        else if (year==2022){
            t.setText(yirmiikifiyatı);
            z.setText(yirmiikizamoranı);

        }
        else if (year==2021){
            t.setText(yirmibirfiyatı);
            z.setText(yirmibirzamoranı);

        }
        else if (year==2020){
            t.setText(yirmifiyatı);
            z.setText(yirmizamoranı);

        }
        else if (year==2019){
            t.setText(ondokuzfiyatı);
            z.setText(ondokuzzamoranı);

        }
        else if (year==2018){
            t.setText(onsekizfiyatı);
            z.setText(onsekizzamoranı);

        }
        else if (year==2017){
            t.setText(onyedifiyatı);
            z.setText(onyedizamoranı);

        }
        else if (year==2016){
            t.setText(onaltıfiyatı);
            z.setText(onaltızamoranı);

        }
        else if (year==2015){
            t.setText(onbeşfiyatı);
            z.setText(onbeşzamoranı);

        }
        else if (year==2014){
            t.setText(ondörtfiyatı);
            z.setText(ondörtzamoranı);

        }
        else if (year==2013){
            t.setText(onüçfiyatı);
            z.setText(onüçzamoranı);

        }
        else if (year==2012){
            t.setText(onikifiyatı);
            z.setText(onikizamoranı);

        }
        else if (year==2011){
            t.setText(onbirfiyatı);
            z.setText(onbirzamoranı);

        }
        else if (year==2010){
            t.setText(onfiyatı);
            z.setText(onzamoranı);

        }
        else if (year==2009){
            t.setText(dokuzfiyatı);
            z.setText(dokuzzamoranı);

        }
        else if (year==2008){
            t.setText(sekizfiyatı);
            z.setText(sekizzamoranı);

        }
        else if (year==2007){
            t.setText(yedifiyatı);
            z.setText(yedizamoranı);

        }
        else if (year==2006){
            t.setText(altıfiyatı);
            z.setText(altızamoranı);

        }
        else if (year==2005){
            t.setText(beşfiyatı);
            z.setText(beşzamoranı);

        }
        else if (year==2004){
            t.setText(dörtfiyatı);
            z.setText(dörtzamoranı);

        }
        else if (year==2003){
            t.setText(ücfiyatı);
            z.setText(üçzamoranı);

        }
        else if (year==2002){
            t.setText(ikifiyatı);
            z.setText(ikizamoranı);

        }
        else if (year==2001){
            t.setText(birfiyatı);
            z.setText(birzamoranı);

        }
        else if (year==2000){
            t.setText(sıfırfiyatı);
            z.setText(sıfırzamoranı);

        }
        else if (year!=2000-2023) {
            t.setText(bilmiyorum);
            z.setText(bilmiyorum);

        }

        return getMonthFormat (month) +"/"+ day +"/"+ year;



    }



    private String getMonthFormat(int month) {
        if (month==1)
            return "OCA";
        if (month==2)
            return "ŞUB";
        if (month==3)
            return "MAR";
        if (month==4)
            return "NİS";
        if (month==5)
            return "MAY";
        if (month==6)
            return "HAZ";
        if (month==7)
            return "TEM";
        if (month==8)
            return "AGU";
        if (month==9)
            return "EYL";
        if (month==10)
            return "EKİ";
        if (month==11)
            return "KAS";
        if (month==12)
            return "ARA";

        return "OCA";


    }

    public void openDatePicker(View view){
        datePickerDialog.show();
    }

}