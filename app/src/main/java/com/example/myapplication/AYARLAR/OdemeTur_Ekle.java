package com.example.myapplication.AYARLAR;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.VERİTABANI.DbHelper;

public class OdemeTur_Ekle extends AppCompatActivity {
    Button ekle;
    EditText gorev;
    private DbHelper v1;

 @Override

 protected void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.odemetur_ekle);
     v1=new DbHelper(this);
     ekle=(Button)findViewById(R.id.btnGorevEkle);
     gorev=(EditText)findViewById(R.id.etGorev);
     ekle.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             try{
                 ekleme(gorev.getText().toString());
                 Toast.makeText(getApplicationContext(),"Veritabanına Eklendi", Toast.LENGTH_LONG).show();
             } finally {
                 v1.close();
             }
         }
     });
 }
private void ekleme(String odemetur){
    SQLiteDatabase db=v1.getWritableDatabase();
    ContentValues cv1=new ContentValues();
    cv1.put("OdemeTuru",odemetur);
    db.insertOrThrow("OdemeTuru",null, cv1);
}

}
