package com.example.danny.autov2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by danny on 14/04/17.
 */

public class Menuviajes extends Activity {

    Button btnViajes;
    Button postular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuviajes);

    }



    public void ejecutarTrazarRuta(View vista){
        Intent intencion = new Intent(this,MapsActivity.class);
        startActivity(intencion);

    }

    public void ejecutarListarViajes(View vista){
        Intent intencion = new Intent(this,ItemViajesActiviti.class);
        startActivity(intencion);

    }

}
