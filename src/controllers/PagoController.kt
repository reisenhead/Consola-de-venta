package controllers

import models.*
import validate
import java.util.*

fun menuPagoInciandoPago(pago:Pago,cliente:Cliente){
    println("PAgo-> total a pagar: ${pago.getTotalApagar()}")
    println("Cliente -> Nombre: ${cliente.getNombre()}")
    println("idCliente: ${cliente.getIdCliente()}")
    println("*************************************************")
    println("*                                               *")
    println("*        Preparando todo para tu compra         *")
    println("*                                               *")
    println("*************************************************")
    println("\n")
    opcionDeRecibidoDeLCompra(pago,cliente)
}

fun opcionDeRecibidoDeLCompra(pago:Pago,cliente:Cliente){
    println("\n\n            LO MEJOR ESTÁ LLEGANDO")
    println("******    Como quieres recibir tu compra?   ******")
    println("*      1- Enviar a mi domicilio                  *")
    println("*      2- Retiro en sucursal de paqueteria       *")
    println("**************************************************")
    println("Selecciona una opcion")
    var opcion = readLine()?.toInt()
    while(!rangoOpcionValido(opcion.toString())){
        println("Usted tiene solo dos opciones, es decir solo puede seleccionar 1 o 2, unicamente")
        println("Ingrese una opcion a continucacion:")
        opcion = readLine()?.toInt()
    }
    when (opcion) {
        1 -> enviarAmiDomicilio(pago,cliente)
        2 -> retirarEnSucursalDePaqueteria(pago,cliente)
    }
}

