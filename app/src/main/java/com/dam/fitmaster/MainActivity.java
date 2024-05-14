package com.dam.fitmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CheckBox;
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
        CheckBox recuerdame = findViewById(R.id.Recuerdame);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("recuerdame", "false");
        if(checkbox.equals("true")){
            Intent intent = new Intent(MainActivity.this, MenuBienvenida.class);
            startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(this, "Porfavor, introduzca tus credenciales", Toast.LENGTH_SHORT).show();
        }

        MiBaseDatos MDB = new MiBaseDatos(MainActivity.this);
        SQLiteDatabase db = MDB.getWritableDatabase();
        if (db != null){
        }else
    {
        Toast.makeText(MainActivity.this, "Fallo en la Aplicación", Toast.LENGTH_LONG).show();
    }
        Usuario usuarioAle = new Usuario("alemorper", "fitmaster", "Alejandro", "Moreno Perez",
                "alemorper4@alum.us.es", 22, "Masculino", "Moderadamente activo",
                "Ganar masa muscular",  "2 días a la semana");
        MDB.insertarUsuario(usuarioAle);
        Log.d("MainActivity", "Añadido usuario a BBDD");



        LoginButton.setOnClickListener(view -> {

            // Acción al hacer clic en el botón de inicio de sesión
            String username = UserText.getText().toString();
            String password = PasswordText.getText().toString();

            Log.d("MainActivity", "Nombre de usuario: " + username);
            Log.d("MainActivity", "Contraseña: " + password);


            if (MDB.validarCredenciales(username, password)) {
                Usuario usuario = MDB.getDetallesUsuario(username);
                if (usuario != null) {
                    SharedPreferences prefs = getSharedPreferences("prefs_usuario", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("objetivo", usuario.getObjetivo());
                    editor.putString("frecuencia", usuario.getFrecuenciaEntreno());
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, MenuBienvenida.class);
                    intent.putExtra("usuario", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No se encontraron detalles del usuario.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SignupButton.setOnClickListener(view -> {
            // Acción al hacer clic en el botón de registro
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);

            startActivity(intent);
        });

        recuerdame.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(buttonView.isChecked()){
                SharedPreferences preferences1 = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences1.edit();
               editor.putString("recuerdame", "true");
                editor.apply();
                Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();


            }else if(!buttonView.isChecked()){
                SharedPreferences preferences1 = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences1.edit();
                editor.putString("recuerdame", "false");
                editor.apply();
                Toast.makeText(MainActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
            }
        });


        }

}


