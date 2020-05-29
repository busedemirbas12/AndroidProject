package com.example.myapplication.AYARLAR;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Personal_Ekle extends Activity {
    private DbHelper v1;
    Spinner sp;
    EditText et;
    EditText et2;
    EditText et3;
    EditText et4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_ekle);
        String[]sutunlar= {"Gorev"};
        v1=new DbHelper(this);
        int syc=0;
        String[] bilgiler={"","","","","","","","",""};
        final String[] index={"","","","","","","","",""};
        sp = (Spinner)findViewById(R.id.Personalspinner);
        et = (EditText)findViewById(R.id.edtperad);
        et2 = (EditText)findViewById(R.id.edtsoyad);
        et3 = (EditText)findViewById(R.id.edtkullaniciadi);
        et4 = (EditText)findViewById(R.id.edtsifre);
        btn = (Button)findViewById(R.id.btnkaydet);
        SQLiteDatabase db=v1.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From PersonalGorevleri where Durum = 0", null);
        db.isOpen();
        while(cursor.moveToNext())
        {
            bilgiler[syc]=cursor.getString(cursor.getColumnIndex("Gorev"));
            index[syc]=cursor.getString(cursor.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterPersonalGorev = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterPersonalGorev.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapterPersonalGorev);
        final int[] SpinnerDeger = new int[1];
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerDeger[0]= position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //btn.setOnClickListener();
        PersonalEkle(et.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString(),Integer.parseInt(index[SpinnerDeger[0]]));
        Toast.makeText(getApplicationContext(), "Veritabanına Eklendi", Toast.LENGTH_SHORT).show();
    }};
}
private void PersonalEkle(String PersonalAdi, String soyad, String kullaniciadi, String sifre, int PersonalGorevId)
        {
            SQLiteDatabase db=v1.getWritableDatabase();
            ContentValues cv1=new ContentValues();
            cv1.put("YetkiID", PersonalGorevId);
            cv1.put("AD", PersonalAdi);
            cv1.put("SOYAD", soyad);
            cv1.put("KullaniciAdi", kullaniciadi);
            cv1.put("Sifre", sifre);
            db.insertOrThrow("Personeller", null, cv1);

        }
        }