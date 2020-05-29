package com.example.myapplication.AYARLAR;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.VERİTABANI.DbHelper;

public class Gorev_Sil extends AppCompatActivity {
    private DbHelper v1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gorev_sil);

        Button btnSil=(Button)findViewById(R.id.btnGorevSil);
        Spinner sp=(Spinner)findViewById(R.id.spinnerGorev);
        v1=new DbHelper(this);
        int syc=0;
        String [] bilgiler={"","","","","","","","","","","","","",""};
        final String[] index={"","","","","","","","","","","","",""};
        SQLiteDatabase db=v1.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From PersonelGorevleri where Durum = 0", null);
        db.isOpen();
        while(cursor.moveToNext())
        {
            bilgiler[syc]=cursor.getString(cursor.getColumnIndex("Gorev"));
            index[syc]=cursor.getString(cursor.getColumnIndex("ID"));
            syc++;
        }
        ArrayAdapter<String> dataAdapterGorev = new ArrayAdapter<~>(this, android.R.layout.simple_spinner_item, bilgiler);
        dataAdapterGorev.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapterGorev);
        final  int[] SpinnerDeger=new int[1];

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerDeger[0]=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //btnSil.setOnClickListener(){
            GorevSil(Integer.parseInt(index[SpinnerDeger[0]]));
        Toast.makeText(getApplicationContext(),"Gorev Silindi", Toast.LENGTH_LONG).show();
        Intent intent= new Intent();
        intent.setClass(Gorev_Sil.this, Gorev_Sil.class);
        startActivity(intent);
        }};
}
private void GorevSil(int id){
    SQLiteDatabase db=v1.getWritableDatabase();
    ContentValues v1=new ContentValues();
    cv1.put("Durum",1);
    db.update("PersonelGorevleri", cv1,"ID ="+ id, null );
        }
        }
