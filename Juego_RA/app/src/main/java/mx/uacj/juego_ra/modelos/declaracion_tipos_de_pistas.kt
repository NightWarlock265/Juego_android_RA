package mx.uacj.juego_ra.modelos


public interface PistaGenerica{
    val tipo: TiposDePistas
    val texto: String?
}

data class Informacion( // Es la pista con solo texto y posiblemente una imagen
        override val tipo: TiposDePistas = TiposDePistas.texto,
        override val texto: String,
        val imagen: String? = null
) : PistaGenerica

data class Boton(
    val texto: String,
    val direccion: PistaGenerica?
)

data class InformacionInteractiva(
    override val tipo: TiposDePistas = TiposDePistas.interactiva,
    override val texto: String?,
    val lista_de_botones: List<Boton>
) : PistaGenerica
