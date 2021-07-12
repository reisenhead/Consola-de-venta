package controllers

import iniciarSesion
import menuInicio
import models.Cliente
import models.Usuario
import validate
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


fun cargarUsuariosClientes(usuariosClientes: MutableMap<Usuario, Cliente>): MutableMap<Usuario, Cliente> {
    val usuarioBeto = Usuario(1, "Beto","toor")
    val beto =Cliente(usuarioBeto.getIdUsuario(),1,"Beto","Santander","beto.santander@gmail.com")
    usuarioBeto.setUsuario(generarUsuario(beto.getNombre(),beto.getApellidos()))
   // println("User: ${usuarioBeto.getUsuario()}")
    val usuarioJose = Usuario(2, "Chee","toor")
    val jose =Cliente(usuarioJose.getIdUsuario(),2,"Jose J","Calderon C","josechee.unp@gmail.com")
    usuarioJose.setUsuario(generarUsuario(jose.getNombre(),jose.getApellidos()))
    //println("USer: ${usuarioJose.getUsuario()}")
    val usuariosMap: MutableMap<Int, Usuario> = mutableMapOf()
    val clientesMap: MutableMap<Int,Cliente> = mutableMapOf()
    usuariosMap[usuarioBeto.getIdUsuario()] = usuarioBeto
    usuariosMap[usuarioJose.getIdUsuario()] = usuarioJose

    clientesMap[beto.getIdCliente()] = beto
    clientesMap[jose.getIdCliente()] = jose

    usuariosClientes.put(usuarioBeto,beto)
    usuariosClientes.put(usuarioJose,jose)

    /*
    * User: SAB2021
    * User: CACJOJ2021
     */
     return usuariosClientes
}

fun registrarNuevoUsuarioCliente(){
    fun creandoNuevoUsuario(nuevoUsuario:Usuario, nuevoCliente:Cliente, usuariosCliente: MutableMap<Usuario, Cliente>){
        println("Creando usuario........")
        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
        nuevoCliente.mostrarDatosNuevoUsuario(nuevoUsuario,nuevoCliente)
        usuariosCliente.put(nuevoUsuario,nuevoCliente)
        menuInicio(nuevoUsuario,nuevoCliente)
    }
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)
    println("----------Completa tus datos---------:\n")
    var nombre:String
    var apellidos:String
    var email:String
    var clave:String
    /*Comprobar quer los datos ingresados sean lo mas reales possible (no numericos)*/
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

    /*Inicio instanciando nuevos objetos*/
     val nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
     val nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
    nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
    /*Fin instanciando nuevos objetos*/

    if(!isEmailValid(email) || existeCorreo(usuariosCliente, email)) {
        email = verificacionDelEmailDelNuevoUSuario(usuariosCliente, email)
        nuevoCliente.setEmail(email)
        creandoNuevoUsuario(nuevoUsuario, nuevoCliente, usuariosCliente)
    }else{
            creandoNuevoUsuario(nuevoUsuario,nuevoCliente,usuariosCliente)
    }
   println("Tamanio de la dataClass de los usuarios actualmente: ${usuariosCliente.size}")
}

fun verificacionDelEmailDelNuevoUSuario(usuariosCliente :MutableMap<Usuario, Cliente>,emailCorrecto:String):String {
    var email:String
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
            while(isInt(opcion)=="" || !rangoOpcionValido(opcion)){
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
                    } else {
                        if (existeCorreo(usuariosCliente, email)) {
                            do {
                                println(
                                    "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                            " o ya existe una cuenta con este e-mail:"
                                )
                                println("Email:")
                                email = readLine()!!
                            } while (!validate(email) || existeCorreo(usuariosCliente, email));
                        }
                    }
                }
            }
        }
    } else {
        if (existeCorreo(usuariosCliente, email)) {
            println("*** Ya existe una cuenta con: $email.***")
            println("*  Por favor selecciona una opcion:                    *")
            println("*  1- Ingresa a tu cuenta:                             *")
            println("*  2- Usar otro e-mail:                                *")
            var opcion = readLine()!!
            while(isInt(opcion)=="" || !rangoOpcionValido(opcion)){
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
                        if (existeCorreo(usuariosCliente, email) || !validate(email) || !isEmailValid(email)) {
                            do {
                                println(
                                    "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                            " o ya existe una cuenta con este e-mail:"
                                )
                                println("Email:")
                                email = readLine()!!
                            } while (!validate(email) || existeCorreo(usuariosCliente, email) || !isEmailValid(email));
                        }
                    } else {
                        if (existeCorreo(usuariosCliente, email) || !validate(email) || !isEmailValid(email)) {
                            do {
                                println(
                                    "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                            " o ya existe una cuenta con este e-mail:"
                                )
                                println("Email:")
                                email = readLine()!!
                            } while (!validate(email) || existeCorreo(usuariosCliente, email) || !isEmailValid(email));
                        }
                    }
                }
            }
        }
    }
    return email
}

