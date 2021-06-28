//package `mercadolibre eq3`



/*fun main(){
    val user = "Bedu"
    val password = "toor"

    println("")
    println("Bienvenid@ a Mercado Libre")
    menu()

}

fun verificarUsuario(user: String, password: String): Boolean {
    var mensaje:Boolean = false

    if(user.contentEquals("Bedu") && password.contentEquals("toor")){
        mensaje = true
    }

    return mensaje;
}*/
/*
fun menu(){
    println("****************MENU***************")
    println("* Por favor selecciona una opcion:*")
    println("*  1- Iniciar sesion:             *")
    println("*  2- Entrar como invitado:       *")
    println("*  3- Registrarse:                *")
    println("*  4- Salir:                      *")
    println("***********************************")

    println("\nIngresa un digito:")
    val opcion = readLine()!!
    when (Integer.parseInt(opcion)) {
        1 -> {
            println("Por favor ingresa tu usuario:")
            val usuarioActual = readLine()!!

            println("Por favor ingresa tu contrasenia:")
            val passwordActual = readLine()!!

            if(verificarUsuario(usuarioActual,passwordActual)){
                println("BIENVENID@ $usuarioActual\n")
            }else{
                println("Usuario o Contrasenia incorrecta\n")
            }
        }
        2 -> print("BIENVENID@")
        3 -> print("EN MANTENIMIENTO")
        4 -> print("GRACIAS; REGRESA PRONTO")
    }

}

fun main(){
    val user = "Bedu"
    val password = "toor"

    println("")
    println("Bienvenid@ a Mercado Libre")
    menu()

}

fun verificarUsuario(user: String, password: String): Boolean {
    var mensaje:Boolean = false

    if(user.contentEquals("Bedu") && password.contentEquals("toor")){
        mensaje = true
    }

    return mensaje;
}

fun menu(){
    println("****************MENU***************")
    println("* Por favor selecciona una opcion:*")
    println("*  1- Iniciar sesion:             *")
    println("*  2- Entrar como invitado:       *")
    println("*  3- Registrarse:                *")
    println("*  4- Salir:                      *")
    println("***********************************")

    println("\nIngresa un digito:")
    val opcion = readLine()!!
    when (Integer.parseInt(opcion)) {
        1 -> {
            println("Por favor ingresa tu usuario:")
            val usuarioActual = readLine()!!

            println("Por favor ingresa tu contrasenia:")
            val passwordActual = readLine()!!

            if(verificarUsuario(usuarioActual,passwordActual)){
                println("BIENVENID@ $usuarioActual\n")
            }else{
                println("Usuario o Contrasenia incorrecta\n")
            }
        }
        2 -> print("BIENVENID@")
        3 -> print("EN MANTENIMIENTO")
        4 -> print("GRACIAS; REGRESA PRONTO")
    }

}


*/




