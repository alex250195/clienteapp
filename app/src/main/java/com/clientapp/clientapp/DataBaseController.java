package com.clientapp.clientapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alex on 31/05/2016.
 */
public class DataBaseController {
    private SQLiteDatabase db;
    private DataBase database;

    public DataBaseController(Context context){
        this.database = new DataBase(context);
    }

    public String insert(String cliente, String contato, String endereco){
        ContentValues values;
        long result;

        db = database.getWritableDatabase();

        values = new ContentValues();
        values.put("cliente", cliente);
        values.put("contato", contato);
        values.put("endereco", endereco);

        result = db.insert("CLIENT", null, values);
        db.close();

        if (result == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }

    public Cursor searchAll(){
        db = database.getReadableDatabase();

        String orderBy = " _id DESC ";

        String[] campos = new String[]{"_id", "cliente", "contato", "endereco"};
        Cursor cursor = db.query("CLIENT", campos, null, null, null, null, orderBy);

        if(cursor != null) cursor.moveToFirst();
        db.close();

        return cursor;
    }

    public boolean delete(int id){
        String where = "_id = " + id;
        db = database.getReadableDatabase();
        db.delete("CLIENT", where, null);
        db.close();
        return true;
    }
}
