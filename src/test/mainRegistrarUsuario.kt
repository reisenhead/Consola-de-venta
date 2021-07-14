package test


import controllers.*

fun main() {
    //   var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()

    //registrarNuevoUsuarioCliente()
/*
    var opcion = readLine()!!
  //  println(opcion)
 //   println(isInt(opcion))
    if(isInt(opcion)==""){
        println("isInt() = ''? -> ${isInt(opcion)}")
    }else{
        println(isInt(opcion))
    }*/
    var cadena:String = "859p1"
    println(esCodigoPostal(cadena))

}

fun isInt(valor:String):Any{
    var result:Boolean = false
    try {
        return  Integer.parseInt(valor)
    } catch(e: Exception){
        return ""
    }
}

