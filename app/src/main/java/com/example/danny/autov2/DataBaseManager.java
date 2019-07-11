package com.example.danny.autov2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
//import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by danny on 02/05/17.
 */

public class DataBaseManager {


    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;








    public DataBaseManager(Context context) {
        ourcontext=context;


    }

    public DataBaseManager abrirBaseDeDatos()  {
        try{
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        }catch(Exception e){
            e.printStackTrace();

        }finally {
            return this;
        }

    }

    public void close(){

        database.close();
    }

    public ContentValues generarContentValues(Persona Mipersona){

        ContentValues cv = new ContentValues();
        cv.put(dbhelper.COLUMNNAME_NAME, Mipersona.getNombre());
        cv.put(dbhelper.COLUMNNAME_CONTRASEÑA, Mipersona.getContraseña());
        cv.put(dbhelper.COLUMNNAME_APELLIDO, Mipersona.getApellido());
        cv.put(dbhelper.COLUMNNAME_CORREO, Mipersona.getCorreo());
        cv.put(dbhelper.COLUMNNAME_USUARIO, Mipersona.getNusuario());


        return cv;
    }



    public void insertarDatos(Persona Mipersona) {

        long i = database.insert(dbhelper.TABLE_NAME, null, this.generarContentValues(Mipersona));

        if(i>0){
            Toast.makeText(ourcontext,"Persona Registrada Con Exito",Toast.LENGTH_SHORT).show();

        }

    }

    public void deleteData(long memberID) {
        database.delete(dbhelper.TABLE_NAME, dbhelper.COLUMNNAME_ID + "="
                + memberID, null);
    }

    public int actualizarDatos(long memberID, Persona Mipersona) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(dbhelper.COLUMNNAME_NAME, Mipersona.getNombre());
        cvActualizar.put(dbhelper.COLUMNNAME_CONTRASEÑA,Mipersona.getContraseña());
        cvActualizar.put(dbhelper.COLUMNNAME_APELLIDO, Mipersona.getApellido());
        cvActualizar.put(dbhelper.COLUMNNAME_CORREO, Mipersona.getCorreo());
        cvActualizar.put(dbhelper.COLUMNNAME_USUARIO, Mipersona.getNusuario());



