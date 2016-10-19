package com.clientapp.clientapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alex on 31/05/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "clientapp.db";
    private static final int VERSAO = 1;

    public DataBase(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE CLIENT (" +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " cliente TEXT NOT NULL," +
                " contato TEXT NOT NULL," +
                " endereco TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CLIENT");
        onCreate(db);
    }
}
