package com.example.bizam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    Button login;
    EditText email,pass;
    FirebaseAuth firebaseAuth;

    private SharedPreferences.Editor editor;
    private FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity2.this,R.color.gri));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MainActivity2.this,R.color.gri));


        login=(Button) findViewById(R.id.buttongiris);
        email=(EditText) findViewById(R.id.email_et);
        pass=(EditText) findViewById(R.id.password_et);
        firebaseAuth=FirebaseAuth.getInstance();
        mUser=firebaseAuth.getCurrentUser();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginClick();
            }

            private void loginClick() {
                String useremail=email.getText().toString();
                String userpass=pass.getText().toString();


                if (useremail.isEmpty()){
                    startActivity(new Intent(MainActivity2.this,MainActivity2.class));
                    Toast.makeText(MainActivity2.this, "Şu E-postayı doğru gir!!", Toast.LENGTH_SHORT).show();
                }
                if (userpass.isEmpty()||userpass.length()<6){
                    startActivity(new Intent(MainActivity2.this,MainActivity2.class));
                    Toast.makeText(MainActivity2.this, "En az 6 haneli şifre giriniz", Toast.LENGTH_SHORT).show();
                }


                firebaseAuth.signInWithEmailAndPassword(useremail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity2.this, "Başarılı giriş denemesi", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(MainActivity2.this,Anasayfa.class));
                        }
                        else
                        {
                            Toast.makeText(MainActivity2.this, "Başarısız giriş denemesi", Toast.LENGTH_SHORT).show();
                        }

                    }






                });

            }

        });



        TextView kayitekraninagecis;

        kayitekraninagecis=findViewById(R.id.textView);
        kayitekraninagecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, kaydolekrani.class));
            }
        });


    }


    private void openDash() {
        startActivity(new Intent(MainActivity2.this,Anasayfa.class));
        finish();
    }


}