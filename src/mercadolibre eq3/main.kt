package `mercadolibre eq3`

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
