package mx.uacj.juego_ra.modelos

import android.location.Location

data class Pista(
    var nombre: String,
    var ubicacion: Location,
    var distancia_minima: Float = 15F,
    var distancia_maxima: Float = 150F,
    var cuerpo: PistaGenerica
)
