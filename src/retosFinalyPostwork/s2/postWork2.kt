package retosFinalyPostwork.s2

import controllers.existeCorreo
import controllers.isEmailValid
import controllers.isInt
import controllers.rangoOpcionValido
import models.Cliente
import models.Usuario

// en nuestro proyecto

//PostWork 1

/* operaciones de validacion del login con if, realizando operaciones condicionales, bucles
fragmento tomado del package controllers archivo ClienteControllers*/

/*fun verificacionDelEmailDelNuevoUSuario(usuariosCliente :MutableMap<Usuario, Cliente>, emailCorrecto:String):String {
    var email:String = ""
    email = emailCorrecto
    if (!isEmailValid(email)) {
        do {
            println("Usa el formato nombre@ejemplo.com en tu email")
            println("Email:")
            email = readLine()!!
        } while (!isEmailValid(email))
        if (existeCorreo(usuariosCliente, email)) {
            println("*** Ya existe una cuenta con: $email.***")
            println("*  Por favor selecciona una opcion:                    *")
            println("*  1- Ingresa a tu cuenta:                             *")
            println("*  2- Usar otro e-mail:                                *")
            var opcion = readLine()!!
            while(isInt(opcion) =="" || !rangoOpcionValido(opcion)){
                println("Solo puede ingresar un valor numerico, es decir: 1 o 2")
                println("*  Por favor selecciona una opcion:                    *")
                println("*  1- Ingresa a tu cuenta:                             *")
                println("*  2- Usar otro e-mail:                                *")
                opcion = readLine()!!
            }
            when (Integer.parseInt(opcion)) {
                1 -> {
                    iniciarSesion()
                }
                2 -> {
                    do {
                        println("Email:")
                        email = readLine()!!
                    } while (!(validate(email)))
                    if (!isEmailValid(email)) {
                        do {
                            println("Usa el formato nombre@ejemplo.com en tu email")
                            println("Email:")
                            email = readLine()!!
                        } while (!isEmailValid(email))
                        while (!((validate(email))) || (existeCorreo(usuariosCliente, email)) || !isEmailValid(email)) {
                            println(
                                "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                        " o ya existe una cuenta con este e-mail:"
                            )
                            println("Email:")
                            email = readLine()!!
                        }
                    } else { */