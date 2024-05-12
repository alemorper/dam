package com.dam.fitmaster;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.annotation.SuppressLint;

public class MiBaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 4;
    ;
    private static final String NOMBRE_BASEDATOS = "fitmaster.db";
    String detalleRutinaGanarMasa2Dias =
            "### Día 1: Enfoque en Parte Superior del Cuerpo\n" +
                    "1. **Calentamiento**\n" +
                    "   - 5-10 minutos de cardio ligero (bicicleta estática o cinta)\n" +
                    "   - Estiramientos dinámicos\n\n" +
                    "2. **Ejercicios Compuestos**\n" +
                    "   - **Press de banca** - 4 series de 8-12 repeticiones\n" +
                    "   - **Remo con barra** - 3 series de 8-12 repeticiones\n\n" +
                    "3. **Ejercicios de Aislamiento**\n" +
                    "   - **Curl de bíceps con barra** - 3 series de 10-15 repeticiones\n" +
                    "   - **Extensiones de tríceps en polea alta** - 3 series de 10-15 repeticiones\n\n" +
                    "4. **Trabajo de Hombros y Pecho**\n" +
                    "   - **Press militar con barra** - 3 series de 8-12 repeticiones\n" +
                    "   - **Elevaciones laterales con mancuernas** - 3 series de 12-15 repeticiones\n\n" +
                    "5. **Core y Abs**\n" +
                    "   - **Plancha** - 3 series de 30-60 segundos\n" +
                    "   - **Crunches** - 3 series de 15-20 repeticiones\n\n" +
                    "### Día 2: Enfoque en Parte Inferior del Cuerpo\n" +
                    "1. **Calentamiento**\n" +
                    "   - 5-10 minutos de cardio ligero (bicicleta estática o cinta)\n" +
                    "   - Estiramientos dinámicos\n\n" +
                    "2. **Ejercicios Compuestos**\n" +
                    "   - **Sentadillas** - 4 series de 8-12 repeticiones\n" +
                    "   - **Peso muerto** - 3 series de 8-12 repeticiones\n\n" +
                    "3. **Ejercicios de Aislamiento**\n" +
                    "   - **Curl de piernas** - 3 series de 10-15 repeticiones\n" +
                    "   - **Extensiones de piernas** - 3 series de 10-15 repeticiones\n\n" +
                    "4. **Trabajo de Glúteos y Piernas**\n" +
                    "   - **Puentes de glúteo** - 3 series de 12-15 repeticiones\n" +
                    "   - **Estocadas** - 3 series de 12-15 repeticiones por pierna\n\n" +
                    "5. **Core y Abs**\n" +
                    "   - **Levantamientos de piernas colgantes** - 3 series de 10-15 repeticiones\n" +
                    "   - **Bicicleta abdominal** - 3 series de 15-20 repeticiones\n\n" +
                    "### Consejos Generales\n" +
                    "- **Progresión**: Aumenta gradualmente el peso cuando las series y repeticiones se vuelvan más fáciles.\n" +
                    "- **Descanso**: Entre series, descansa de 1 a 2 minutos para ejercicios compuestos y hasta 1 minuto para aislamiento.\n" +
                    "- **Nutrición**: Asegúrate de tener una dieta rica en proteínas y calorías suficientes para apoyar el crecimiento muscular.\n" +
                    "- **Hidratación**: Mantente bien hidratado antes, durante y después de tus entrenamientos.";
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


    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);

    }
    // Método para obtener la contraseña del usuario por su nombre de usuario

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
        db.execSQL(TABLA_RUTINAS);
        insertarRutinaInicial(db);
        Log.d("MiBaseDatos", "Tablas de Base de Datos creadas...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MiBaseDatos", "OnUpgrade");
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_RUTINAS);
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
        insertarRutina(db, "Ganar masa muscular", "2 días a la semana", detalleRutinaGanarMasa2Dias);
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

}
