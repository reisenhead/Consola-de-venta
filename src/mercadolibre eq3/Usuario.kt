package `mercadolibre eq3`

data class Usuario(val user:String="",val password:String="")

fun cargarUsuarios(usuarios: MutableMap<Int,Usuario>){
    usuarios[1] = Usuario("Bedu","toor")

}