fun enviarAmiDomicilio(pago: Pago,cliente:Cliente){
    println("************AGREGA UN DOMICILIO************\n\n")
    println("Nombre y apellido -> Tal cual figure en el INE o IFE:")
    var nombre:String= readLine()!!
    while (!validate(nombre)) {
        println("Nombre y apellido -> Tal cual figure en el INE o IFE:")
        nombre = readLine()!!
    }
    println()
    println("Codigo Postal:")
    var codigoPostal:Int = readLine()!!.toInt()
    while (!(validate(codigoPostal.toString())) || !esCodigoPostal(codigoPostal.toString())) {
        println("Ingrese un Codigo Postal valido. Con el formato: 00000")
        codigoPostal = readLine()!!.toInt()
    }

    println()
    println("Estado:")
    var estado:String= readLine()!!
    while (!validate(estado)) {
        println("Ingrese el Estado:")
        estado = readLine()!!
    }

    println()
    println("Municipio/Alcaldia:")
    var municipioAlcaldia:String= readLine()!!
    while (!validate(municipioAlcaldia)) {
        println("Ingrese el Municipio o Alcaldia:")
        municipioAlcaldia = readLine()!!
    }

    println()
    println("Colonia:")
    var colonia:String= readLine()!!
    while (!validate(colonia)) {
        println("Ingrese la Colonia:")
        colonia = readLine()!!
    }
    println()
    println("Calle:")
    var calle:String= readLine()!!
    while (!validate(calle)) {
        println("Ingrese la Calle:")
        calle = readLine()!!
    }

    println()
    println("Numero exterior:")
    println("Tienes Numero exterior si/no")
    var opcion = readLine()!!
    var numeroExterior: Int?=null
    if ("s" in opcion.lowercase(Locale.getDefault())) {
        println("Ingresa tu numero exterior:")
        numeroExterior = readLine()!!.toInt()
        while (!validate(numeroExterior.toString()) || isInt(numeroExterior.toString())=="") {
            println("Ingresa tu numero exterior:")
            val numeroExterior = readLine()!!
        }
    }

    println()
    opcion=""
    println("Numero exterior:")
    println("Tienes Numero interior/Depto? si/no")
    opcion = readLine()!!
    var numeroInterior: Int?=null
    if ("s" in opcion.lowercase(Locale.getDefault())) {
        println("Ingresa tu numero interior:")
        numeroInterior = readLine()!!.toInt()
        while (!validate(numeroInterior.toString()) || isInt(numeroInterior.toString())=="") {
            println("Ingresa tu numero interior:")
            val numeroInterior = readLine()!!
        }
    }
    /////////////
    println()
    opcion=""
    println("Entre que calles esta?")
    println("Quieres agregar las calles? si/no")
    opcion = readLine()!!
    var calle1: String?=null
    var calle2:String?=null
    if ("s" in opcion.lowercase(Locale.getDefault())) {
        println("Ingresa la calle 1:")
        calle1 = readLine()!!
        while (!validate(calle1)) {
            println("Ingresa el nombre de la primer calle en que estas:")
            val calle1 = readLine()!!
        }

        println("Ingresa la calle 2:")
        calle2 = readLine()!!
        while (!validate(calle1)) {
            println("Ingresa el nombre de la segunda calle en que estas:")
            val calle2 = readLine()!!
        }
    }
    /////////////////
    println()
    println("Es tu Trabajo o Casa?. Ingresa tu respuesta:")
    var casaTrabajo = readLine()!!
    while (!validate(casaTrabajo)){
        println("Es tu Trabajo o Casa?. Ingresa tu respuesta:")
        casaTrabajo = readLine()!!
    }
    println()
    println("Ingresa a continuacion tu Numero de contacto a 10 dígitos con el prefijo")
    println("Con el formato: +52 0000000000")
    var numeroDeContacto = readLine()!!
    while (!(validate(numeroDeContacto)) || !esNumeroTelefonico(numeroDeContacto)) {
        println("Ingrese un numero de contacto valido. Con el formato: +52 0000000000:")
        numeroDeContacto = readLine()!!
    }
    println()
    println("Ingrese indicaciones adicionales para entregar tus compras en esta dirección.")
    println("Por ejemplo-> Descripcion de la fachada de referencia para encontrarla, indicaciones de seguridad, etc.")
    var indicacionesAdicionales = readLine()!!
    while (!(validate(indicacionesAdicionales))){
        println("Ingrese indicaciones adicionales para entregar tus compras en esta dirección.")
        println("Por ejemplo-> Descripcion de la fachada de referencia para encontrarla, indicaciones de seguridad, etc:")
        indicacionesAdicionales = readLine()!!
    }

    val direccion=Direccion(nombre,
        codigoPostal,
        estado,
        municipioAlcaldia,
        colonia,
        calle,
        numeroExterior,
        numeroInterior,
        calle1,
        calle2,
        casaTrabajo,
        numeroDeContacto,
        indicacionesAdicionales)

    confirmarDomilicioEnElMapa(direccion,pago,cliente)

}

fun confirmarDomilicioEnElMapa(direccion: Direccion,pago:Pago,cliente:Cliente){
    println("************CONFIRMA TU DOMICILIO CON LOS DATOS A CONTINUCACIÓN************\n\n")
    println("Es aqui el domicilio de envio?")
    if(direccion.calle1!=null){
        println("Calle ${direccion.calle} entre ${direccion.calle1} y ${direccion.calle2}")
    }else {
        println("Calle ${direccion.calle}")
    }
    println()
    println("${direccion.estado}, ${direccion.colonia}, ${direccion.municipioAlcaldia}")
    println("Codigo Postal: ${direccion.codigoPostal}")

    println("**************************************************")
    println("*      1- EDITAR                                 *")
    println("*      2- CONFIRMAR                              *")
    println("**************************************************")
    var opcion:String= readLine()!!
    while (!validate(opcion) || isInt(opcion) == "" || !rangoOpcionValido(opcion)){
        println("Ingresa una opcion correcta. Ingrese 1 o 2:")
        opcion = readLine()!!
    }
    when (opcion.toInt()) {
        1 -> enviarAmiDomicilio(pago,cliente)
        2 -> confirmandoCompra(pago,direccion,cliente)
    }

}

