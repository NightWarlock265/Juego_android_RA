package mx.uacj.juego_ra.ui.organismos

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import mx.uacj.juego_ra.modelos.Informacion

@Composable
fun InformacionVista(informacion_a_mostrar: Informacion){
    Column {
        Text(informacion_a_mostrar.texto)
    }
}