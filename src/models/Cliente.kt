package models

////checar la herencia que se esta realizando


/*
class SmartWatch(
    price: Float,
    name: String,
    sku: String) : Product( price, name, sku) {

    override fun getTotalPrice(quantity: Int): Float {
        return quantity*price
    }
}

* */
class Cliente(idPersona: Int,
              nombre:String,
              apellidos:String,
              sexo: String,
              edad: Int,
              direccion: String):
              Person(nombre,apellidos,sexo,edad,direccion) {

              val idUsuario:Int = 1
              var numeroTelefono: String =""
              var correoElectronico: String = ""




//listado de prodiuto ya comprado
}

