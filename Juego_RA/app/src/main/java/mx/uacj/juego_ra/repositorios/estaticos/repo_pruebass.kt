package mx.uacj.juego_ra.repositorios.estaticos

import android.location.Location
import androidx.collection.objectListOf
import mx.uacj.juego_ra.modelos.Boton
import mx.uacj.juego_ra.modelos.Informacion
import mx.uacj.juego_ra.modelos.InformacionInteractiva
import mx.uacj.juego_ra.modelos.Pista

object RepositorioPruebas{
    var pistas = listOf(Pista(
            nombre = "pista_1",
            ubicacion = Location("proveedor").apply {
                latitude = 31.7156044
                longitude = -106.4246012
            },
            cuerpo = Informacion(
                texto = "Prueba de texto para comprobar esto pista 1",
                imagen = null
            )
        ),
        Pista(
            nombre = "pista_2",
            ubicacion = Location("proveedor").apply {
                latitude = 31.742051557303974
                longitude = -106.43239449750396
            },
            cuerpo = Informacion(
                texto = "Prueba de texto para comprobar esto pista 2",
                imagen = null
            )
        ),
        Pista(
            nombre = "pista_3",
            ubicacion = Location("proveedor").apply {
                latitude = 31.743284485783107
                longitude = -106.43353257877321
            },
            cuerpo = Informacion(
                texto = "Prueba de texto para comprobar esto pista 3",
                imagen = null
            )
        ),

        Pista(
            nombre = "pista_4",
            ubicacion = Location("proveedor"),
            distancia_maxima = 15.0f,
            cuerpo = InformacionInteractiva(
                texto = "Esto es una prueba de pista tipo interactiva",
                lista_de_botones = listOf(
                    Boton(
                            texto = "Ir a pantalla 1",
                            direccion = null
                        ),
                    Boton(
                        texto = "Ir a pantalla dos",
                        direccion = null
                    )
                )
            )
        ),

    )
}