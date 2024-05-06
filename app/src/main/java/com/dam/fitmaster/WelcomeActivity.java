package com.dam.fitmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etAge, etHeight, etWeight;
    private RadioGroup rgGender;
    private Spinner spinnerActivityLevel;
    private CheckBox cbGainMuscle, cbDaily;
    // Define más variables para otros CheckBoxes y componentes.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        rgGender = findViewById(R.id.rgGender);
        spinnerActivityLevel = findViewById(R.id.spinnerActivityLevel);
        cbGainMuscle = findViewById(R.id.cbGainMuscle);
        //cbDaily = findViewById(R.id.cbDaily);
        // Inicializa los otros CheckBoxes y componentes aquí.
    }

    public void onRegisterClicked(View view) {
        // Recolecta y valida los datos aquí. Implementa el almacenamiento en base de datos o manejo de la lógica de negocio.
    }
}
