package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.AYARLAR.MainActivity;

public class Anasayfa extends Activity {
    Button btnmasasiparis;
    Button btnaciksiparis;
    Button btnayarlar;
    Button btncikis;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);

        btnmasasiparis = (Button)findViewById(R.id.btnmasasiparis);
        btnaciksiparis = (Button)findViewById(R.id.btnaciksiparis);
        btnayarlar = (Button)findViewById(R.id.btnayarlar);
        btncikis  = (Button)findViewById(R.id.btncikis);

        //btnayarlar.setOnClickListener(){
        Intent intent= new Intent(Anasayfa.this, MainActivity.class);
        startActivity(intent);

    }};
//btnmasasiparis.setOnClickListener(){
Intent intent= new Intent(Anasayfa.this, Masa_Siparis.class);
        startActivity(intent);
}};
//btnaciksiparis.setOnClickListener(){
        Intent intent= new Intent(Anasayfa.this,Acik_Siparisler.class);
        startActivity(intent);
        }};
//btnaciksiparis.setOnClickListener(){
ActivityCompat.finishAffinity(Anasayfa.this);
Intent intent= new Intent;
intent.setClass(Anasayfa.this,GirisEkrani.class);
startActivity(intent);
        }};
        }
        }

