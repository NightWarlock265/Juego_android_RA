package mx.uacj.juego_ra.ui.organismos

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.serialization.Contextual
import java.lang.Math.abs

@Composable
fun DetectorAgitamiento(modificador: Modifier = Modifier){
    val contexto = LocalContext.current
    var contador_agitadas by remember { mutableStateOf(0) }

    DisposableEffect(Unit) {
        val gestor_sensor = contexto.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor_agitamiento = gestor_sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        val escucha = object: android.hardware.SensorEventListener {
            override fun onSensorChanged(evento: SensorEvent?) {
                if(evento != null){
                    val x = evento.values[0]
                    val y = evento.values[1]
                    val z = evento.values[2]

                    val sumatoria = abs(x) + abs(y) + abs(z) /// -4 -> 4    4 -> 4
                    if(sumatoria > 80){
                        Log.v("SENSOR_VELOCIDAD", "LA velocidad fue de ${sumatoria}")
                        contador_agitadas = contador_agitadas + 1
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) { }
        }

        gestor_sensor.registerListener(escucha, sensor_agitamiento, SensorManager.SENSOR_DELAY_NORMAL)

        onDispose {
            gestor_sensor.unregisterListener(escucha)
        }

    }

    Column {
        Text("Cantidad de agitadas ${contador_agitadas}")
    }
}