package com.example.myapplication.VERİTABANI;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "restapp.db";
    public static final int DB_VERSION = 1;
    private GirisEkranı ge;

    public DbHelper (context context) {super (context, DB_NAME, null, DB_VERSION); }

@Override
public void onCreate(SQLiteDatabase db) {
        db.execSQL(Kategoriler.getSql());
        db.execSQL(Adisyonlar.getSql());
        db.execSQL(HesapOdeme.getSql());
        db.execSQL(Masalar.getSql());
        db.execSQL(OdemeTuru.getSql());
        db.execSQL(PersonalGorevleri.getSql());
        db.execSQL(Personaller.getSql());
        db.execSQL(Satislar.getSql());
        db.execSQL(Urunler.getSql());

}

@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXİSTS Kategoriler");
        db.execSQL("DROP TABLE IF EXİSTS Adisyonlar");
        db.execSQL("DROP TABLE IF EXİSTS HesapOdeme");
        db.execSQL("DROP TABLE IF EXİSTS Masalar");
        db.execSQL("DROP TABLE IF EXİSTS OdemeTuru");
        db.execSQL("DROP TABLE IF EXİSTS PersonalGorevleri");
        db.execSQL("DROP TABLE IF EXİSTS Personaller");
        db.execSQL("DROP TABLE IF EXİSTS Satislar");
        db.execSQL("DROP TABLE IF EXİSTS Urunler");
        onCreate(db);

}
}
