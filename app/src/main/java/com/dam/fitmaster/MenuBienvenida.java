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

        Button entreno_dia = findViewById(R.id.entreno_dia);
        Button rutina = findViewById(R.id.rutina);
        Button dieta = findViewById(R.id.dieta);
        Button logout = findViewById(R.id.logout);

        entreno_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 1 presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuBienvenida.this, EntrenamientoDiaActivity.class);
                startActivity(intent);
            }
        });

        rutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 2 presionado", Toast.LENGTH_SHORT).show();

            }
        });

        dieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 3 presionado", Toast.LENGTH_SHORT).show();

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("recuerdame", "false");
                editor.apply();
                finish();
            }
        });


    }
}