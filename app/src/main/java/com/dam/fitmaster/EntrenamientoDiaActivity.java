package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CalendarView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EntrenamientoDiaActivity extends AppCompatActivity {
    private TextView dia, dia_entrenamiento,semana_entrenamiento;
    private CalendarView calendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento_dia);
        dia = findViewById(R.id.dateText);
        dia_entrenamiento = findViewById(R.id.DayText);
        semana_entrenamiento = findViewById(R.id.WeekText);
        Button training_completed = findViewById(R.id.TrainingButton);
        Intent intent = getIntent();
        String usuario = "";
        if (intent != null)
            usuario = intent.getStringExtra("usuario");
        //Implementacion de fecha en base al dia actual

        Log.d("EntrenamientoDiaActivity","Valor de usuario " + usuario);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy",new Locale("es", "ES"));
        String fechaActual = dateFormat.format(calendar.getTime());

        dia.setText(fechaActual);

        MiBaseDatos MDB = new MiBaseDatos(EntrenamientoDiaActivity.this);
        SQLiteDatabase db = MDB.getWritableDatabase();

        Usuario usuario1 = new Usuario();
        usuario1 = MDB.getDetallesUsuario(usuario);


        int numero_semana = MDB.obtenerNumeroSemanas(usuario);
        int numero_dia = MDB.obtenerDiasEntrenados(usuario);
        int frecuenciaEntrenoNumerica;
        String frecuencia_entreno = usuario1.getFrecuenciaEntreno();
        switch (frecuencia_entreno) {
            case "2 días a la semana":
                frecuenciaEntrenoNumerica = 2;
                break;
            case "3 días a la semana":
                frecuenciaEntrenoNumerica = 3;
                break;
            case "4 días a la semana":
                frecuenciaEntrenoNumerica = 4;
                break;
            case "5 días a la semana":
                frecuenciaEntrenoNumerica = 5;
                break;
            default:
                frecuenciaEntrenoNumerica = 2; // Valor predeterminado
                break;
        }
        Log.d("EntrenamientoDiaActivity","Valor de frecuenciaEntreno " + frecuenciaEntrenoNumerica);

        dia_entrenamiento.setText("Dia de entrenamiento " + String.valueOf(numero_dia));
        semana_entrenamiento.setText("Semana " + String.valueOf(numero_semana));

        String finalUsuario = usuario;
        training_completed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Aumentar numero de dia de entrenamiento
                MDB.incrementarDiaEntrenado(finalUsuario,frecuenciaEntrenoNumerica);

                Intent intent = new Intent(EntrenamientoDiaActivity.this, MenuBienvenida.class);
                intent.putExtra("usuario", finalUsuario);
                startActivity(intent);
            }
        });
    }
}