fun confirmandoCompra(pago:Pago,direccion:Direccion,cliente:Cliente){
    println("************¿COMO QUIERES RECIBIR O RETIRAR TU COMPRA?************\n\n")
    println("Domicilio:")
    println("C.P. ${direccion.codigoPostal}")
    if(direccion.calle1!=null){
        println("${direccion.calle} entre ${direccion.calle1} y ${direccion.calle2}")
    }
    println("${direccion.calle} - ${direccion.indicaciones}")
    println("${direccion.nombreApellido} - ${direccion.numeroDeContacto}")
    println()
    println("Recibir compra:")
    println("--> Llega mañana ------------------ $99")
    println("Llega el domingo 18 de julio ------ $99")
    println("Llega entre el 15 y 17 de julio --- $99")
    println()
    println("Retirar compra:")
    println("Llega mañana ---------------------- $99")
    println("Llega el domingo 18 de julio ------ $99")
    println("Llega entre el 15 y 17 de julio --- $99")

    println("\n")
    println("**************************************************")
    println("*      1- EDITAR DIRECCION                       *")
    println("*      2- EDITAR OPCION DE ENVIO                 *")
    println("*      3- CONTINUAR                              *")
   //
    println("**************************************************")
    var opcion:String= readLine()!!
    while (!validate(opcion) || isInt(opcion) == "" || !rangoOpcionValidoConfirmandoCompra(opcion)){
        println("Ingresa una opcion correcta. Ingrese 1, 2 0 3:")
        opcion = readLine()!!
    }
    when (opcion.toInt()) {
        1 -> enviarAmiDomicilio(pago,cliente)
        2 -> opcionDeRecibidoDeLCompra(pago,cliente)
        3 -> comoQuieresPagar(pago,cliente)
    }

}
/*Aqui comprobar si el cliente tiene tarjetas agregadas en la appp*/
fun comoQuieresPagar(pago:Pago,cliente:Cliente){
    println("************¿COMO QUIERES PAGAR?************\n\n")
    println("Con Mercado Pago\n")
    var tarjetasDelCliente= obtenerTarjetasDelCliente(cliente.getIdCliente())
    if(tarjetasDelCliente!=null){
        tarjetasDelCliente.forEach{
            println("-------------------------------------")
            println("${it.getDescripcionTarjeta()}")
            println("${it.getNumeroTarjeta()}")
            println("-------------------------------------")
        }
        println("\n")
        println("1- Selecionar Tarjeta")
    }

    println("2 - Nueva tarjeta de credito")
    println("3-  Nueva trajeta de debito")
    var opcion:String= readLine()!!
    while (!validate(opcion) || isInt(opcion) == "" || !rangoOpcionValidoConfirmandoCompra(opcion)){
        println("Ingresa una opcion correcta. Ingrese un numero valido")
        opcion = readLine()!!
    }
    when (opcion.toInt()) {
        1 -> seleccionarTarjeta(pago,tarjetasDelCliente,cliente)
        2 -> agregarNuevaTarjetaDeCredito(pago,cliente)
        3 -> agregarNuevaTarjetaDeDebito(pago,cliente)
    }
}

