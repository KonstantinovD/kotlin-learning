package common.cs018_scope_functions

import common.common_1.printSeparator
import common.cs017_functional_interfaces.DoublePredicate
import kotlin.random.Random

fun main() {
    useLet()
    printSeparator()

    useWith()
    printSeparator()

    useRunAndApply()
    printSeparator()

    useAlso()
    printSeparator()

    useTakeIfUnless()
    printSeparator()

    // разница между this/it еще и в том, что it не скрывает keyword 'this'
    // для доступа к экземпляру класса, если лямбда находится внутри функции класса
    // А еще тут показывается, как можно использовать let для функции
    val sample = ThisSample()
    println(sample.count(listOf("six", "seven", "eight", "nine")))
    println(sample.count(listOf("ten", "eleven")))
    println("Функция count() вызвана ${sample.cnt} раза")
}

fun useLet() { // let - context object is 'it'
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    // кстати, объект it можно просто в лямбды передавать
    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)

    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        println("Num of elements: ${it.size}")
        it// возвращаемое значение - результат лямбды - тот же объект
    }.let {
        println("Element number 1: ${it.get(0)}")
        42// возвращаемое значение - результат лямбды - другой объект
    }.let {
        println("Answer to the Ultimate Question of Life, the Universe, and Everything: $it")
    }


    // если функция только одна, можно передать ссылку на функцию/метод
    numbers.map { it.length }.filter { it > 3 }.let(::println)
}

fun useWith() { // with - context object is 'this' - но это не функция расширения
    // особенность - вызывается с аргументом
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    with(numbers) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }

    val oddNums = numbers.map { str ->
        with(str) {
            var res = str.length
            res = if (res % 2 == 1) res + 1 else res
            res
        }
    }.let {
        println("Результат маппинга: $it")
        it
    }
    println("Размер замапленного списка: ${oddNums.size}")

}

// run - делает то же самое, что и with, но реализован как функция расширения
// apply - работает как run, но возвращает сам объект
fun useRunAndApply() { // run/apply - context object is 'this'
    // Полезно использовать, когда ваша лямбда одновременно
    // инициализирует объекты и вычисляет возвращаемое значение.
    data class Character(var name: String, var damage: Int, var hp: Int = 10)

    val evilBunnyTemplate = Character("Evil bunny", 1)
    val evilBunny = evilBunnyTemplate.apply {
        val resHp = Random.nextInt(1,6)
        hp = resHp
        if (hp >= 5) {
            this.damage *= 3 // можно с this
            name = "Boss bunny" // можно без него
        }
    }
    val attack = evilBunny.run {
        val protection = Random.nextInt(1,4)
        // можно и с this и без него
        if (damage - protection > 0) this.damage else 0 // правила как в хелбое
    }

    println("Вы встретили ${evilBunny.name}, hp=${evilBunny.hp}, сила атаки=${evilBunny.damage}")
    println("${evilBunny.name} нанес вам $attack урона")

    // run можно использовать и не как функция расширения, но он все равно
    // возвращает результат лямбды. Такое использование run можно прочитать как
    // "запустите блок кода и вычислите результат"
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"
        Regex("[$sign]?[$digits$hexDigits]+")
    }

    for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
        println(match.value)
    }
}

// also - работает как apply, но доступ к объекту через it
// Используйте also для действий, которым требуется ссылка на объект,
// а не на его свойства и функции
fun useAlso() { //  - context object is 'this'
    val numbers = mutableListOf("one", "two", "three")
    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")
}

fun useTakeIfUnless() {
    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")

    // takeIf и takeUnless особенно полезны в сочетании с другими
    // scope functions. Для этого используется safe call '?' после
    // вызова takeIf/takeUnless
    fun displaySubstringPosition(input: String, sub: String) {
        input.indexOf(sub).takeIf { it >= 0 }?.let {
            println("The substring $sub is found in $input.")
            println("Its start position is $it.")
        }
    }
    // Напечатает 'Its start position is 7'
    displaySubstringPosition("010000011", "11")
    // Ничего не напечатает, поскольку takeIf{} вернет null
    displaySubstringPosition("010000011", "12")
}

class ThisSample(var cnt: Int = 0) {
    fun count(elems: List<String>) = let {
        elems.apply {
            // нельзя вызвать this.cnt
            print("Передан массив: $this")
        }
        elems.also {
            this.cnt++
            println(", Еще раз: $it")
        }.count()
    }
}
