package com.example.danny.autov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ejecutarLpersonaRegistro(View vista){
     Intent intencion = new Intent(this,PersonaRegistro.class);
        startActivity(intencion);

    }

    public void ejecutarLLogin(View vista){
        Intent intencion = new Intent(this,Login.class);
        startActivity(intencion);

    }


}
