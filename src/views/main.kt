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

}

fun verificarUsuario(user: String, password: String) {
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)
   // var usuariosClienteEnSesion: MutableMap<Usuario, Cliente>
    var usuarioEnSesion=Usuario(0,"","")
    var clienteEnSesion=Cliente(0,0,"","","")

    if(existeUsuario(usuariosCliente,user) || existeCorreo(usuariosCliente,user) || existeNumeroTelefonico(usuariosCliente,user)){
        if(isContraseniaCorrecta(usuariosCliente,password)){
            //println("Hola! ${obtenerNombreAmostrar(usuariosCliente,user)}")
            //
            usuarioEnSesion = obtenerUsuarioEnSesion(usuariosCliente, user)
            clienteEnSesion = obtenerClienteEnSesion(usuariosCliente,user)

          //  clienteEnSesion.mostrarDatosDelCliente(usuarioEnSesion,clienteEnSesion)
            //
            menuInicio(usuarioEnSesion,clienteEnSesion)
        }else{
            do {
                println("Revisa tu clave.\n")
                println("Clave")
                val passwordActual = readLine()!!
            }while(!(isContraseniaCorrecta(usuariosCliente,passwordActual)))

            //
            usuarioEnSesion = obtenerUsuarioEnSesion(usuariosCliente, user)
            clienteEnSesion = obtenerClienteEnSesion(usuariosCliente,user)

          //  clienteEnSesion.mostrarDatosDelCliente(usuarioEnSesion,clienteEnSesion)
            //
            menuInicio(usuarioEnSesion,clienteEnSesion)
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
        2 -> menuInicioInvitado()
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

fun menuInicio(usuario: Usuario,cliente: Cliente) {

    val productos: MutableMap<Int, Producto> = mutableMapOf()
    val opcion: Int?
    println("Hola! ${cliente.getNombre()}")
    println("************Bienvenido a Mercado Libre************")
    println("**************************************************")
    println("* Para consultar o actualizar tus datos          *")
    println("* Selecciona 0:                                  *")
    println("**************************************************")
    println("\n")
    println("**************************************************")
    println("* Sí prefiere, seleccione lo que desee realizar:  *")
    println("*  1- Ver el listado completo de productos:      *")
    println("*  2- Buscar producto por nombre o coicidencia:  *")
    println("*  3- Consulta producto por categoria:           *")
    println("*  4- Consulta producto por marca:               *")
    println("*  5- Carrito:                                   *")
    println("*  6- Salir:                                     *")
    println("**************************************************")
    opcion = readLine()?.toInt()
    when (opcion) {
        0 -> datosPersonalesDelCliente(usuario,cliente)
        1 -> listadoCompleto(productos)
        2 -> consultaProductoPorCoicidencia(productos)
        3 -> consultaProductoPorCategoria(productos)
        4 -> consultaProductoPorMarca(productos)
        5 -> Menucarrito()
        6 -> print("GRACIAS; REGRESA PRONTO")
    }
}



fun menuInicioInvitado() {

    val productos: MutableMap<Int, Producto> = mutableMapOf()
    val opcion: Int?
    println("************Bienvenido a Mercado Libre************")
    println("\n")
    println("**************************************************")
    println("* A continuacion seleccione lo que desee realizar:")
    println("*  1- Ver el listado completo de productos:      *")
    println("*  2- Buscar producto por nombre o coicidencia:  *")
    println("*  3- Consulta producto por categoria:           *")
    println("*  4- Consulta producto por marca:               *")
    println("*  5- Carrito:                                   *")
    println("*  6- Salir:                                     *")
    println("**************************************************")
    opcion = readLine()?.toInt()
    when (opcion) {
        1 -> listadoCompleto(productos)
        2 -> consultaProductoPorCoicidencia(productos)
        3 -> consultaProductoPorCategoria(productos)
        4 -> consultaProductoPorMarca(productos)
        5 -> Menucarrito()
        6 -> print("GRACIAS; REGRESA PRONTO")
    }
}

