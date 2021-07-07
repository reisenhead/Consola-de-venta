package Carrrito

class car{
    var nombreCompleto: String = ""

    fun agregarCantidad(cantidad: ArrayList<Int>) {
        nombreCompleto += cantidad
    }
    fun agregarEsp(espacio: String) {
        nombreCompleto += espacio
    }
    fun agregarNombre(nombre: String =" ") {
        nombreCompleto += nombre
    }
    fun agregarPrecio(precio: Float) {
        nombreCompleto += precio
    }
    fun agregarSigno(signo: String){
        nombreCompleto += signo
    }
    fun agregarStok(Stok: Int) {
        nombreCompleto += Stok
    }
    fun agregarTotal(total: Float) {
        nombreCompleto += total
    }
    fun imprimirNombre(){
        println(nombreCompleto)
    }

}
