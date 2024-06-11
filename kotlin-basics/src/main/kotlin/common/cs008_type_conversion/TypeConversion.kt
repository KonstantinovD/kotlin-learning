package common.cs008_type_conversion

import common.cs006_String_basics.printSeparator
import kotlin.random.Random

fun main() {
    val longValue: Long = 100L
    val intValue: Int = 200
    val newLongValue = intValue

    // val intValue: Int = longValue // Error: Type mismatch
    val newIntValue: Int = longValue.toInt()

    val stringValue = newIntValue.toString()
    val floatValue1 = longValue.toFloat()
    val floatValue2 = stringValue.toFloat()
    println(floatValue1 == floatValue2)
    printSeparator()

    checkNullable()
    checkNumberFormatException()
    printSeparator()

    checkCast("Hello")
    checkCast(28.6f)
    printSeparator()

    checkAsOperator()
    printSeparator()
}

fun checkNullable() {
    val s = if (Random.nextBoolean()) "37" else null
    val i: Int? = s?.toInt()
    println("Nullable int: $i")
}

fun checkNumberFormatException() {
    val s = if (Random.nextBoolean()) "sample" else "14"
    val i: Int? = try {
        s.toInt()
    } catch (e: NumberFormatException) {
        println("Got exception: ${e.message}")
        null
    }
    println("Exceptionable int: $i")
}

fun checkCast(obj: Any) {
    if (obj is String) {
        println("String: $obj, length: ${obj.length}")
    }
    if (obj is Number) {
        println("Number: $obj, toInt: ${obj.toInt()}, isNegative: ${obj.toInt() < 0}")
    }
}

fun checkAsOperator() {
    val s = if (Random.nextBoolean()) 14 else "14"
    val i: Int? = s as? Int
    println("Safe-casted int: $i")
}
