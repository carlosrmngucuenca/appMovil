package com.example.danny.autov2;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 03/05/17.
 */

public class ItemViajesActiviti extends Activity {

    DataBaseManager manager;
    ListView lista;
    Cursor cursor;
    List<DatosAdapter> listaViajeros;
    SimpleCursorAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemviajes);

        manager.abrirBaseDeDatos();

        lista = (ListView) findViewById(R.id.lisitaViajes);

        listaViajeros= manager.getlistaPersonas();
         Adapter miadapter = new Adapter(getApplicationContext(),listaViajeros);
        lista.setAdapter(miadapter);



    }




}
