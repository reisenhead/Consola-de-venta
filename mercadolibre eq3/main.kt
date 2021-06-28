import `mercadolibre eq3`.Carrito
import `mercadolibre eq3`.Producto
import `mercadolibre eq3`.cargar
//data class Producto(val nombre: String, val marca:String, val categoria:String,val precio: Float, val cantidad: Int)



fun main(){
    /*val user = "Bedu"
    val password = "toor"*/

    //inicializar la clase Producto y cargar datos en ella
    val productos: MutableMap<Int, Producto> = mutableMapOf()

    cargar(productos)


    println("")
    println("   Bienvenid@ a Mercado Libre      ")


    menu()

    //consultaProductoPorNombre(productos)
    //consultaProductoPorMarca(productos)
    //consultaProductoPorCategoria(productos)
    //listadoCompleto(productos)
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
        1 -> iniciarSesion()
        2 -> print("BIENVENID@")
        3 -> print("EN MANTENIMIENTO")
        4 -> print("GRACIAS; REGRESA PRONTO")
    }


}

fun iniciarSesion(){
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    println("Por favor ingresa tu usuario:")
    val usuarioActual = readLine()!!

    println("Por favor ingresa tu contrasenia:")
    val passwordActual = readLine()!!

    val userValidated = validate(usuarioActual)
    val passValidate = validate(passwordActual)

    if(userValidated&&passValidate) {
        if (verificarUsuario(usuarioActual, passwordActual)) {
            println("BIENVENID@ $usuarioActual\n")

            //cargar(productos)
            //listadoCompleto(productos)
            //  listadoCompleto(productos)
            // consultaProducto(productos)
        } else {
            println("Usuario o Contrasenia incorrecta\n")
            iniciarSesion()
        }
    }else{
        println("Los campos no pueden estar vacíos \n")
        iniciarSesion()
    }

    menuInicio()
}


fun validate(input: String): Boolean{
    if(input.isEmpty()){
        return false
    }
    return true
}

fun menuInicio() {

    val productos: MutableMap<Int, Producto> = mutableMapOf()

    println("**********Bienvenido a Mercado Libre**********")
    println("* Por favor selecciona una opcion:           *")
    println("*  1- Ver el listado completo de productos:  *")
    println("*  2- Consulta producto por categoria:       *")
    println("*  3- Consulta producto por marca:           *")
    println("*  4- Carrito:                               *")
    println("*  5- Salir:                                 *")
    println("**********************************************")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> listadoCompleto(productos)
        2 -> consultaProductoPorCategoria(productos)
        3 -> consultaProductoPorMarca(productos)
        4 -> carrito()
        5 -> print("GRACIAS; REGRESA PRONTO")
    }
}




fun listadoCompleto(productos: MutableMap<Int, Producto>) {

    cargar(productos)

    println("Deseas ver el listado completo de productos? si/no: ")
    val respuesta = readLine()!!
    when (respuesta) {
        "si" ->{
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
    println("*************************************************")
    println("*  Desea agregar un Articulo ingrese codigo     *")
    println("*************************************************")
    var opcion2: String? = readLine()
        println("*************************************************")
    println("*  Ingrese la cantidad de articulos             *")
    println("*************************************************")
    var opcion3 = readLine()

    //var cat = Carrito(nombre = opcion2, cantidad = opcion3,)


}


fun consultaProducto(productos: MutableMap<Int, Producto>) {
    print("Ingrese el código de un producto para ver mas detalles:")
    val codigo = readLine()!!.toInt()
    if (codigo in productos)
        println("Nombre: ${productos[codigo]?.nombre} Marca: ${productos[codigo]?.marca}  Precio: ${productos[codigo]?.precio} Stock: ${productos[codigo]?.cantidad}")
    else
        println("No existe un producto con  dicho código")
}

fun consultaProductoPorNombre(productos: MutableMap<Int, Producto>) {
    var bandera = false
    print("Ingrese el nombre del  producto para ver mas detalles:")
    val nombreBuscar = readLine()!!

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {
        if(nombreBuscar in value.nombre){
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

fun consultaProductoPorMarca(productos: MutableMap<Int, Producto>) {
    var bandera = false
    print("Ingrese la marca de un producto para ver mas detalles:")
    val nombreBuscar = readLine()!!

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {
        if(nombreBuscar in value.marca){
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
        println("No se encontro ningun producto de esta Marca")
    }
}

fun consultaProductoPorCategoria(productos: MutableMap<Int, Producto>) {
    var bandera = false
    print("Ingrese la categoria de productos a buscar:")
    val categoriaBuscar = readLine()!!.capitalize()

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {

        if(categoriaBuscar in value.categoria){
            //  println("$key = $value")
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
        println("No se encontro ningun producto en esta categoria")
    }

}

// MENU CARRITO LE FALTA  SINCRONIZARLO CON EL MENU DE LISTADO DE PRODUCTOS *****
fun carrito() {
    var car = Carrito(nombre = "Laptop", cantidad = 1)
    println("**********Productos del carrito: ***********")
    println("*                                          *")
    println("*  Articulo                 Cantidad       *")
    println("  ${car.nombre}                       ${car.cantidad}          *")
    println("*******************************************+")
    println("*             Menu del carrito             *")
    println("********************************************")
    println("*    1. Regresar al Menu de productos      *")
    println("*    2. Modificar cantidad de articulos    *")
    println("*    3. Ir a Comprar                       *")
    println("*    4. Salir de Programa                  *")
    println("********************************************")
    println("           Elija una opcion                 ")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> menuInicio()
        2 -> modificarCarrito()
        3 -> comprarcarrito()
        5 -> print("GRACIAS; REGRESA PRONTO A MERCADO LIBRE")
    }
}
fun modificarCarrito() {

    println("********************************************")
    println("*        Que producto desea Modificar      *")


}
fun comprarcarrito() {

}

fun comprar(productos: MutableMap<Int, Producto>) {
    println("Que producto deseas comprar: ")

}


fun sinStock(productos: MutableMap<Int, Producto>) {
    val cant = productos.count { it.value.cantidad == 0 }
    println("Cantidad de artículos sin stock: $cant")
}
