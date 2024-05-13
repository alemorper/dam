package com.dam.fitmaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//Lee del fichero videos.txt y añade los valores a la BBDD
public class FileReader {
    public void insertVideosFromTextFile(Context context, SQLiteDatabase db) {
        // Nombre del archivo de texto en assets
        String filename = "videos.txt";

        try {
            // Abrir el archivo de texto desde assets
            InputStream inputStream = context.getAssets().open(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Leer cada línea del archivo
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Dividir la línea en partes usando el separador ;
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String nombreEjercicio = parts[0];
                    String videoId = parts[1];

                    // Insertar el nombre del ejercicio y el videoId en la base de datos
                    ContentValues values = new ContentValues();
                    values.put("nombre_ejercicio", nombreEjercicio);
                    values.put("video_id", videoId);
                    db.insert("videos", null, values);
                }
            }

            // Cerrar el BufferedReader y el InputStream
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
