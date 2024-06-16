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

import java.util.Calendar;

public class sut extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    TextView back1;
    private Button datebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sut);

        back1=(TextView)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sut.this,Icecekler.class);
                startActivity(intent);
                finish();
            }
        });

        initDatePicker();
        datebutton=findViewById(R.id.datePickerButton);
        datebutton.setText(getTodaysDate());




        getWindow().setStatusBarColor(ContextCompat.getColor(sut.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(sut.this,R.color.gri));

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

        String yirmiücfiyatı= String.valueOf(30);
        String yirmiikifiyatı=String.valueOf(25);
        String yirmibirfiyatı=String.valueOf(9.5);
        String yirmifiyatı=String.valueOf(7.5);
        String ondokuzfiyatı=String.valueOf(5.95);
        String onsekizfiyatı=String.valueOf(4.95);
        String onyedifiyatı=String.valueOf(4.5);
        String onaltıfiyatı=String.valueOf(4);
        String onbeşfiyatı=String.valueOf(3.75);
        String ondörtfiyatı=String.valueOf(3.25);
        String onüçfiyatı=String.valueOf(3);
        String onikifiyatı=String.valueOf(0);
        String onbirfiyatı=String.valueOf(0);
        String onfiyatı=String.valueOf(0);
        String dokuzfiyatı=String.valueOf(0);
        String sekizfiyatı=String.valueOf(0);
        String yedifiyatı=String.valueOf(0);
        String altıfiyatı=String.valueOf(0);
        String beşfiyatı=String.valueOf(0);
        String dörtfiyatı=String.valueOf(0);
        String ücfiyatı=String.valueOf(0);
        String ikifiyatı=String.valueOf(0);
        String birfiyatı=String.valueOf(0);
        String sıfırfiyatı=String.valueOf(0);

        String bilmiyorum=String.valueOf(0);


        String yirmiikizamoranı=String.valueOf(20);
        String yirmibirzamoranı=String.valueOf(215);
        String yirmizamoranı=String.valueOf(300);
        String ondokuzzamoranı=String.valueOf(400);
        String onsekizzamoranı=String.valueOf(506);
        String onyedizamoranı=String.valueOf(566);
        String onaltızamoranı=String.valueOf(650);
        String onbeşzamoranı=String.valueOf(700);
        String ondörtzamoranı=String.valueOf(823);
        String onüçzamoranı=String.valueOf(900);
        String onikizamoranı=String.valueOf(0);
        String onbirzamoranı=String.valueOf(0);
        String onzamoranı=String.valueOf(0);
        String dokuzzamoranı=String.valueOf(0);
        String sekizzamoranı=String.valueOf(0);
        String yedizamoranı=String.valueOf(0);
        String altızamoranı=String.valueOf(0);
        String beşzamoranı=String.valueOf(0);
        String dörtzamoranı=String.valueOf(0);
        String üçzamoranı=String.valueOf(0);
        String ikizamoranı=String.valueOf(0);
        String birzamoranı=String.valueOf(0);
        String sıfırzamoranı=String.valueOf(0);



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
