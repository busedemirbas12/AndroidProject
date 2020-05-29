package com.example.myapplication.AYARLAR;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.VERİTABANI.DbHelper;

public class Urun_Ekle extends AppCompatActivity {
private DbHelper v1;
Spinner sp;
EditText et;
EditText et2;
Button btn;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.urun_ekle);
    String[]sutunlar={"Kategori"};
    v1=new DbHelper(this);
    int syc=0;
    String[] bilgiler={"","","","","","","","",""};
    final String[] index={"","","","","","","","",""};
    sp = (Spinner)findViewById(R.id.KategoriSpinner);
    et = (EditText)findViewById(R.layout.editTextUrunAd);
    et2 = (EditText)findViewById(R.layout.editTextUrunFiyat);
    btn = (Button)findViewById(R.layout.btnkaydet);

    SQLiteDatabase db=v1.getReadableDatabase();
    Cursor cursor = db.rawQuery("Select * From Kategoriler where Durum - 0", null);
    db.isOpen();
    while(cursor.moveToNext())
    {
        bilgiler[syc]=cursor.getString(cursor.getColumnIndex("Kategori"));
        index[syc]=cursor.getString(cursor.getColumnIndex("ID"));
        syc++;
    }
    ArrayAdapter<String> dataAdapterKategori = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bilgiler);
    dataAdapterKategori.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    sp.setAdapter(dataAdapterKategori);
    final int[] SpinnerDeger = new int[1];
    sp.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerDeger[0] = position;
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }};
//btn.setOnClickListener(){
    UrunEkle(et.getText().toString(),Integer.parseInt(Index[SpinnerDeger[0]]), Float parseFloat(et2.getText().toString()));
        Toast.makeText(getApplicationContext(), "Veritabanına Eklendi", Toast.LENGTH_LONG.show());
        }};
}
private void UrunEkle (String UrunAdi,int KategoriId, float fiyat) {
    SQLiteDatabase db = v1.getWritableDatabase();
    ContentValues cv1 = new ContentValues();
    cv1.put("KategoriID", KategoriId);
    cv1.put("UrunAdi", UrunAdi);
    cv1.put("Fiyat", fiyat);
}
}