fun isInt(valor:String):Any{
    try {
        return  valor.toInt()
    } catch(e: Exception){
        return ""
    }
}
/*
fun isString():Any{

}*/

fun rangoOpcionValido(valor:String):Boolean{
    var result:Boolean = false
    try {
        if(valor.toInt() in 1..2){
            result = true
        }
    } catch(e: Exception){
    }
    return result
}

fun rangoOpcionValidoMenuDatosCliente(valor:String):Boolean{
    var result:Boolean = false
    try {
        if(valor.toInt() in 1..4){
            result = true
        }
    } catch(e: Exception){
    }
    return result
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

    for ((_, cliente) in usuariosClientes) {
        if (cliente.getEmail().equals(email)) {
            existe=true
        }
    }
    return existe
}

fun existeNumeroTelefonico(usuariosClientes: MutableMap<Usuario, Cliente>,numeroTelefonico:String):Boolean{
    var existe=false
    for ((_, value) in usuariosClientes) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/
        if (value.getNumeroTelefonico().equals(numeroTelefonico)) {
            existe=true
        }
    }
    return existe
}

fun obtenerNombreAmostrar(usuariosClientes: MutableMap<Usuario, Cliente>,user:String):String{
    var nombre: String =""
    for ((key, value) in usuariosClientes) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/
        if (key.getUsuario().equals(user) || value.getEmail().equals(user)||value.getNumeroTelefonico().equals(user)) {
            nombre=value.getNombre()
        }
    }
    return nombre
}

fun obtenerUsuarioEnSesion(usuariosClientes: MutableMap<Usuario, Cliente>, nombreDelUsuarioEnSesion:String):Usuario{
    var usuarioEnSesion = Usuario(0,"","")
    for ((key, value) in usuariosClientes) {
        if (key.getUsuario().equals(nombreDelUsuarioEnSesion) || value.getEmail().equals(nombreDelUsuarioEnSesion) || value.getNumeroTelefonico().equals(nombreDelUsuarioEnSesion)) {
            usuarioEnSesion=key
        }
    }
    return usuarioEnSesion
}

fun obtenerClienteEnSesion(usuariosClientes: MutableMap<Usuario, Cliente>, nombreDelClienteEnSesion:String):Cliente{
    var clienteEnSesion = Cliente(0,0,"","","")
    for ((key, value) in usuariosClientes) {
        if (key.getUsuario().equals(nombreDelClienteEnSesion) || value.getEmail().equals(nombreDelClienteEnSesion) || value.getNumeroTelefonico().equals(nombreDelClienteEnSesion)) {
            clienteEnSesion=value
        }
    }
    return clienteEnSesion
}


fun datosPersonalesDelCliente(usuarioEnSesion:Usuario,clienteEnSesion:Cliente) {
    clienteEnSesion.mostrarDatosDelCliente(usuarioEnSesion, clienteEnSesion)

    println("********************************************************")
    println("*  Por favor selecciona una opcion:                    *")
    println("*  1- Actualizar Datos de Usuario:                     *")
    println("*  2- Actualizar Datos del Cliente:                    *")
    println("*  3- Regresar al menu principal:                      *")
    println("*  4- Salir de la aplicacion:                          *")
    println("********************************************************")
    var opcion = readLine()!!
    while (isInt(opcion) == "" || !rangoOpcionValidoMenuDatosCliente(opcion)) {
        clienteEnSesion.mostrarDatosDelCliente(usuarioEnSesion, clienteEnSesion)
        println("*Solo puede ingresar un valor numerico, entre 1 y 4    ")
        println("********************************************************")
        println("*  Por favor selecciona una opcion:                    *")
        println("*  1- Actualizar Datos de Usuario:                     *")
        println("*  2- Actualizar Datos del Cliente:                    *")
        println("*  3- Regresar al menu principal:                      *")
        println("*  4- Salir de la aplicacion:                          *")
        println("********************************************************")
        opcion = readLine()!!
    }
    when (Integer.parseInt(opcion)) {
        1 -> {
            actualizarDatosUsuario(usuarioEnSesion,clienteEnSesion)
        }
        2 -> {
            actualizarDatosCliente(usuarioEnSesion,clienteEnSesion)
        }
        3 -> {
            menuInicio(usuarioEnSesion,clienteEnSesion)
        }
        4 -> {
            print("GRACIAS; REGRESA PRONTO")
        }
    }

}

