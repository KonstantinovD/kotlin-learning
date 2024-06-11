package common.cs006_String_basics

fun main() {
    val language = "Kotlin"
    println(language.length) // 6
    val empty = ""
    println(empty.length) // 0
    println(empty.length) // 0
    printSeparator()

    val one = "1"
    val two = "2"
    val twelve = one + two
    println(one)      // 1, no changes
    println(two)      // 2, no changes
    println(twelve)   // 12
    printSeparator()

    printLadder(3)
    println()
    printLadder(7)
    printSeparator()

    println("Have a nice $language!")
    println("$language has ${language.length} letters in the name")
    val expression = "${7 + 8}"
    println(expression) // печатаем произвольное выражение
    printSeparator()
}

const val SEPARATOR = "----------"
fun printSeparator() = println(SEPARATOR)

fun printLadder(times :Int) {
    for (i in 1..times) println("#".repeat(i))
}