fun agregarNuevaTarjetaDeCredito(pago:Pago,cliente: Cliente){
   // var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    //usuariosCliente =  cargarUsuariosClientes(usuariosCliente)

    println("Ingresa la compania o descripcion de la tarjeta. Por ejemplo->Santander, Banamex, Bancomer, Azteca, etcetera")
    var descripcionTarjeta:String= readLine()!!
    while (!validate(descripcionTarjeta)){
        println("Ingresa una opcion correcta. Ingrese un numero valido")
        descripcionTarjeta = readLine()!!
    }
    println("Ingresa el numero de la tarjeta a 16 digitos")
    println("Con el formato: 1234567891234567")
    var numeroTarjeta:String= readLine()!!
    while (!validate(numeroTarjeta) || !esNumeroDeTarjeta(numeroTarjeta)){
        println("Ingresa el numero de la tarjeta a 16 digitos")
        println("Con el formato: 1234567891234567")
        numeroTarjeta = readLine()!!
    }
    println("Ingresa el nombre y apellido que aparece en la tarjeta")
    var nombreApellido:String= readLine()!!
    while (!validate(nombreApellido)){
        println("Ingresa el nombre y apellido que aparece en la tarjeta")
        nombreApellido = readLine()!!
    }
    println("Ingresa la fecha de expiracion que aparece en la tarjeta.")
    println("Con el formato MM/AA. Por ejemplo 07/22")
    var fechaExpiracion:String= readLine()!!
    while (!validate(fechaExpiracion)){
        println("Ingresa el nombre y apellido que aparece en la tarjeta")
        fechaExpiracion = readLine()!!
    }
    println("Ingresa el codigo de seguridad que aparece al reverso de la tarjeta.")
    println("Con el formato 000")
    var codigoDeSeguridad:String= readLine()!!
    while (!validate(codigoDeSeguridad) || !esCodigodeSeguridad(codigoDeSeguridad)){
        println("Ingresa el codigo de seguridad que aparece al reverso de la tarjeta.")
        println("Con el formato 000")
        codigoDeSeguridad = readLine()!!
    }
    val nuevaTarjetaDeCredito = Tarjeta(cliente.getIdCliente(), 1, descripcionTarjeta,numeroTarjeta.toLong(), nombreApellido, fechaExpiracion, codigoDeSeguridad.toInt())

   // println(pago.getListadoCarrito())
    println("Tu compra:")
    pago.getListadoCarrito().forEach{
        println(it)

    }
    println("Pagas: $ ${pago.getTotalApagar()} MXN")
    println("De tu tarjeta de Debito")
    println("De ${nuevaTarjetaDeCredito.getDescripcionTarjeta()}")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Pago Exitoso")
    println("\n\n")
    println("Muchas gracias ${cliente.getNombre()} por comprar en Mercado Libre\n")
    println("CODO A CODO EN LAS DIFÍCILES HASTA QUE LLEGUE LO MEJOR")
    println("SEGUIMOS TRABAJANDO para ayudarte a comprar sin salir de tu casa y preservar el bienestar de todos")
    println("\n\n\n")
    println("El Equipo 3, tiene todo para llegar a la etapa Final.")

}

fun agregarNuevaTarjetaDeDebito(pago:Pago,cliente: Cliente){
    // var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    //usuariosCliente =  cargarUsuariosClientes(usuariosCliente)

    println("Ingresa la compania o descripcion de la tarjeta. Por ejemplo->Santander, Banamex, Bancomer, Azteca, etcetera")
    var descripcionTarjeta:String= readLine()!!
    while (!validate(descripcionTarjeta)){
        println("Ingresa una opcion correcta. Ingrese un numero valido")
        descripcionTarjeta = readLine()!!
    }
    println("Ingresa el numero de la tarjeta a 16 digitos")
    println("Con el formato: 1234567891234567")
    var numeroTarjeta:String= readLine()!!
    while (!validate(numeroTarjeta) || !esNumeroDeTarjeta(numeroTarjeta)){
        println("Ingresa el numero de la tarjeta a 16 digitos")
        println("Con el formato: 1234567891234567")
        numeroTarjeta = readLine()!!
    }
    println("Ingresa el nombre y apellido que aparece en la tarjeta")
    var nombreApellido:String= readLine()!!
    while (!validate(nombreApellido)){
        println("Ingresa el nombre y apellido que aparece en la tarjeta")
        nombreApellido = readLine()!!
    }
    println("Ingresa la fecha de expiracion que aparece en la tarjeta.")
    println("Con el formato MM/AA. Por ejemplo 07/22")
    var fechaExpiracion:String= readLine()!!
    while (!validate(fechaExpiracion)){
        println("Ingresa el nombre y apellido que aparece en la tarjeta")
        fechaExpiracion = readLine()!!
    }
    println("Ingresa el codigo de seguridad que aparece al reverso de la tarjeta.")
    println("Con el formato 000")
    var codigoDeSeguridad:String= readLine()!!
    while (!validate(codigoDeSeguridad) || !esCodigodeSeguridad(codigoDeSeguridad)){
        println("Ingresa el codigo de seguridad que aparece al reverso de la tarjeta.")
        println("Con el formato 000")
        codigoDeSeguridad = readLine()!!
    }
    val nuevaTarjetaDeCredito = Tarjeta(cliente.getIdCliente(), 1, descripcionTarjeta,numeroTarjeta.toLong(), nombreApellido, fechaExpiracion, codigoDeSeguridad.toInt())

    // println(pago.getListadoCarrito())
    println("Tu compra:")
    pago.getListadoCarrito().forEach{
        println(it)
    }
    println("Pagas: $ ${pago.getTotalApagar()} MXN")
    println("De tu tarjeta de Debito")
    println("De ${nuevaTarjetaDeCredito.getDescripcionTarjeta()}")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Realizando pago....")
    println("Pago Exitoso")
    println("\n\n")
    println("Muchas gracias ${cliente.getNombre()} por comprar en Mercado Libre\n")
    println("CODO A CODO EN LAS DIFÍCILES HASTA QUE LLEGUE LO MEJOR")
    println("SEGUIMOS TRABAJANDO para ayudarte a comprar sin salir de tu casa y preservar el bienestar de todos")
    println("\n\n\n")
    println("El Equipo 3, tiene todo para llegar a la etapa Final.")

}

