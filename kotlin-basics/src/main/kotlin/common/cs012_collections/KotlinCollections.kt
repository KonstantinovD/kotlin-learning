package common.cs012_collections

import common.common_1.printSeparator
import java.util.LinkedHashMap

fun main() {
    val lsImmutable: Collection<String> = listOf("six", "seven")
    printAll(lsImmutable)
    // lsImmutable.add("ten") - нет такого метода

    val lsMutable: MutableCollection<String> = mutableListOf("one", "two")
    lsMutable.add("ten")
    printAll(lsMutable)
    var iter = lsMutable.iterator()
    iter.next()
    iter.remove()
    printAll(lsMutable)
    printSeparator()

    val numbers = ArrayList<String>() // обычно просто mutableListOf()
    // immutable to mutable ArrayList
    numbers.addAll(listOf("one", "two", "three", "three"))
    println(numbers)
    println("Number of elements: ${numbers.size}")
    println("Third element: ${numbers.get(2)}")
    println("Fourth element: ${numbers[3]}")
    println("Index of element \"two\": ${numbers.indexOf("two")}")

    numbers.removeAt(1)
    println(numbers)
    numbers.add("four")
    println(numbers)
    numbers[1] = "twelve"
    println(numbers)
    numbers.shuffle()
    println(numbers)
    printSeparator()

    val numbersSet = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbersSet.size}")
    if (numbersSet.contains(1)) println("1 is in the set")

    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbersSet == numbersBackwards}")

    // можно скастить Set к дефолтному LinkedHashSet
    val mutableSetInt: LinkedHashSet<Int>? = numbersBackwards as? LinkedHashSet<Int>
    // но можно сделать и ерунду
    val mutableSetString: LinkedHashSet<String>? = numbersBackwards as? LinkedHashSet<String>
    // и потом получить ClassCastException на
    // println(mutableSetString.iterator().next().length)
    mutableSetInt!!.add(18)
    println(mutableSetInt)
    printSeparator()

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    println(numbersMap) // {key1=1, key2=2, key3=3, key4=1}
    println("All keys: ${numbersMap.keys}") // [key1, key2, key3, key4]
    println("All values: ${numbersMap.values}") // [1, 2, 3, 1]
    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}") // 2
    if (1 in numbersMap.values) println("The value 1 is in the map") // in the map
    if (numbersMap.containsValue(1)) println("The value 1 is in the map") // in the map
    // casting to linked map
    val mutableMap: LinkedHashMap<String, Int> = numbersMap as LinkedHashMap<String, Int>
    numbersMap.put("default", 0)
    mutableMap["key2"] = 7
    println(numbersMap) // {key1=1, key2=7, key3=3, key4=1, default=0}
    printSeparator()

    val deque = ArrayDeque(listOf(1, 2, 3))
    deque.addFirst(0)
    deque.addLast(4)
    println(deque) // [0, 1, 2, 3, 4]
    println(deque.first()) // 0
    println(deque.last()) // 4
    deque.removeFirst()
    deque.removeLast()
    println(deque) // [1, 2, 3]
}

fun printAll(strings: Collection<String>) {
    val it = strings.iterator()
    while (it.hasNext()) {
        print("${it.next()} ")
    }
    println()
}