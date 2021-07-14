package models

import java.util.concurrent.atomic.AtomicLong
/* *
**1-> Tarjeta de credito
**2-> Tarjeta de debito
* otra forma de pago -> mandar mensaje en desarrollo
* */
class Tarjeta(idCliente:Int, idTarjeta:Int,descripcionTarjeta:String, numeroTarjeta: Long,  nombreApellido:String, fechaDeExpriracion:String,codigoDeSeguridad:Int) {
    private var idCliente:Int=idCliente
    private var tipoTarjeta:Int=idTarjeta
    private var descripcionTarjeta:String=descripcionTarjeta
    private var numeroTarjeta:Long=numeroTarjeta
    private var nombreApellido:String = nombreApellido
    private var fechaDeExpriracion:String=fechaDeExpriracion
    private var codigoDeSeguridad:Int = codigoDeSeguridad
    private var saldo:Float = 0f


    constructor (idCliente: Int,idTarjeta:Int,descripcionTarjeta:String, numeroTarjeta: Long,  nombreApellido:String, fechaDeExpriracion:String,codigoDeSeguridad:Int,saldo:Float)
            : this(idCliente,idTarjeta,descripcionTarjeta,numeroTarjeta,nombreApellido,fechaDeExpriracion,codigoDeSeguridad) {
        this.saldo=saldo
    }

    fun getIdCliente():Int{
        return this.idCliente
    }
    fun setIdCliente(idCliente: Int){
        this.idCliente=idCliente
    }

    fun getTipoTarjeta():Int{
        return this.tipoTarjeta
    }
    fun setTipoTarjeta(tipoTarjeta:Int){
        this.tipoTarjeta=tipoTarjeta
    }

    fun getDescripcionTarjeta():String{
        return this.descripcionTarjeta
    }
    fun setDescripcionTarjeta(descripcionTarjeta:String){
        this.descripcionTarjeta=descripcionTarjeta
    }

    fun getNumeroTarjeta():Long{
        return this.numeroTarjeta
    }
    fun setNumeroTarjeta(numeroTarjeta:Long){
        this.numeroTarjeta=numeroTarjeta
    }

    fun getNombreApellido():String{
        return this.nombreApellido
    }
    fun setNombreApellido(nombreApellido:String){
        this.nombreApellido=nombreApellido
    }

    fun getFechaDeExpriracion():String{
        return this.fechaDeExpriracion
    }
    fun setFechaDeExpriracion(fechaDeExpriracion:String){
        this.fechaDeExpriracion=fechaDeExpriracion
    }

    fun getCodigoDeSeguridad():Int{
        return this.codigoDeSeguridad
    }
    fun setCodigoDeSeguridad(codigoDeSeguridad:Int){
        this.codigoDeSeguridad=codigoDeSeguridad
    }


}