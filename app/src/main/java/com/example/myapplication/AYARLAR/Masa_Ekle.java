package com.example.myapplication.AYARLAR;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.VERİTABANI.DbHelper;

public class Masa_Ekle extends AppCompatActivity {
    Button ekle;
    EditText kapasite;
    private DbHelper v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masa_ekle);
        v1=new DbHelper(this);
        ekle=(Button)findViewById(R.layout.btnMasaEkle);
        kapasite=(EditText)findViewById(R.layout.etMasaKapasite);
        ekle.setOnClickListener(new View.onClickListener() {
            try
            {
                ekleme(kapasite.getText().toString());
                Toast.makeText(getApplicationContext(),"Veritabanına Eklendi",Toast.LENGTH_LONG).show();
            }
            finally{
                v1.close();
            }
        }};
}
private void ekleme(String kapasite)
{
    SQLiteDatabase db=v1.getWritableDatabase();
    ContentValues cv1= new ContentValues();
    cv1.put("Kapasite",kapasite);
    db.insertOrThrow("Masalar",null,cv1);
}
