package com.example.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.VERİTABANI.DbHelper;

public class GirisEkranı extends Activity {
    private DbHelper v1;
    Button giris;
    Button AdminOlustur;
    EditText sifre;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris_ekrani);
        giris=(Button)findViewById(R.id.btngiris);
        sifre=(EditText) findViewById(R.id.editgiris);
        AdminOlustur = (Button)findViewById(R.id.btnAdmin);
        v1=new DbHelper(this);

       // AdminOlustur.setOnClickListener()
        SQLiteDatabase db= v1.getReadableDatabase();
        ContentValues cv2= new ContentValues();
        cv2.put("Gorev", "Admin");
        db.insertOrThrow("PersonalGorevleri",null, cv2);
        ContentValues cv1= new ContentValues();
        cv1.put("YetkiID",1);
        cv1.put("AD","Admin");
        cv1.put("SOYAD","Admin");
        cv1.put("KullaniciAdi","Admin");
        cv1.put("Sifre","123456");
db.insertOrThrow("Personeller",null, cv1);
        Toast.makeText(getApplicationContext(), "Standart Admin Oluşturuldu", Toast.LENGTH_SHORT).show();
            }
        });
//giris.setOnClickListener(){
        String Sifre= sifre.getText().toString();
        if(sifre.getText().toString()==""){
        Toast.makeText(getApplicationContext(),"Alanı Boş Bırakmayınız",Toast.LENGHT_SHORT).show();
        }
        else {
            int id=0;
            SQLiteDatabase db= v1.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From Personeller where Durum = 0 and Sifre = '"+ Sifre + "'", null);
        db.isOpen();
        while(cursor.moveToNext()){
            id= Integer.parseInt(cursor.getString(cursor.getColumnIndex("YetkiID")));
        }
        if(id==0)
        {
            Toast.makeText(getApplicationContext(), "Boyle Bir Kullanıcı Bulunamadı",Toast.LENGHT_SHORT).show();
            AdminOlustur.setVisibility(View.VISIBLE);
        }
        else if(id==1){
        Intent giris=new Intent();
        giris.setClass(GirisEkrani.this,Anasayfa.class);
        startActivity(giris);
        }
        else if (id != 0){
            Intent giris = new Intent();
            giris.setClass(GirisEkrani.this,Anasayfa2.class);
            startActivity(giris);
        }

}
        }};
        }
}
