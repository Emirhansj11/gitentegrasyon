package com.example.bizam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bizam.Model.Kullanici;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class kaydolekrani extends AppCompatActivity {

Button sign;
EditText email,pass;
FirebaseAuth firebaseAuth;
FirebaseFirestore mFirestore;
private Kullanici mKullanici;
private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydolekrani);
        getWindow().setStatusBarColor(ContextCompat.getColor(kaydolekrani.this,R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(kaydolekrani.this,R.color.gri));
        sign=(Button) findViewById(R.id.buttonkaydol);
        email=(EditText) findViewById(R.id.kaydol_email_et);
        pass=(EditText) findViewById(R.id.kaydol_password_et);
        firebaseAuth=FirebaseAuth.getInstance();
        mFirestore=FirebaseFirestore.getInstance();
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }

            private void signup() {
                String useremail=email.getText().toString();
                String userpass=pass.getText().toString();
                if (useremail.isEmpty()){
                    startActivity(new Intent(kaydolekrani.this,kaydolekrani.class));
                    Toast.makeText(kaydolekrani.this, "E-postanı gir! Benim canımı sıkma!!", Toast.LENGTH_SHORT).show();
                }
                if (userpass.isEmpty()||userpass.length()<6){
                    startActivity(new Intent(kaydolekrani.this,kaydolekrani.class));
                    Toast.makeText(kaydolekrani.this, "En az 6 haneli şifre giriniz", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.createUserWithEmailAndPassword(useremail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            mUser=firebaseAuth.getCurrentUser();
                          if (mUser != null){
                              mKullanici = new Kullanici(useremail,mUser.getUid());
                              mFirestore.collection("Kullanıcılar").document(mUser.getUid())
                                      .set(mKullanici)
                                      .addOnCompleteListener(kaydolekrani.this, new OnCompleteListener<Void>() {
                                          @Override
                                          public void onComplete(@NonNull Task<Void> task) {
                                              if (task.isSuccessful()){
                                                  Toast.makeText(kaydolekrani.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                                  finish();
                                                  startActivity(new Intent(kaydolekrani.this,Anasayfa.class));
                                              }
                                          }
                                      });
                          }
                        }
                        else{
                            Toast.makeText(kaydolekrani.this, "Kayıt başarısız", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });



        TextView girisekranınagecis;
        girisekranınagecis = findViewById(R.id.textView2);
        girisekranınagecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kaydolekrani.this, MainActivity2.class));
                finish();
            }



                    });


                }

            }   