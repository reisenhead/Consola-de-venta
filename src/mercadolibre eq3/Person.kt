package `mercadolibre eq3`

open class Person(){

    private var idUsuario: Int = 0
    private var nombre: String = ""
    private var apellidos: String = ""
    private var sexo: String = "sexo"
    private var edad: Int = 0
    private var direccion: String = ""



    constructor (nombre:String,apellidos:String,sexo: String,edad: Int,direccion: String) : this() {

        this.nombre=nombre
        this.apellidos=apellidos
        this.sexo=sexo
        this.edad=edad
        this.direccion=direccion
    }

    constructor (nombre:String,apellidos:String,sexo: String,edad: Int) : this() {
        this.nombre=nombre
        this.apellidos=apellidos
        this.sexo=sexo
        this.edad=edad
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }



}