import java.util.*
import `mercadolibre eq3`.Producto
import `mercadolibre eq3`.cargar


import controllers.Menucarrito
import controllers.agregarCarrrito


//data class Producto(val nombre: String, val marca:String, val categoria:String,val precio: Float, val cantidad: Int)


import controllers.*
import models.Cliente
import models.Usuario


fun main(){
    /*A continucacion se manda a llamar la funcion principal de la Aplicacion*/


    menu()
  /* usuariosCliente.forEach{
       println("Usuario: ${it.key.getUsuario()}")
       println("Nombre: ${it.value.getNombre()}")
       println("Apellidos: ${it.value.getApellidos()}")
       println()
   }*/

}

fun verificarUsuario(user: String, password: String) {
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)

    if(existeUsuario(usuariosCliente,user) || existeCorreo(usuariosCliente,user) || existeNumeroTelefonico(usuariosCliente,user)){
        if(isContraseniaCorrecta(usuariosCliente,password)){
            println("Hola! ${obtenerNombreAmostrar(usuariosCliente,user)}")
            menuInicio()
        }else{
            do {
                println("Revisa tu clave.\n")
                println("Clave")
                val passwordActual = readLine()!!
            }while(!(isContraseniaCorrecta(usuariosCliente,passwordActual)))
            println("Hola! ${obtenerNombreAmostrar(usuariosCliente,user)}")
            menuInicio()
        }
    }else{
        println("Revisa tu e-mail o usuario.\n")
        iniciarSesion()
    }

}

fun menu(){
    val productos: MutableMap<Int, Producto> = mutableMapOf()

    println("****************MENU***************")
    println("* Por favor selecciona una opcion:*")
    println("*  1- Iniciar sesion:             *")
    println("*  2- Entrar como invitado:       *")
    println("*  3- Crea tu cuenta:             *")
    println("*  4- Salir:                      *")
    println("***********************************")

    println("\nIngresa un digito:")
    val opcion = readLine()!!
    when (Integer.parseInt(opcion)) {
        1 -> iniciarSesion()
        2 -> menuInicio()
        3 -> registrarNuevoUsuarioCliente()//funcion para crear un nuevo usuario y cliente
        4 -> print("GRACIAS; REGRESA PRONTO")
    }
}

fun iniciarSesion(){
    val productos: MutableMap<Int, Producto> = mutableMapOf()
    println("----------!Hola! Para seguir, ingresa tu teléfono, e-mail o usuario---------:")

    println("Teléfono, e-mail o usuario:")
    val usuarioActual = readLine()!!

    println("Clave:")
    val passwordActual = readLine()!!

    val userValidated = validate(usuarioActual)
    val passValidate = validate(passwordActual)

    if(userValidated&&passValidate) {
        verificarUsuario(usuarioActual, passwordActual)
          //  println("BIENVENID@ $usuarioActual\n")
    }else{
        println("Los campos no pueden estar vacíos \n")
        iniciarSesion()
    }
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
    println("*  5- Carrito:                                   *")
    println("*  6- Salir:                                     *")
    println("**************************************************")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> listadoCompleto(productos)
        2 -> consultaProductoPorCoicidencia(productos)
        3 -> consultaProductoPorCategoria(productos)
        4 -> consultaProductoPorMarca(productos)
        5 -> Menucarrito()
        6 -> print("GRACIAS; REGRESA PRONTO")
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

    agregarCarrrito()

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

