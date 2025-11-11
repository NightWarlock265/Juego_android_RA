package mx.uacj.juego_ra.gestor_permisos

import android.Manifest
import androidx.collection.emptyObjectList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.util.fastFilter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.common.util.CollectionUtils.listOf
import java.util.Collections.emptyList

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ParaLaSolictudDePermisos(
        con_permisos_obtenidos: () -> Unit,
        sin_permisos_obtenidos: () -> Unit,
        con_permisos_revocados: () -> Unit
){
    val estado_de_los_permisos = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    ){ lista_permisos ->
        var tengo_todos_los_permisos: Boolean = false // Variable bandera o flag

        for (permiso in lista_permisos.values){
            if(!permiso){
                tengo_todos_los_permisos = false
                break
            }
            else {
                tengo_todos_los_permisos = true
            }
        }

        if(tengo_todos_los_permisos){
            con_permisos_obtenidos.invoke()
        }
        else {
            sin_permisos_obtenidos.invoke()
        }

    }

    LaunchedEffect(key1 = estado_de_los_permisos) {
        val tengo_los_permisos_revocados = estado_de_los_permisos.revokedPermissions.size == estado_de_los_permisos.permissions.size

        estado_de_los_permisos.permissions

        /*
        var lista_de_permisos_por_pedir: MutableList<PermissionState> = emptyList<PermissionState>()

        for(permiso in estado_de_los_permisos.permissions){
            if(!permiso.status.isGranted){
                lista_de_permisos_por_pedir.add(permiso)
            }
        }
        */

        val lista_de_permisos_por_pedir = estado_de_los_permisos.permissions.fastFilter { permiso ->
            !permiso.status.isGranted
        }

        if(!lista_de_permisos_por_pedir.isEmpty()){
            estado_de_los_permisos.launchMultiplePermissionRequest()
        }

        if(tengo_los_permisos_revocados){
            con_permisos_revocados()
        }
        else {
            if(estado_de_los_permisos.allPermissionsGranted){
                con_permisos_obtenidos()
            }
            else {
                sin_permisos_obtenidos()
            }
        }
    }
}