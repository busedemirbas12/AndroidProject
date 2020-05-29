package com.example.myapplication.AYARLAR;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.VERİTABANI.DbHelper;

public class Gorev_Ekle extends AppCompatActivity {
    Button ekle;
    EditText gorev;
    private DbHelper v1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gorev_ekle);
        v1=new DbHelper(this);
        ekle= (Button)findViewById(R.id.btnGorevEkle);
        gorev=(EditText)findViewById(R.id.etGorev);
        //ekle.setOnClickListener()
        {
            try{
                ekleme(gorev.getText().toString());
                Toast.makeText(getApplicationContext(), "Veritabanına Eklendi", Toast.LENGTH_SHORT).show();
            } finally {
                v1.close();
            }
        } };
}
private void ekleme(String gorev){
    SQLiteDatabase db= v1.getWritableDatabase();
    ContentValues cv1=new ContentValues();
    cv1.put("Gorev",gorev);
    db.insertOrThrow("PersonelGorevleri",null, cv1);
}
}
