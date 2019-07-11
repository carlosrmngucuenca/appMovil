package com.example.danny.autov2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class RegistrarViaje extends Activity implements View.OnClickListener {

    Button Botonmapa;
    private EditText NumeroDeAsientos;
    private EditText CostoAsiento;
    private MapsActivity Mimapa;
    ArrayList <LatLng> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_viaje);
        Botonmapa = (Button)findViewById(R.id.btn_GuardarRtuta_Mapa);
        Botonmapa.setOnClickListener(this);
        NumeroDeAsientos=(EditText)findViewById(R.id.txtNumeroDeAsientos);
        CostoAsiento=(EditText)findViewById(R.id.txtCostoAsiento);



    }

    public void setLista(ArrayList<LatLng> lista) {
        this.lista = lista;
    }

    @Override
    public void onClick(View v) {

        Intent myintent = new Intent(RegistrarViaje.this,MapsActivity.class);
        startActivity(myintent);

    }
}
