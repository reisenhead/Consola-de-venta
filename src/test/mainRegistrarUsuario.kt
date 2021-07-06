package test


import `mercadolibre eq3`.Producto
import controllers.*
import models.Cliente
import models.Usuario
import models.UsuarioDataClass

import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()

    registrarNuevoUsuarioCliente()

}


