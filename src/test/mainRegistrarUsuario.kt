package test


import `mercadolibre eq3`.Producto
import controllers.*
import models.Cliente
import models.Usuario
import models.UsuarioDataClass

import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {
 //   var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()

    //registrarNuevoUsuarioCliente()

    var opcion = readLine()!!
  //  println(opcion)
 //   println(isInt(opcion))
    if(isInt(opcion)==""){
        println("isInt() = ''? -> ${isInt(opcion)}")
    }else{
        println(isInt(opcion))
    }

}

fun isInt(valor:String):Any{
    var result:Boolean = false
    try {
      return  valor.toInt()
    } catch(e: Exception){
        return ""
    }
}

