package controllers

import `mercadolibre eq3`.Producto
import `mercadolibre eq3`.cargar
import listadoCompleto
import menuInicio
import models.carrito
import java.util.ArrayList

/* Aqui tengo el Menu Carrito en el cual despligo 6 opciones que puede realizar el usuario
   en la cual puede regresar al Menu Princiapl, agregar articulos al carrito, ver el estado actual del carrito,
   o eliminar aticulos del carrito
 */
fun Menucarrito() {
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    println("*******************************************+")
    println("*             Menu del carrito             *")
    println("********************************************")
    println("*    1. Regresar al Menu principal         *")
    println("*    2. Agregar más articulos al Carrito   *")
    println("*    3. Ver Articulos en el Carrito        *")
    println("*    4. Eliminar articulos                 *")
    println("*    5. Ir a Comprar                       *")
    println("*    6. Salir de Programa                  *")
    println("********************************************")
    println("           Elija una opcion                 ")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> menuInicio()
        2 -> listadoCompleto(productos)
        3 -> impresionCarrito()
        4 -> elimarProducto()
        5 -> println(" Comprando  Articulos  ")
        6 -> {
            println("************************************************************************************")
            println("************* GRACIAS POR SU VISITA; REGRESA PRONTO A MERCADO LIBRE ****************")
            println("************************************************************************************")
        }

    }
}
/*  Aqui agregre estas variables globales para poderlas usar en todas mis siguientes funciones del Carrito
 */
var listacarrito : ArrayList<String> = arrayListOf<String>()
var nombre = carrito()
var Totalprecio : Float = 0.0f
var Numero: Int = 0
var subTotal: ArrayList<Float> = arrayListOf<Float>()

/* En esta funcion  se reciben los codigos que desea agregar en el carrito ya mostrados, así como la
   cantidad de articulos, despues se encarga de seleccionar el articulo y mandarlo al carrito
*/
fun menucarritoagregar() {
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
/*  Aqui muestra los articulos del carrito aun cuando se se tenga nada en el carrito
*/

fun impresionCarrito() {
    println("************************************************************************************")
    println("                   Productos agregados al Carrito:                                 *")
    println("************************************************************************************")
    println("*No.  Cantidad      Articulo                Precio    stok   Disponibles     Total *")
    lista()
    println("************************************************************************************")
    agregarCarrrito()
}

/*
   Aquí se despliega la lista guardada en el la clase carrito, ademas de agregar
    Cantidad de articulo agregados: $cont          Total a pagar $$Totalprecio
     */
fun lista() {
    var cont= listacarrito.count()

    listacarrito.forEach{
        println(it)
    }
    println("************************************************************************************")
    println("*  Cantidad de articulo agregados: $cont          Total a pagar $$Totalprecio       ")
}
/* Aqui despliega si se desea agregar otro ariculo al carrito, si la respuesta es no se regresa al menu
   del carrito

*/
fun agregarCarrrito() {
    println("*       Deseas agregar un articulo al carrito si o no s/n                          *")
    println("************************************************************************************")
    var x : String =  ""
    x = readLine()!!.toString()

    if(x == "s") {
        menucarritoagregar()
    }else{
        Menucarrito()
    }
}
/*  Esta función se encarga de eliminar del carrito el articulo segun sea el No. que el cliente desea
   eliminar

 */
fun elimarProducto() {
    println("************************************************************************************")
    println("*                  Productos agregados al Carrito:                                 *")
    println("************************************************************************************")
    println("*No.  Cantidad      Articulo                Precio    stok   Disponibles     Total *")
    lista()
    println("************************************************************************************")
    println("***************** Que No. de articulo desea eliminar *******************************")
    var opcion4 = readLine()?.toInt()
    var indicador: Int = opcion4!! -1
    listacarrito.removeAt(indicador)
    println("************************************************************************************")
    println("                   Articulo Eliminado del carrito                                   ")
    impresionCarrito()

}