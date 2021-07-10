import java.util.*
import `mercadolibre eq3`.Producto
import `mercadolibre eq3`.cargar
import `mercadolibre eq3`.*
import models.carrito

//data class Producto(val nombre: String, val marca:String, val categoria:String,val precio: Float, val cantidad: Int)



fun main(){
    /*val user = "Bedu"
    val password = "toor"*/

    //inicializar la clase Producto y cargar datos en ella
  /*  val productos: MutableMap<Int, Producto> = mutableMapOf()

    cargar(productos)
    println("")
    println("   Bienvenid@ a Mercado Libre      ")
*/

    /*A continucacion se manda a llamar la funcion principal de la Aplicacion*/
    menu()
    /*var persona = Person()
    persona.setNombre("Chee")

    println(persona.getNombre())

    var persona2 = Person("Jose","Calderon Castillo","Masculino",23)
    println(persona2.getNombre())

    var cliente1 = persona2
    println("El nombre del primer cliente es: ${cliente1.getNombre()}")*/

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
    println("----------INICIAR SESION------------:")
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

/* Aqui tengo el Menu Carrito en el cual despligo 6 opciones que puede realizar el usuario
   en la cual puede regresar al Menu Princiapl, agregar articulos al carrito, ver el estado actual del carrito,
   o eliminar aticulos del carrito
 */
fun Menucarrito() {
    println("*******************************************+")
    println("*             Menu del carrito             *")
    println("********************************************")
    println("*    1. Regresar al Menu principal         *")
    println("*    2. Agregar más articulos al Carrito   *")
    println("*    3. Articulo en el Carrito             *")
    println("*    4. Eliminar articulos                 *")
    println("*    5. Ir a Comprar                       *")
    println("*    6. Salir de Programa                  *")
    println("********************************************")
    println("           Elija una opcion                 ")
    val opcion = readLine()
    when (Integer.parseInt(opcion)) {
        1 -> menuInicio()
        2 -> menucarritoagregar()
        3 -> impresionCarrito()
        4 -> elimarProducto()
        5 -> println(" Comprando  Articulos  ")
        6 -> print("GRACIAS POR SU VISITA; REGRESA PRONTO A MERCADO LIBRE")

    }
}
/*  Aqui agregre estas variables globales para poderlas usar en todas mis siguientes funciones del Carrito
 */
var listacarrito : ArrayList<String> = arrayListOf<String>()
var nombre = carrito()
var Totalprecio : Float = 0.0f
var Numero: Int = 0
var subTotal: ArrayList<Float> = arrayListOf<Float>()

/*
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
fun impresionCarrito() {
    println("************************************************************************************")
    println("                   Productos agregados al Carrito:                                 *")
    println("************************************************************************************")
    println("*No.  Cantidad      Articulo                Precio    stok   Disponibles     Total *")
    lista()
    println("************************************************************************************")
    agregarCarrrito()
}


fun lista() {
    var cont= listacarrito.count()

    listacarrito.forEach{
        println(it)
    }
    println("************************************************************************************")
    println("*  Cantidad de articulo agregados: $cont          Total a pagar $$Totalprecio       ")

}

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