fun actualizarDatosUsuario(usuario:Usuario,cliente:Cliente){
    val usuariosClientes: MutableMap<Usuario, Cliente> =mutableMapOf()
    usuariosClientes.put(usuario,cliente)
    println("Para continuar por favor, ingresa tu clave o contraseña")
    var claveIngresado = readLine()!!
    while(!isContraseniaCorrecta(usuariosClientes,claveIngresado)) {
        println("Clave incorrecta...")
        println("Por favor ingresa tu clave, esto con la finalidad de tener siempre seguridad con tu cuenta de usuario\n")
        println("Clave o Contraseña:")
        claveIngresado = readLine()!!
    }
        println("Nombre de Usuario: ${usuario.getUsuario()}")
        println("Deseas cambiar el nombre de usuario? si/no")
        var opcion = readLine()!!
        var valor: String
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa tu nuevo Usuario:")
            valor = readLine()!!
            while (!validate(valor)) {
                println("Ingresa tu nuevo Usuario:")
                val opcion = readLine()!!
            }
            usuario.setUsuario(valor)
        }
        println("Deseas cambiar  tu contraseña? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa tu nueva Contraseña:")
            var pasword = readLine()!!
            while (!(validate(pasword))) {
                println("Nueva contraseña:")
                pasword = readLine()!!
            }
            usuario.setContrasenia(pasword)
        }
        datosPersonalesDelCliente(usuario, cliente)

}

