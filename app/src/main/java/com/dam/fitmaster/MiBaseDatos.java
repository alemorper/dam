package com.dam.fitmaster;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.annotation.SuppressLint;

public class MiBaseDatos extends SQLiteOpenHelper implements Rutinas {

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
    private static final String TABLA_RUTINAS = "CREATE TABLE IF NOT EXISTS rutinas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "objetivo TEXT," +
            "frecuencia TEXT," +
            "detalle TEXT NOT NULL" +
            ")";

    private static final String TABLA_ENTRENOS = "CREATE TABLE IF NOT EXISTS entrenos (" +
            "usuario TEXT PRIMARY KEY," + // Columna usuario como clave primaria
            "frecuencia_semanal INTEGER CHECK(frecuencia_semanal BETWEEN 2 AND 5)," + // Columna para la frecuencia semanal con restricción CHECK
            "numero_semana INTEGER DEFAULT 0," + // Columna para el número de semanas entrenadas
            "dias_entrenados INTEGER DEFAULT 0" + // Columna para el número de días entrenados con valor predeterminado
            ")";


    private static final String TABLA_VIDEOS = "CREATE TABLE IF NOT EXISTS videos (" +
            "nombre_ejercicio TEXT PRIMARY KEY," + // Clave primaria: nombre del ejercicio
            "video_id TEXT" + // ID del video asociado al ejercicio
            ")";

