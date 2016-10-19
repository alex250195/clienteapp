package com.clientapp.clientapp;

/**
 * Created by Alex on 31/05/2016.
 */
public class Client {
    private String cliente;
    private String contato;
    private String endereco;

    public void setCliente(String cliente){this.cliente = cliente;}
    public void setContato(String contato){this.contato = contato;}
    public void setEndereco(String endereco){this.endereco = endereco;}

    public String getCliente(){return this.cliente;}
    public String getContato(){return this.contato;}
    public String getEndereco(){return this.endereco;}
}
