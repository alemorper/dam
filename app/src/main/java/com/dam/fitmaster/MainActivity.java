package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LoginButton = findViewById(R.id.LoginButton);
        Button SignupButton = findViewById(R.id.SignupButton);
        EditText UserText = findViewById(R.id.UserText);
        EditText PasswordText = findViewById(R.id.PasswordText);


        LoginButton.setOnClickListener(view -> {
            // Acción al hacer clic en el botón de inicio de sesión
            String username = UserText.getText().toString();
            String password = PasswordText.getText().toString();
            Log.d("MainActivity", "Nombre de usuario: " + username);
            Log.d("MainActivity", "Contraseña: " + password);
        });

        }
}