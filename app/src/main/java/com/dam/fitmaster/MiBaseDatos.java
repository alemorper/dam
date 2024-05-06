package com.dam.fitmaster;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MiBaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 4;
    ;
    private static final String NOMBRE_BASEDATOS = "fitmaster.db";
    private static final String TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS usuario (" +
            "usuario TEXT PRIMARY KEY," +
            "contraseña TEXT NOT NULL," +
            "nombre TEXT NOT NULL," +
            "apellidos TEXT NOT NULL," +
            "correo TEXT NOT NULL," +
            "edad INTEGER NOT NULL," +
            "genero TEXT CHECK(genero IN ('Masculino','Femenino','Otro')) NOT NULL," +
            "altura INTEGER NOT NULL," +
            "peso INTEGER NOT NULL," +
            "nivel_actual TEXT CHECK(nivel_actual IN ('Sedentario','Moderadamente activo','Muy Activo','Altamente Activo','Atleta de Alto Rendimiento')) NOT NULL," +
            "objetivo TEXT CHECK(objetivo IN ('Masa Muscular','Fuerza','Resistencia Muscular','Tonificar','Otro')) NOT NULL," +
            "nivel_experiencia TEXT CHECK(nivel_experiencia IN ('Principiante','Intermedio','Avanzado')) NOT NULL," +
            "frecuencia_entreno TEXT CHECK(frecuencia_entreno IN ('Diariamente','3-5 veces por semana','1-2 veces por semana','Ocasionalmente')) NOT NULL," +
            "parte_cuerpo_fav TEXT CHECK(parte_cuerpo_fav IN ('Pecho','Espalda','Piernas','Brazos','Hombros','Abdominales','Gluteos','Cuerpo Completo')) NOT NULL" +
            ")";




    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
        Log.d("MiBaseDatos", "Base de Datos creada...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MiBaseDatos", "OnUpgrade");
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIO);
        onCreate(db);
    }


}
