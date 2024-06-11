package common.cs007_boolean

import common.common_1.printSeparator

fun main() {
    val t = true  // t is true
    val f = false // f is false
    // никаких присваиваний 0 - как и в Java
    println(t) // true
    println(f) // false
    printSeparator()

    // конвертация строки в boolean
    for (value in listOf("true", "True", "TRuE", "T", "false")) {
        val b1: Boolean = value.toBoolean() // case insensitive
        val b2: Boolean? = value.toBooleanStrictOrNull() // case sensitive or null
        print("initial: $value; case insensitive: $b1, case sensitive or null: $b2")
        try {
            val b3: Boolean = value.toBooleanStrict() // case sensitive or exception
            println(", strict case sensitive: $b3")
        } catch (iex: IllegalArgumentException) {
            println(", got an exception: $iex")
        }
    }
    printSeparator()

    // логические операторы - как и в java, за исключением XOR
    // (в java используется "^")
    val b1 = false xor true
}