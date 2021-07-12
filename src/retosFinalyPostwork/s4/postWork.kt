package retosFinalyPostwork.s4

// En nuestro proyecto

//PostWork 4

/* Uso de clase con retorno y variables privadas
   Fragmento obtenido de package models clase Persona
* */

//open class Persona(nombre: String,apellidos:String){
//
//    private var nombre: String = nombre
//    private var apellidos: String = apellidos
//    private var sexo: String = ""
//    private var edad: Int = 0
//    private var codigoPostal: Int =0
//    private var direccion: String = ""
//
//    constructor (nombre:String,apellidos:String,sexo: String,edad: Int) : this(nombre,apellidos) {
//        this.sexo=sexo
//        this.edad=edad
//    }
//
//
//    constructor (nombre:String,apellidos:String,sexo: String,edad: Int,codigoPostal: Int, direccion: String) : this(nombre,apellidos) {
//        this.sexo=sexo
//        this.edad=edad
//        this.codigoPostal=codigoPostal
//        this.direccion=direccion
//    }
//
//
//    fun getNombre(): String {
//        //   println("Llamado desde el getNombre() $nombre")
//        return this.nombre
//    }
//
//    fun setNombre(nombre: String) {
//        this.nombre = nombre
//    }
//
//    fun getApellidos(): String {
//        //  println("Llamado desde el getNombre() $nombre")
//        return this.apellidos
//    }
//
//    fun setApellidos(apellidos: String) {
//        this.apellidos = apellidos
//    }