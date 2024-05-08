package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;
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

        entreno_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuBienvenida.this, "Botón 1 presionado", Toast.LENGTH_SHORT).show();

            }
        });

        rutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuBienvenida.this, "Botón 2 presionado", Toast.LENGTH_SHORT).show();

            }
        });

        dieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuBienvenida.this, "Botón 3 presionado", Toast.LENGTH_SHORT).show();

            }
        });
    }
}