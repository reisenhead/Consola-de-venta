package controllers
import models.Categoria
import models.Cliente
import models.Marcas
import models.Producto
import java.util.*




fun consultaProductoPorNombre(productos: MutableMap<Int, Producto>, marca: MutableMap<Int,Marcas>,categorias: MutableMap<Int, Categoria>,cliente:Cliente) {

    cargar(productos)
    cargarMarcas(marca)
    cargarCategorias(categorias)
    val nombreBuscar: String?

        println("****************************************")
        println("Busca el articulo que prefieras: :")
        nombreBuscar = readLine()?.toString()//convertir a minuscula el texto que se ingrese

    if (nombreBuscar != null) {

        println("\n********Todos nuestros productos: ********** \n")
        for ((key, value) in productos)
            if( value.nombre.lowercase(Locale.getDefault()).contains("$nombreBuscar") ||
                value.marca.lowercase(Locale.getDefault()).contains("$nombreBuscar") ||
                value.categoria.lowercase(Locale.getDefault()).contains("$nombreBuscar")){

                println("Codigo: $key")
                println("Nombre: ${value.nombre}")
                println("Marca: ${value.marca}")
                println("Categoria: ${value.categoria}")
                println("Precio: $ ${value.precio}")
                // println("Se econtro el producto")
                println("************************")

            }
        agregarCarrrito(cliente)


    }else {
        println("El campo no puede estar vacio")
        return consultaProductoPorNombre(productos ,marca,categorias,cliente)
    }

}

fun mostrarMarcas(marca: MutableMap<Int, Marcas>) {
    cargarMarcas(marca)

    for ((_,value) in marca)
        println("Codigo ${value.idMarca} Categoria ${value.descripcion}")

}
fun consultaProductoPorMarca(productos: MutableMap<Int, Producto>, marca: MutableMap<Int,Marcas>,cliente:Cliente){


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
        return consultaProductoPorMarca(productos,marca,cliente)
    }



        println("\n**********Productos Encontrados: ********** \n")

        //Verificamos que el campo no se deje vacio.

        if (nombreBuscar != null) {



            for ((key, value) in productos)
                if (nombreBuscar == value.idMarca) {
                    println("Codigo: $key")
                    println("Nombre: ${value.nombre}")
                    println("Marca: ${value.marca}")
                    println("Categoria: ${value.categoria}")
                    println("Precio: $ ${value.precio}")
                    println("************************")
                }
            agregarCarrrito(cliente)


        } else {
            println("El campo no puede estar vacio")
            return consultaProductoPorMarca(productos, marca,cliente)
        }

}


fun mostrarCategorias(categorias: MutableMap<Int, Categoria>) {
    cargarCategorias(categorias)

    for ((_,value) in categorias)
        println("Codigo ${value.idCatetoria} Categoria ${value.descripcion}")

}

fun consultaProductoPorCategoria(productos: MutableMap<Int, Producto>, categorias: MutableMap<Int, Categoria>,cliente:Cliente){


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
        return consultaProductoPorCategoria(productos, categorias,cliente)
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

            agregarCarrrito(cliente)


        } else {
            println("El campo no puede estar vacio")
            return consultaProductoPorCategoria(productos, categorias,cliente)
        }

}


fun listadoCompleto(productos: MutableMap<Int, Producto>, categorias: MutableMap<Int, Categoria>,cliente: Cliente) {

    cargar(productos)
    cargarCategorias(categorias)


    println("Deseas ver el listado completo de productos? (Escriba s/n): ")
    val respuesta = readLine()!!
    when (respuesta) {
        "s" -> {
            for ((key,value) in productos) {
                println("Codigo: $key")
                println("Nombre: ${value.nombre}")
                println("Marca: ${value.marca}")
                println("Categoria: ${value.categoria}")
                println("Precio: $ ${value.precio}")
                println("************************")
            }
        }
        "n" -> {
            println("Tenemos estas categorias para ti: ")

            mostrarCategorias(categorias)
        }
        else -> {
            println("No puedo reconocer tu respuesta, Busca el producto por categoria")
        }
    }
    agregarCarrrito(cliente)

}