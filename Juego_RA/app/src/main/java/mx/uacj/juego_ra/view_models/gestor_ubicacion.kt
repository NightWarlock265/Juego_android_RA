package mx.uacj.juego_ra.view_models

import android.location.Location
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mx.uacj.juego_ra.repositorios.RepositorioUbicacion
import javax.inject.Inject

@HiltViewModel
class GestorUbicacion @Inject constructor(
    private val repositorio_ubicacion: RepositorioUbicacion
): ViewModel(){
    private val _ubicacion_actual: MutableState<Location> = mutableStateOf(Location("juego_ra"))
    val ubicacion_actual: State<Location> = _ubicacion_actual

    fun actualizar_ubicacion_actual(ubicacion_nueva: Location){
        _ubicacion_actual.value = ubicacion_nueva
    }
}