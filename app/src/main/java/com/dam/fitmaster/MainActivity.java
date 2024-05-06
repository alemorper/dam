package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LoginButton = findViewById(R.id.LoginButton);
        Button SignupButton = findViewById(R.id.SignupButton);
        EditText UserText = findViewById(R.id.UserText);
        EditText PasswordText = findViewById(R.id.PasswordText);

        MiBaseDatos MDB = new MiBaseDatos(MainActivity.this);
        SQLiteDatabase db = MDB.getWritableDatabase();
        if (db != null){
        }else
    {
        Toast.makeText(MainActivity.this, "FALLO AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
    }





        LoginButton.setOnClickListener(view -> {
            // Acción al hacer clic en el botón de inicio de sesión
            String username = UserText.getText().toString();
            String password = PasswordText.getText().toString();
            Log.d("MainActivity", "Nombre de usuario: " + username);
            Log.d("MainActivity", "Contraseña: " + password);
        });

        SignupButton.setOnClickListener(view -> {
            // Acción al hacer clic en el botón de registro
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        });

        }
}