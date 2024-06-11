package common.cs017_functional_interfaces

// функциональный интерфейс - через объявление 'fun interface'
// обязан иметь ровно 1 абстрактный метод
// различие с псевдонимом типов - может иметь неабстрактные члены
fun interface IntPredicate {
    fun accept(i: Int): Boolean
    fun printInfo(i: Int) { println("Result of accept $i is ${accept(i)}") }
}

val isEven = IntPredicate { it % 2 == 0 }

// type alias - псевдоним типа - используется для переименования типа
// это просто имена существующих типов, они не создают новый тип,
// в отличие от функциональных интерфейсов
// Например, здесь у лямбды есть тип - мы просто переопределяем его название
typealias DoublePredicate = (i: Double) -> Boolean

val isMoreThan10: DoublePredicate = { it > 10.0 }

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")

    cons(isMoreThan10)
    cons(act = { it > 11.0})
    cons { it > 9.0 }
    cons2 { it > 14.0 }
    cons2(isMoreThan10)

    isEven.printInfo(14)
}

// тут разбираются способы передачи лямбды в функцию
fun cons(act: (Double) -> Boolean) {
    if (act(11.0)) {
        println("Верно")
    } else {
        println("Неверно")
    }
}

fun cons2(act: DoublePredicate) {
    if (act(11.0)) {
        println("Верно")
    } else {
        println("Неверно")
    }
}