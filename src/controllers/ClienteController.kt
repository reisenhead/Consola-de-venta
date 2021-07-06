package controllers

import iniciarSesion
import menuInicio
import models.Cliente
import models.Usuario
import models.UsuarioDataClass
import validate
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


fun cargarUsuariosClientes(usuariosClientes: MutableMap<Usuario, Cliente>): MutableMap<Usuario, Cliente> {
    val usuarioBeto = Usuario(1, "Beto","toor")
    val beto =Cliente(usuarioBeto.getIdUsuario(),1,"Beto","Santander","beto.santander@gmail.com")
    usuarioBeto.setUsuario(generarUsuario(beto.getNombre(),beto.getApellidos()))

    val usuarioJose = Usuario(2, "Chee","toor")
    val jose =Cliente(usuarioJose.getIdUsuario(),2,"Jose J","Calderon C","josechee.unp@gmail.com")
    usuarioJose.setUsuario(generarUsuario(jose.getNombre(),jose.getApellidos()))

    var usuariosMap: MutableMap<Int, Usuario> = mutableMapOf()
    var clientesMap: MutableMap<Int,Cliente> = mutableMapOf()
    usuariosMap[usuarioBeto.getIdUsuario()] = usuarioBeto
    usuariosMap[usuarioJose.getIdUsuario()] = usuarioJose

    clientesMap[beto.getIdCliente()] = beto
    clientesMap[jose.getIdCliente()] = jose

    usuariosClientes.put(usuarioBeto,beto)
    usuariosClientes.put(usuarioJose,jose)

     return usuariosClientes
}

fun registrarNuevoUsuarioCliente(){
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()

    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)
    println("----------Completa tus datos---------:\n")
    var nombre:String =""
    var apellidos:String =""
    var email:String =""
    var clave:String =""
    do {
        println("Nombre:")
        nombre = readLine()!!
    }while(!(validate(nombre)))
    do {
        println("Apellidos:")
        apellidos = readLine()!!
    }while(!(validate(apellidos)))
    do {
        println("Email:")
        email = readLine()!!
    }while(!(validate(email)))

    do {
        println("Clave:")
        clave = readLine()!!
    }while(!(validate(clave)))

    if(!isEmailValid(email)){
        do{
            println("Usa el formato nombre@ejemplo.com en tu email")
            println("Email:")
            email = readLine()!!
        }while(!isEmailValid(email))
        if(existeCorreo(usuariosCliente,email)){
            println("*** Ya existe una cuenta con: $email.***")
            println("*  Por favor selecciona una opcion:                    *")
            println("*  1- Ingresa a tu cuenta:                             *")
            println("*  2- Usar otro e-mail:                                *")
            var opcion = readLine()!!
            when(Integer.parseInt(opcion)){
                1 -> {
                    iniciarSesion()
                }
                2 -> {
                    do {
                        println("Email:")
                        email = readLine()!!
                    }while(!(validate(email)))
                    if(!isEmailValid(email)) {
                        do {
                            println("Usa el formato nombre@ejemplo.com en tu email")
                            println("Email:")
                            email = readLine()!!
                        } while (!isEmailValid(email))
                        println("Creando usuario........")

                        val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
                        val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
                        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
                        nuevoCliente.mostrarDadosNuevoUsuario(nuevoUsuario,nuevoCliente)
                        //nuevoUsuario.mostrarNombreUsuario()
                        usuariosCliente.put(nuevoUsuario,nuevoCliente)
                        menuInicio()
                    }else{
                        println("Creando usuario........")

                        val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
                        val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
                        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
                        nuevoCliente.mostrarDadosNuevoUsuario(nuevoUsuario,nuevoCliente)
                        //nuevoUsuario.mostrarNombreUsuario()
                        usuariosCliente.put(nuevoUsuario,nuevoCliente)
                        menuInicio()

                    }

                }
            }

        }else{
            println("Creando usuario........")

            val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
            val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
            nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
            nuevoCliente.mostrarDadosNuevoUsuario(nuevoUsuario,nuevoCliente)
            usuariosCliente.put(nuevoUsuario,nuevoCliente)
            menuInicio()
        }
    }else{
        if(existeCorreo(usuariosCliente,email)){
            println("*** Ya existe una cuenta con: $email.***")
            println("*  Por favor selecciona una opcion:                    *")
            println("*  1- Ingresa a tu cuenta:                             *")
            println("*  2- Usar otro e-mail:                                *")
            var opcion = readLine()!!
            when(Integer.parseInt(opcion)){
                1 -> {
                    iniciarSesion()
                }
                2 -> {
                    do {
                        println("Email:")
                        email = readLine()!!
                    }while(!(validate(email)))
                    if(!isEmailValid(email)) {
                        do {
                            println("Usa el formato nombre@ejemplo.com en tu email")
                            println("Email:")
                            email = readLine()!!
                        } while (!isEmailValid(email))
                        println("Creando usuario........")

                        val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
                        val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
                        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
                        nuevoCliente.mostrarDadosNuevoUsuario(nuevoUsuario,nuevoCliente)
                        //nuevoUsuario.mostrarNombreUsuario()
                        usuariosCliente.put(nuevoUsuario,nuevoCliente)
                        menuInicio()
                    }else{
                        println("Creando usuario........")

                        val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
                        val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
                        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
                        nuevoCliente.mostrarDadosNuevoUsuario(nuevoUsuario,nuevoCliente)
                        usuariosCliente.put(nuevoUsuario,nuevoCliente)
                        menuInicio()
                    }
                }
            }
        }else{
            println("Creando usuario........")

            val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
            val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
            nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
            nuevoCliente.mostrarDadosNuevoUsuario(nuevoUsuario,nuevoCliente)
            usuariosCliente.put(nuevoUsuario,nuevoCliente)
            menuInicio()
        }
    }
  //  println("Tamanio de la dataClass de los usuarios actualmente: ${usuariosCliente.size}")

}

fun isEmailValid(email: String): Boolean {
    var isValid = false
    //val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val expression ="(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    val inputStr: CharSequence = email
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher: Matcher = pattern.matcher(inputStr)
    if (matcher.matches()) {
        isValid = true
    }
    return isValid
}

fun existeCorreo(usuariosClientes: MutableMap<Usuario, Cliente>,email:String):Boolean{
    var existe=false

    for ((user, cliente) in usuariosClientes) {
        if (cliente.getEmail().equals(email)) {
            existe=true

        }
    }
    return existe
}

fun existeNumeroTelefonico(clientesMap:MutableMap<Int,Cliente>,numeroTelefonico:String):Boolean{
    var existe=false
    for ((key, value) in clientesMap) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/

        if (value.getNumeroTelefonico().equals(numeroTelefonico)) {
            existe=true
        }
    }
    return existe
}