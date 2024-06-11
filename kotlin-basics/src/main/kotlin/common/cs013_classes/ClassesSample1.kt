package common.cs013_classes

import common.common_1.printSeparator

// private означает, что член виден только внутри этого класса (включая все его члены).
class C private constructor(a: Int) {
    fun printInfo() {
        println("I'm a private constructor class")
    }
}

class Empty // пустой класс без тела

class InitOrderDemo(name: String) {
    var firstProperty = "First property: $name".also(::println)
    val secondProperty : String // val можно инициализировать в init-блоке
    init { // можно работать с уже засетанным полем name
        println("First initializer block that prints $name")
    }

    init {
        secondProperty = "${name.length}"
        println("Second initializer block that prints ${secondProperty}")
    }

    constructor(name: String, property: String) : this(name) {
        firstProperty = property
       // secondProperty = property - Error, нельзя инициализировать val
    }
}

data class Person(
    val firstName: String,
    val lastName: String,
    var age: Int = 25, // trailing comma
)

fun main() {
    // val cls = C() - Error, поскольку конструктор приватный
    val cls = Empty()
    println("${cls::class.java.simpleName}, ${cls}")
    var nextClass = Empty()
    println(nextClass.equals(cls)) // false, т. к. equals не переопределен
    printSeparator()

    // пошла инициализация класса с init-блоками
    val demoInitClass = InitOrderDemo("Svislach")
    println(demoInitClass.firstProperty)
    printSeparator()

    val p = Person("Evgenii", "Onegin")
    println(p)
    printSeparator()

    val secondaryInitClass = InitOrderDemo("Svislach", "Berezina")
    println("First property after secondary init: ${secondaryInitClass.firstProperty}")
    printSeparator()
}
