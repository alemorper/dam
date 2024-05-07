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
    private static final String TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS usuarios (" +
            "usuario TEXT PRIMARY KEY," +
            "contraseña TEXT NOT NULL," +
            "nombre TEXT NOT NULL," +
            "apellidos TEXT NOT NULL," +
            "correo TEXT NOT NULL," +
            "edad INTEGER NOT NULL," +
            "genero TEXT CHECK(genero IN ('Masculino','Femenino','Otro')) NOT NULL," +
            "nivel_actual TEXT CHECK(nivel_actual IN ('Sedentario','Moderadamente activo','Muy activo','Altamente activo','Atleta de alto rendimiento')) NOT NULL," +
            "objetivo TEXT CHECK(objetivo IN ('Ganar masa muscular','Pérdida de grasa','Mantenerse')) NOT NULL," +
            "frecuencia_entreno TEXT CHECK(frecuencia_entreno IN ('2 días a la semana','3 días a la semana','4 días a la semana','5 días a la semana')) NOT NULL" +
            //"parte_cuerpo_fav TEXT CHECK(parte_cuerpo_fav IN ('Pecho','Espalda','Piernas','Brazos','Hombros','Abdominales','Gluteos','Cuerpo Completo')) NOT NULL" +
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

    // Método para insertar datos en la tabla de usuario
    public boolean insertarUsuario(Usuario usuario) {
        long salida = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        if (db != null) {
            // Verificar si el nombre de usuario ya existe en la base de datos
            Cursor cursor = db.rawQuery("SELECT usuario FROM usuarios WHERE usuario = ?", new String[]{usuario.getUsuario()});
            if (cursor.getCount() == 0) {
                // El nombre de usuario no existe, se puede insertar
                ContentValues values = new ContentValues();
                values.put("usuario", usuario.getUsuario());
                values.put("contraseña", usuario.getContraseña());
                values.put("nombre", usuario.getNombre());
                values.put("apellidos", usuario.getApellidos());
                values.put("correo", usuario.getCorreo());
                values.put("edad", usuario.getEdad());
                values.put("genero", usuario.getGenero());
                values.put("nivel_actual", usuario.getNivelActual());
                values.put("objetivo", usuario.getObjetivo());
                values.put("frecuencia_entreno", usuario.getFrecuenciaEntreno());
                //values.put("parte_cuerpo_fav", usuario.getParteCuerpoFav());
                salida = db.insert("usuarios", null, values);
            }else{
                Log.d("MiBaseDatos","El usuario escogido ya existe, escoja otro"); //Añadir quizas un Toast para avisar a Usuario registrandose
            }
            cursor.close();
        }
        db.close();
        return (salida > 0);
    }

}