fun actualizarDatosCliente(usuario:Usuario,cliente:Cliente){
    val usuariosClientes: MutableMap<Usuario, Cliente> =mutableMapOf()
    usuariosClientes.put(usuario,cliente)
    println("Para continuar por favor, ingresa tu clave o contraseña")
    var claveIngresado = readLine()!!
    while(!isContraseniaCorrecta(usuariosClientes,claveIngresado)) {
        println("Clave incorrecta...")
        println("Por favor ingresa tu clave, esto con la finalidad de tener siempre seguridad con tu cuenta de usuario\n")
        println("Clave o Contraseña:")
        claveIngresado = readLine()!!
    }
    println("Nombre: ${cliente.getNombre()}")
    println("Deseas actulizar tu nombre? si/no")
    var opcion = readLine()!!

    if("s" in opcion.lowercase(Locale.getDefault())){
        println("Ingresa tu nuevo nombre correctamente:")
        var nombre = readLine()!!
        while(!validate(nombre)) {
            println("Ingresa nombre:")
            nombre = readLine()!!
        }
        cliente.setNombre(nombre)
    }
    println("Apellidos: ${cliente.getApellidos()}")
    println("Deseas actualizar  tus Apellidos? si/no")
    opcion = readLine()!!
    if("s" in opcion.lowercase(Locale.getDefault())) {
        println("Ingresa tus Apellidos correctamente:")
        var apellidos = readLine()!!
        while (!(validate(apellidos))) {
            println("Apellidos:")
            apellidos = readLine()!!
        }
        cliente.setApellidos(apellidos)
    }
    opcion=""
    println("E-mail: ${cliente.getEmail()}")
    println("Deseas actualizar tu E-mail? si/no")
    opcion = readLine()!!
    if("s" in opcion.lowercase(Locale.getDefault())) {
        /*dado que aun no se tiene claro la regla de negocio para esta opcion por ello aun no se implementa (por seguridad y consistencia)*/
        println("\nLo sentimos mucho :(, pero aun no se encuentra disponible la opción del cambio de e-mail:\n\n")
    }
    println("Teclee para continuar")
    opcion = readLine()!!
    if(cliente.getNumeroTelefonico() == ""){
        println("Numero Telefónico:")
        println("Actualmente no tienes un número de telefono registrado, por lo que te recomendamos agregar uno Ahora")
        println("Deseas agregar un número telefónico? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa a continuacion tu Numero Telefonico a 10 dígitos con el prefijo")
            println("Con el formato: +52 0000000000")
            var numero = readLine()!!
            while (!(validate(numero)) || !esNumeroTelefonico(numero)) {
                println("Ingrese un numero telefonico valido. CCon el formato: +52 0000000000:")
                numero = readLine()!!
            }
            cliente.setNumeroTelefonico(numero)
        }
    }else {
        opcion=""
        println(": ${cliente.getNumeroTelefonico()}")
        println("Deseas actualizar tu número telefónico? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa a continuacion tu Numero Telefonico a 10 dígitos con el prefijo")
            println("Con el formato: +52 0000000000")
            var numero = readLine()!!
            while (!(validate(numero)) || !esNumeroTelefonico(numero)) {
                println("Ingrese un numero telefonico valido. CCon el formato: +52 0000000000:")
                numero = readLine()!!
            }
            cliente.setNumeroTelefonico(numero)
        }
    }
    opcion=""
    if(cliente.getCodigoPostal() ==0){
        println("Actualmente no tienes un Codigo Postal registrado, por lo que te recomendamos agregar uno")
        println("Deseas agregar un codigo postal ahora? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa a continuacion tu codigo postal a 5 dígitos, en formato numerico")
            println("Por ejemplo: 00000")
            var codigoPostal = readLine()!!
            while (!(validate(codigoPostal)) || !esCodigoPostal(codigoPostal)) {
                println("Ingrese un Codigo Postal. Con el formato: 00000")
                codigoPostal = readLine()!!
            }
            try{
            cliente.setCodigoPostal(codigoPostal.toInt())
            }catch (e:Exception){
                println("Se produjo un error al asignar el codigo postal, lo estamos revisando....")
            }
        }
    }else {
        opcion=""
        println("Código Postal: ${cliente.getCodigoPostal()}")
        println("Deseas actualizar tu número telefónico? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa a continuacion tu codigo postal a 5 dígitos, en formato numerico")
            println("Por ejemplo: 00000")
            var codigoPostal = readLine()!!
            while (!(validate(codigoPostal)) || !esCodigoPostal(codigoPostal)) {
                println("Ingrese un Codigo Postal valido. Con el formato: 00000")
                codigoPostal = readLine()!!
            }
            try{
                cliente.setCodigoPostal(codigoPostal.toInt())
            }catch (e:Exception){
                println("Se produjo un error al asignar el codigo postal, lo estamos revisando....")
            }
        }
    }

    opcion=""
    if(cliente.getDireccion()==""){
        println("No tienes una dirección registrado por lo que te recomendamos agregar una direccion")
        println("Deseas agregar una dirección ahora? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa a continuacion tu dirección:")
            var direccion = readLine()!!
            while (!(validate(direccion))) {
                println("Ingrese una direccion valida")
                direccion = readLine()!!
            }
            cliente.setDireccion(direccion)
        }
    }else {
        opcion=""
        println("Código Postal: ${cliente.getCodigoPostal()}")
        println("Deseas actualizar tu número telefónico? si/no")
        opcion = readLine()!!
        if ("s" in opcion.lowercase(Locale.getDefault())) {
            println("Ingresa a continuacion tu direccion")
            var direccion = readLine()!!
            while (!(validate(direccion)) || !esCodigoPostal(direccion)) {
                println("Ingrese una direccion valida:")
                direccion = readLine()!!
            }
            cliente.setDireccion(direccion)
        }
    }
    datosPersonalesDelCliente(usuario,cliente)
}

fun isIntCaracter(valor:String):Any{
    var result:Boolean = false
    try {
        return  Integer.parseInt(valor)
    } catch(e: Exception){
        return ""
    }
}

fun esNumeroTelefonico(numero:String):Boolean{
    var esNumeroTelefono:Boolean=false
    if(numero.length==14){
        try{
            var partesNumero = numero.toCharArray()
            var subCadena1 = numero.split(" ")
            if(subCadena1[0].equals("+52")){
                var bandera:Int =0
                subCadena1[1].forEach {
                    if(isIntCaracter(it.toString())!=""){
                        bandera++
                    }
                }
                if(bandera==10){
                    esNumeroTelefono = true
                }

            }}catch(e: Exception){
            esNumeroTelefono = false
        }
    }
    return esNumeroTelefono
}


fun esCodigoPostal(codigoPostal:String):Boolean{
    var esNumeroTelefono:Boolean=false
    if(codigoPostal.length==5){
        try{
            var bandera:Int =0
            codigoPostal.forEach {

                if(isIntCaracter(it.toString())!=""){
                    bandera++
                }
            }
            if(bandera==5){
                esNumeroTelefono = true
            }

        }catch(e: Exception){
            esNumeroTelefono = false
        }
    }
    return esNumeroTelefono
}