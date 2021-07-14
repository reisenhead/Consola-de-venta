package test

import controllers.menuPagoInciandoPago
import controllers.obtenerTarjetasActuales
import models.Direccion
import models.Tarjeta
import java.util.concurrent.atomic.AtomicLong

fun main() {
    /*
    val n: Long = 1234567891234567
    val nombreApellido:String ="Jose Juan Calderon Castillo"
    println(nombreApellido)
    menuPagoInciandoPago()*/

    val direccion= Direccion("Jose Calderon",
        96584,
        "DF",
        "Iztapalapa",
        "","",
        0,
        0,
        "",
    "",
    "Casa",
    "5236521456",
    "Casa de cxolor azul dos plantas")

    println("nombre apellido: ${direccion.nombreApellido}")
    println("Municipio/Alcaldia: ${direccion.municipioAlcaldia}")
    println("casa o trabajo: ${direccion.casaTrabajo}")
    direccion.casaTrabajo="Trabajo"
    println("casa o trabajo: ${direccion.casaTrabajo}")

    var tarjetasDeLosClientes: ArrayList<Tarjeta> = obtenerTarjetasActuales()
    tarjetasDeLosClientes.forEach{
        println("Tipo Tarjeta: ${it.getTipoTarjeta()}")
        println("Descripcion Tarjeta: ${it.getDescripcionTarjeta()}")
        println("Numero Tarjeta: ${it.getNumeroTarjeta()}")
        println("Fecha de Expiracion: ${it.getFechaDeExpriracion()}")
    }


}