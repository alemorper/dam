package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CalendarView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EntrenamientoDiaActivity extends AppCompatActivity {
    private TextView dia_entreno;
    private CalendarView calendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento_dia);
        dia_entreno = findViewById(R.id.diaText);
        Button volver = findViewById(R.id.BackButton);
        calendario = findViewById(R.id.calendarView);


        //Implementacion de fecha en base al dia actual

        //Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy",new Locale("es", "ES"));
        //String fechaActual = dateFormat.format(calendar.getTime());
        //
        //dia_entreno.setText(fechaActual);


        // Configurar el listener del CalendarView
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Crear un objeto Calendar y establecer la fecha seleccionada
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                // Formatear la fecha seleccionada
                String fechaSeleccionada = dateFormat.format(selectedDate.getTime());

                // Mostrar la fecha seleccionada en el TextView DiaText
                dia_entreno.setText(fechaSeleccionada);
            }
        });
        volver.setOnClickListener(new View.OnClickListener() { //Te devuelve al contexto anterior

            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuBienvenida.this, "Botón 1 presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EntrenamientoDiaActivity.this, MenuBienvenida.class);
                startActivity(intent);
            }
        });
    }
}