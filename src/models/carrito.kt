package models
//Clase carrito v3

class carrito{
    var nombreCompleto: String = ""

    fun clear() {
        var nombrecom = nombreCompleto.replace("${nombreCompleto}","")
        nombreCompleto =  nombrecom
    }
    fun agregarDisponibles(disponible: Int) {
        nombreCompleto += disponible
    }
    fun agregarNumero(numero: Int) {
        nombreCompleto += numero
    }
    fun agregarCantidad(cantidad: Int) {
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
    fun imprimirNombre(): String {
        return nombreCompleto
    }

}


