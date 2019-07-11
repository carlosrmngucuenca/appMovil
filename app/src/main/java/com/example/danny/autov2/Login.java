package com.example.danny.autov2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by danny on 14/04/17.
 */

public class Login extends Activity implements View.OnClickListener {


    private EditText txtUsuario;
    private EditText txtContrasena;
    private Button Ingresar;
    private DataBaseManager manager;
    private Persona  Mipersona;
    private Cursor Registro;
    String contrasena;
    String Usuario;
    MapsActivity Maps;
    PersonaLogin MipersonaLogin;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initviews();
        initlisteners();
        initobjects();





    }

    public void initviews(){
        txtUsuario= (EditText)findViewById(R.id.txtUsuariolog);
        txtContrasena=(EditText)findViewById(R.id.textContrasenalog);
        Ingresar=(Button)findViewById(R.id.btnIngresolog);
    }

    public void initlisteners(){
        Ingresar.setOnClickListener(this);
    }

    public void initobjects(){
        manager = new DataBaseManager(this);
    }

    public boolean validate(String Usuario , String contrasena){

        boolean valid = true;
        boolean ban = false;
        manager.abrirBaseDeDatos();

        if (manager.CheckUsuario(Usuario,contrasena)==ban){
            txtUsuario.setError("Nombre  Invalido");
            txtContrasena.setError("Contraseña Invalida");

            valid= false;
        }

        if(contrasena.isEmpty()){
            txtContrasena.setError("Porfavor Ingrese Un Nombre valido");
            valid=false;

        }

        if(Usuario.isEmpty()){
            txtUsuario.setError("Porfavor Ingrese Un Usuario Valido");
            valid=false;

        }

        return valid;


    }

    public void registrar(String Usuario , String contrasena){
        boolean valider = false;
        if (validate(Usuario,contrasena)==valider){

            Toast.makeText(this,"Registro Fallido ",Toast.LENGTH_SHORT).show();

        }else{
            Maps= new MapsActivity();

            manager.abrirBaseDeDatos();
           // Toast.makeText(this,"quiere entrar creado",Toast.LENGTH_SHORT).show();
            Cursor Micursor=manager.DatosUsuario(Usuario,contrasena);
           // int cursorCount = Micursor.getCount();

            /*if( cursorCount>0){
                Toast.makeText(this,"conculta log creada",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this,"consulta log no creado",Toast.LENGTH_SHORT).show();*/
           // }
            String id  = String.valueOf(Micursor.getInt(0));
            String Nombre = Micursor.getString(1);
            String Apellido = Micursor.getString(3);
            String Correo= Micursor.getString(4);
            String Usuariologin=Micursor.getString(5);

            MipersonaLogin = new PersonaLogin(Nombre,Apellido,Correo,Usuariologin,id);
            System.out.println(""+MipersonaLogin.getNombre());
            System.out.println(""+MipersonaLogin.getApellido());
            System.out.println(""+MipersonaLogin.getCorreo());
            System.out.println(""+MipersonaLogin.getIdConductor());


            Maps.setPersonalog(MipersonaLogin);


            startActivity(new Intent(Login.this,Menuviajes.class));

        }
    }



    public Persona getMipersona() {
        return Mipersona;
    }

    public void setMipersona(Persona mipersona) {
        Mipersona = mipersona;
    }

    public void Inicio(){}

    @Override
    public void onClick(View v) {
        manager.abrirBaseDeDatos();
        contrasena = txtContrasena.getText().toString();
        Usuario = txtUsuario.getText().toString();



        registrar(contrasena,Usuario);
        manager.close();



    }



    public void Datoslogin (){

        String Nombre = Registro.getString(Registro.getColumnIndex(DBhelper.COLUMNNAME_NAME));





    }
}
