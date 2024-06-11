package common.cs009_functions

fun main() {
    val customGreeting = greet(greeting = "Welcome", name = "Bob")
    // val greeting2 = greet(greeting = "Bye") - нельзя, name не указано
    println(customGreeting) // Output: Welcome, Bob!

    println(multiplyNumbers(2,17))
    printNumbers(9, -9) // возвращает тип Unit - он же void

    println(singletonList(13.4f))
}

fun greet(name: String, greeting: String = "Hello"): String {
    return "$greeting, $name!"
}
fun multiplyNumbers(a: Int, b: Int) = a * b
fun printNumbers(a: Int, b: Int) = println(a + b)

fun <T> singletonList(item: T): List<T> { return listOf(item) }