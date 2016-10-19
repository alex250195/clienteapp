package com.clientapp.clientapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SelectClientActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_client);

        DataBaseController crud = new DataBaseController(getBaseContext());
        Cursor cursor = crud.searchAll();

        String[] nomeCampos = new String[] {"cliente", "contato", "endereco"};
        int[] idViews = new int[] {R.id.client, R.id.contato, R.id.endereco};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.select,cursor,nomeCampos,idViews, 0);
        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adaptador);
    }
}
