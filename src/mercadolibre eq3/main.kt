import java.util.*
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


    //consultaProductoPorCoicidencia(productos)

    //menuInicio()
//   consultaProductoPorNombre(productos)
    //  consultaProductoPorMarca(productos)
    // consultaProductoPorCategoria(productos)
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
        2 -> menuInicio()
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

    println("************Bienvenido a Mercado Libre************")
    println("* Por favor selecciona una opcion:               *")
    println("*  1- Ver el listado completo de productos:      *")
    println("*  2- Buscar producto por nombre o coicidencia:  *")
    println("*  3- Consulta producto por categoria:           *")
    println("*  4- Consulta producto por marca:               *")
    println("*  5- Salir:                                     *")
    println("**************************************************")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> listadoCompleto(productos)
        2 -> consultaProductoPorCoicidencia(productos)
        3 -> consultaProductoPorCategoria(productos)
        4 -> consultaProductoPorMarca(productos)
        5 -> print("GRACIAS; REGRESA PRONTO")
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
            for ((codigo,producto) in productos)
                println("Categorias: ${producto.categoria}")
        }
        else -> {
            println("No puedo reconocer tu respuesta, Busca el producto por categoria")
        }
    }

}

/*A continuacion la funcion tiene como objetivo buscar las letras o caracteres coicidentes dentro del nombre,
marca, categoria de cada producto, este caracteres o letras son las que ingresan el usuario, para bucar o consultar.
Por ejemplo: si se ingresa Hi, His, Hisen; me regresa los prodcutos que coincide en su nombre, marca, categoria;
en este caso regresaría, todos los productos relacionados a Hisense.
*/
fun consultaProductoPorCoicidencia(productos: MutableMap<Int, Producto>) {
    cargar(productos)
    var bandera = false
    print("Ingrese la palabra a buscar dentro de los productos:")
    val nombreBuscar = readLine()!!.lowercase(Locale.getDefault())//convertir a minuscula el texto que se ingrese

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {
        //convertir a minuscula el texto de cada value.
        if( value.nombre.lowercase(Locale.getDefault()).contains("$nombreBuscar") ||
            value.marca.lowercase(Locale.getDefault()).contains("$nombreBuscar") ||
            value.categoria.lowercase(Locale.getDefault()).contains("$nombreBuscar")){

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

/*Consulta y retorna todos los productos que tenga por nombre al que se ingreso
Por ejemplo si se ingresa: Huawei P40, retornaria todos los detalles correspondiente a este producto(Huawei P40)
*/
fun consultaProductoPorNombre(productos: MutableMap<Int, Producto>) {
    cargar(productos)
    var bandera = false
    print("Ingrese el nombre del  producto para ver mas detalles:")
    val nombreBuscar = readLine()!!.lowercase(Locale.getDefault())

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {
        if(nombreBuscar in value.nombre.lowercase(Locale.getDefault())){
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
    cargar(productos)
    var bandera = false
    print("Ingrese la marca de un producto para ver mas detalles:")
    val nombreBuscar = readLine()!!.lowercase(Locale.getDefault())

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {
        if(nombreBuscar in value.marca.lowercase(Locale.getDefault())){
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
    cargar(productos)
    var bandera = false
    print("Ingrese la categoria de productos a buscar:")
    val categoriaBuscar = readLine()!!.lowercase(Locale.getDefault())

    println("\n**********Productos Encontrados: ********** \n")
    for ((key, value) in productos) {

        if(categoriaBuscar in value.categoria.lowercase(Locale.getDefault())){
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

fun comprar(productos: MutableMap<Int, Producto>) {
    println("Que producto deseas comprar: ")
}

fun sinStock(productos: MutableMap<Int, Producto>) {
    val cant = productos.count { it.value.cantidad == 0 }
    println("Cantidad de artículos sin stock: $cant")
}
