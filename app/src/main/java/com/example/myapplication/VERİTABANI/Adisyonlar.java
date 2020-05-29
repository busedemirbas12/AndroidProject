package com.example.myapplication.VERİTABANI;

public class Adisyonlar {
    static String getSql () {
        return "CREATE TABLE Adisyonlar (ID INTEGER PRIMARY KEY AUTO INCREMENT, PersonalID INTEGER, MasaID INTEGER, Tarih TIME, Durum BOOLEAN DEFAULT 0, FOREIGN KEY(PersonalID), FOREIGN KEY(MasaID), REFERENCES(MasalarID))";
    }
}
