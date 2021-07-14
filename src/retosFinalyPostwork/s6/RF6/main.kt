package retosFinalyPostwork.s6.RF6;

import java.text.SimpleDateFormat
import java.util.*


fun main() {

    val now = Date()
    val formatDate = SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz")

    println("Fecha actual: " + formatDate.format(now))

    val iPhone = IPhone()

    println("precio sin impuesto: ${iPhone.price}")
    println("precio con impuesto: ${iPhone.priceWithTax()}")
}