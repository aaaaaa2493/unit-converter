package unitConverter

import java.util.*

fun getCorrectName(value: Double, measure: String): String {
    return when(measure) {
        "meters", "meter", "m" ->
            if (value == 1.0) "meter" else "meters"
        "kilometers", "kilometer", "km" ->
            if (value == 1.0) "kilometer" else "kilometers"
        "centimeters", "centimeter", "cm" ->
            if (value == 1.0) "centimeter" else "centimeters"
        "millimeters", "millimeter", "mm" ->
            if (value == 1.0) "millimeter" else "millimeters"
        "miles", "mile", "mi" ->
            if (value == 1.0) "mile" else "miles"
        "yards", "yard", "yd" ->
            if (value == 1.0) "yard" else "yards"
        "feet", "foot", "ft" ->
            if (value == 1.0) "foot" else "feet"
        "inches", "inch", "in" ->
            if (value == 1.0) "inch" else "inches"
        else -> "???"
    }
}

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    print("Enter a number and a measure of length: ")

    val value = scanner.nextDouble()
    val measure = scanner.next().toLowerCase()

    val result = value * when(measure) {
        "meters", "meter", "m" -> 1.0
        "kilometers", "kilometer", "km" -> 1000.0
        "centimeters", "centimeter", "cm" -> 0.01
        "millimeters", "millimeter", "mm" -> 0.001
        "miles", "mile", "mi" -> 1609.35
        "yards", "yard", "yd" -> 0.9144
        "feet", "foot", "ft" -> 0.3048
        "inches", "inch", "in" -> 0.0254
        else -> 0.0
    }

    println("$value ${getCorrectName(value, measure)} is $result ${getCorrectName(result, "m")}")
}