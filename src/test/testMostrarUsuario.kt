package test

import controllers.cargarUsuariosClientes
import controllers.obtenerClienteEnSesion
import controllers.obtenerNombreAmostrar
import controllers.obtenerUsuarioEnSesion
import models.Cliente
import models.Usuario

fun main() {
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)
    var usuarioEnSesion=Usuario(0,"","")
    var clienteEnSesion=Cliente(0,0,"","","")
    //usuariosClienteEnSesion= obtenerClienteEnSesion(usuariosCliente, obtenerNombreAmostrar(usuariosCliente,"Beto"))
    usuarioEnSesion= obtenerUsuarioEnSesion(usuariosCliente, "josechee.unp@gmail.com")
    println(usuarioEnSesion.getUsuario())

    clienteEnSesion = obtenerClienteEnSesion(usuariosCliente,"CACJOJ2021")
    println("Nombre: ${clienteEnSesion.getNombre()}")


}