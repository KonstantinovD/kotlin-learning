package common.cs011_arrays

import common.common_1.printSeparator

fun main() {
    // Creates an array with values [1, 2, 3]
    val simpleArray = arrayOf(1, 2, 3)
    println(simpleArray.joinToString())

    // Creates an array with values [null, null, null]
    val nullArray: Array<Int?> = arrayOfNulls(3)
    println(nullArray.joinToString())

    // Creates empty array []
    var exampleArray = emptyArray<String>()
    println(exampleArray.size)

    // Creates an Array<Int> that initializes with zeros [0, 0, 0]
    val initArray = Array<Int>(3) { 0 }
    println(initArray.joinToString())

    // Creates an Array<String> with values ["0", "1", "4", "9", "16"]
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { print(it) }
    printSeparator()

    // Суммирование
    println(simpleArray.sum())
    // Перемешать элементы [1,2,3]
    simpleArray.shuffle()
    println(simpleArray.joinToString())
    simpleArray.shuffle()
    println(simpleArray.joinToString())
    printSeparator()

    // Конвертация в коллекции
    val toCollectionArray = arrayOf("a", "b", "c", "c")
    // Converts to a Set
    println(toCollectionArray.toSet())  // [a, b, c]
    // Converts to a List
    println(toCollectionArray.toList()) // [a, b, c, c]
    printSeparator()

    // Конвертация в Map возможна только массива пар Pair<K,V>
    val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)
    // Converts to a Map
    // The keys are fruits and the values are their number of calories
    // Note how keys must be unique, so the latest value of "apple" overwrites the first
    println(pairArray.toMap())
    // {apple=140, banana=150, cherry=90}
}