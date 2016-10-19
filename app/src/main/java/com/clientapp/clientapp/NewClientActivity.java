package com.clientapp.clientapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewClientActivity extends AppCompatActivity {

    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);

        this.client = new Client();

        Button insert = (Button) findViewById(R.id.button3);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertClient();
            }
        });
    }

    public void insertClient(){
        DataBaseController crud = new DataBaseController(this);
        String result;

        EditText cliente = (EditText)findViewById(R.id.editText);
        EditText contato = (EditText)findViewById(R.id.editText2);
        EditText endereco = (EditText) findViewById(R.id.editText3);

        this.client.setCliente(cliente.getText().toString());
        this.client.setContato(contato.getText().toString());
        this.client.setEndereco(endereco.getText().toString());

        result = crud.insert(this.client.getCliente(), this.client.getContato(), this.client.getEndereco());
        Toast.makeText(this.getApplicationContext(), result, Toast.LENGTH_LONG).show();

        exitInsert();
    }

    public void exitInsert(){
        Intent exit = new Intent(this, MainActivity.class);
        startActivity(exit);

        finish();
    }
}
