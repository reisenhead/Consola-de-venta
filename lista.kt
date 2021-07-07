package Carrrito
import Producto
import cargar


fun main() {

    println("   Bienvenid@ a Mercado Libre      ")


    // Funcion Carrito
//    var i: String = "s"
//    do {

    menucarrito()

}

fun menucarrito() {
    println("*************************************************")
    println("*  Desea agregar un Articulo ingrese codigo     *")
    println("*************************************************")

    val productos: MutableMap<Int, Producto> = mutableMapOf()
    cargar(productos)
    val opcion2 = readLine()!!.toInt()
    val opc2 : Int = opcion2
    //val add = opc2.add(opcion2!!.toInt())
    //var total: Float = 0f
    var names1 = ""
    var precio1 = 0f
    var stok = 0
    if((opc2 in 10..29)) {
        when (opc2){
            10 -> {
                names1 = productos[10]!!.nombre
                precio1 = productos[10]!!.precio
                stok = productos[10]!!.cantidad
            }
            11 ->{
                names1 = productos[11]!!.nombre
                precio1 = productos[11]!!.precio
                stok = productos[11]!!.cantidad
            }
            12->{
                names1 = productos[12]!!.nombre
                precio1 = productos[12]!!.precio
                stok = productos[12]!!.cantidad
            }
            13->{
                names1 = productos[13]!!.nombre
                precio1 = productos[13]!!.precio
                stok = productos[13]!!.cantidad
            }
            14->{
                names1 = productos[14]!!.nombre
                precio1 = productos[14]!!.precio
                stok = productos[14]!!.cantidad
            }
            15->{
                names1 = productos[15]!!.nombre
                precio1 = productos[15]!!.precio
                stok = productos[15]!!.cantidad
            }
            16->{
                names1 = productos[16]!!.nombre
                precio1 = productos[16]!!.precio
                stok = productos[16]!!.cantidad
            }
            17->{
                names1 = productos[17]!!.nombre
                precio1 = productos[17]!!.precio
                stok = productos[17]!!.cantidad
            }
            18->{
                names1 = productos[18]!!.nombre
                precio1 = productos[18]!!.precio
                stok = productos[18]!!.cantidad
            }
            19->{
                names1 = productos[19]!!.nombre
                precio1 = productos[19]!!.precio
                stok = productos[19]!!.cantidad
            }
            20->{
                names1 = productos[20]!!.nombre
                precio1 = productos[20]!!.precio
                stok = productos[20]!!.cantidad
            }
            21->{
                names1 = productos[21]!!.nombre
                precio1 = productos[21]!!.precio
                stok = productos[21]!!.cantidad
            }
            22->{
                names1 = productos[22]!!.nombre
                precio1 = productos[22]!!.precio
                stok = productos[22]!!.cantidad
            }
            23->{
                names1 = productos[23]!!.nombre
                precio1 = productos[23]!!.precio
                stok = productos[23]!!.cantidad
            }
            24->{
                names1 = productos[24]!!.nombre
                precio1 = productos[23]!!.precio
                stok = productos[24]!!.cantidad
            }
            25->{
                names1 = productos[25]!!.nombre
                precio1 = productos[25]!!.precio
                stok = productos[25]!!.cantidad
            }
            26->{
                names1 = productos[26]!!.nombre
                precio1 = productos[26]!!.precio
                stok = productos[26]!!.cantidad
            }
            27->{
                names1 = productos[27]!!.nombre
                precio1 = productos[27]!!.precio
                stok = productos[27]!!.cantidad
            }
            28->{
                names1 = productos[28]!!.nombre
                precio1 = productos[28]!!.precio
                stok = productos[28]!!.cantidad
            }
            29->{
                names1 = productos[29]!!.nombre
                precio1 = productos[29]!!.precio
                stok = productos[29]!!.cantidad
            }
        }
    }
    else  {
        names1 = "articulo no encontrado"
    }
    val namess = arrayListOf<kotlin.String>()
    namess.add(names1)
    println("*************************************************")
    println("*  Ingrese la cantidad de articulos             *")
    println("*************************************************")
    val opcion3 = readLine()!!.toInt()
    val opc3 = arrayListOf<Int>()
    opc3.add(opcion3)

    val Tot = opcion3*precio1
    val nombre = car()
    val espacios ="  "
    val espaciosl ="      "
    val signo = "$"
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarCantidad(cantidad = opc3)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarNombre(nombre =names1)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarSigno(signo = signo)
    nombre.agregarPrecio(precio = precio1)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarStok(Stok= stok)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarSigno(signo = signo)
    nombre.agregarTotal(total=Tot)

    println("*********************  Productos del carrito:    ********************************")
    println("*                                                                               *")
    println("*  Cantidad      Articulo                 Precio     Disponibles      Total     *")
    println(nombre.imprimirNombre())
    println("*********************************************************************************")
    agregarCarrrito()
}
fun menulinea() {
    println("*********************************************************************************")
}
fun agregarCarrrito() {
    println("*     Deseas agregar un articulo al carrito si o no s/n                         *")
    println("*********************************************************************************")
    var x : String =  ""
     x = readLine()!!.toString()

    if(x == "s") {
        menucarrito()
    }else{
     println("Regrese pronto")
    }

}