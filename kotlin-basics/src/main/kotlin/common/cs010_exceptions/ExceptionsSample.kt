package common.cs010_exceptions

class Person(var name: String? = null)

fun main() {

    val person = Person()

    try {
        val s = person.name ?: throw IllegalArgumentException("Name required")
        println(s)
        fail(s)
    } catch (e : Exception) {
        println(e.message)
    }

    val x = null           // 'x' has type `Nothing?`
    val l = listOf(null, null, null)   // 'l' has type `List<Nothing?>
    println(x)
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}