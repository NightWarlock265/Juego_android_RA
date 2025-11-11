package mx.uacj.juego_ra.ui.pantallas

import android.location.Location
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mx.uacj.juego_ra.modelos.Informacion
import mx.uacj.juego_ra.modelos.InformacionInteractiva
import mx.uacj.juego_ra.modelos.TiposDePistas
import mx.uacj.juego_ra.repositorios.estaticos.RepositorioPruebas
import mx.uacj.juego_ra.ui.organismos.InformacionInteractivaVista
import mx.uacj.juego_ra.ui.organismos.InformacionVista

@Composable
fun Principal(ubicacion: Location?, modificador: Modifier = Modifier){

    var mostrar_pantalla_generica by remember { mutableStateOf(true) }
    var mostrar_pista_cercana by remember { mutableStateOf(false) }

    Column(
        modificador
            .fillMaxSize()
            .background(Color.Black)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        for(pista in RepositorioPruebas.pistas){
            if(ubicacion == null) break

            val distancia_a_la_pista = ubicacion.distanceTo(pista.ubicacion)
            if(distancia_a_la_pista < pista.distancia_maxima){
                mostrar_pantalla_generica = false
                val nivel_de_distancia = (distancia_a_la_pista * 100) / (pista.distancia_maxima - pista.distancia_minima)

                Text("La pista es: ${pista.nombre}", color = Color.LightGray)
                Text("el nivel de la distancia a la pista es ${nivel_de_distancia}", color = Color.LightGray)

                if(nivel_de_distancia > 75){
                    Text("Estas frio todavia", color = Color.LightGray)
                } else if (nivel_de_distancia > 50){
                    Text("Te estas acercando", color = Color.LightGray)
                } else if(nivel_de_distancia > 25){
                    Text("Muy cercas, sigue asi", color = Color.LightGray)
                } else if(nivel_de_distancia < 20 && !mostrar_pista_cercana){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { mostrar_pista_cercana = true }
                            .padding(vertical = 4.dp)
                    ){
                        Text("Capturar pista cercana", color = Color.LightGray)
                    }
                }

                if(mostrar_pista_cercana) {
                    when (pista.cuerpo.tipo) {
                        TiposDePistas.texto -> InformacionVista(pista.cuerpo as Informacion)
                        TiposDePistas.interactiva -> InformacionInteractivaVista(pista.cuerpo as InformacionInteractiva)
                        TiposDePistas.camara -> TODO()
                        TiposDePistas.agitar_telefono -> TODO()
                    }
                }
            }
        }

        if(mostrar_pantalla_generica){
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("NO te encuentras cercas de alguna pista por el momento ", color = Color.LightGray)
                Text("Por favor sigue explorando  ", color = Color.LightGray)
            }
        }
    }
}
