package mx.uacj.juego_ra.repositorios

import androidx.compose.runtime.MutableState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import android.location.Location
import androidx.compose.runtime.mutableStateOf

@Module
@InstallIn(SingletonComponent::class)
object repositorio_ubicacion_singleton{
    @Provides
    @Singleton
    fun crea_repostiorio_gestor_de_ubicacion(): RepositorioUbicacion{
        return InstanciaRepositorioUbicacion()
    }
}


class InstanciaRepositorioUbicacion(
    override val ubicacion: MutableState<Location> = mutableStateOf(Location("juego_ra"))
): RepositorioUbicacion {}

interface RepositorioUbicacion {
    val ubicacion: MutableState<Location>
}
