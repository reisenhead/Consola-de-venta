package retosFinalyPostwork.s7

// Postwork 7

//Obtenido de nuestro proyecto

/*
fun menu(){

    val opcion: Int?
    try {


        println("*****MENU******")
        println("* Por favor selecciona una opcion:*")
        println("*  1- Iniciar sesion:             *")
        println("*  2- Entrar como invitado:       *")
        println("*  3- Crea tu cuenta:             *")
        println("*  4- Salir:                      *")
        println("*************")

        println("\nIngresa un digito:")
        opcion = readLine()?.toInt()

    } catch(e: NumberFormatException) {  // Nos dice que solo debemos poner numeros.
        println("********************")
        println("La opcion solo acepta valor numerico,es decir del 1 al 4 ")
        println("********************")
        return menu()
    }
    when (opcion) {
        1 -> iniciarSesion()
        2 -> menuInicioInvitado()
        3 -> registrarNuevoUsuarioCliente()//funcion para crear un nuevo usuario y cliente
        4 -> print("GRACIAS; REGRESA PRONTO")
    }
}*/


/*
fun main() {
    // .1
    fun divide(num1:Int,num2:Int): Int{
        return try { num1/num2} catch (e : Exception){0}
    }

    println(divide(10,0))
    println(divide(10,2))

    // .2
    val me = Person(name = "Andres", visitedCities = listOf("Mexico", null, "Brasil"))

//    me.visitedCities?.forEach {
//        println("Cities -> ${it ?: throw IllegalArgumentException("Ciudad vacía")}")
//    }

    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }

    val you = Person()
    val name = you.name ?: fail("No existe nombre")
    println(name)

 */