fun esNumeroDeTarjeta(numeroTarjeta:String):Boolean{
    var esNumeroDeTarjeta:Boolean=false
    if(numeroTarjeta.length==16){
        try{
            var bandera:Int =0
            numeroTarjeta.forEach {

                if(isIntCaracter(it.toString())!=""){
                    bandera++
                }
            }
            if(bandera==16){
                esNumeroDeTarjeta = true
            }

        }catch(e: Exception){
            esNumeroDeTarjeta = false
        }
    }
    return esNumeroDeTarjeta
}

fun esCodigodeSeguridad(codigoDeSeguridad:String):Boolean{
    var esCodigoDeSeguridad:Boolean=false
    if(codigoDeSeguridad.length==3){
        try{
            var bandera:Int =0
            codigoDeSeguridad.forEach {

                if(isIntCaracter(it.toString())!=""){
                    bandera++
                }
            }
            if(bandera==3){
                esCodigoDeSeguridad = true
            }

        }catch(e: Exception){
            esCodigoDeSeguridad = false
        }
    }
    return esCodigoDeSeguridad
}


fun seleccionarTarjeta(pago:Pago,tarjetas:ArrayList<Tarjeta>,cliente:Cliente){
    var contador:Int=1

    if(tarjetas!=null){
        tarjetas.forEach{
            println("Tarjeta $contador:")
            println("${it.getDescripcionTarjeta()}")
            println("${it.getNumeroTarjeta()}")
            contador++
            println()
        }
        println("\n")
        println(" Ingresa el numero de la tarjeta a seleccionar por ejemplo: 1, 2, 3 ")
        var opcion:String= readLine()!!
        while (!validate(opcion) || isInt(opcion) == ""){
            println("Ingresa una opcion correcta. Ingrese un numero valido")
            opcion = readLine()!!
        }
        // println(pago.getListadoCarrito())
        println("Tu compra:")
        pago.getListadoCarrito().forEach{
            println(it)
        }
        println("Pagas: $ ${pago.getTotalApagar()} MXN")
        try {
            println("De tu ${tarjetas[opcion.toInt()-1].getDescripcionTarjeta()}\n")
        }catch (e:Exception){//arreglar el bug que se esta teniendo en este bloque en relacion con el print de arriba

        }finally {
            println("Realizando pago....")
            println("Realizando pago....")
            println("Realizando pago....")
            println("Realizando pago....")
            println("Realizando pago....")
            println("Realizando pago....")
            println("Pago Exitoso")
            println("\n\n")
            println("Muchas gracias ${cliente.getNombre()} por comprar en Mercado Libre\n")
            println("CODO A CODO EN LAS DIFÍCILES HASTA QUE LLEGUE LO MEJOR")
            println("SEGUIMOS TRABAJANDO para ayudarte a comprar sin salir de tu casa y preservar el bienestar de todos")
            println("\n\n\n")
            println("El Equipo 3, tiene todo para llegar a la etapa Final.")
        }
    }
}

