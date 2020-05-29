package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import com.example.myapplication.VERİTABANI.DbHelper;

public class Masa_Siparis extends Activity {
    private DbHelper v1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masa_siparis);

        Button btnMasaSec = (Button)findViewById(R.id.btnMasaSec);
        Spinner sp= (Button)findViewById(R.id.spinnerMasaSec);
        v1=new DbHelper(this);
        int syc=0;
        String [] bilgiler={"","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        final String[] index={"","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        SQLiteDatabase db=v1.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From Masalar where Durum = 0", null);
        db.isOpen();
        while(cursor.moveToNext())
        {
            bilgiler[syc]="Masa"+ cursor.getString(cursor.getColumnIndex("ID"))+"Kapasite:"+cursor.getString(cursor.getColumnIndex("Kapasite"));
            index[syc]=cursor.getString(cursor.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterGorev = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterGorev.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapterGorev);
        final  int[] SpinnerDeger=new int[1];

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerDeger[0]=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //btnMasaSec.setOnClickListener(){
        Intent intent= new Intent();
        intent.setClass(Masa_Siparis.this, Adisyon_Gir.class);
        intent.putExtra("ID",index[SpinnerDeger[0]].toString());
        startActivity(intent);
    }};
        }
        }
