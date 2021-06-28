package `mercadolibre eq3`

class Cliente(nombre:String,
              apellidos:String,
              sexo: String,
              edad: Int,
              direccion: String=""):
              Person(nombre,apellidos,sexo,edad,direccion) {

              val idUsuario:Int = 1
              var numeroTelefono: String =""
              var correoElectronico: String = ""


}

