package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Acik_Siparisler extends AppCompatActivity {
    private DbHelper V1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acik_siparisler);

        Button btnHesap = (Button)findViewById(R.id.btnHesap);
        Button btnUrunGor = (Button)findViewById(R.id.btnUrunGor);
        Button btnMasaSec = (Button)findViewById(R.id.btnKapaliMasaSec);
        Spinner sp=(Spinner)findViewById(R.id.spinnerKapaliMasaSec);
        v1=new DbHelper(this);
        int syc=0;
        String[] bilgiler={"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        final String[] index={"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        SQLiteDatabase db= v1.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From Masalar where Durum = 2", null);
        db.isOpen();
        while(cursor.moveToNext())
        {
            bilgiler[syc]= "Masa"+ cursor.getString(cursor.getColumnIndex("ID"))+"Kapasite: "+cursor.getString(cursor.getColumnIndex("Kapasite"));
            index [syc]=cursor.getString(cursor.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterMasa = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterMasa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapterMasa);
        final int[] SpinnerDeger = new int[1];

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerDeger [0]= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       // btnMasaSec.setOnClickListener(){
        Intent intent = new Intent();
        intent.setClass(Acik_Siparisler.this,Adisyon_Gir.class);
        intent.putExtra("ID", index[SpinnerDeger[0]].toString());
        startActivity(intent);
    }};
// btnUrunGor.setOnClickListener(){
        Intent intent = new Intent();
                intent.setClass(Acik_Siparisler.this,Urun_Gor.class);
        intent.putExtra("ID", index[SpinnerDeger[0]].toString());
        startActivity(intent);
        }};
        // btnHesap.setOnClickListener(){
        Intent intent = new Intent();
        intent.setClass(Acik_Siparisler.this,Hesap_Ode.class);
        intent.putExtra("ID", index[SpinnerDeger[0]].toString());
        startActivity(intent);
        }};
        }
        }