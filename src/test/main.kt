package test

fun main() {

prueba()


}

fun prueba() {
    try {
        println("Escribe un texto")
        val v = readLine().toString()
        v.toInt()
    } catch(e: NumberFormatException) {
        e.printStackTrace()
        println("No se pudo convertir, hubo un error: $e")
        return prueba()
    }

}