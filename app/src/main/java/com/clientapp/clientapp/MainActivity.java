package com.clientapp.clientapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inserir = (Button) findViewById(R.id.button);
        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newClient();
            }
        });

        Button select = (Button) findViewById(R.id.button2);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectClient();
            }
        });
    }

    public void newClient(){
        Intent insert = new Intent(this, NewClientActivity.class);
        startActivity(insert);
    }

    public void selectClient(){
        Intent select = new Intent(this, SelectClientActivity.class);
        startActivity(select);
    }
}
