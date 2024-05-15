package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.os.Bundle;

public class CambiarObjetivoActivity extends AppCompatActivity {

    private Spinner spinnerFrecuencia;
    private RadioGroup radioGroupObjetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_objetivo);

        String usuario = getIntent().getStringExtra("usuario");  // Asegúrate de que "usuario" se pasa correctamente

        RadioGroup rgObjectivo = findViewById(R.id.rgObjective);
        Spinner spFrecuencia = findViewById(R.id.spinnerTrainingFrequency);

        Button guardarCambios = findViewById(R.id.guardarCambios);
        guardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevoObjetivo = "";
                int radioButtonIdObjective = rgObjectivo.getCheckedRadioButtonId();
                if (radioButtonIdObjective != -1) {
                    RadioButton radioButton = findViewById(radioButtonIdObjective);
                    nuevoObjetivo = radioButton.getText().toString();

                }
                String nuevaFrecuencia = spFrecuencia.getSelectedItem().toString();

                MiBaseDatos db = new MiBaseDatos(CambiarObjetivoActivity.this);
                boolean actualizado = db.actualizarObjetivoFrecuenciaUsuario(usuario, nuevoObjetivo, nuevaFrecuencia);


                if (actualizado) {
                    // Guardar los cambios en SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("prefs_usuario", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("objetivo", nuevoObjetivo);
                    editor.putString("frecuencia", nuevaFrecuencia);
                    editor.apply();
                    Toast.makeText(CambiarObjetivoActivity.this, "Preferencias actualizadas", Toast.LENGTH_SHORT).show();
                    finish();
                } else {

                    Toast.makeText(CambiarObjetivoActivity.this, "Error al actualizar preferencias", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}