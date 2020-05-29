package com.example.myapplication.AYARLAR;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Personal_Sil extends Activity {
    private DbHelper v1;
    Button btn;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personel_sil);
        btn = (Button)findViewById(R.id.personelsil);
        Spinner sp = (Spinner)findViewById(R.id.PerSilSpinner);
        v1 = new DbHelper(this);
        int syc=0;
        String [] bilgiler = {"","","","","","","","","","","","","",""};
        final String [] index = {"","","","","","","","","","","","",""};
        SQLiteDatabase db= v1.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From Personeller where Durum = 0", null);
        db.isOpen();
        while (cursor.moveToNext()){
            bilgiler[syc]=cursor.getString(cursor.getColumnIndex("ID"))+" "+cursor.getString(cursor.getColumnIndex("AD"))+" "+cursor.getString(cursor.getColumnIndex("SOYAD"));
            index[syc] =cursor.getString(cursor.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterAD = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapterAD);
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
        PersonelSil(Integer.parseInt(index[SpinnerDeger[0]]));
        Toast.makeText(getApplicationContext(),"Personel Silindi",Toast.LENGTH_LONG).show();
    }};

}
private void PersonelSil(int id)
        {
            SQLiteDatabase db=v1.getWritableDatabase();
            ContentValues cv1=new ContentValues();
            cv1.put("Durum",1);
            db.update("Personeller", cv1, "ID = "+id, null);
        }
        }

