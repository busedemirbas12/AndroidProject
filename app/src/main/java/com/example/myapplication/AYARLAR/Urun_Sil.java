package com.example.myapplication.AYARLAR;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.VERİTABANI.DbHelper;

public class Urun_Sil extends AppCompatActivity {
      private DbHelper v1;
      Button btn;
      EditText et;
      @Override
    protected void onCreate(Bundle savedInstanceState){
          super.onCreate(savedInstanceState);
          setContentView(R.layout.urun_sil);
          v1=new DbHelper(this);

         // btn.setOnClickListener(){
          if (et.getText().toString()=="")
          {
              Toast.makeText(getApplicationContext(),"Alanı boş bırakmayınız", Toast.LENGTH_SHORT).show();
          }
          else
          {
              String urunAdi = et.getText().toString();
              int id=0;
              SQLiteDatabase db=v1.getReadableDatabase();
              Cursor cursor = db.rawQuery("Select * From urunler where Durum = 0 and UrunAdi = '"+urunAdi+"'", null);
              db.isOpen();
              while (Cursor.moveToNext())
              {
                  id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("ID")));
              }
              if(id==0)
                  Toast.makeText(getApplicationContext(),"Boyle Bir Urun Bulunamadı..", Toast.LENGTH_SHORT).show();
              else
              {
                  UrunSil(id);
                  Toast.makeText(getApplicationContext(),"Urun Silindi", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent();
                  et.setText("");
              }
          }

      }};
}
private void UrunSil(int id)
        {
            SQLiteDatabase db=v1.getWritableDatabase();
            ContentValues cv1=new ContentValues();
            cv1.put("Durum",1);
            db.update("Urunler", cv1, "ID = " + id, null);
        }
        }
