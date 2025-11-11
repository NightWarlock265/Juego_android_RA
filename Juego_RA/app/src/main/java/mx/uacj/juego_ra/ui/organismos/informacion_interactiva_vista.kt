package mx.uacj.juego_ra.ui.organismos

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import mx.uacj.juego_ra.modelos.InformacionInteractiva

@Composable
fun InformacionInteractivaVista(informacion_interactiva: InformacionInteractiva){
    Column {
        Text("${informacion_interactiva.texto}")

        for(boton in informacion_interactiva.lista_de_botones){
            Text("BOton para ir a ${boton.texto}")
        }
    }
}