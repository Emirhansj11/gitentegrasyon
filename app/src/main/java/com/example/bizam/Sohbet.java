package com.example.bizam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Sohbet extends AppCompatActivity {
    TextView back1;
    EditText etYazi,editname;
    TextView tvYazi,txtoku;
    TextView btnGonder;


    DatabaseReference dbRef;
    ListView lvmesaj;

    String userId;
    LinearLayout linearlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sohbet);


        etYazi = findViewById(R.id.etYazi);
        btnGonder = findViewById(R.id.btnGoner);
        linearlay = findViewById(R.id.linearlay);
        tvYazi = findViewById(R.id.tvYazi);
        dbRef = FirebaseDatabase.getInstance().getReference();
        userId = "user1";


            btnGonder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String yazi = etYazi.getText().toString();
                    if (yazi.length()>94){
                        Toast.makeText(Sohbet.this, "Lütfen yazılarınızda 94 karakteri geçmeyin", Toast.LENGTH_SHORT).show();
                    }
                    if (yazi.length()==0){
                       yazi="Bi Zam Seni Seviyorum";
                        Toast.makeText(Sohbet.this, "Lütfen spam atmayınız", Toast.LENGTH_SHORT).show();
                    }


                    dbRef.child("chatroom").child("messages").push().setValue(yazi);
                    etYazi.setText("");

                    View view = LayoutInflater.from(Sohbet.this).inflate(R.layout.mycardview, null);

                    int margin = 8;
                    float density = getResources().getDisplayMetrics().density;
                    int pixel = (int) (margin * density);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(pixel, pixel, pixel, pixel);
                    view.setLayoutParams(params);

                    TextView textvieww = view.findViewById(R.id.textvieww);
                    textvieww.setText(yazi);



                    linearlay.addView(view);

                }
            });



        dbRef.child("chatroom").child("messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                linearlay.removeAllViews();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String yazi=snapshot.getValue(String.class);


                    View view = LayoutInflater.from(Sohbet.this).inflate(R.layout.mycardview, null);

                    int margin = 8;
                    float density = getResources().getDisplayMetrics().density;
                    int pixel = (int) (margin * density);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(pixel, pixel, pixel, pixel);
                    view.setLayoutParams(params);

                    TextView textvieww = view.findViewById(R.id.textvieww);
                    textvieww.setText(yazi);



                    linearlay.addView(view);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        back1=(TextView)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sohbet.this,Anasayfa.class);
                startActivity(intent);
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(Sohbet.this, R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(Sohbet.this, R.color.gri));
    }


}