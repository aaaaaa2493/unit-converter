package unitConverter

import java.util.*

enum class MeasureGroup {
    Length, Weight, Temperature
}

enum class Measure {
    Meter, Kilometer, Centimeter, Millimeter, Mile, Yard, Foot, Inch,
    Gram, Kilogram, Milligram, Pound, Ounce;

    fun getGroup() = when (this) {
        Meter, Kilometer, Centimeter, Millimeter, Mile, Yard, Foot, Inch -> MeasureGroup.Length
        Gram, Kilogram, Milligram, Pound, Ounce -> MeasureGroup.Weight
    }

    fun getCorrectName(value: Double) = when(this) {
        Meter -> if (value == 1.0) "meter" else "meters"
        Kilometer -> if (value == 1.0) "kilometer" else "kilometers"
        Centimeter -> if (value == 1.0) "centimeter" else "centimeters"
        Millimeter -> if (value == 1.0) "millimeter" else "millimeters"
        Mile -> if (value == 1.0) "mile" else "miles"
        Yard -> if (value == 1.0) "yard" else "yards"
        Foot -> if (value == 1.0) "foot" else "feet"
        Inch -> if (value == 1.0) "inch" else "inches"
        Gram -> if (value == 1.0) "gram" else "grams"
        Kilogram -> if (value == 1.0) "kilogram" else "kilograms"
        Milligram -> if (value == 1.0) "milligram" else "milligrams"
        Pound -> if (value == 1.0) "pound" else "pounds"
        Ounce -> if (value == 1.0) "ounce" else "ounces"
    }

    fun getCoefficient() = when(this) {
        Meter -> 1.0
        Kilometer -> 1000.0
        Centimeter -> 0.01
        Millimeter -> 0.001
        Mile -> 1609.35
        Yard -> 0.9144
        Foot -> 0.3048
        Inch -> 0.0254
        Gram -> 1.0
        Kilogram -> 1000.0
        Milligram -> 0.001
        Pound -> 453.592
        Ounce -> 28.3495
    }
}

fun getMeasure(measure: String): Measure {
    return when(measure) {
        "meters", "meter", "m" -> Measure.Meter
        "kilometers", "kilometer", "km" ->Measure.Kilometer
        "centimeters", "centimeter", "cm" -> Measure.Centimeter
        "millimeters", "millimeter", "mm" -> Measure.Millimeter
        "miles", "mile", "mi" -> Measure.Mile
        "yards", "yard", "yd" -> Measure.Yard
        "feet", "foot", "ft" -> Measure.Foot
        "inches", "inch", "in" -> Measure.Inch
        "grams", "gram", "g" -> Measure.Gram
        "kilograms", "kilogram", "kg" -> Measure.Kilogram
        "milligrams", "milligram", "mg" -> Measure.Milligram
        "pounds", "pound", "lb" -> Measure.Pound
        "ounces", "ounce", "oz" -> Measure.Ounce
        else -> Measure.Meter
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
        val measureFrom = getMeasure(scanner.next().toLowerCase())

        scanner.next()
        val measureTo = getMeasure(scanner.next().toLowerCase())

        if (measureTo.getGroup() != measureFrom.getGroup()) {
            println("Conversion from ${measureFrom.getCorrectName(2.0)} " +
                    "to ${measureTo.getCorrectName(2.0)} is impossible")
            continue
        }

        val coefficientFrom = measureFrom.getCoefficient()
        val coefficientTo = measureTo.getCoefficient()

        val result = value * coefficientFrom / coefficientTo

        println("$value ${measureFrom.getCorrectName(value)} is $result ${measureTo.getCorrectName(result)}")

    }

}