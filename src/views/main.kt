import controllers.*
import java.util.*
import models.Producto
import models.Categoria


fun main(){


    //A continucacion se manda a llamar la funcion principal de la Aplicacion
    menu()

}

fun verificarUsuario(user: String, password: String): Boolean {
    var mensaje = false

    if(user.contentEquals("Bedu") && password.contentEquals("toor")){
        mensaje = true
    }

    return mensaje
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
        1 -> iniciarSesion()
        2 -> menuInicio()
        3 -> print("EN MANTENIMIENTO")
        4 -> print("GRACIAS; REGRESA PRONTO")
    }

}

fun iniciarSesion(){

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
    val categorias: MutableMap<Int, Categoria> = mutableMapOf()


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
        2 -> println("hola")
        3 -> consultaProductoPorCategoria(productos,categorias)
        4 -> consultaProductoPorMarca(productos)
        5 -> print("GRACIAS; REGRESA PRONTO")
    }
}