        int i = database.update(dbhelper.TABLE_NAME, cvActualizar,
                dbhelper.COLUMNNAME_ID + " = " + memberID, null);
        return i;
    }


    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                dbhelper.COLUMNNAME_ID,
                dbhelper.COLUMNNAME_NAME,
                dbhelper.COLUMNNAME_CONTRASEÑA,
                dbhelper.COLUMNNAME_APELLIDO,
                dbhelper.COLUMNNAME_CORREO,
                dbhelper.COLUMNNAME_USUARIO

        };
        Cursor c = database.query(dbhelper.TABLE_NAME, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }




    public boolean CheckUsuario(String contrasena,String usu){

        String[] Columnas = new String[] {
                dbhelper.COLUMNNAME_NAME,
                dbhelper.COLUMNNAME_CONTRASEÑA,
                dbhelper.COLUMNNAME_APELLIDO,
                dbhelper.COLUMNNAME_CORREO,
                dbhelper.COLUMNNAME_USUARIO
        };

        String selection = dbhelper.COLUMNNAME_CONTRASEÑA + " = ?" + " AND " + dbhelper.COLUMNNAME_USUARIO+ " =?";
        String[] selectionArgs =new String[]  { contrasena, usu };



       Cursor cursor=database.query(dbhelper.TABLE_NAME,Columnas, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();


        if (cursorCount > 0){
            Toast.makeText(ourcontext,"Login Correcto",Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;



    }

    public Cursor DatosUsuario(String contrasena,String usu){
        Toast.makeText(ourcontext,"entra",Toast.LENGTH_SHORT).show();
        String[] Columnas = new String[] {
                dbhelper.COLUMNNAME_ID,
                dbhelper.COLUMNNAME_NAME,
                dbhelper.COLUMNNAME_CONTRASEÑA,
                dbhelper.COLUMNNAME_APELLIDO,
                dbhelper.COLUMNNAME_CORREO,
                dbhelper.COLUMNNAME_USUARIO
        };

        String selection = dbhelper.COLUMNNAME_CONTRASEÑA + " = ?" + " AND " + dbhelper.COLUMNNAME_USUARIO+ " =?";
        String[] selectionArgs =new String[]  { contrasena, usu };



        Cursor cursor=database.query(dbhelper.TABLE_NAME,Columnas, selection, selectionArgs, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        System.out.println(""+cursor.toString());
        int cursorCount = cursor.getCount();


        return cursor;



    }

    public boolean checkUser(String email){
        String[] columns = {
                dbhelper.COLUMNNAME_NAME,
                dbhelper.COLUMNNAME_CONTRASEÑA,
                dbhelper.COLUMNNAME_APELLIDO,
                dbhelper.COLUMNNAME_CORREO,
                dbhelper.COLUMNNAME_USUARIO
        };

        String selection =  dbhelper.COLUMNNAME_CORREO + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = database.query(dbhelper.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();


        if (cursorCount > 0){
            return true;
        }
        return false;
    }




   /*
   *
   * Aqui va la tabla de Conductore y sus Operaciones
   *
   * */



    public void insertarDatosConductores(String Nombre,String Punto1 ,String Punto2, String Punto3 ,String Punto4,String idConductor,String costo, String NumeroDeAsientos) {

        Toast.makeText(ourcontext,"entra",Toast.LENGTH_SHORT).show();
        ContentValues cvDOS = new ContentValues();
        cvDOS.put(dbhelper.COLUMNAME_NAME_VIAJERO, Nombre);
        cvDOS.put(dbhelper.COLUMNAME_PUNTO1_VIAJERO,Punto1);
        cvDOS.put(dbhelper.COLUMNAME_PUNTO2_VIAJERO,Punto2);
        cvDOS.put(dbhelper.COLUMNAME_PUNTO3_VIAJERO,Punto3);
        cvDOS.put(dbhelper.COLUMNAME_PUNTO4_VIAJERO,Punto4);
        cvDOS.put(dbhelper.COLUMNAME_ID_CONDUCTOR,idConductor);
        cvDOS.put(dbhelper.COLUMNAME_ASIENTOS_VIAJERO_COSTO,costo);
        cvDOS.put(dbhelper.COLUMNAME_ASIENTOS_VIAJERO,NumeroDeAsientos);


        System.out.println(""+cvDOS.toString());


        long i =database.insert(dbhelper.TABLE_NAME_VIAJES,null,cvDOS);


        if( i>0){
            Toast.makeText(ourcontext,"Viaje creado",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(ourcontext,"Viaje no creado",Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor leerDatosViajerosparalisar() {
        String[] todasLasColumnas = new String[] {
                dbhelper.COLUMNAME_NAME_VIAJERO,
                dbhelper.COLUMNAME_ASIENTOS_VIAJERO_COSTO


        };
        Cursor c = database.query(dbhelper.TABLE_NAME_VIAJES, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }


    public ArrayList<DatosAdapter> getlistaPersonas(){
        ArrayList<DatosAdapter> datos = new ArrayList<>();

        Cursor c= leerDatosViajerosparalisar();


        if(c.moveToFirst()){
            do{
                DatosAdapter Misdatos = new DatosAdapter();
                Misdatos.setNombre(c.getString(c.getColumnIndex(dbhelper.COLUMNAME_NAME_VIAJERO)));
                Misdatos.setCosto(c.getString(c.getColumnIndex(dbhelper.COLUMNAME_ASIENTOS_VIAJERO_COSTO)));

               datos.add(Misdatos);

            }while (c.moveToNext());

        }



        return  datos;
    }











}
