package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Urun_Gor extends AppCompatActivity {
    private DbHelper v1;

    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.urun_gor);

        ListView lvUrunListesi = (ListView)findViewById(R.id.lvUrunListesi);
        v1= new DbHelper(this);
        int syc=0;
        final TextView masaNo = (TextView)findViewById(R.id.txtMasaNo);
        Intent intent = getIntent();
        masaNo.setText(intent.getStringExtra("ID").toString());

        String[] bilgiler={"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        final String[] index={"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        SQLiteDatabase db= v1.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select Satislar.ID, UrunAdi, Fiyat, Adet, From Satislar,Urunler where Satislar.Durum = 0 and Satislar.MasaID = ", null);
        db.isOpen();
        while(cursor.moveToNext())
        {
    }
}
