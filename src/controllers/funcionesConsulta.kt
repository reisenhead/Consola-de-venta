package controllers

import models.Categoria
import models.Marcas
import models.Producto
import java.util.*

fun consultaProductoPorNombre(productos: MutableMap<Int, Producto>) {
    cargar(productos)
    var bandera = false
    print("Ingrese el nombre del  producto para ver mas detalles:")
    val nombreBuscar = readLine()!!.lowercase(Locale.getDefault())

    println("\n********Todos nuestros productos: ********** \n")
    for ((_, value) in productos) {
        if( value.nombre.lowercase(Locale.getDefault()).contains(nombreBuscar) ||
            value.marca.lowercase(Locale.getDefault()).contains(nombreBuscar) ||
            value.categoria.lowercase(Locale.getDefault()).contains(nombreBuscar)){
            println("Nombre: ${value.nombre}")
            println("Marca: ${value.marca}")
            println("Categoria: ${value.categoria}")
            println("Precio: $ ${value.precio}")
            // println("Se econtro el producto")
            println("************************")
            bandera =true

            agregarCarrrito()
        }
    }
    if(bandera == false){
        println("No se encontro ningun producto con este nombre")
    }

}

fun mostrarMarcas(marca: MutableMap<Int, Marcas>) {
    cargarMarcas(marca)

    for ((_,value) in marca)
        println("Codigo ${value.idMarca} Categoria ${value.descripcion}")

}
fun consultaProductoPorMarca(productos: MutableMap<Int, Producto>, marca: MutableMap<Int, Marcas>){


    cargar(productos)
    mostrarMarcas(marca)

    val nombreBuscar: Int?
    try {
        println("****************************************")
        println("Ingrese el codigo de categoria a buscar:")
        nombreBuscar = readLine()?.toInt()//convertir a minuscula el texto que se ingrese
    }catch(e: NumberFormatException) {
        println("************************************************************")
        println("El codigo solo puede ser de valor numerico intenta de nuevo ")
        println("************************************************************")
        return consultaProductoPorMarca(productos,marca)
    }



        println("\n**********Productos Encontrados: ********** \n")

        //Verificamos que el campo no se deje vacio.

        if (nombreBuscar != null) {
            //convertir a minuscula el texto de cada value.



            for ((key, value) in productos)
                if (nombreBuscar == value.idMarca) {
                    println("Codigo: $key")
                    println("Nombre: ${value.nombre}")
                    println("Marca: ${value.marca}")
                    println("Categoria: ${value.categoria}")
                    println("Precio: $ ${value.precio}")
                    println("************************")
                }
            agregarCarrrito()


        } else {
            println("El campo no puede estar vacio")
            return consultaProductoPorMarca(productos, marca)
        }

}


fun mostrarCategorias(categorias: MutableMap<Int, Categoria>) {
    cargarCategorias(categorias)

    for ((_,value) in categorias)
        println("Codigo ${value.idCatetoria} Categoria ${value.descripcion}")

}

fun consultaProductoPorCategoria(productos: MutableMap<Int, Producto>, categorias: MutableMap<Int, Categoria>){


    cargar(productos)
    mostrarCategorias(categorias)

    val nombreBuscar: Int?
    try {
        println("****************************************")
        println("Ingrese el codigo de categoria a buscar:")
        nombreBuscar = readLine()?.toInt()//convertir a minuscula el texto que se ingrese
    }catch(e: NumberFormatException) {
        println("************************************************************")
        println("El codigo solo puede ser de valor numerico intenta de nuevo ")
        println("************************************************************")
        return consultaProductoPorCategoria(productos, categorias)
    }



        println("\n**********Productos Encontrados: ********** \n")

        //Verificamos que el campo no se deje vacio.

        if (nombreBuscar != null) {
            //convertir a minuscula el texto de cada value.



            for ((key, value) in productos)
                if (nombreBuscar == value.idCategoria) {
                    println("Codigo: $key")
                    println("Nombre: ${value.nombre}")
                    println("Marca: ${value.marca}")
                    println("Categoria: ${value.categoria}")
                    println("Precio: $ ${value.precio}")
                    println("************************")
                }

            agregarCarrrito()


        } else {
            println("El campo no puede estar vacio")
            return consultaProductoPorCategoria(productos, categorias)
        }

}


fun listadoCompleto(productos: MutableMap<Int, Producto>) {

    cargar(productos)

    println("Deseas ver el listado completo de productos? si/no: ")
    val respuesta = readLine()!!
    when (respuesta) {
        "si" -> {
            for ((codigo, producto) in productos)
                println("Código: $codigo  Nombre: ${producto.nombre} ")
        }
        "no" -> {
            println("Tenemos estas categorias para ti: ")
            for ((_,producto) in productos)
                println("Categorias: ${producto.categoria}")
        }
        else -> {
            println("No puedo reconocer tu respuesta, Busca el producto por categoria")
        }
    }
    agregarCarrrito()

}

/*A continuacion la funcion tiene como objetivo buscar las letras o caracteres coicidentes dentro del nombre,
marca, categoria de cada producto, este caracteres o letras son las que ingresan el usuario, para bucar o consultar.
Por ejemplo: si se ingresa Hi, His, Hisen; me regresa los prodcutos que coincide en su nombre, marca, categoria;
en este caso regresaría, todos los productos relacionados a Hisense.
*/
/*
fun consultaProductoPorCoicidencia(productos: MutableMap<Int, Producto>) {
    cargar(productos)
    var bandera = false
    print("Ingrese la palabra a buscar dentro de los productos:")
    val nombreBuscar = readLine()!!.lowercase(Locale.getDefault())//convertir a minuscula el texto que se ingrese

    println("\n**********Productos Encontrados: ********** \n")
    for ((_, value) in productos) {
        //convertir a minuscula el texto de cada value.
        if( value.nombre.lowercase(Locale.getDefault()).contains(nombreBuscar) ||
            value.marca.lowercase(Locale.getDefault()).contains(nombreBuscar) ||
           value.categoria.lowercase(Locale.getDefault()).contains(nombreBuscar)){

            println("Nombre: ${value.nombre}")
            println("Marca: ${value.marca}")
            println("Categoria: ${value.categoria}")
            println("Precio: $ ${value.precio}")
            // println("Se econtro el producto")
            println("************************")
            bandera =true
        }
    }
    if(bandera == false){
        println("No se encontro ningun producto con este nombre")
    }
}
*/

/*Consulta y retorna todos los productos que tenga por nombre al que se ingreso
Por ejemplo si se ingresa: Huawei P40, retornaria todos los detalles correspondiente a este producto(Huawei P40)
*/