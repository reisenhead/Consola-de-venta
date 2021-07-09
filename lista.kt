package Carrrito
import Producto
import cargar

//V3

fun main() {

    println("   Bienvenid@ a Mercado Libre      ")


    Menucarrito1()

}

fun Menucarrito1() {
    println("*******************************************+")
    println("*             Menu del carrito             *")
    println("********************************************")
    println("*    1. Regresar al Menu de productos      *")
    println("*    2. Articulo en el Carrito             *")
    println("*    3. Eliminar articulos                 *")
    println("*    4. Ir a Comprar                       *")
    println("*    5. Salir de Programa                  *")
    println("********************************************")
    println("           Elija una opcion                 ")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> menucarrito()
        2 -> impresionCarrito()
        3 -> elimarProducto()
        4 -> println(" Comprando  Articulos  ")
        5 -> print("GRACIAS POR SU VISITA; REGRESA PRONTO A MERCADO LIBRE")

}
}
var listacarrito : ArrayList<String> = arrayListOf<String>()
var nombre = car()
var Totalprecio : Float = 0.0f
var Numero: Int = 0
fun menucarrito() {
    println("*************************************************")
    println("*  Desea agregar un Articulo ingrese codigo     *")
    println("*************************************************")

    val productos: MutableMap<Int, Producto> = mutableMapOf()
    cargar(productos)
    var opcion2 = readLine()!!.toInt()
    val opc2 : Int = opcion2
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

    println("*************************************************")
    println("*  Ingrese la cantidad de articulos             *")
    println("*************************************************")
    var opcion3 = readLine()!!.toInt()
    var opc3 = arrayListOf<Int>()
    opc3.add(opcion3)

    var Tot = opcion3*precio1
    Totalprecio = Totalprecio+Tot

    var espacios ="  "
    var espaciosl ="      "
    var signo = "$"
    var disponibles = stok - opcion3

    var num = 1
    Numero = Numero + num
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarNumero(numero = Numero)
    //nombre.agregarEsp(espacio= espacios)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarCantidad(cantidad = opcion3)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarNombre(nombre =names1)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarSigno(signo = signo)
    nombre.agregarPrecio(precio = precio1)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarStok(Stok= stok)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarDisponibles(disponible = disponibles)
    //nombre.agregarEsp(espacio= espacios)
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarSigno(signo = signo)
    nombre.agregarTotal(total=Tot)
    listacarrito.add(nombre.imprimirNombre())
    nombre.clear()

    impresionCarrito()
}
fun impresionCarrito() {
    println("****************  Productos agregados al Carrito:    *******************************")
    println("*                                                                                  *")
    println("*No.  Cantidad      Articulo                Precio    stok   Disponibles     Total *")
    lista()
    println("************************************************************************************")
    agregarCarrrito()
}

fun lista() {
    var cont= listacarrito.count()

    listacarrito.forEach{
        println(it)
    }
    println("************************************************************************************")
    println("*  Cantidad de articulo agregados: $cont          Total a pagar $$Totalprecio       ")

}

fun agregarCarrrito() {
    println("*       Deseas agregar un articulo al carrito si o no s/n                          *")
    println("************************************************************************************")
    var x : String =  ""
     x = readLine()!!.toString()

    if(x == "s") {
        menucarrito()
    }else{
        Menucarrito1()
        }
}

fun elimarProducto() {

    println("********** Que No. de articulo desea eliminar **************")

}