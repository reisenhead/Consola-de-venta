package controllers

import `mercadolibre eq3`.Producto
import `mercadolibre eq3`.cargar
import listadoCompleto
import menuInicio
import models.Carrito
import java.util.ArrayList

/* Aqui tengo el Menu Carrito en el cual despligo 6 opciones que puede realizar el usuario
   en la cual puede regresar al Menu Princiapl, agregar articulos al carrito, ver el estado actual del carrito,
   o eliminar aticulos del carrito
 */
fun menuCarrito() {
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    println("*******************************************+")
    println("*             Menu del carrito             *")
    println("********************************************")
    println("*    1. Regresar al Menu principal         *")
    println("*    2. Agregar articulos al Carrito       *")
    println("*    3. Ver Articulo en el Carrito         *")
    println("*    4. Eliminar articulos del Carrito     *")
    println("*    5. Ir a Comprar                       *")
    println("*    6. Salir de Programa                  *")
    println("********************************************")
    println("           Elija una opcion                 ")
    println("********************************************")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> menuInicio()
        2 -> listadoCompleto(productos)
        3 -> impresionCarrito()
        4 -> elimarProducto()
        5 -> println(" Comprando  Articulos  ")
        6 -> print("GRACIAS POR SU VISITA; REGRESA PRONTO A MERCADO LIBRE")

    }
}
/*  Aqui agregre estas variables globales para poderlas usar en todas mis siguientes funciones del Carrito
 */
var listacarrito : ArrayList<String> = arrayListOf<String>()
var nombre = Carrito()
var Totalprecio : Float = 0.0f
var Numero: Int = 0
var restaPrecio = 0.0f
var opc3: ArrayList<Float> = arrayListOf<Float>()

/* Aqui se agregan los articulos y su cantidad al carrito
*/
fun menucarritoagregar() {
    println("*************************************************")
    println("*  Desea agregar un Articulo ingrese codigo     *")
    println("*************************************************")

    val productos: MutableMap<Int, Producto> = mutableMapOf()
    cargar(productos)
    val opcion2 = readLine()!!.toInt()
    val opc2 : Int = opcion2
    var names1 = ""
    var precio1 = 0.0f
    var stok = 0
    val Entrada = 1
    if((opc2 in 10..73)) {
        when (Entrada){
            1 -> {
                names1 = productos[opc2]!!.nombre
                precio1 = productos[opc2]!!.precio
                stok = productos[opc2]!!.cantidad
            }
        }
    }
    else  {
        names1 = "articulo no encontrado"
    }
    println("*************************************************")
    println("*  Ingrese la cantidad de articulos             *")
    println("*************************************************")
    val opcion3 = readLine()!!.toInt()

    opc3.add(precio1)

    val totalArticulo = opcion3*precio1
    Totalprecio += totalArticulo
    val espacios ="  "
    val espaciosl ="      "
    val signo = "$"
    val disponibles = stok - opcion3
    productos[opc2]!!.cantidad = disponibles
    val num = 1
    Numero += num
    nombre.agregarEsp(espacio= espacios)
    nombre.agregarNumero(numero = Numero)
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
    nombre.agregarEsp(espacio= espaciosl)
    nombre.agregarSigno(signo = signo)
    nombre.agregarTotal(total=totalArticulo)
    listacarrito.add(nombre.imprimirNombre())
    nombre.clear()

    impresionCarrito()
}
/*  Aqui se muestra que tiene el carrito, aunque todavia no tenga articulos
* */
fun impresionCarrito() {
    println("************************************************************************************")
    println("                   Productos agregados al Carrito:                                 *")
    println("************************************************************************************")
    println("*No.  Cantidad      Articulo                Precio    stok   Disponibles     Total *")
    lista()
    println("************************************************************************************")
    agregarCarrrito()
}
/*   Aqui se muestra la lista de articulos del carrito ademas de los siguientes datos
     Cantidad de articulo agregados: $cont          Total a pagar $Totalprecio
 */
fun lista() {
    val cont= listacarrito.count()
    val totalapagar = Totalprecio - restaPrecio
    listacarrito.forEach{
        println(it)
    }
    println("************************************************************************************")
    println("*  Cantidad de articulo agregados: $cont         Total a pagar $$totalapagar          ")

}
/*   Esta funcion realiza un bucle para agregar articulos o productos al carrito si no lo manda
    al menu de inicio
*/
fun agregarCarrrito() {
    println("************************************************************************************")
    println("*       Deseas agregar un articulo al carrito si o no s/n                          *")
    println("************************************************************************************")
    val opcionSi =readLine()!!.toString()

    if(opcionSi == "s") {
        menucarritoagregar()
    }else{
        menuCarrito()
    }
}
/*   Esta funcion se encarga de eliminar los articulos del carrito que el cliente desear descartar
*/
var indicador = 0
fun elimarProducto() {
    println("************************************************************************************")
    println("*                  Productos agregados al Carrito:                                 *")
    println("************************************************************************************")
    println("*No.  Cantidad      Articulo                Precio    stok   Disponibles     Total *")
    lista()
    println("************************************************************************************")
    println("***************** Que No. de articulo desea eliminar *******************************")

    val opcion4 = readLine()?.toInt()
    indicador= opcion4!! -1
    listacarrito.removeAt(indicador)
    restaPrecio = opc3[indicador]
    println("************************************************************************************")
    println("                   Articulo Eliminado del carrito                                   ")
    impresionCarrito()

}