package com.dam.fitmaster;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dieta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        // Lista de horarios de comida de lunes a domingo
        Comida[] comidas = {
                new Comida("Lunes", "Cereal con leche", "Pollo con arroz", "Fruta", "Ensalada"),
                new Comida("Martes", "Tostadas con aguacate", "Pasta con salsa de tomate", "Yogur", "Salmón con verduras"),
                new Comida("Miércoles", "Huevos revueltos", "Ensalada de pollo", "Batido de proteínas", "Arroz con carne"),
                new Comida("Jueves", "Panqueques de avena", "Sopa de verduras", "Nueces", "Pescado al horno con papas"),
                new Comida("Viernes", "Smoothie de frutas", "Wrap de pollo", "Galletas integrales", "Ensalada César"),
                new Comida("Sábado", "Tortilla española", "Pizza casera", "Zumo de naranja", "Tacos de carne"),
                new Comida("Domingo", "Avena con frutas", "Filete a la parrilla con verduras", "Yogur griego", "Pasta Alfredo")
        };

        // Configurar RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        AdaptadorComida adaptador = new AdaptadorComida(comidas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
    }
}