    private Context mContext;
    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
        mContext = context;
    }
    // Método para obtener la contraseña del usuario por su nombre de usuario

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
        db.execSQL(TABLA_RUTINAS);
        db.execSQL(TABLA_ENTRENOS);
        db.execSQL(TABLA_VIDEOS);
        insertarRutinaInicial(db);
        insertarVideoInicial(mContext,db);
        Log.d("MiBaseDatos", "Tablas de Base de Datos creadas...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MiBaseDatos", "OnUpgrade");
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_RUTINAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ENTRENOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_VIDEOS);
        onCreate(db);
    }

    private void insertarRutina(SQLiteDatabase db, String objetivo, String frecuencia, String detalle) {
        ContentValues cv = new ContentValues();
        cv.put("objetivo", objetivo);
        cv.put("frecuencia", frecuencia);
        cv.put("detalle", detalle);
        db.insert("rutinas", null, cv);
    }

    private void insertarRutinaInicial(SQLiteDatabase db) {
        insertarRutina(db, "Mantenerse", "2 días a la semana", detalleRutinaGanarMasa2Dias);
        insertarRutina(db, "Mantenerse", "3 días a la semana", detalleRutinaGanarMasa3Dias);
        insertarRutina(db, "Mantenerse", "4 días a la semana", detalleRutinaGanarMasa4Dias);
        insertarRutina(db, "Mantenerse", "5 días a la semana", detalleRutinaGanarMasa5Dias);
        insertarRutina(db, "Ganar masa muscular", "2 días a la semana", detalleRutinaGanarMasa2Dias);
        insertarRutina(db, "Ganar masa muscular", "3 días a la semana", detalleRutinaGanarMasa3Dias);
        insertarRutina(db, "Ganar masa muscular", "4 días a la semana", detalleRutinaGanarMasa4Dias);
        insertarRutina(db, "Ganar masa muscular", "5 días a la semana", detalleRutinaGanarMasa5Dias);
        insertarRutina(db, "Pérdida de grasa", "2 días a la semana", detalleRutinaPerdidaGrasa2Dias);
        insertarRutina(db, "Pérdida de grasa", "3 días a la semana", detalleRutinaPerdidaGrasa3Dias);
        insertarRutina(db, "Pérdida de grasa", "4 días a la semana", detalleRutinaPerdidaGrasa4Dias);
        insertarRutina(db, "Pérdida de grasa", "5 días a la semana", detalleRutinaPerdidaGrasa5Dias);
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

    public boolean borrarUsuario(String usuario) {
        SQLiteDatabase db = getWritableDatabase();
        long salida = 0;
        if (db != null) {
            salida = db.delete("usuarios", "usuario=?", new String[]{usuario}); //Eliminamos al usuario enviado como parametro
        }
        db.close();
        return salida > 0;
    }
    public boolean validarCredenciales(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null; //Objeto Cursor proporciona acceso a los resultados de una consulta
        boolean salida = false;
        int count = -1;

            // Consulta para verificar las credenciales en la base de datos
            String query = "SELECT COUNT(*) FROM usuarios WHERE usuario = ? AND contraseña = ?"; //Consulta SQL
            cursor = db.rawQuery(query, new String[]{username, password});

            // Si el cursor tiene al menos una fila, las credenciales son válidas
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
                if (count >= 1) {
                    salida = true;
                }
            }

            // Cierra el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
            Log.d("MiBaseDatos","Valor de salida " + salida + "  Valor de count " + count);
        return salida;
    }

    @SuppressLint("Range")
    public Usuario getDetallesUsuario(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Usuario usuario = null;

        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE usuario = ?", new String[]{username});
        if (cursor.moveToFirst()) {
            usuario = new Usuario();
            usuario.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            usuario.setContraseña(cursor.getString(cursor.getColumnIndex("contraseña")));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            usuario.setApellidos(cursor.getString(cursor.getColumnIndex("apellidos")));
            usuario.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
            usuario.setEdad(cursor.getInt(cursor.getColumnIndex("edad")));
            usuario.setGenero(cursor.getString(cursor.getColumnIndex("genero")));
            usuario.setNivelActual(cursor.getString(cursor.getColumnIndex("nivel_actual")));
            usuario.setObjetivo(cursor.getString(cursor.getColumnIndex("objetivo")));
            usuario.setFrecuenciaEntreno(cursor.getString(cursor.getColumnIndex("frecuencia_entreno")));
        }
        cursor.close();
        db.close();

        return usuario;
    }
    public void guardarPreferenciasUsuario(Context context, String objetivo, String frecuencia) {
        SharedPreferences prefs = context.getSharedPreferences("prefs_usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("objetivo", objetivo);
        editor.putString("frecuencia", frecuencia);

        editor.apply();
    }

    public boolean verificaUsuarioRep(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        boolean usuarioRepetido = false;
        int count = -1;
            // Consulta para verificar si el usuario ya existe en la base de datos
            String query = "SELECT COUNT(*) FROM usuarios WHERE usuario = ?";
            cursor = db.rawQuery(query, new String[]{username});

            // Si el cursor tiene al menos una fila y el conteo es mayor que cero, significa que el usuario está repetido
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
                if (count > 0) {
                    usuarioRepetido = true;
                }
            }

            // Cierra el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        Log.d("MiBaseDatos","Valor de usuarioRepetido " + usuarioRepetido + "  Valor de count " + count);
        return usuarioRepetido;
    }
    @SuppressLint("Range")
    public String obtenerRutina(String objetivo, String frecuencia) {
        SQLiteDatabase db = this.getReadableDatabase();
        String rutina = "No se encontró una rutina para los criterios seleccionados.";

        // Consulta SQL para buscar la rutina basada en objetivo y frecuencia
        String[] columns = {"detalle"};
        String selection = "objetivo = ? AND frecuencia = ?";
        String[] selectionArgs = {objetivo, frecuencia};

        Cursor cursor = db.query("rutinas", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            rutina = cursor.getString(cursor.getColumnIndex("detalle"));
        }
        cursor.close();
        db.close();

        return rutina;
    }
    public void insertarEntreno( String usuario, int frecuenciaSemanal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("frecuencia_semanal", frecuenciaSemanal);
        cv.put("numero_semana",1);
        cv.put("dias_entrenados",1);
        db.insert("entrenos", null, cv);
    }

    public boolean incrementarDiaEntrenado(String usuario, int frecuencia) {
        //La funcion devolvera true cuando una semana haya sido incrementada
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        // WHERE clause para especificar el usuario
        String user = "usuario = ?";
        String[] arg = {usuario};
        int dias = obtenerDiasEntrenados(usuario);
        if(dias == frecuencia) {
            // Actualizar la fila correspondiente al usuario
            valores.put("dias_entrenados", 1);
            int numero_semana = obtenerNumeroSemanas(usuario);
            valores.put("numero_semana", numero_semana + 1);
            db.update("entrenos",valores, user,arg);
            return true;
        }else{
            valores.put("dias_entrenados", dias + 1);
            db.update("entrenos", valores, user, arg);

        }
        return false;
    }

    @SuppressLint("Range")
    public int obtenerDiasEntrenados( String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Columnas que queremos recuperar
        String[] columnas = {"dias_entrenados"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "usuario = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {usuario};

        // Realizar la consulta
        Cursor cursor = db.query("entrenos", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar el valor de días entrenados
        int diasEntrenados = 0;

        // Verificar si se encontraron resultados y obtener el valor de días entrenados
        if (cursor.moveToFirst()) {
            diasEntrenados = cursor.getInt(cursor.getColumnIndex("dias_entrenados"));
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver el valor de días entrenados
        return diasEntrenados;
    }
    @SuppressLint("Range")
    public int obtenerNumeroSemanas( String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Columnas que queremos recuperar
        String[] columnas = {"numero_semana"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "usuario = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {usuario};

        // Realizar la consulta
        Cursor cursor = db.query("entrenos", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar el valor de días entrenados
        int numero_semana = 0;

        // Verificar si se encontraron resultados y obtener el valor de días entrenados
        if (cursor.moveToFirst()) {
            numero_semana = cursor.getInt(cursor.getColumnIndex("numero_semana"));
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver el valor de días entrenados
        return numero_semana;
    }
    @SuppressLint("Range")
    private String obtenerFrecuenciaEntreno(String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Columnas que queremos recuperar
        String[] columnas = {"frecuencia_entreno"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "usuario = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {usuario};

        // Realizar la consulta
        Cursor cursor = db.query("usuarios", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar la frecuencia de entrenamiento
        String frecuenciaEntreno = "";

        // Verificar si se encontraron resultados y obtener la frecuencia de entrenamiento
        if (cursor.moveToFirst()) {
            frecuenciaEntreno = cursor.getString(cursor.getColumnIndex("frecuencia_entreno"));
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver la frecuencia de entrenamiento
        return frecuenciaEntreno;
    }

    private void insertarVideoInicial(Context context,SQLiteDatabase db) {
        FileReader reader = new FileReader();
        reader.insertVideosFromTextFile(context , db);
    }
    @SuppressLint("Range")
    public String obtenerVideoId( String nombre_ejercicio) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Columnas que queremos recuperar
        String[] columnas = {"video_id"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "nombre_ejercicio = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {nombre_ejercicio};

        // Realizar la consulta
        Cursor cursor = db.query("videos", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar el valor de días entrenados
        String video_id = "";

        // Verificar si se encontraron resultados y obtener el valor de días entrenados
        if (cursor.moveToFirst()) {
            video_id = cursor.getString(cursor.getColumnIndex("video_id"));
        }

        // Cerrar el cursor
        cursor.close();
        Log.d("MiBaseDatos","Video ID " + video_id);
        // Devolver el valor de días entrenados
        return video_id;
    }

    public boolean actualizarObjetivoFrecuenciaUsuario(String usuario, String nuevoObjetivo, String nuevaFrecuencia) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("objetivo", nuevoObjetivo);
        cv.put("frecuencia_entreno", nuevaFrecuencia);

        try {
            int result = db.update("usuarios", cv, "usuario=?", new String[]{usuario});
            db.close();
            return result > 0;
        } catch (SQLiteConstraintException e) {
            Log.e("MiBaseDatos", "Error al actualizar: ", e);
            return false;
        } finally {
            if (db.isOpen()) {
                db.close();
            }
        }
    }
}
