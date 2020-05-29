package com.example.myapplication.VERİTABANI;

public class OdemeTuru {
    static String getSql(){
        return "CREATE TABLE OdemeTuru (ID INTEGER PRIMARY KEY AUTOINCREMENT,OdemeTuru TEXT,Durum BOOLEAN DEFAULT O)";

    }
}
