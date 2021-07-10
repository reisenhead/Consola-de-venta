package models
//Clase carrito v3
/* Aqui la clases carrito agrega los datos de compra al carrito en un cadena de texto en la cual se agrega
   primero la cantidad, despues el nombre del producto, precio,  disponbles y total de los articulos por el precio
   en cada uno se le agrega espacios para que el texto no quede amontonado.
   Tambien hay una funcion que se encarga de borrar la cadena de texto para el siguiente articulo a agregar
   al final retorna el nombre ya con la suma de los textos y espacios agregados
 */
class car{
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


