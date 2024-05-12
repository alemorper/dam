package com.dam.fitmaster;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.annotation.SuppressLint;

public class MiBaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 4;
    ;
    private static final String NOMBRE_BASEDATOS = "fitmaster.db";
    String detalleRutinaGanarMasa2Dias =
            "<h3>Día 1: Enfoque en Parte Superior del Cuerpo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática o cinta)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios Compuestos</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca</strong> - 4 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con barra</strong> - 3 series de 8-12 repeticiones</li>" +
                    "<li><strong>Ejercicios de Aislamiento</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con barra</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de tríceps en polea alta</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Trabajo de Hombros y Pecho</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press militar con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones laterales con mancuernas</strong> - 3 series de 12-15 repeticiones</li>" +
                    "<li><strong>Core y Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Plancha</strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong>Crunches</strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Enfoque en Parte Inferior del Cuerpo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática o cinta)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios Compuestos</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas</strong> - 4 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Peso muerto</strong> - 3 series de 8-12 repeticiones</li>" +
                    "<li><strong>Ejercicios de Aislamiento</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de piernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de piernas</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Trabajo de Glúteos y Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Puentes de glúteo</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Estocadas</strong> - 3 series de 12-15 repeticiones por pierna</li>" +
                    "<li><strong>Core y Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Levantamientos de piernas colgantes</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Bicicleta abdominal</strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Progresión</strong>: Aumenta gradualmente el peso cuando las series y repeticiones se vuelvan más fáciles.</li>" +
                    "<li><strong>Descanso</strong>: Entre series, descansa de 1 a 2 minutos para ejercicios compuestos y hasta 1 minuto para aislamiento.</li>" +
                    "<li><strong>Nutrición</strong>: Asegúrate de tener una dieta rica en proteínas y calorías suficientes para apoyar el crecimiento muscular.</li>" +
                    "<li><strong>Hidratación</strong>: Mantente bien hidratado antes, durante y después de tus entrenamientos.</li>" +
                    "</ul>";
    String detalleRutinaGanarMasa3Dias =
            "<h3>Día 1: Pecho y Tríceps</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio suave<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Pecho</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca inclinado con mancuernas</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Cruces de cables</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Tríceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Fondos en paralelas</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Press francés</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de tríceps en polea alta</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de piernas</strong> - 3 series de 12-15 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Espalda y Bíceps</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio suave<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Peso muerto</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Jalones al pecho</strong> - 3 series de 10-12 repeticiones</li>" +
                    "<li><strong>Bíceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Curl con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl con mancuernas alternado</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Crunches</strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Piernas y Hombros</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio suave<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Prensa de piernas</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de piernas</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Hombros</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press militar</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones laterales con mancuernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones frontales con mancuernas</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Plancha</strong> - 3 series de 30-60 segundos</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Intensidad</strong>: Asegúrate de utilizar un peso que te permita completar las repeticiones con dificultad pero sin comprometer la técnica.</li>" +
                    "<li><strong>Descanso</strong>: Toma descansos de 1-2 minutos entre series y 2-3 minutos entre ejercicios diferentes para maximizar la recuperación muscular.</li>" +
                    "<li><strong>Alimentación</strong>: Consumir suficientes proteínas y calorías es crucial para el crecimiento muscular.</li>" +
                    "<li><strong>Hidratación</strong>: Beber agua suficiente antes, durante y después del entrenamiento ayuda a mejorar el rendimiento y la recuperación.</li>" +
                    "</ul>";
    String detalleRutinaGanarMasa4Dias =
            "<h3>Día 1: Pecho y Tríceps</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Pecho</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Press inclinado con mancuernas</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Aperturas con mancuernas</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Tríceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Dips o fondos en paralelas</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de tríceps en polea alta</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Press francés con mancuernas</strong> - 3 series de 8-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Espalda y Bíceps</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Peso muerto</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Jalón al pecho</strong> - 3 series de 10-12 repeticiones</li>" +
                    "<li><strong>Bíceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con mancuernas (alternando)</strong> - 3 series de 10-15 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Piernas y Abs</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Prensa de piernas</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de piernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de piernas</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de piernas</strong> - 3 series de 15-20 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Crunches en máquina</strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Hombros y Abs</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Hombros</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press militar con barra</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones laterales con mancuernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones frontales con mancuernas</strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Planchas</strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong>Oblicuos en máquina</strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Progresión</strong>: Asegúrate de aumentar gradualmente el peso para maximizar el crecimiento muscular.</li>" +
                    "<li><strong>Descanso</strong>: Entre series, descansa de 1 a 2 minutos para los ejercicios de aislamiento y hasta 2-3 minutos para los compuestos.</li>" +
                    "<li><strong>Nutrición</strong>: Es esencial mantener una dieta rica en proteínas y calorías adecuadas para soportar el crecimiento muscular.</li>" +
                    "<li><strong>Hidratación</strong>: Beber suficiente agua a lo largo del día, especialmente antes, durante y después de los entrenamientos, para mejorar el rendimiento y la recuperación.</li>" +
                    "</ul>";
    String detalleRutinaGanarMasa5Dias =
            "<h3>Día 1: Pecho</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Press inclinado con mancuernas</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Aperturas con mancuernas en banco plano</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Pullover con mancuerna</strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Espalda</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Peso muerto</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Jalón al pecho</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo a una mano con mancuerna</strong> - 3 series de 8-12 repeticiones por lado</li>" +
                    "</ol>" +
                    "<h3>Día 3: Piernas</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Prensa de piernas</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de piernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de piernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de talones (pantorrillas)</strong> - 4 series de 12-15 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Hombros y Trapecios</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press militar con barra</strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones laterales con mancuernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones frontales con mancuernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Encogimientos de hombros con mancuernas para trapecios</strong> - 4 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 5: Brazos (Bíceps y Tríceps)</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con barra</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps concentrado</strong> - 3 series de 10-12 repeticiones por brazo<br/>" +
                    "&nbsp;&nbsp;- <strong>Press francés</strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Extensiones de tríceps en polea alta</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Dips o fondos para tríceps</strong> - 3 series hasta fallo</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Progresión</strong>: Aumenta gradualmente las cargas para garantizar la progresión muscular.</li>" +
                    "<li><strong>Descanso</strong>: Descansa entre 1 a 2 minutos entre series y hasta 2-3 minutos entre ejercicios diferentes, especialmente en los días de ejercicios compuestos pesados.</li>" +
                    "<li><strong>Nutrición</strong>: Mantén una alimentación rica en proteínas y balanceada en macronutrientes para apoyar la recuperación y el crecimiento muscular.</li>" +
                    "<li><strong>Hidratación</strong>: Beber suficiente agua es crucial para el rendimiento durante el entrenamiento y la recuperación post-entrenamiento.</li>" +
                    "</ul>";

    String detalleRutinaPerdidaGrasa2Dias =
            "<h3>Día 1: Entrenamiento de Cuerpo Completo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio moderado (trotar, bicicleta estática)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 30 segundos, seguido de 30 segundos de descanso antes de pasar al siguiente.<br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas con peso corporal</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Flexiones de pecho</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con banda de resistencia</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Zancadas alternadas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Plancha</strong><br/>" +
                    "&nbsp;&nbsp;- Repite el circuito 3 veces.</li>" +
                    "<li><strong>Intervalos de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- Intervalos de sprint: Corre a máxima velocidad durante 30 segundos, seguido de 60 segundos de caminata o trote lento.<br/>" +
                    "&nbsp;&nbsp;- Realiza un total de 5-8 intervalos.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Entrenamiento de Cuerpo Completo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio moderado (trotar, bicicleta estática)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 30 segundos, seguido de 30 segundos de descanso antes de pasar al siguiente.<br/>" +
                    "&nbsp;&nbsp;- <strong>Burpees</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de hombros con mancuernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con mancuernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de piernas colgantes para abdomen</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Puentes de glúteo</strong><br/>" +
                    "&nbsp;&nbsp;- Repite el circuito 3 veces.</li>" +
                    "<li><strong>Intervalos de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- Intervalos en bicicleta estática: Pedalea tan rápido como puedas durante 30 segundos, seguido de 60 segundos pedaleando a un ritmo lento.<br/>" +
                    "&nbsp;&nbsp;- Realiza un total de 5-8 intervalos.</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Intensidad</strong>: Mantén una alta intensidad durante los intervalos para maximizar la quema de calorías.</li>" +
                    "<li><strong>Frecuencia</strong>: Intenta mantener poco tiempo de descanso entre ejercicios y circuitos para mantener elevada la frecuencia cardíaca.</li>" +
                    "<li><strong>Nutrición</strong>: Para la pérdida de grasa, es esencial que consumas menos calorías de las que quemas. Considera consultar a un nutricionista para obtener un plan adecuado.</li>" +
                    "<li><strong>Hidratación</strong>: Beber agua suficiente es crucial, especialmente al realizar entrenamientos de alta intensidad.</li>" +
                    "<li><strong>Recuperación</strong>: Asegúrate de dormir suficientes horas y de realizar estiramientos o actividades de baja intensidad los días de descanso para facilitar la recuperación.</li>" +
                    "</ul>";

    String detalleRutinaPerdidaGrasa3Dias =
            "<h3>Día 1: Entrenamiento de Cuerpo Completo (Fuerza + Cardio)</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trotar)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 45 segundos con 15 segundos de descanso entre ellos.<br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas con peso corporal</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Flexiones de pecho</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Remo en posición de plancha con mancuernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Zancadas con mancuernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Crunches bicicleta</strong><br/>" +
                    "&nbsp;&nbsp;- Repite el circuito 3 veces.</li>" +
                    "<li><strong>Cardio Intervalos de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- 1 minuto de alta intensidad (sprints, saltos, bicicleta rápida) seguido de 1 minuto de baja intensidad.<br/>" +
                    "&nbsp;&nbsp;- Realiza un total de 10 minutos.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Entrenamiento HIIT y Core</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de trote ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>HIIT (Entrenamiento Interválico de Alta Intensidad)</strong><br/>" +
                    "&nbsp;&nbsp;- Alternar ejercicios de alta intensidad (20 segundos) con períodos de descanso activo (10 segundos) durante 20 minutos.<br/>" +
                    "&nbsp;&nbsp;- Incluye ejercicios como burpees, saltos al cajón, sprints, y saltos de tijera.</li>" +
                    "<li><strong>Entrenamiento de Core</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Planchas</strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de piernas</strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Russian twists</strong> - 3 series de 15-20 repeticiones por lado</li>" +
                    "</ol>" +
                    "<h3>Día 3: Entrenamiento de Cuerpo Completo (Fuerza + Cardio)</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trotar)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 45 segundos con 15 segundos de descanso entre ellos.<br/>" +
                    "&nbsp;&nbsp;- <strong>Prensa de pecho con mancuernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Peso muerto con kettlebell</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Jalón al pecho en polea</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de hombros con mancuernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Planchas con movimientos de brazo</strong><br/>" +
                    "&nbsp;&nbsp;- Repite el circuito 3 veces.</li>" +
                    "<li><strong>Cardio Intervalos de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- 1 minuto de alta intensidad (correr, bicicleta rápida, saltos) seguido de 1 minuto de baja intensidad.<br/>" +
                    "&nbsp;&nbsp;- Realiza un total de 10 minutos.</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Intensidad</strong>: Mantén una alta intensidad en los intervalos de cardio para maximizar la quema de calorías.</li>" +
                    "<li><strong>Recuperación</strong>: Los descansos breves entre ejercicios ayudan a mantener elevada la frecuencia cardíaca, pero asegúrate de no sacrificar la forma.</li>" +
                    "<li><strong>Nutrición</strong>: Asegúrate de comer una dieta balanceada y controlar tu consumo calórico, ya que la nutrición es clave para la pérdida de grasa.</li>" +
                    "<li><strong>Hidratación</strong>: Mantente bien hidratado para soportar un rendimiento óptimo y recuperación.</li>" +
                    "<li><strong>Monitoreo</strong>: Utiliza un monitor de frecuencia cardíaca para asegurarte de que te mantienes en el rango de alta intensidad durante los intervalos de cardio.</li>" +
                    "</ul>";
    String detalleRutinaPerdidaGrasa4Dias =
            "<h3>Día 1: Piernas y Cardio</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Prensa de piernas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Zancadas con mancuernas</strong> - 3 series de 12 repeticiones por pierna<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de talones (pantorrillas)</strong> - 3 series de 15-20 repeticiones</li>" +
                    "<li><strong>Cardio de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- 10 minutos de intervalos en bicicleta estática: 30 segundos a máxima velocidad, 1 minuto a velocidad moderada.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Pecho y Espalda</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (saltar cuerda, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Pecho y Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Jalones al pecho en polea</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Pullover con mancuerna</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con barra</strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Hombros y Brazos</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Hombros y Brazos</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press militar con mancuernas</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones laterales con mancuernas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con barra</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Tríceps en polea alta</strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Cardio y Core</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de trote ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Cardio Intenso</strong><br/>" +
                    "&nbsp;&nbsp;- 20 minutos de HIIT: Alternar 20 segundos de esfuerzo máximo (sprints, burpees, saltos de tijera) con 40 segundos de descanso activo (caminar, trote ligero).</li>" +
                    "<li><strong>Entrenamiento de Core</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Planchas</strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong>Crunches</strong> - 3 series de 15-20 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Russian twists</strong> - 3 series de 20 repeticiones por lado</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Progresión y Variación</strong>: Cambia la intensidad y los ejercicios cada pocas semanas para continuar desafiando a tu cuerpo y evitar mesetas de adaptación.</li>" +
                    "<li><strong>Descanso</strong>: Mantén los descansos entre series cortos (30-60 segundos) para mantener elevada la frecuencia cardíaca.</li>" +
                    "<li><strong>Nutrición</strong>: Para optimizar la pérdida de grasa, es crucial mantener un déficit calórico. Considera obtener asesoramiento nutricional personalizado.</li>" +
                    "<li><strong>Hidratación</strong>: Bebe agua adecuadamente antes, durante y después de tus sesiones para mantener un rendimiento óptimo.</li>" +
                    "<li><strong>Monitoreo de Intensidad</strong>: Utiliza un monitor de frecuencia cardíaca para asegurarte de que estás trabajando en las zonas de intensidad adecuadas durante el cardio.</li>" +
                    "</ul>";
    String detalleRutinaPerdidaGrasa5Dias =
            "<h3>Día 1: Piernas y Cardio</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Sentadillas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Prensa de piernas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Zancadas con mancuernas</strong> - 3 series de 12 repeticiones por pierna<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones de talones (pantorrillas)</strong> - 3 series de 15-20 repeticiones</li>" +
                    "<li><strong>Cardio de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- 10 minutos de intervalos en bicicleta estática: 30 segundos a máxima velocidad, 1 minuto a velocidad moderada.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Pecho y Espalda</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (saltar cuerda, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Pecho y Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press de banca</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Jalones al pecho en polea</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Pullover con mancuerna</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Remo con barra</strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Hombros y Brazos</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Hombros y Brazos</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Press militar con mancuernas</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Elevaciones laterales con mancuernas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Curl de bíceps con barra</strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Tríceps en polea alta</strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Cardio y Core</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de trote ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Cardio Intenso</strong><br/>" +
                    "&nbsp;&nbsp;- 20 minutos de HIIT: Alternar 20 segundos de esfuerzo máximo (sprints, burpees, saltos de tijera) con 40 segundos de descanso activo (caminar, trote ligero).</li>" +
                    "<li><strong>Entrenamiento de Core</strong><br/>" +
                    "&nbsp;&nbsp;- <strong>Planchas</strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong>Crunches</strong> - 3 series de 15-20 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong>Russian twists</strong> - 3 series de 20 repeticiones por lado</li>" +
                    "</ol>" +
                    "<h3>Día 5: Entrenamiento de Circuito Total del Cuerpo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito Total del Cuerpo</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza un circuito que incluya ejercicios de piernas, pecho, espalda, hombros, brazos y core.<br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio sin descanso entre ellos.<br/>" +
                    "&nbsp;&nbsp;- Descansa 1-2 minutos al final de cada circuito.<br/>" +
                    "&nbsp;&nbsp;- Repite el circuito de 3 a 4 veces.</li>" +
                    "</ol>" +
                    "<h3>Consejos Generales</h3>" +
                    "<ul>" +
                    "<li><strong>Progresión y Variación</strong>: Cambia la intensidad y los ejercicios regularmente para evitar mesetas.</li>" +
                    "<li><strong>Descanso</strong>: Mantén los descansos cortos entre series para mantener elevada la frecuencia cardíaca.</li>" +
                    "<li><strong>Nutrición</strong>: Mantén un déficit calórico y considera consultar a un nutricionista.</li>" +
                    "<li><strong>Hidratación</strong>: Bebe suficiente agua antes, durante y después del ejercicio.</li>" +
                    "<li><strong>Monitoreo de Intensidad</strong>: Utiliza un monitor de frecuencia cardíaca para garantizar que estés trabajando en la zona de intensidad adecuada.</li>" +
                    "</ul>";


    private static final String TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS usuarios (" +
            "usuario TEXT PRIMARY KEY," +
            "contraseña TEXT NOT NULL," +
            "nombre TEXT NOT NULL," +
            "apellidos TEXT NOT NULL," +
            "correo TEXT NOT NULL," +
            "edad INTEGER NOT NULL," +
            "genero TEXT CHECK(genero IN ('Masculino','Femenino','Otro')) NOT NULL," +
            "nivel_actual TEXT CHECK(nivel_actual IN ('Sedentario','Moderadamente activo','Muy activo','Altamente activo','Atleta de alto rendimiento')) NOT NULL," +
            "objetivo TEXT CHECK(objetivo IN ('Ganar masa muscular','Pérdida de grasa','Mantenerse')) NOT NULL," +
            "frecuencia_entreno TEXT CHECK(frecuencia_entreno IN ('2 días a la semana','3 días a la semana','4 días a la semana','5 días a la semana')) NOT NULL" +
            //"parte_cuerpo_fav TEXT CHECK(parte_cuerpo_fav IN ('Pecho','Espalda','Piernas','Brazos','Hombros','Abdominales','Gluteos','Cuerpo Completo')) NOT NULL" +
            ")";
    private static final String TABLA_RUTINAS = "CREATE TABLE IF NOT EXISTS rutinas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "objetivo TEXT," +
            "frecuencia TEXT," +
            "detalle TEXT NOT NULL" +
            ")";


    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);

    }
    // Método para obtener la contraseña del usuario por su nombre de usuario

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
        db.execSQL(TABLA_RUTINAS);
        insertarRutinaInicial(db);
        Log.d("MiBaseDatos", "Tablas de Base de Datos creadas...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MiBaseDatos", "OnUpgrade");
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_RUTINAS);
        onCreate(db);
    }

    private void insertarRutina(SQLiteDatabase db, String objetivo, String frecuencia, String detalle) {
        ContentValues cv = new ContentValues();
        cv.put("objetivo", objetivo);
        cv.put("frecuencia", frecuencia);
        cv.put("detalle", detalle);
        db.insert("rutinas", null, cv);
    }

    private void insertarRutinaInicial(SQLiteDatabase db) {
        insertarRutina(db, "Ganar masa muscular", "2 días a la semana", detalleRutinaGanarMasa2Dias);
        insertarRutina(db, "Ganar masa muscular", "3 días a la semana", detalleRutinaGanarMasa3Dias);
        insertarRutina(db, "Ganar masa muscular", "4 días a la semana", detalleRutinaGanarMasa4Dias);
        insertarRutina(db, "Ganar masa muscular", "5 días a la semana", detalleRutinaGanarMasa5Dias);
        insertarRutina(db, "Pérdida de grasa", "2 días a la semana", detalleRutinaPerdidaGrasa2Dias);
        insertarRutina(db, "Pérdida de grasa", "3 días a la semana", detalleRutinaPerdidaGrasa3Dias);
        insertarRutina(db, "Pérdida de grasa", "4 días a la semana", detalleRutinaPerdidaGrasa4Dias);
        insertarRutina(db, "Pérdida de grasa", "5 días a la semana", detalleRutinaPerdidaGrasa5Dias);
    }

    // Método para insertar datos en la tabla de usuario
    public boolean insertarUsuario(Usuario usuario) {
        long salida = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        if (db != null) {
            // Verificar si el nombre de usuario ya existe en la base de datos
            Cursor cursor = db.rawQuery("SELECT usuario FROM usuarios WHERE usuario = ?", new String[]{usuario.getUsuario()});
            if (cursor.getCount() == 0) {
                // El nombre de usuario no existe, se puede insertar
                ContentValues values = new ContentValues();
                values.put("usuario", usuario.getUsuario());
                values.put("contraseña", usuario.getContraseña());
                values.put("nombre", usuario.getNombre());
                values.put("apellidos", usuario.getApellidos());
                values.put("correo", usuario.getCorreo());
                values.put("edad", usuario.getEdad());
                values.put("genero", usuario.getGenero());
                values.put("nivel_actual", usuario.getNivelActual());
                values.put("objetivo", usuario.getObjetivo());
                values.put("frecuencia_entreno", usuario.getFrecuenciaEntreno());
                //values.put("parte_cuerpo_fav", usuario.getParteCuerpoFav());
                salida = db.insert("usuarios", null, values);
            }else{
                Log.d("MiBaseDatos","El usuario escogido ya existe, escoja otro"); //Añadir quizas un Toast para avisar a Usuario registrandose
            }
            cursor.close();
        }
        db.close();
        return (salida > 0);
    }

    public boolean borrarUsuario(String usuario) {
        SQLiteDatabase db = getWritableDatabase();
        long salida = 0;
        if (db != null) {
            salida = db.delete("usuarios", "usuario=?", new String[]{usuario}); //Eliminamos al usuario enviado como parametro
        }
        db.close();
        return salida > 0;
    }
    public boolean validarCredenciales(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null; //Objeto Cursor proporciona acceso a los resultados de una consulta
        boolean salida = false;
        int count = -1;

            // Consulta para verificar las credenciales en la base de datos
            String query = "SELECT COUNT(*) FROM usuarios WHERE usuario = ? AND contraseña = ?"; //Consulta SQL
            cursor = db.rawQuery(query, new String[]{username, password});

            // Si el cursor tiene al menos una fila, las credenciales son válidas
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
                if (count >= 1) {
                    salida = true;
                }
            }

            // Cierra el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
            Log.d("MiBaseDatos","Valor de salida " + salida + "  Valor de count " + count);
        return salida;
    }

    @SuppressLint("Range")
    public Usuario getDetallesUsuario(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Usuario usuario = null;

        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE usuario = ?", new String[]{username});
        if (cursor.moveToFirst()) {
            usuario = new Usuario();
            usuario.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            usuario.setContraseña(cursor.getString(cursor.getColumnIndex("contraseña")));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            usuario.setApellidos(cursor.getString(cursor.getColumnIndex("apellidos")));
            usuario.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
            usuario.setEdad(cursor.getInt(cursor.getColumnIndex("edad")));
            usuario.setGenero(cursor.getString(cursor.getColumnIndex("genero")));
            usuario.setNivelActual(cursor.getString(cursor.getColumnIndex("nivel_actual")));
            usuario.setObjetivo(cursor.getString(cursor.getColumnIndex("objetivo")));
            usuario.setFrecuenciaEntreno(cursor.getString(cursor.getColumnIndex("frecuencia_entreno")));
        }
        cursor.close();
        db.close();

        return usuario;
    }
    public void guardarPreferenciasUsuario(Context context, String objetivo, String frecuencia) {
        SharedPreferences prefs = context.getSharedPreferences("prefs_usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("objetivo", objetivo);
        editor.putString("frecuencia", frecuencia);
        editor.apply();
    }

    public boolean verificaUsuarioRep(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        boolean usuarioRepetido = false;
        int count = -1;
            // Consulta para verificar si el usuario ya existe en la base de datos
            String query = "SELECT COUNT(*) FROM usuarios WHERE usuario = ?";
            cursor = db.rawQuery(query, new String[]{username});

            // Si el cursor tiene al menos una fila y el conteo es mayor que cero, significa que el usuario está repetido
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
                if (count > 0) {
                    usuarioRepetido = true;
                }
            }

            // Cierra el cursor y la base de datos
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        Log.d("MiBaseDatos","Valor de usuarioRepetido " + usuarioRepetido + "  Valor de count " + count);
        return usuarioRepetido;
    }
    @SuppressLint("Range")
    public String obtenerRutina(String objetivo, String frecuencia) {
        SQLiteDatabase db = this.getReadableDatabase();
        String rutina = "No se encontró una rutina para los criterios seleccionados.";

        // Consulta SQL para buscar la rutina basada en objetivo y frecuencia
        String[] columns = {"detalle"};
        String selection = "objetivo = ? AND frecuencia = ?";
        String[] selectionArgs = {objetivo, frecuencia};

        Cursor cursor = db.query("rutinas", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            rutina = cursor.getString(cursor.getColumnIndex("detalle"));
        }
        cursor.close();
        db.close();

        return rutina;
    }

}
