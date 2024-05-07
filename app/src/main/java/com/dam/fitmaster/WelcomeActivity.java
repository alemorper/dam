package com.dam.fitmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private EditText etName, etSName, etEmail, etAge, etUsername, etPassword;
    private RadioGroup rgGender;
    private Spinner spinnerActivityLevel, spinnerTrainingFrequency;
    private CheckBox cbGainMuscle, cbFatLoss, cbMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        etName = findViewById(R.id.etName);
        etSName = findViewById(R.id.etSName);
        etEmail = findViewById(R.id.etEmail);
        etAge = findViewById(R.id.etAge);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        //etHeight = findViewById(R.id.etHeight);
        //etWeight = findViewById(R.id.etWeight);
        rgGender = findViewById(R.id.rgGender);
        spinnerActivityLevel = findViewById(R.id.spinnerActivityLevel);
        spinnerTrainingFrequency = findViewById(R.id.spinnerTrainingFrequency);
        cbGainMuscle = findViewById(R.id.cbGainMuscle);
        cbFatLoss = findViewById(R.id.cbFatLoss);
        cbMaintain = findViewById(R.id.cbMaintain);
    }

    public void onRegisterClicked(View view) {
        // Recolecta y valida los datos aquí. Implementa el almacenamiento en base de datos o manejo de la lógica de negocio.
    }
}
