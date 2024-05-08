package com.dam.fitmaster;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private EditText etName, etSName, etEmail, etAge, etUsername, etPassword;
    private RadioGroup rgGender, rgObjective;

    // Define más variables para otros CheckBoxes y componentes.
    private Button SignUpButton;
    private Spinner spinnerActivityLevel, spinnerTrainingFrequency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        SignUpButton = findViewById(R.id.btnRegister);
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
        rgObjective = findViewById(R.id.rgObjective);
        //cbDaily = findViewById(R.id.cbDaily);
        // Inicializa los otros CheckBoxes y componentes aquí.


        SignUpButton.setOnClickListener(view -> {
            // Acción al hacer clic en el botón de registro
            //Recolectamos los datos
            String usuario = etUsername.getText().toString();
            String nombre = etName.getText().toString();
            String apellido = etSName.getText().toString();
            String password = etPassword.getText().toString();
            String email = etEmail.getText().toString();
            int edad = Integer.parseInt(etAge.getText().toString());
            //Obtener genero
            int radioButtonId = rgGender.getCheckedRadioButtonId();
            String genero = "Masculino";
            if (radioButtonId != -1) { // Se ha seleccionado algún RadioButton
                RadioButton radioButton = findViewById(radioButtonId);
                genero = radioButton.getText().toString();

            }
            //Obtener objetivo
            String objetivo = "Masa Muscular";
            int radioButtonIdObjective = rgObjective.getCheckedRadioButtonId();
            if (radioButtonIdObjective != -1) {
                RadioButton radioButton = findViewById(radioButtonIdObjective);
                objetivo = radioButton.getText().toString();

            }



            // Obtener el nivel de actividad seleccionado en el Spinner
            String nivelActividadTemporal = spinnerActivityLevel.getSelectedItem().toString();
            String nivelActividad = obtenerNivelActividad(nivelActividadTemporal);

            String frecuenciaEntrenamiento = spinnerTrainingFrequency.getSelectedItem().toString();
            // Verificar si la casilla de verificación está marcada (Solo debe estar marcada una)

            Log.d("WelcomeActivity", "Nombre completo: " + nombre +" " + apellido);
            Log.d("WelcomeActivity", "Usuario: " + usuario);
            Log.d("WelcomeActivity", "Contraseña: " + password);
            Log.d("WelcomeActivity", "Correo electrónico: " + email);
            Log.d("WelcomeActivity", "Edad: " + edad);
            Log.d("WelcomeActivity", "Género seleccionado: " + genero);
            Log.d("WelcomeActivity", "Nivel de actividad: " + nivelActividad);
            Log.d("WelcomeActivity", "Frecuencia de entrenamiento: " + frecuenciaEntrenamiento);
            Log.d("WelcomeActivity", "Objetivo seleccionado: " + objetivo);

            MiBaseDatos MDB = new MiBaseDatos(WelcomeActivity.this);
            SQLiteDatabase db = MDB.getWritableDatabase();
            if (db != null) {
                if(MDB.verificaUsuarioRep(usuario) == false) {
                    Usuario usuario1 = new Usuario(usuario, password, nombre, apellido, email, edad, genero, nivelActividad, objetivo, frecuenciaEntrenamiento);
                    MDB.insertarUsuario(usuario1);
                    Log.d("WelcomeActivity","Usuario añadido con éxito");

                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(WelcomeActivity.this, "El nombre de usuario ya existe, seleccione otro", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    public void onRegisterClicked(View view) {
        // Recolecta y valida los datos aquí. Implementa el almacenamiento en base de datos o manejo de la lógica de negocio.
    }

    public String obtenerNivelActividad(String itemSeleccionado) {
        switch (itemSeleccionado) {
            case "Sedentario (poco o ningún ejercicio)":
                return "Sedentario";
            case "Moderadamente activo (ejercicio ligero 1-3 días a la semana)":
                return "Moderadamente activo";
            case "Muy activo (ejercicio moderado 3-5 días a la semana)":
                return "Muy activo";
            case "Altamente activo (ejercicio intenso 6-7 días a la semana)":
                return "Altamente activo";
            case "Atleta de alto rendimiento":
                return "Atleta de alto rendimiento";
            default:
                return ""; // En caso de que el elemento no coincida con ninguno de los esperados
        }
    }

}
