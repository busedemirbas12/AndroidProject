package com.example.myapplication.AYARLAR;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.VERİTABANI.DbHelper;

public class MainActivity extends AppCompatActivity {
    Button Anasayfa;
    Button UrunEkle;
    Button KategoriEkle;
    Button KategoriSil;
    Button UrunSil;
    Button GorevEkle;
    Button GorevSil;
    Button MasaEkle;
    Button MasaSil;
    Button PersonalEkle;
    Button PersonalSil;
    Button OdemeEkle;
    Button OdemeSil;

    private GoogleApiClient client;
    public static DbHelper dbHelper;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();
        KategoriEkle = (Button)findViewById(R.id.btnkategoriekle);
        KategoriSil = (Button)findViewById(R.id.btnkategorisil);
        UrunEkle = (Button)findViewById(R.id.btnurunekle);
        UrunSil = (Button)findViewById(R.id.btnurunsil);
        PersonalEkle = (Button)findViewById(R.id.btnpersonalekle);
        PersonalSil = (Button)findViewById(R.id.btnpersonalsil);
        GorevEkle=(Button)findViewById(R.id.btngorevekle);
        GorevSil = (Button)findViewById(R.id.btngorevsil);
        MasaEkle = (Button)findViewById(R.id.btnmasaekle);
        MasaSil = (Button)findViewById(R.id.btnmasasil);
        OdemeEkle = (Button)findViewById(R.id.btnodemeekle);
        OdemeSil = (Button)findViewById(R.id.btnodemesil);
        Anasayfa = (Button)findViewById(R.id.btnanasayfa);

        Anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
