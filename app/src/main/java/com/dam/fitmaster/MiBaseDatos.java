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
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdebanca'>Press de banca</a></strong> - 4 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoconbarra'>Remo con barra</a></strong> - 3 series de 8-12 repeticiones</li>" +
                    "<li><strong>Ejercicios de Aislamiento</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldebicepsconbarra'>Curl de bíceps con barra</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdetricepsenpoleaalta'>Extensiones de tríceps en polea alta</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Trabajo de Hombros y Pecho</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressmilitarconbarra'>Press militar con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacioneslateralesconmancuernas'>Elevaciones laterales con mancuernas</a></strong> - 3 series de 12-15 repeticiones</li>" +
                    "<li><strong>Core y Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://plancha'>Plancha</a></strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://crunches'>Crunches</a></strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Enfoque en Parte Inferior del Cuerpo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática o cinta)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios Compuestos</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillas'>Sentadillas</a></strong> - 4 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pesomuerto'>Peso muerto</a></strong> - 3 series de 8-12 repeticiones</li>" +
                    "<li><strong>Ejercicios de Aislamiento</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldepiernas'>Curl de piernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdepiernas'>Extensiones de piernas</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Trabajo de Glúteos y Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://puentesdegluteo'>Puentes de glúteo</a></strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://estocadas'>Estocadas</a></strong> - 3 series de 12-15 repeticiones por pierna</li>" +
                    "<li><strong>Core y Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://levantamientosdepiernascolgantes'>Levantamientos de piernas colgantes</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://bicicletaabdominal'>Bicicleta abdominal</a></strong> - 3 series de 15-20 repeticiones</li>" +
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
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdebanca'>Press de banca</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdebancainclinadoconmancuernas'>Press de banca inclinado con mancuernas</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://crucesdecables'>Cruces de cables</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Tríceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://fondosenparalelas'>Fondos en paralelas</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressfrances'>Press francés</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdetricepsenpoleaalta'>Extensiones de tríceps en polea alta</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesdepiernas'>Elevaciones de piernas</a></strong> - 3 series de 12-15 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Espalda y Bíceps</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio suave<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pesomuerto'>Peso muerto</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoconbarra'>Remo con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://jalonesalpecho'>Jalones al pecho</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "<li><strong>Bíceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curlconbarra'>Curl con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curlconmancuernasalternado'>Curl con mancuernas alternado</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://crunches'>Crunches</a></strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Piernas y Hombros</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio suave<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillas'>Sentadillas</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://prensadepiernas'>Prensa de piernas</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldepiernas'>Curl de piernas</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Hombros</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressmilitar'>Press militar</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacioneslateralesconmancuernas'>Elevaciones laterales con mancuernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesfrontalesconmancuernas'>Elevaciones frontales con mancuernas</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://plancha'>Plancha</a></strong> - 3 series de 30-60 segundos</li>" +
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
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdebanca'>Press de banca</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressinclinadoconmancuernas'>Press inclinado con mancuernas</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://aperturasconmancuernas'>Aperturas con mancuernas</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Tríceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://dipsofondosenparalelas'>Dips o fondos en paralelas</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdetricepsenpoleaalta'>Extensiones de tríceps en polea alta</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressfrancesconmancuernas'>Press francés con mancuernas</a></strong> - 3 series de 8-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Espalda y Bíceps</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pesomuerto'>Peso muerto</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoconbarra'>Remo con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://jalonalpecho'>Jalón al pecho</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "<li><strong>Bíceps</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldebicepsconbarra'>Curl de bíceps con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curlconmancuernasalternado'>Curl de bíceps con mancuernas (alternando)</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Piernas y Abs</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillas'>Sentadillas</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://prensadepiernas'>Prensa de piernas</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldepiernas'>Curl de piernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdepiernas'>Extensiones de piernas</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesdepiernas'>Elevaciones de piernas</a></strong> - 3 series de 15-20 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://crunchesenmaquina'>Crunches en máquina</a></strong> - 3 series de 15-20 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Hombros y Abs</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Hombros</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressmilitarconbarra'>Press militar con barra</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacioneslateralesconmancuernas'>Elevaciones laterales con mancuernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesfrontalesconmancuernas'>Elevaciones frontales con mancuernas</a></strong> - 3 series de 10-15 repeticiones</li>" +
                    "<li><strong>Abs</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://planchas'>Planchas</a></strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://oblicuosenmaquina'>Oblicuos en máquina</a></strong> - 3 series de 15-20 repeticiones</li>" +
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
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdebanca'>Press de banca</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressinclinadoconmancuernas'>Press inclinado con mancuernas</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://aperturasconmancuernasenbancoPlano'>Aperturas con mancuernas en banco plano</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pulloverconmancuerna'>Pullover con mancuerna</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 2: Espalda</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pesomuerto'>Peso muerto</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoconbarra'>Remo con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://jalonalpecho'>Jalón al pecho</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoaunamanoconmancuerna'>Remo a una mano con mancuerna</a></strong> - 3 series de 8-12 repeticiones por lado</li>" +
                    "</ol>" +
                    "<h3>Día 3: Piernas</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillas'>Sentadillas</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://prensadepiernas'>Prensa de piernas</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldepiernas'>Curl de piernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdepiernas'>Extensiones de piernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesdetalonespantorrillas'>Elevaciones de talones (pantorrillas)</a></strong> - 4 series de 12-15 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Hombros y Trapecios</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressmilitarconbarra'>Press militar con barra</a></strong> - 4 series de 6-10 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacioneslateralesconmancuernas'>Elevaciones laterales con mancuernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesfrontalesconmancuernas'>Elevaciones frontales con mancuernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://encogimientosdehombrosconmancuernasparatrapecios'>Encogimientos de hombros con mancuernas para trapecios</a></strong> - 4 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 5: Brazos (Bíceps y Tríceps)</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Ejercicios</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldebicepsconbarra'>Curl de bíceps con barra</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldebicepsconcentrado'>Curl de bíceps concentrado</a></strong> - 3 series de 10-12 repeticiones por brazo<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressfrances'>Press francés</a></strong> - 3 series de 8-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://extensionesdetricepsenpoleaalta'>Extensiones de tríceps en polea alta</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://dipsofondosparatriceps'>Dips o fondos para tríceps</a></strong> - 3 series hasta fallo</li>" +
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
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillasconpesocorporal'>Sentadillas con peso corporal</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://flexionesdepecho'>Flexiones de pecho</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoconbandaderesistencia'>Remo con banda de resistencia</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://zancadasalternadas'>Zancadas alternadas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://plancha'>Plancha</a></strong><br/>" +
                    "&nbsp;&nbsp;- Repite el circuito 3 veces.</li>" +
                    "<li><strong>Intervalos de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- Intervalos de sprint: Corre a máxima velocidad durante 30 segundos, seguido de 60 segundos de caminata o trote lento.<br/>" +
                    "&nbsp;&nbsp;- Realiza un total de 5-8 intervalos.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Entrenamiento de Cuerpo Completo</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio moderado (trotar, bicicleta estática)</a><br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 30 segundos, seguido de 30 segundos de descanso antes de pasar al siguiente.<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://burpees'>Burpees</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdehombrosconmancuernas'>Press de hombros con mancuernas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldebicepsconmancuernas'>Curl de bíceps con mancuernas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesdepiernascolgantesparaabdomen'>Elevaciones de piernas colgantes para abdomen</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://puentesdegluteo'>Puentes de glúteo</a></strong><br/>" +
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
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trotar)</a><br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 45 segundos con 15 segundos de descanso entre ellos.<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillasconpesocorporal'>Sentadillas con peso corporal</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://flexionesdepecho'>Flexiones de pecho</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoenposiciondeplancha'>Remo en posición de plancha con mancuernas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://zancadasconmancuernas'>Zancadas con mancuernas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://crunchesbicicleta'>Crunches bicicleta</a></strong><br/>" +
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
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://planchas'>Planchas</a></strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesdepiernas'>Elevaciones de piernas</a></strong> - 3 series de 10-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://russiantwists'>Russian twists</a></strong> - 3 series de 15-20 repeticiones por lado</li>" +
                    "</ol>" +
                    "<h3>Día 3: Entrenamiento de Cuerpo Completo (Fuerza + Cardio)</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trotar)</a><br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Circuito de Fuerza</strong><br/>" +
                    "&nbsp;&nbsp;- Realiza cada ejercicio durante 45 segundos con 15 segundos de descanso entre ellos.<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://prensadepechoconmancuernas'>Prensa de pecho con mancuernas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pesomuertoconkettlebell'>Peso muerto con kettlebell</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://jalonalpechoenpolea'>Jalón al pecho en polea</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdehombrosconmancuernas'>Press de hombros con mancuernas</a></strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://planchasconmovimientosdebrazo'>Planchas con movimientos de brazo</a></strong><br/>" +
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
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)</a><br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Piernas</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://sentadillas'>Sentadillas</a></strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://prensadepiernas'>Prensa de piernas</a></strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://zancadasconmancuernas'>Zancadas con mancuernas</a></strong> - 3 series de 12 repeticiones por pierna<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacionesdetalones'>Elevaciones de talones (pantorrillas)</a></strong> - 3 series de 15-20 repeticiones</li>" +
                    "<li><strong>Cardio de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- 10 minutos de intervalos en bicicleta estática: 30 segundos a máxima velocidad, 1 minuto a velocidad moderada.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Pecho y Espalda</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (saltar cuerda, trote suave)</a><br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Pecho y Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressdebanca'>Press de banca</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://jalonesalpechoenpolea'>Jalones al pecho en polea</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pulloverconmancuerna'>Pullover con mancuerna</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://remoconbarra'>Remo con barra</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Hombros y Brazos</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)</a><br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Hombros y Brazos</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://pressmilitarconmancuernas'>Press militar con mancuernas</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://elevacioneslateralesconmancuernas'>Elevaciones laterales con mancuernas</a></strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://curldebicepsconbarra'>Curl de bíceps con barra</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://tricepsenpoleaalta'>Tríceps en polea alta</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Cardio y Core</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de trote ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Cardio Intenso</strong><br/>" +
                    "&nbsp;&nbsp;- 20 minutos de HIIT: Alternar 20 segundos de esfuerzo máximo (sprints, burpees, saltos de tijera) con 40 segundos de descanso activo (caminar, trote ligero).</li>" +
                    "<li><strong>Entrenamiento de Core</strong><br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://planchas'>Planchas</a></strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://crunches'>Crunches</a></strong> - 3 series de 15-20 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <strong><a href='fitmaster://russiantwists'>Russian twists</a></strong> - 3 series de 20 repeticiones por lado</li>" +
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
                    "&nbsp;&nbsp;- <a href='fitmaster://sentadillas'><strong>Sentadillas</a></strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://prensadepiernas'><strong>Prensa de piernas</strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://zancadasconmancuernas'><strong>Zancadas con mancuernas</a></strong> - 3 series de 12 repeticiones por pierna<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://elevacionesdetalones'><strong>Elevaciones de talones (pantorrillas)</a></strong> - 3 series de 15-20 repeticiones</li>" +
                    "<li><strong>Cardio de Alta Intensidad</strong><br/>" +
                    "&nbsp;&nbsp;- 10 minutos de intervalos en bicicleta estática: 30 segundos a máxima velocidad, 1 minuto a velocidad moderada.</li>" +
                    "</ol>" +
                    "<h3>Día 2: Pecho y Espalda</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (saltar cuerda, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Pecho y Espalda</strong><br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://pressdebanca'><strong>Press de banca</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://jalonesalpechoenpolea'><strong>Jalones al pecho en polea</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://pulloverconmancuerna'><strong>Pullover con mancuerna</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://remoconbarra'><strong>Remo con barra</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 3: Hombros y Brazos</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de cardio ligero (bicicleta estática, trote suave)<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Entrenamiento de Hombros y Brazos</strong><br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://pressmilitarconmancuernas'><strong>Press militar con mancuernas</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://elevacioneslateralesconmancuernas'><strong>Elevaciones laterales con mancuernas</a></strong> - 3 series de 12-15 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://curldebicepsconbarra'><strong>Curl de bíceps con barra</a></strong> - 3 series de 10-12 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://tricepsenpoleaalta'><strong>Tríceps en polea alta</a></strong> - 3 series de 10-12 repeticiones</li>" +
                    "</ol>" +
                    "<h3>Día 4: Cardio y Core</h3>" +
                    "<ol>" +
                    "<li><strong>Calentamiento</strong><br/>" +
                    "&nbsp;&nbsp;- 5-10 minutos de trote ligero<br/>" +
                    "&nbsp;&nbsp;- Estiramientos dinámicos</li>" +
                    "<li><strong>Cardio Intenso</strong><br/>" +
                    "&nbsp;&nbsp;- 20 minutos de HIIT: Alternar 20 segundos de esfuerzo máximo (sprints, burpees, saltos de tijera) con 40 segundos de descanso activo (caminar, trote ligero).</li>" +
                    "<li><strong>Entrenamiento de Core</strong><br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://planchas'><strong>Planchas</a></strong> - 3 series de 30-60 segundos<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://crunches'><strong>Crunches</a></strong> - 3 series de 15-20 repeticiones<br/>" +
                    "&nbsp;&nbsp;- <a href='fitmaster://russiantwists'><strong>Russian twists</a></strong> - 3 series de 20 repeticiones por lado</li>" +
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

    private static final String TABLA_ENTRENOS = "CREATE TABLE IF NOT EXISTS entrenos (" +
            "usuario TEXT PRIMARY KEY," + // Columna usuario como clave primaria
            "frecuencia_semanal INTEGER CHECK(frecuencia_semanal BETWEEN 2 AND 5)," + // Columna para la frecuencia semanal con restricción CHECK
            "numero_semana INTEGER DEFAULT 0," + // Columna para el número de semanas entrenadas
            "dias_entrenados INTEGER DEFAULT 0" + // Columna para el número de días entrenados con valor predeterminado
            ")";


    private static final String TABLA_VIDEOS = "CREATE TABLE IF NOT EXISTS videos (" +
            "nombre_ejercicio TEXT PRIMARY KEY," + // Clave primaria: nombre del ejercicio
            "video_id TEXT" + // ID del video asociado al ejercicio
            ")";

    private Context mContext;
    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
        mContext = context;
    }
    // Método para obtener la contraseña del usuario por su nombre de usuario

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
        db.execSQL(TABLA_RUTINAS);
        db.execSQL(TABLA_ENTRENOS);
        db.execSQL(TABLA_VIDEOS);
        insertarRutinaInicial(db);
        insertarVideoInicial(mContext,db);
        Log.d("MiBaseDatos", "Tablas de Base de Datos creadas...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MiBaseDatos", "OnUpgrade");
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_RUTINAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ENTRENOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_VIDEOS);
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
    public void insertarEntreno( String usuario, int frecuenciaSemanal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("frecuencia_semanal", frecuenciaSemanal);
        cv.put("numero_semana",1);
        cv.put("dias_entrenados",1);
        db.insert("entrenos", null, cv);
    }

    public boolean incrementarDiaEntrenado(String usuario, int frecuencia) {
        //La funcion devolvera true cuando una semana haya sido incrementada
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        // WHERE clause para especificar el usuario
        String user = "usuario = ?";
        String[] arg = {usuario};
        int dias = obtenerDiasEntrenados(usuario);
        if(dias == frecuencia) {
            // Actualizar la fila correspondiente al usuario
            valores.put("dias_entrenados", 1);
            int numero_semana = obtenerNumeroSemanas(usuario);
            valores.put("numero_semana", numero_semana + 1);
            db.update("entrenos",valores, user,arg);
            return true;
        }else{
            valores.put("dias_entrenados", dias + 1);
            db.update("entrenos", valores, user, arg);

        }
        return false;
    }

    @SuppressLint("Range")
    public int obtenerDiasEntrenados( String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Columnas que queremos recuperar
        String[] columnas = {"dias_entrenados"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "usuario = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {usuario};

        // Realizar la consulta
        Cursor cursor = db.query("entrenos", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar el valor de días entrenados
        int diasEntrenados = 0;

        // Verificar si se encontraron resultados y obtener el valor de días entrenados
        if (cursor.moveToFirst()) {
            diasEntrenados = cursor.getInt(cursor.getColumnIndex("dias_entrenados"));
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver el valor de días entrenados
        return diasEntrenados;
    }
    @SuppressLint("Range")
    public int obtenerNumeroSemanas( String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Columnas que queremos recuperar
        String[] columnas = {"numero_semana"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "usuario = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {usuario};

        // Realizar la consulta
        Cursor cursor = db.query("entrenos", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar el valor de días entrenados
        int numero_semana = 0;

        // Verificar si se encontraron resultados y obtener el valor de días entrenados
        if (cursor.moveToFirst()) {
            numero_semana = cursor.getInt(cursor.getColumnIndex("numero_semana"));
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver el valor de días entrenados
        return numero_semana;
    }
    @SuppressLint("Range")
    private String obtenerFrecuenciaEntreno(String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Columnas que queremos recuperar
        String[] columnas = {"frecuencia_entreno"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "usuario = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {usuario};

        // Realizar la consulta
        Cursor cursor = db.query("usuarios", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar la frecuencia de entrenamiento
        String frecuenciaEntreno = "";

        // Verificar si se encontraron resultados y obtener la frecuencia de entrenamiento
        if (cursor.moveToFirst()) {
            frecuenciaEntreno = cursor.getString(cursor.getColumnIndex("frecuencia_entreno"));
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver la frecuencia de entrenamiento
        return frecuenciaEntreno;
    }

    private void insertarVideoInicial(Context context,SQLiteDatabase db) {
        FileReader reader = new FileReader();
        reader.insertVideosFromTextFile(context , db);
    }
    @SuppressLint("Range")
    public String obtenerVideoId( String nombre_ejercicio) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Columnas que queremos recuperar
        String[] columnas = {"video_id"};

        // Cláusula WHERE para especificar el usuario
        String whereClause = "nombre_ejercicio = ?";

        // Argumentos para reemplazar el placeholder en la cláusula WHERE
        String[] whereArgs = {nombre_ejercicio};

        // Realizar la consulta
        Cursor cursor = db.query("videos", columnas, whereClause, whereArgs, null, null, null);

        // Inicializar el valor de días entrenados
        String video_id = "";

        // Verificar si se encontraron resultados y obtener el valor de días entrenados
        if (cursor.moveToFirst()) {
            video_id = cursor.getString(cursor.getColumnIndex("video_id"));
        }

        // Cerrar el cursor
        cursor.close();
        Log.d("MiBaseDatos","Video ID " + video_id);
        // Devolver el valor de días entrenados
        return video_id;
    }
}
