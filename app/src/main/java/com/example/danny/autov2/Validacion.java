package com.example.danny.autov2;

import android.content.Context;
import android.icu.text.DateFormat;
import android.widget.EditText;

/**
 * Created by danny on 16/05/17.
 */

public class Validacion {

    private Context context;

    public Validacion(Context context){
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText EditTextNombre){
        boolean valid = true;
        String value = EditTextNombre.getText().toString().trim();
        if (value.isEmpty()|| value.length()>32 ){
            EditTextNombre.setError("Porfavor Ingrese Un Nombre valido");

            valid= false;
        }

        return valid;


    }


}
