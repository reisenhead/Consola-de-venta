import controllers.*
import models.Producto
import models.Categoria
import models.Marcas


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

    val opcion: Int?
try {


    println("****************MENU***************")
    println("* Por favor selecciona una opcion:*")
    println("*  1- Iniciar sesion:             *")
    println("*  2- Entrar como invitado:       *")
    println("*  3- Registrarse:                *")
    println("*  4- Salir:                      *")
    println("***********************************")

    println("\nIngresa un digito:")
     opcion = readLine()?.toInt()

} catch(e: NumberFormatException) {
    println("************************************************************")
    println("La opcion solo acepta valor numerico,es decir del 1 al 4 ")
    println("************************************************************")
    return menu()
}

    when (opcion) {
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
    val marca: MutableMap<Int, Marcas> = mutableMapOf()
    val opcion: Int?

    try {


        println("************Bienvenido a Mercado Libre************")
        println("* Por favor selecciona una opcion:               *")
        println("*  1- Ver el listado completo de productos:      *")
        println("*  2- Buscar producto por nombre o coicidencia:  *")
        println("*  3- Consulta producto por categoria:           *")
        println("*  4- Consulta producto por marca:               *")
        println("*  5- Salir:                                     *")
        println("**************************************************")
        opcion = readLine()?.toInt()

    } catch (e: NumberFormatException) {
        println("************************************************************")
        println("La opcion solo acepta valor numerico, es decir del 1 al 5 ")
        println("************************************************************")
        return menuInicio()
    }

        when (opcion) {
            1 -> listadoCompleto(productos)
            2 -> consultaProductoPorNombre(productos)
            3 -> consultaProductoPorCategoria(productos, categorias)
            4 -> consultaProductoPorMarca(productos, marca)
            5 -> print("GRACIAS; REGRESA PRONTO")
        }

}






