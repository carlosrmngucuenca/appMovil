package com.example.danny.autov2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by danny on 02/05/17.
 */

public class DBhelper extends SQLiteOpenHelper {

    static final String DB_NAME = "Personas";
    static final int DB_VERSION = 3;

    public static final String TABLE_NAME = "VPersonas";
    public static final String COLUMNNAME_ID = "_id";
    public static final String COLUMNNAME_NAME = "nombre";
    public static final String COLUMNNAME_CONTRASEÑA = "contraseña";
    public static final String COLUMNNAME_APELLIDO= "apellido";
    public static final String COLUMNNAME_CORREO= "correo";
    public static final String COLUMNNAME_USUARIO= "usuario";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + COLUMNNAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMNNAME_NAME + " TEXT NOT NULL, "
            + COLUMNNAME_CONTRASEÑA +" TEXT NOT NULL,"
            + COLUMNNAME_APELLIDO+" TEXT NOT NULL,"
            + COLUMNNAME_USUARIO+" TEXT NOT NULL,"
            + COLUMNNAME_CORREO+" TEXT NOT NULL);";

    public static final String TABLE_NAME_VIAJES = "TablaViajesConductorasPersonas";
    public static final String COLUMNAME_VIAJES_ID = "_id";
    public static final String COLUMNAME_NAME_VIAJERO = "nombreViajero";
    public static final String COLUMNAME_PUNTO1_VIAJERO= "punto1";
    public static final String COLUMNAME_PUNTO2_VIAJERO= "punto2";
    public static final String COLUMNAME_PUNTO3_VIAJERO= "punto3";
    public static final String COLUMNAME_PUNTO4_VIAJERO= "punto4";
    public static final String COLUMNAME_ID_CONDUCTOR= "idConductor";
    public static final String COLUMNAME_ASIENTOS_VIAJERO= "asientos";
    public static final String COLUMNAME_ASIENTOS_VIAJERO_COSTO= "costo";

    public static final String CREATE_TABLE_CONDUCTORES_VIAJES = " create table " + TABLE_NAME_VIAJES + "("
            + COLUMNAME_VIAJES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMNAME_NAME_VIAJERO + " TEXT NOT NULL, "
            + COLUMNAME_PUNTO1_VIAJERO +" TEXT, "
            + COLUMNAME_PUNTO2_VIAJERO+" TEXT, "
            + COLUMNAME_PUNTO3_VIAJERO+" TEXT, "
            + COLUMNAME_PUNTO4_VIAJERO+" TEXT, "
            + COLUMNAME_ID_CONDUCTOR+" TEXT, "
            + COLUMNAME_ASIENTOS_VIAJERO_COSTO+" TEXT, "
            + COLUMNAME_ASIENTOS_VIAJERO+" TEXT);";









    public DBhelper(Context context) {
        super(context,DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_CONDUCTORES_VIAJES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBhelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS TablaViajesConductorasPersonas");
        db.execSQL(CREATE_TABLE_CONDUCTORES_VIAJES);


    }
}
