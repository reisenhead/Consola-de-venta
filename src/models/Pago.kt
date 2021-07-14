package models

import java.util.ArrayList

class Pago(idPago:Int,cliente:Cliente,listaCarrito: ArrayList<String>, totalApagar:Float, metodoPago:Int) {

    private var idPago: Int = idPago
    private var cliente: Cliente = cliente
    private var listaCarrito: ArrayList<String> = listaCarrito
    private var totalApagar: Float = totalApagar
    private var metodoPago: Int = metodoPago

    fun getIdPago():Int{
        return this.idPago
    }
    fun setIdPago(idPago: Int){
        this.idPago=idPago
    }
    fun getCliente():Cliente{
        return this.cliente
    }
    fun setCliente(cliente:Cliente){
        this.cliente=cliente
    }
    fun getListadoCarrito():ArrayList<String>{
        return this.listaCarrito
    }
    fun setCliente(listaCarrito:ArrayList<String>){
        this.listaCarrito=listaCarrito
    }
    fun getTotalApagar():Float{
        return this.totalApagar
    }
    fun setTotalApagar(totalApagar:Float){
        this.totalApagar=totalApagar
    }
    fun getMetodoPago():Int{
        return this.metodoPago
    }
    fun setMetodoPago(metodoPago: Int){
        this.idPago=metodoPago
    }

}