package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Adisyon_Gir extends AppCompatActivity {
    private DbHelper v1;
    final int[] SpinnerKategoriDeger = new int[1];
    final int[] SpinnerUrunDeger = new int[1];
    String [] Kategoribilgiler={"","","","","","","","","","","","","","",""};
    final String[] KategoriIndex={"","","","","","","","","","","","","",""};
    final String[] Urunbilgiler={"","","","","","","","","","","","","","",""};
    String [] Adet = {"1","2","3","4","5","6","7","8","9","10"};
    TextView tvMasaId;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adisyon_gir);

        tvMasaId = (TextView)findViewById(R.id.tvMasaId);
        Intent intent = getIntent();
        tvMasaId.setText(intent.getStringExtra("ID").toString());

        Button ekle = (Button)findViewById(R.id.btnAdisyonEkle);
        Spinner spKategoriler = (Spinner)findViewById(R.id.spAdisyonKategori);

        Spinner spAdet = (Spinner)findViewById(R.id.spAdisyonAdet);
        v1=new DbHelper(this);
        int syc=0;

        SQLiteDatabase db=v1.getReadableDatabase();

        /*--------KATEGORİ------*/
        Cursor cursorKategori= db.rawQuery("Select * From Kategoriler where Durum = 0", null);
        db.isOpen();
        while (cursorKategori.moveToNext())
        {
            Kategoribilgiler[syc]=cursorKategori.getString(cursorKategori.getColumnIndex("Kategori"));
            KategoriIndex [syc]=cursorKategori.getString(cursorKategori.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterKategori = new ArrayAdapter<~>(this,android.R.layout.simple_spinner_item, Kategoribilgiler);
        dataAdapterKategori.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKategoriler.setAdapter(dataAdapterKategori);

        spKategoriler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerKategoriDeger[0]=position;
                Urunler();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /*--------ADET------*/
        AdapterView<String> dataAdapterAdet = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item , Adet);
        dataAdapterAdet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAdet.setAdapter(dataAdapterAdet);
        final int[] adet= {0};
        spAdet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adet [0] = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //ekle.setOnClickListener(){
            int AdisyonID = Integer.parseInt(AdisyonEkle(Integer.parseInt(tvMasaId.getText().toString())));
            int UrunID = Integer.parseInt(UrunIndex[SpinnerUrunDeger[0]]);
            int MasaID = Integer.parseInt(tvMasaId.getText().toString());
            MasaAc(MasaID);
            SatisEkle(AdisyonID, UrunID, MasaID, adet[0]);
        Toast.makeText(getApplicationContext(), "Urun Eklendi", Toast.LENGTH_SHORT).show();
        }};
}
public void Urunler()
        {
/*-----------------URUNLER-------------*/
final Spinner spUrunler = (Spinner)findViewById(R.id.spAdisyonUrun);
int sycUrun=0;
SQLiteDatabase db=v1.getReadableDatabase();
Cursor cursorUrun= db.rawQuery("Select * From Urunler where Durum = 0 and KategoriID"+ KategoriIndex[SpinnerKategoriDeger[0]],null);
        db.isOpen();
        while(cursor.moveToNext())
        {
            Urunbilgiler[sycUrun]= cursorUrun.getString(cursorUrun.getColumnIndex("Urun Adi"));
            UrunIndex[sycUrun]=cursorUrun.getString(cursorUrun.getColumnIndex("ID"));
            sycUrun++;
        }
        ArrayAdapter<String> dataAdapterUrun = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterUrun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUrunler.setAdapter(dataAdapterUrunler);
        spUrunler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SpinnerDeger [0]= position;
        }

@Override
public void onNothingSelected(AdapterView<?> parent) {

        }
        });


private String AdisyonEkle(int MasaID)
        {
            int s=0;
            Date suanki = new Date();
            String adisyonID =null;
            SQLiteDatabase db= v1.getWritableDatabase();
            //---Deneme
        if(s==0)
        {
        Cursor cursorMevcutAdisyon=db.rawQuery("Select ID From Adisyonlar where Durum = 0 and MasaID = "+tvMasaId.getText(),null);
        db.isOpen();
        while(cursorMevcutAdisyon.moveToNext()){
        s=1;
        adisyonID=cursorMevcutAdisyon.getString(cursorMevcutAdisyon.getColumnIndex("ID"));
        }
        }
            //---Deneme
        if(s!=1){
            ContentValues cv1= new ContentValues();
            cv1.put("MasaID", MasaID);
            cv1.put("PersonalID",1);
            cv1.put("Tarih", suanki.toString());
            db.insertOrThrow("Adisyonlar", null, cv1);
            Cursor cursorYeniAdisyon= db.rawQuery("Select * From Adisyonlar where Durum = 0 ORDER BY ID DESC LIMIT 1",null);
            db.isOpen();
            while(cursorYeniAdisyon.moveToNext()){
                AdisyonID = cursorYeniAdisyon.getString(cursorYeniAdisyon.getColumnIndex("ID"));
        }
        }
return adisyonID;
        }
private void MasaAc(int MasaID){
    SQLiteDatabase db= v1.getWritableDatabase();
    ContentValues cv1 = new ContentValues();
    cv1.put("Durum",2);
    db.update("Masalar",cv1, "ID = " + MasaID, null);
        }
        private void SatisEkle(int AdisyonId, int UrunID, int MasaID, int Adet){
    SQLiteDatabase db=v1.getWritableDatabase();
    ContentValues cv1=new ContentValues();
    cv1.put("AdisyonID", AdisyonId);
    cv1.put("UrunID", UrunID);
    cv1.put("MasaID", MasaID);
    cv1.put("Adet", Adet);
    db.insertOrThrow("Satislar", null, cv1);
        }
        }