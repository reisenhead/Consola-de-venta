package test


import models.Cliente
import models.Usuario
import controllers.generarUsuario
import controllers.*

fun main() {
    val usuarioBeto = Usuario(1, "Beto","toor")
    val beto =Cliente(usuarioBeto.getIdUsuario(),1,"Beto","Santander","beto.santander@gmail.com")
    usuarioBeto.setUsuario(generarUsuario(beto.getNombre(),beto.getApellidos()))
    usuarioBeto.mostrarNombreUsuario()

    val usuariojose = Usuario(2, "Chee","toor")
    val jose =Cliente(usuariojose.getIdUsuario(),2,"Jose J","Calderon C","josechee.unp@gmail.com")
    usuariojose.setUsuario(generarUsuario(jose.getNombre(),jose.getApellidos()))
    usuariojose.mostrarNombreUsuario()

    var usuariosMap: MutableMap<Int,Usuario> = mutableMapOf()
    var clientesMap: MutableMap<Int,Cliente> = mutableMapOf()
    usuariosMap[usuarioBeto.getIdUsuario()] = usuarioBeto
    usuariosMap[usuariojose.getIdUsuario()] = usuariojose

    clientesMap[beto.getIdCliente()] = beto
    clientesMap[jose.getIdCliente()] = jose

    //println(existeUsuario(usuariosMap,"CACJOJ2021"))
    /*  for ((key, value) in usuariosMap) {
          println("IdUsuario: $key")
          println("Usuario: ${value.getUsuario()}")
          var cliente = clientesMap.get(key)
          if (cliente != null) {
              println("idCliente: ${cliente.getIdCliente()}")
              println("Nombre(s) Cliente: ${cliente.getNombre()}")
              println("Apellido(s) Cliente: ${cliente.getApellidos()}")
          }
          println()
      }
      println("\n")
      /*obtener valores del Map*/
      val u = usuariosMap.get(2)
      if (u != null) {
          println(u.getIdUsuario())
          println(u.getContrasenia())
      }
      println(usuariosMap.size)*/



    //  clienteJose.setNombre("chee")
    //   clienteJose.setApellidos("Calderon")
    /* println(clienteJose.getNombre())
     println(clienteJose.getApellidos())
     println(clienteJose.getSexo())
     println(clienteJose.getIdCliente())*/
}

/*
fun existeUsuario(usuariosMap:MutableMap<Int,Usuario>,user:String):Boolean{
    var existe=false
    for ((key, value) in usuariosMap) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/
        if (value.getUsuario().equals(user)) {
            existe=true
        }
    }
    return existe
}*/

/*
fun existeCorreo(clientesMap:MutableMap<Int,Cliente>,email:String):Boolean{
    var existe=false
    for ((key, value) in clientesMap) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/
        if (value.getEmail().equals(email)) {
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
}*/
