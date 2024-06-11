package common.cs003_Scanner_example

import java.util.Scanner

fun main() {
    // Creates an instance of Scanner
    val reader = Scanner(System.`in`)

    val number = reader.nextInt()
    val square = number * number

    println("Number: $number\nSquare: $square")
}