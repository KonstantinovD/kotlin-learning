package common.p23_simple


// Data class must have at least one primary constructor parameter
// Т. е. нельзя написать 'data class Person' или 'data class Person()'
data class Person(val name: String,
                  val age: Int? = null) // age null по умолчанию
fun main(args: Array<String>) {
    val persons = listOf(
        Person("Alice"), // по умолчанию age = null
        Person("Bob", age = 29)
    )

    // оператор elvis ?: -> возвращает 0 если age = null
    val oldest = persons.maxByOrNull { it.age ?: 0 }
    // val oldest = persons.maxByOrNull{ it.age!! } -> java.lang.NullPointerException

    println("The oldest is: $oldest")

    // persons.get(0).name = "Pavel"
    // ошибка компиляции, т. к. член класса обозначен как val
}

// The oldest is: Person(name=Bon, age=29)