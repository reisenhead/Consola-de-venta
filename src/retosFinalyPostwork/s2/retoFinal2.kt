package retosFinalyPostwork.s2

fun main() {
    listadeRopa()
}
var nombres = mutableListOf<String>(
    "Blusa Azul",
    "Pantalon de mezclilla",
    "Sueter Verde",
    "Calcetines",
    "Zapatos",
    "Bufanda"
)
fun listadeRopa() {
    println(" **********  Catalogo de ropa Zara ***********")
    println("*  Desea ver la lista de ropa actual s/n     *")
    val opc = readLine()
    if (opc == "s"){

    println(nombres)
    println("  Desea agregar o quitar  una ropa.  1.- Para agregar 2.- Para quitar")
    val opcion = readLine()?.toInt()
    if(opcion == 1){
    println(" Escriba la ropa que desea agregar a la lista ")
        val opcion2 = readLine()
        nombres.add(opcion2.toString())
        println(" Articulo agregado: $opcion2 ")
        println(nombres)
        repeticionDeCiclo()
    }else {
        println(" Escriba la ropa que desea quitar de la lista ")
        val opcion3 = readLine().toString()
        when(opcion3){
          "Zapatos" ->{
              nombres.removeAt(4)
              println(" Articulo quitado: $opcion3 ")
              println(nombres)
              repeticionDeCiclo()
          }
            "Blusa Azul" ->{
                nombres.removeAt(0)
                println(" Articulo quitado: $opcion3 ")
                println(nombres)
                repeticionDeCiclo()
            }
            "Pantalon de mezclilla" ->{
                nombres.removeAt(1)
                println(" Articulo quitado: $opcion3 ")
                println(nombres)
                repeticionDeCiclo()
            }
            "Sueter Verde" ->{
                nombres.removeAt(2)
                println(" Articulo quitado: $opcion3 ")
                println(nombres)
                repeticionDeCiclo()
            }
            "Calcetines" ->{
                nombres.removeAt(3)
                println(" Articulo quitado: $opcion3 ")
                println(nombres)
                repeticionDeCiclo()
            }
            "Bufanda" ->{
                nombres.removeAt(5)
                println(" Articulo quitado: $opcion3 ")
                println(nombres)
                repeticionDeCiclo()
            }
        }


    }


    }else{
        println(" Gracias por pasar al catalogo de ropa Zara")
}
}




fun repeticionDeCiclo() {
   println("Desea agregar o quitar otro articulo escriba:  si o no")
   val opcion4 = readLine().toString()
    if(opcion4 == "si"){
      println("Imprimiendo Lista de Ropa")
      listadeRopa()
    }else{
        println("******Gracias por pasar al catalogo de ropa Zara*********")
    }

}