package com.dam.fitmaster;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RutinaSemanalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_semanal);

        TextView tvRutinaContent = findViewById(R.id.tvRutinaContent);

        SharedPreferences prefs = getSharedPreferences("prefs_usuario", MODE_PRIVATE);
        String objetivo = prefs.getString("objetivo", "default_objetivo");
        String frecuencia = prefs.getString("frecuencia", "default_frecuencia");

        MiBaseDatos db = new MiBaseDatos(this);
        String rutina = db.obtenerRutina(objetivo, frecuencia);

        if (rutina.equals("No se encontró una rutina para los criterios seleccionados.")) {
            tvRutinaContent.setText(rutina);
        } else {
            tvRutinaContent.setText(Html.fromHtml(formatRutina(rutina), Html.FROM_HTML_MODE_LEGACY));
        }
    }

    private String formatRutina(String rutina) {
        // Aquí puedes añadir más formato, como colores o tamaños de texto diferentes
        return rutina.replace("**", "<b>").replace("##", "<b>").replace("\n", "<br/>");
    }
}