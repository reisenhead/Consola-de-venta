package Carrrito
import Producto
import cargar

fun main() {

    println("   Bienvenid@ a Mercado Libre      ")
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    cargar(productos)


    //carrito() funcion
    println("*************************************************")
    println("*  Desea agregar un Articulo ingrese codigo     *")
    println("*************************************************")

    var opcion2 = readLine()!!.toInt()
    var opc2 : Int = opcion2
    //val add = opc2.add(opcion2!!.toInt())
    var names1 : String = ""
    var precio1: Float = 0f
    var stok: Int = 0
    if((opc2 in 10..29)) {

           when (opc2){
               10 -> {
                   names1 = productos[10]!!.nombre
                   precio1 = productos[10]!!.precio
                   stok = productos[10]!!.cantidad

               }
           }
    }
    else  {
        //names1 = "articulo no encontrado"
    }

    println("*************************************************")
    println("*  Ingrese la cantidad de articulos             *")
    println("*************************************************")
    var opcion3 = readLine()!!.toInt()
    var opc3 = arrayListOf<Int>()
    opc3.add(opcion3.toInt())
//    println("*************************************************")
//    println("*  Desea agregar un Articulo ingrese codigo     *")
//    println("*************************************************")
//    opcion2 = readLine()
//
//    opc2.add(opcion2!!.toInt())
//    println("*************************************************")
//    println("*  Ingrese la cantidad de articulos             *")
//    println("*************************************************")
//    opcion3 = readLine()!!.toInt()
//
//    opc3.add(opcion3.toInt())
    println("*********************  Productos del carrito:    *************************")
    println("*                                                                        *")
    println("*        Articulo         Cantidad        Precio      Stok               *")
    println("*  $names1            $opc3          $precio1      $stok                *")
    println("**************************************************************************")
    //carrito()

}






fun carrito() {

}