fun obtenerTarjetasDelCliente(idCliente:Int):ArrayList<Tarjeta>{
    var tarjetasDelCliente:ArrayList<Tarjeta> = ArrayList<Tarjeta>()
    var tarjetasDeLosClientes: ArrayList<Tarjeta> = obtenerTarjetasActuales()

    tarjetasDeLosClientes.forEach{
        if(it.getIdCliente().equals(idCliente)){
            tarjetasDelCliente.add(it)
        }
    }
    return tarjetasDelCliente
}


fun retirarEnSucursalDePaqueteria(pago:Pago,cliente:Cliente){
    val punto1:String = "Agencia Mercado Libre- Servicio Automotriz BMW\n Lun -vier: 10 am a 20:00 hrs- Sab 10 a 16 hrs"
    val punto2:String = "Agencia Mercado Libre- Papeleria The Mexican}n\n" +
            " Lun - Dom: 8 am a 20:00 hrs"
    val punto3:String = "Agencia Mercado Libre- UNPA\n" +
            "Lun -vier: 10 am a 20:00 hrs- Sab 10 a 16 hrs"
    val punto4:String = "Agencia Mercado Libre- Gamer Center\n" +
            "Lun - Sab: 7 am a 22:00 hrs - Dom 12 pm a  22 hrs"
    println("************ELIGE UN PUNTO DE RETIRO************\n\n")
    println()
    println("1 ->  $punto1 \n")
    println("2 ->  $punto2 \n")
    println("3 ->  $punto3 \n")
    println("4 ->  $punto4 \n")
    println("**************************************************")
    var opcion:String= readLine()!!
    while (!validate(opcion) || isInt(opcion) == "" || !rangoOpcionValidoMenuDatosCliente(opcion)){
        println("Ingresa una opcion correcta. Ingrese 1, 2, 3 o 4:")
        opcion = readLine()!!
    }
    when (opcion.toInt()) {
        1 -> confirmandoCompraRetirandoEnSucursal(pago,cliente,punto1)
        2 -> confirmandoCompraRetirandoEnSucursal(pago,cliente,punto2)
        3 -> confirmandoCompraRetirandoEnSucursal(pago,cliente,punto3)
        4 -> confirmandoCompraRetirandoEnSucursal(pago,cliente,punto4)
    }

    //rangoOpcionValidoMenuDatosCliente
}

fun confirmandoCompraRetirandoEnSucursal(pago:Pago,cliente:Cliente,puntoDeRetiro:String){
    println("************CONFIRMA EL PUNTO DE RETIRO************\n\n")

    println(puntoDeRetiro)
    println("\n")
    println("**************************************************")
    println("*      1- EDITAR PUNTO DE RETIRO                 *")
    println("*      2- EDITAR OPCION DE ENVIO                 *")
    println("*      3- CONTINUAR                              *")
    //
    println("**************************************************")
    var opcion:String= readLine()!!
    while (!validate(opcion) || isInt(opcion) == "" || !rangoOpcionValidoConfirmandoCompra(opcion)){
        println("Ingresa una opcion correcta. Ingrese 1, 2 0 3:")
        opcion = readLine()!!
    }
    when (opcion.toInt()) {
        1 -> retirarEnSucursalDePaqueteria(pago,cliente)
        2 -> opcionDeRecibidoDeLCompra(pago,cliente)
        3 -> comoQuieresPagar(pago,cliente)
    }
}

fun rangoOpcionValidoConfirmandoCompra(valor:String):Boolean{
    var result:Boolean = false
    try {
        if(valor.toInt() in 1..3){
            result = true
        }
    } catch(e: Exception){
    }
    return result
}
