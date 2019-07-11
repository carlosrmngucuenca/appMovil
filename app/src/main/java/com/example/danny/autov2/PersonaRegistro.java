package com.example.danny.autov2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by danny on 14/04/17.
 */

public class PersonaRegistro extends Activity implements View.OnClickListener {

    private Button guardar;
    private EditText inputNombre;
    private EditText inputEmail;
    private EditText inputApellido;
    private EditText inputContraseña;
    private EditText inputUsuario;
    private DataBaseManager manager;

    String nombre ;
    String email ;
    String apellido ;
    String contraseña ;
    String Usuario ;



    public Persona Mipersona;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.personaregistro);

        initviews();
        initlisteners();
        initobjects();



    }

    public  void initviews(){

        inputNombre=(EditText)findViewById(R.id.txtNombre);
        inputApellido=(EditText)findViewById(R.id.txtApellido);
        inputEmail=(EditText)findViewById(R.id.txtCorreo);
        guardar=(Button) findViewById(R.id.btnGuardar);
        inputApellido=(EditText) findViewById(R.id.txtApellido);
        inputContraseña=(EditText)findViewById(R.id.txtContrasena) ;
        inputUsuario=(EditText) findViewById(R.id.txtUsuario);


    }

    public void initlisteners(){
        guardar.setOnClickListener(this);
    }

    public void initobjects(){
        manager = new DataBaseManager(this);
    }


    public void onClick(View v) {

        postDataSql();
        registrar();




    }

    public void registrar(){
        if (!validate()){

            Toast.makeText(this,"Registro Fallido ",Toast.LENGTH_SHORT).show();

        }else{

            manager.abrirBaseDeDatos();
            Mipersona=new Persona(nombre,apellido,email,contraseña,Usuario);
            manager.insertarDatos(Mipersona);
            startActivity(new Intent(PersonaRegistro.this,MainActivity.class));

        }
    }


    public boolean validate(){

        boolean valid = true;

        if (nombre.isEmpty()|| nombre.length()>32 ){
            inputNombre.setError("Porfavor Ingrese Un Nombre valido");

            valid= false;
        }

        if(email.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            inputEmail.setError("Porfavor Ingrese Un Nombre valido");
            valid=false;

        }

        if(apellido.isEmpty()){
            inputApellido.setError("Porfavor Ingrese Un Nombre valido");
            valid=false;

        }

        if(contraseña.isEmpty()){
            inputContraseña.setError("Porfavor Ingrese Un Nombre valido");
            valid=false;

        }

        if(Usuario.isEmpty()){
            inputUsuario.setError("Porfavor Ingrese Un Nombre valido");
            valid=false;

        }

        return valid;


    }

    public void postDataSql(){


             nombre = inputNombre.getText().toString();
             email = inputEmail.getText().toString();
             apellido = inputApellido.getText().toString();
             contraseña = inputContraseña.getText().toString();
             Usuario = inputUsuario.getText().toString();




    }

    public void limpiarDatos(){
        inputNombre.setText(null);
        inputApellido.setText(null);
        inputEmail.setText(null);
        inputApellido.setText(null);
        inputContraseña.setText(null); ;
        inputUsuario.setText(null);


    }


}
