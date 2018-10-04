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
        "kilograms", "kilogram", "kg" ->
            if (value == 1.0) "kilogram" else "kilograms"
        "grams", "gram", "g" ->
            if (value == 1.0) "gram" else "grams"
        "milligrams", "milligram", "mg" ->
            if (value == 1.0) "milligram" else "milligrams"
        "pounds", "pound", "lb" ->
            if (value == 1.0) "pound" else "pounds"
        "ounces", "ounce", "oz" ->
            if (value == 1.0) "ounce" else "ounces"
        else -> "???"
    }
}

fun getCoefficient(measure: String): Double {
    return when(measure) {
        "meters", "meter", "m" -> 1.0
        "kilometers", "kilometer", "km" -> 1000.0
        "centimeters", "centimeter", "cm" -> 0.01
        "millimeters", "millimeter", "mm" -> 0.001
        "miles", "mile", "mi" -> 1609.35
        "yards", "yard", "yd" -> 0.9144
        "feet", "foot", "ft" -> 0.3048
        "inches", "inch", "in" -> 0.0254
        "kilograms", "kilogram", "kg" -> 1000.0
        "grams", "gram", "g" -> 1.0
        "milligrams", "milligram", "mg" -> 0.001
        "pounds", "pound", "lb" -> 453.592
        "ounces", "ounce", "oz" -> 28.3495
        else -> 0.0
    }
}

fun getMeasureId(measure: String): Int {
    val singular = getCorrectName(1.0, measure)
    return when(singular) {
        "meter", "kilometer", "centimeter", "millimeter", "mile", "yard", "foot", "inch" -> 1
        "kilogram", "gram", "milligram", "pound", "ounce" -> 2
        else -> -1
    }
}

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    while (true) {

        print("Enter what you want co convert (or exit): ")

        val strValue = scanner.next()
        if (strValue == "exit") {
            break
        }

        val value = strValue.toDouble()
        val measureFrom = scanner.next().toLowerCase()

        scanner.next()
        val measureTo = scanner.next().toLowerCase()

        if (getMeasureId(measureFrom) != getMeasureId(measureTo)) {
            println("Conversion from ${getCorrectName(2.0, measureFrom)} " +
                    "to ${getCorrectName(2.0, measureTo)} is impossible")
            continue
        }

        val coefficientFrom = getCoefficient(measureFrom)
        val coefficientTo = getCoefficient(measureTo)

        val result = value * coefficientFrom / coefficientTo

        println("$value ${getCorrectName(value, measureFrom)} is $result ${getCorrectName(result, measureTo)}")

    }
}