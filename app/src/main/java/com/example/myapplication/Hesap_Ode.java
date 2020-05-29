package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.AYARLAR.MainActivity;
import com.example.myapplication.VERİTABANI.DbHelper;

import org.w3c.dom.Text;

import javax.microedition.khronos.egl.EGLDisplay;

public class Hesap_Ode extends AppCompatActivity {
    private DbHelper v1;
    Spinner spOdeme;
    EditText etIndirim;
    TextView tvAraToplam;
    TextView tvKDV;
    TextView tvToplamTutar;
    TextView tvMasaNo;
    Button btnHesapOde;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hesap_ode);

        v1= new DbHelper(this);
        int syc=0;
        String[] bilgiler={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        final String[] index={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        String adisyonID = "";
        float AraToplam = 0;
        spOdeme = (Spinner)findViewById(R.id.spOdemeTuru);
        etIndirim = (EditText)findViewById(R.id.etIndirim);
        tvAraToplam = (TextView)findViewById(R.id.tvAraToplam);
        tvKDV = (TextView)findViewById(R.id.tvKDV);
        tvToplamTutar = (TextView)findViewById(R.id.tvToplamTutar);
        tvMasaNo = (TextView)findViewById(R.id.txtMasaNo);
        btnHesapOde = (Button)findViewById(R.id.btnHesapOde);

        Intent intent = getIntent();
        tvMasaNo.setText(intent.getStringExtra("ID").toString());

        SQLiteDatabase db= v1.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From OdemeTuru where Durum = 0 ",null);
        db.isOpen();
        while(cursor.moveToNext())
        {
            bilgiler[syc]=cursor.getString(cursor.getColumnIndex("OdemeTuru"));
            index [syc]=cursor.getString(cursor.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterOdemeTuru = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterOdemeTuru.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOdeme.setAdapter(dataAdapterOdemeTuru);
        final int[] SpinnerDeger = new int[1];

        spOdeme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerDeger[0]= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Cursor cursor2 = db.rawQuery("Select AdisyonID,Satislar.ID,UrunAdi,Fiyat,Adet From Satislar,Urunler where Satislar.Durum = 0 and Satislar.MasaID = "+ tvMasaNo.getText().toString()+"and Urunler.ID = Satislar.UrunID",null);
                db.isOpen();
        while(cursor2.moveToNext()){

            AraToplam(Float.parseFloat(cursor2.getString(cursor2.getColumnIndex("Fiyat")))*Integer.parseInt(cursor2.getString(cursor2.getColumnIndex("Adet"))))+ AraToplam;adisyonID=cursor2.getString(cursor2.getColumnIndex("AdisyonID"));

        }
        tvAraToplam.setText(String.valueOf(AraToplam));
        tvKDV.setText(String.valueOf(AraToplam*0.18));
        tvToplamTutar.setText(String.valueOf(AraToplam+(AraToplam*0.18)));
        final String finalAdisyonID = adisyonID ;
       // btnHesapOde.setOnClickListener(){
            HesapOde()
                    MasaKapa(Integer.parseInt(tvMasaNo.getText().toString()));
            AdisyonKapa(Integer.parseInt(finalAdisyonID));
            SatislarKapa();
            Toast.makeText(getApplicationContext(),"Hesap Odendi", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
            intent.setClass(Hesap_Ode.this, MainActivity.class);
            startActivity(intent);
        }};
private void HesapOde(String AdisyonId,String OdemeTurId,float AraToplam,float KDV,float Indirim,float ToplamTutar){
        SQLiteDatabase db=v1.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        cv1.put("AdisyonID",AdisyonId);
        cv1.put("OdemeTurID",OdemeTurId);
        cv1.put("AraToplam",AraToplam);
        cv1.put("KDV",KDV);
        cv1.put("Indirim",Indirim);
        cv1.put("ToplamTutar",ToplamTutar-Indirim);
        db.insertOrThrow("HesapOdeme",null,cv1);
        }
    private void MasaKapa(int MasaID){
        SQLiteDatabase db=v1.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        cv1.put("Durum", 0);
        db.update("Masalar", cv1, "ID = " + MasaID, null);

    }
private void AdisyonKapa(int AdisyonID){
        SQLiteDatabase db=v1.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        cv1.put("Durum", 1);
        db.update("Adisyonlar", cv1, "ID = " + AdisyonID, null);

}
private void SatislarKapa(){
        SQLiteDatabase db=v1.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        Cursor cursor = db.rawQuery("Select AdisyonID,Satislar.ID,UrunAdi,Fiyat,Adet From Satislar,Urunler where Satislar.Durum = 0 and Satislar.MasaID =",null);
        db.isOpen();
        while(cursor.moveToNext())
        {
        String SatisId = cursor.getString(cursor.getColumnIndex("Satislar.ID"));
        cv1.put("Durum", 1);
        db.update("Satislar", cv1, "ID = " + Integer.parseInt(SatisId), null);
        }
        }
        }