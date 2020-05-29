package com.example.myapplication.AYARLAR;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Kategori_Sil extends AppCompatActivity {
    private DbHelper v1;

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.kategori_sil);

    Button btnSil = (Button) findViewById(R.id.btnKategoriSil);
    Spinner sp = (Spinner)findViewById(R.id.KategoriSilSpinner);
    v1=new DbHelper(this);
    int syc=0;
    String[] bilgiler ={"","","","","","","","","","","","","",""};
    final String[] index={"","","","","","","","","","","","",""};
    SQLiteDatabase db=v1.getReadableDatabase();
    Cursor cursor = db.rawQuery("Select * From Kategoriler where Durum - 0", null);
    db.isOpen();
    while (cursor.moveToNext())
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
//btnSil.setOnClickListener(){
    KategoriSil(Integer.parseInt(index[SpinnerDeger[0]]));
    Toast.makeText(getApplicationContext(), "Kategori Silindi", Toast.LENGTH_LONG).show();
    Intent ıntent = new Intent();
    intent.setClass(Kategori_Sil.this, Kategori_Sil.class);
    startActivity(intent);
}};
        }
        private void KategoriSil(int id)
        {
    SQLiteDatabase db=v1.getWritableDatabase();
    ContentValues cv1=new ContentValues();
    cv1.put("Durum", 1);
    db.update("Kategoriler", cv1, "ID = "+ id, null);
        }
        }

