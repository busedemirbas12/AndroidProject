package com.example.myapplication.AYARLAR;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.VERİTABANI.DbHelper;

public class Kategori_Ekle extends AppCompatActivity {
    Button ekle;
    TextView kategoriadi;
    EditText kategori;

    private DbHelper v1;
@Override
protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kategori_ekle);
    v1=new DbHelper(this);

    ekle=(Button)findViewById(R.id.btnekle);
    kategoriadi=(TextView)findViewById(R.id.txtktad);

    kategori=(EditText)findViewById(R.id.edtkategori);
    ekle.setOnClickListener(new View.onClickListener() {

@Override
        public void onClick(View v) {
    try
    {
        ekleme(kategori.getText().toString());
        Toast.makeText(getApplicationContext(), "Veritabanına Eklendi", Toast.LENGTH_LONG).show();
    }
    finally {
        v1.close();
    }
        }
        }};
}
private void ekleme(String kategori) {
    SQLiteDatabase db=v1.getWritableDatabase();
    ContentValues cv1=new ContentValues();
    cv1.put("Kategori", kategori);
    db.insertOrThrow("Kategoriler",null,cv1);
}
}
