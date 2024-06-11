package common.cs002_variables_and_input

fun main() {
    val inputLine1 = readLine()
    val inputLine2 = readLine()

    val num1: Int = inputLine1?.toInt() ?: 1
    val num2: Int = inputLine2?.toInt() ?: 1

    println(num1 + num2)
    println(num1 - num2)
    println(num1 * num2)
    println(num1 / num2)
}