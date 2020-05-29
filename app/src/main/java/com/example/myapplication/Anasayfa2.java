package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Anasayfa2 extends Activity {
    Button btnmasasiparis;
    Button btnaciksiparis;
    Button btncikis;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa2);

        btnmasasiparis = (Button)findViewById(R.id.btnmasagiris);
        btnaciksiparis = (Button) findViewById(R.id.btnacik);
        btncikis = (Button)findViewById(R.id.btncikis);

        // btnmasasiparis.setOnClickListener((v) {
                Intent intent= new Intent(Anasayfa2.this, Masa_Siparis.class);
                startActivity(intent);
        }};
                //btnaciksiparis.setOnClickListener {
                Intent intent=new Intent(Anasayfa2.this, Acik_Siparisler.class);
                startActivity(intent);
        }};
       // btnekle.setOnClickListener {
       ActivityCompat.finisAffinity(Anasayfa2.this);
       Intent intent = new Intent();
       intent.setClass(Anasayfa2.this, GirisEkranı.class);
       startActivity(intent);
        }};
        }
        }
