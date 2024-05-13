package com.dam.fitmaster;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RutinaSemanalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_semanal);

        WebView tvRutinaContent = findViewById(R.id.tvRutinaContent);
        tvRutinaContent.getSettings().setJavaScriptEnabled(true); // Habilitar JavaScript
        tvRutinaContent.setWebViewClient(new WebViewClientMod(RutinaSemanalActivity.this)); // Configurar un WebViewClient

        SharedPreferences prefs = getSharedPreferences("prefs_usuario", MODE_PRIVATE);
        String objetivo = prefs.getString("objetivo", "default_objetivo");
        String frecuencia = prefs.getString("frecuencia", "default_frecuencia");

        MiBaseDatos db = new MiBaseDatos(this);
        String rutina = db.obtenerRutina(objetivo, frecuencia);

        if (rutina.equals("No se encontró una rutina para los criterios seleccionados.")) {
            tvRutinaContent.loadDataWithBaseURL(null, rutina, "text/html", "UTF-8", null);
        } else {
            tvRutinaContent.loadDataWithBaseURL(null,rutina,"text/html","UTF-8",null);
        }
    }

}