//Modificación
/*
data class Producto(val nombre: String, val marca:String, val categoria:String,val precio: Float, val cantidad: Int)



fun main(){
    val user = "Bedu"
    val password = "toor"

    println("")
    println("   Bienvenid@ a Mercado Libre      ")
    menu()



}

fun verificarUsuario(user: String, password: String): Boolean {
    var mensaje: Boolean = false

    if(user.contentEquals("Bedu") && password.contentEquals("toor")){
        mensaje = true
    }

    return mensaje;
}

fun menu(){
    val productos: MutableMap<Int, Producto> = mutableMapOf()

    println("****************MENU***************")
    println("* Por favor selecciona una opcion:*")
    println("*  1- Iniciar sesion:             *")
    println("*  2- Entrar como invitado:       *")
    println("*  3- Registrarse:                *")
    println("*  4- Salir:                      *")
    println("***********************************")

    println("\nIngresa un digito:")
    val opcion = readLine()!!
    when (Integer.parseInt(opcion)) {
        1 -> {
            println("Por favor ingresa tu usuario:")
            val usuarioActual = readLine()!!

            println("Por favor ingresa tu contrasenia:")
            val passwordActual = readLine()!!

            if(verificarUsuario(usuarioActual,passwordActual)){
                println("BIENVENID@ $usuarioActual\n")

                cargar(productos)
                listadoCompleto(productos)
                listadoCompleto(productos)
                consultaProducto(productos)
            }else{
                println("Usuario o Contrasenia incorrecta\n")
            }

        }

        2 -> print("BIENVENID@")
        3 -> print("EN MANTENIMIENTO")
        4 -> print("GRACIAS; REGRESA PRONTO")
    }


}


fun cargar(productos: MutableMap<Int, Producto>) {
    productos[10] =  Producto("Galaxi Z flip", "Samsung","Celular",24999.99f, 20)
    productos[11] =  Producto("Huawei P40", "Huawei","Celular",5099.90f, 15)
    productos[12] =  Producto("Iphone 11 Pro Max", "Apple","Celular",32999.00f, 5)
    productos[13] =  Producto("Smart TV Samsung 40\"", "Samsung","Televisor",5500f,3)
    productos[14] =  Producto("Smart TV Sony 43\"", "Sony","Televisor",8999.90f,7)
    productos[15] =  Producto("Smart TV Samsung 50\"", "Samsung","Televisor",12699.90f,9)
    productos[16] =  Producto("Huawei whatch Fit 1.64\"", "Huawei","Reloj",1849f,20)
    productos[17] =  Producto("Samsung Galaxy Note 10", "Samsung","Celular",9261.20f,3)
    productos[18] =  Producto("Samsung Galaxi S21+", "Samsung","Celular",18496.90f,8)
    productos[19] =  Producto("Smart TV Hisense 40\"", "Hisense","Televisor",5499.99f,18)
    productos[20] =  Producto("Smart TV LG 32\"", "LG","Televisor",4895.90f,7)
    productos[21] =  Producto("LG K71 128GB gris", "LG","Celular",6470.90f,3)
    productos[22] =  Producto("Iphone X 256GB plata", "Apple","Celular",10199f,9)
    productos[23] =  Producto("Apple Watch Series 3", "Apple","Reloj",6250f,0)
    productos[24] =  Producto("Smart TV Hisense 50\"", "Hisense","Televisor",8999.99f,8)
    productos[25] =  Producto("Sony Xperia 5 li", "Sony","Celular",23999.99f,0)
    productos[26] =  Producto("Macbook Pro 16\"", "Apple","Laptop",62999.90f,7)
    productos[27] =  Producto("Laptop matebook X pro 2020", "Huawei","Laptop",35599f,3)
    productos[28] =  Producto("Huawei watch GT 2e", "Huawei","Reloj",2399.90f,6)
    productos[29] =  Producto("Smart TV Samsung 70\" 4k", "Samsung","Televisor",22393f,2)


}


fun listadoCompleto(productos: MutableMap<Int, Producto>) {

    println("Deseas ver el listado completo de productos?: ")
    val respuesta = readLine()!!
    when (respuesta) {
        "si" -> {
            for ((codigo, producto) in productos)
                println("Código: $codigo  Nombre: ${producto.nombre} ")
        }
        "no" -> {
            println("Tenemos estas categorias para ti: ")
            for ((codigo,producto) in productos)
                println("Categorias: ${producto.categoria}")
        }
        else -> {
            println("No puedo reconocer tu respuesta, Busca el producto por categoria")
        }
    }

}


fun consultaProducto(productos: MutableMap<Int, Producto>) {
    print("Ingrese el código de un producto para ver mas detalles:")
    val codigo = readLine()!!.toInt()
    if (codigo in productos)
        println("Nombre: ${productos[codigo]?.nombre} Marca: ${productos[codigo]?.marca}  Precio: ${productos[codigo]?.precio} Stock: ${productos[codigo]?.cantidad}")
    else
        println("No existe un producto con  dicho código")
}


fun comprar(productos: MutableMap<Int, Producto>) {
    println("Que producto deseas comprar: ")

}


fun sinStock(productos: MutableMap<Int, Producto>) {
    val cant = productos.count { it.value.cantidad == 0 }
    println("Cantidad de artículos sin stock: $cant")
}


////////////////////////////
//funciones para buscar productos por nombre y por marca:

fun consultaProductoPorNombre(productos: MutableMap<Int, Producto>) {
    print("Ingrese el nombre del  producto para ver mas detalles:")
    val nombreBuscar = readLine()!!

    for ((key, value) in productos) {
        if(nombreBuscar in value.nombre){
            println("$key = $value")
            println("Se econtro el producto")
        }
    }
}

fun consultaProductoPorMarca(productos: MutableMap<Int, Producto>) {
    print("Ingrese la marca de un producto para ver mas detalles:")
    val nombreBuscar = readLine()!!

    for ((key, value) in productos) {
        if(nombreBuscar in value.marca){
            println("$key = $value")
            println("Se econtro el producto")
        }
    }
}















// CODIGO MODIFICADO CON FUNCIONES DE BUSCAR PRODUCTOS POR NOMBRE Y POR CATEGORIA:
*/

