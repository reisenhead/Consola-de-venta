package controllers
import iniciarOCrearUsuarioParaComprar
import menuInicio
import menuInicioInvitado

import models.Cliente
import models.Usuario



import models.Carrito
import models.Producto


import models.*

import java.util.ArrayList

/* Aqui tengo el Menu Carrito en el cual despligo 6 opciones que puede realizar el usuario
   en la cual puede regresar al Menu Princiapl, agregar articulos al carrito, ver el estado actual del carrito,
   o eliminar aticulos del carrito
 */
fun menuCarrito(usuario2:Usuario,cliente2:Cliente) {
    usuario = usuario2
    cliente = cliente2
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    val categorias: MutableMap<Int, Categoria> = mutableMapOf()
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
        1 -> menuInicio(usuario, cliente)
        2 -> listadoCompleto(productos,categorias,cliente)
        3 -> impresionCarrito()
        4 -> elimarProducto()
        5 -> {
            if(cliente.getNombre()!=""){
                var pago = Pago(1,cliente,listacarrito,Totalprecio,0)
                var pagoController = menuPagoInciandoPago(pago,cliente)
            }else{
                iniciarOCrearUsuarioParaComprar()
            }

        }//pago
        6 -> print("***    GRACIAS POR SU VISITA; REGRESA PRONTO A MERCADO LIBRE   ***")

    }
}



fun menuCarritoInvitado() {
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    val categorias: MutableMap<Int, Categoria> = mutableMapOf()
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
        1 -> menuInicio(usuario,cliente)
        2 -> listadoCompleto(productos,categorias,cliente)
        3 -> impresionCarrito()
        4 -> elimarProducto()
        5 -> {
            if(cliente.getNombre()!=""){
                var pago = Pago(1,cliente,listacarrito,Totalprecio,0)
                var pagoController = menuPagoInciandoPago(pago,cliente)
            }else{
                iniciarOCrearUsuarioParaComprar()
            }
        }
        6 -> print("***    GRACIAS POR SU VISITA; REGRESA PRONTO A MERCADO LIBRE   ***")
////////
    }
}
/*  Aqui agregre estas variables globales para poderlas usar en todas mis siguientes funciones del Carrito
 */
var listacarrito : ArrayList<String> = arrayListOf<String>()/*LISTA QUE CONTIENE  TODOS LOS PRODUCTOS (DATOS DEL CARRITO)*/
var nombre = Carrito()
var Totalprecio : Float = 0.000f
var Numero: Int = 0
var restaPrecio = 0.0000f
var opc3: ArrayList<Float> = arrayListOf<Float>()
var cliente=Cliente(0,0,"","","email")
var usuario=Usuario(0,"root","root")
/* Aqui se agregan los articulos y su cantidad al carrito
*/

fun comprobarRangoDeProductos(opcion2:Int): Boolean{

    if (opcion2 in 10..80) {
        return true
    }else{
        return false
    }

}

fun menuCarritoAgregar() {
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    cargar(productos)
    var opcion2: Int



    println("************************************************************")
    println("*       Desea agregar un Articulo ingrese codigo           *")
    println("************************************************************")
    opcion2 = readLine()!!.toInt()
    while (!comprobarRangoDeProductos(opcion2)) {
        println("El articulo no existe, ingresa un numero del 10 al 80       ")
        opcion2 = readLine()!!.toInt()
    }


    val opc2: Int = opcion2

    var names1 = ""
    var precio1 = 0.0f
    var stok = 0
    val entrada = 1
    if ((opc2 in 10..80)) {
        when (entrada) {
            1 -> {
                names1 = productos[opc2]!!.nombre
                precio1 = productos[opc2]!!.precio
                stok = productos[opc2]!!.cantidad
            }
        }
    } else {
        names1 = "articulo no encontrado"
    }
    var opcion3: Int?
    try {
        println("****************************************************************")
        println("*           Ingrese la cantidad de articulos                   *")
        println("****************************************************************")
        opcion3 = readLine()?.toInt()
    } catch (e: NumberFormatException) {
        println("*************************************************************")
        println("La cantidad solo puede ser de valor numerico intenta de nuevo")
        println("*************************************************************")
        return menuCarritoAgregar()
    }
    opc3.add(precio1)

    val totalArticulo = opcion3!! * precio1
    Totalprecio += totalArticulo
    val espacios = "  "
    val espaciosl = "      "
    val signo = "$"
    val disponibles = stok - opcion3

    productos[opc2]!!.cantidad = disponibles

    val num = 1
    Numero += num
    nombre.agregarEsp(espacio = espacios)
    nombre.agregarNumero(numero = Numero)
    nombre.agregarEsp(espacio = espaciosl)
    nombre.agregarCantidad(cantidad = opcion3)
    nombre.agregarEsp(espacio = espaciosl)
    nombre.agregarNombre(nombre = names1)
    nombre.agregarEsp(espacio = espacios)
    nombre.agregarSigno(signo = signo)
    nombre.agregarPrecio(precio = precio1)
//    nombre.agregarEsp(espacio= espacios)
//    nombre.agregarEsp(espacio= espacios)
//    nombre.agregarStok(Stok= stok)
    nombre.agregarEsp(espacio = espaciosl)
    nombre.agregarEsp(espacio = espacios)
    nombre.agregarDisponibles(disponible = disponibles)
    nombre.agregarEsp(espacio = espaciosl)
    nombre.agregarSigno(signo = signo)
    nombre.agregarTotal(total = totalArticulo)
    /*
    *
    * AGREGANDO PRODUCTO AL CARRITO
    * */
    listacarrito.add(nombre.imprimirNombre())
    nombre.clear()

    impresionCarrito()
}

/*  Aqui se muestra que tiene el carrito, aunque todavia no tenga articulos
* */
fun impresionCarrito() {
    println("****************************************************************************************")
    println("*                           Productos agregados al Carrito:                            *")
    println("****************************************************************************************")
    println("*No.  Cantidad                Articulos                Precio     Disponibles    Total *")//*******///
    lista()
    println("****************************************************************************************")
    agregarCarrrito(cliente)
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
    println("****************************************************************************************")
    println("*  Cantidad de articulo agregados: $cont         Total a pagar $$totalapagar          ")
    ///"ID","NOMBRE","STOCK","",""
}
/*   Esta funcion realiza un bucle para agregar articulos o productos al carrito si no lo manda
    al menu de inicio
*/
fun agregarCarrrito(cliente2:Cliente) {
    cliente=cliente2
    println("********************************************************************************************")
    println(" Desea agregar un articulo al carrito escriba (s) para si o cualquier letra para continuar  ")
    println("********************************************************************************************")
    val opcionSi =readLine()!!.toString()

    if(opcionSi == "s") {
        menuCarritoAgregar()
    }else{
        menuCarrito(usuario,cliente)
    }
}
/*   Esta funcion se encarga de eliminar los articulos del carrito que el cliente desear descartar
*/
var indicador = 0
fun elimarProducto() {
    println("****************************************************************************************")
    println("*                           Productos agregados al Carrito:                            *")
    println("****************************************************************************************")
    println("*No.  Cantidad                Articulos                Precio     Disponibles    Total *")
    lista()
    println("****************************************************************************************")
    println("*                 Elija el (No.) del Articulo a eliminar                               *")
    println("****************************************************************************************")
    val opcion4 = readLine()?.toInt()
    indicador= opcion4!! -1
    listacarrito.removeAt(indicador)
    restaPrecio = opc3[indicador]
    println("**************************************************************************************")
    println("                   Articulo Eliminado del carrito                                     ")
    impresionCarrito()

}