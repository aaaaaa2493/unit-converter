package unitConverter

import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    print("Enter a number of kilograms: ")

    val kilos = scanner.nextInt()
    val grams = kilos * 1000

    println("$kilos kilograms is $grams grams")

}