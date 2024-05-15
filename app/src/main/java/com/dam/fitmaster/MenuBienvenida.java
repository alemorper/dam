package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MenuBienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bienvenida);
        Intent intent = getIntent();
        String usuario = "";
        if (intent != null)
             usuario = intent.getStringExtra("usuario");

        Button entreno_dia = findViewById(R.id.entreno_dia);
        Button rutina = findViewById(R.id.rutina);
        Button dieta = findViewById(R.id.dieta);
        Button logout = findViewById(R.id.logout);

        String finalUsuario = usuario;
        entreno_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 1 presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuBienvenida.this, EntrenamientoDiaActivity.class);
                intent.putExtra("usuario", finalUsuario);
                startActivity(intent);
            }
        });

        rutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 2 presionado", Toast.LENGTH_SHORT).show();

                // Iniciar RutinaSemanalActivity
                Intent intent = new Intent(MenuBienvenida.this, RutinaSemanalActivity.class);
                startActivity(intent);
            }
        });

        dieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 3 presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuBienvenida.this, Dieta.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("prefs_usuario", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.remove("objetivo");
                editor.remove("frecuencia");
                editor.putString("recuerdame", "false");
                editor.apply();
                finish();
            }
        });

        Button cambiarObjetivo = findViewById(R.id.btnCambiarObjetivo);

        cambiarObjetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuBienvenida.this, CambiarObjetivoActivity.class);
                intent.putExtra("usuario", finalUsuario); // Pasar el usuario
                startActivity(intent);
            }
        });


    }
}