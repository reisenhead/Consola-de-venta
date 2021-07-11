package retosFinalyPostwork.s1

import java.util.Scanner
fun login(user: String, pass:String): Boolean{
    var email:String
    var password:String
    email= user
    password = pass
    if(email=="bedu" && password=="hola"){
        println("Inicio de sesión exitoso")
        return true
    } else{
        println("email o contraseña incorrecto")
        return false
    }
}
fun main(){
    var user = Scanner(System.`in`)
    var pass = Scanner(System.`in`)
    var email:String
    var password:String
    var funcion:String; ("")

    println("Escribe tu usuario")
    email = user.nextLine()
    println("Escribe tu contraseña")
    password = pass.nextLine()

    funcion = login(email, password).toString()

    println("Bienvenido a Mercado Libre")
}