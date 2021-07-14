package models

class Direccion(nombreApellido:String,
                codigoPostal:Int,
                estado:String,
                municipioAlcaldia:String,
                 colonia:String,
                 calle:String,
                 numeroExterior:Int? = null,
                 numeroInterior:Int? = null,
                 calle1:String? = null,
                 calle2:String? = null,
                 casaTrabajo:String,
                 numeroDeContacto:String,
                 indicaciones:String) {

    var nombreApellido:String=nombreApellido
    var codigoPostal:Int=codigoPostal
    var estado:String=estado
    var municipioAlcaldia:String=municipioAlcaldia
    var colonia:String=colonia
    var calle:String=calle
    var numeroExterior:Int?=numeroExterior
    var numeroInterior:Int?=numeroInterior
    var calle1:String?=calle1
    var calle2:String?=calle2
    var casaTrabajo:String=casaTrabajo
    var numeroDeContacto:String=numeroDeContacto
    var indicaciones:String=indicaciones

}