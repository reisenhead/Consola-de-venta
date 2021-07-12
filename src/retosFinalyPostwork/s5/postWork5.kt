package retosFinalyPostwork.s5

// En el proyecto

// Poswork 5

/* Utlizacion de datos al cliente de su registro correo electronico, nombre, apellido, clave,
   generandole un usuario como en la aplicacion de mercado libre, ademas de utilizar clases en
   esta parte
*
* */

//  fragmento tomado del package controllers archivo ClienteController

//
//fun registrarNuevoUsuarioCliente(){
//    fun creandoNuevoUsuario(nuevoUsuario: Usuario, nuevoCliente: Cliente, usuariosCliente: MutableMap<Usuario, Cliente>){
//        println("Creando usuario........")
//        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
//        nuevoCliente.mostrarDatosNuevoUsuario(nuevoUsuario,nuevoCliente)
//        usuariosCliente.put(nuevoUsuario,nuevoCliente)
//        menuInicio()
//    }
//    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
//    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)
//    println("----------Completa tus datos---------:\n")
//    var nombre:String =""
//    var apellidos:String =""
//    var email:String =""
//    var clave:String =""
//    do {
//        println("Nombre:")
//        nombre = readLine()!!
//    }while(!(validate(nombre)))
//    do {
//        println("Apellidos:")
//        apellidos = readLine()!!
//    }while(!(validate(apellidos)))
//    do {
//        println("Email:")
//        email = readLine()!!
//    }while(!(validate(email)))
//
//    do {
//        println("Clave:")
//        clave = readLine()!!
//    }while(!(validate(clave)))
//
//    /*Inicio instanciando nuevos objetos*/
//    var nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
//    var nuevoCliente = Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
//    nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
//    /*Fin instanciando nuevos objetos*/
//
//    if(!isEmailValid(email) || existeCorreo(usuariosCliente, email)) {
//        email = verificacionDelEmailDelNuevoUSuario(usuariosCliente, email)
//        nuevoCliente.setEmail(email)
//        creandoNuevoUsuario(nuevoUsuario, nuevoCliente, usuariosCliente)
//    }else{
//        creandoNuevoUsuario(nuevoUsuario,nuevoCliente,usuariosCliente)
//    }
//    println("Tamanio de la dataClass de los usuarios actualmente: ${usuariosCliente.size}")
//}