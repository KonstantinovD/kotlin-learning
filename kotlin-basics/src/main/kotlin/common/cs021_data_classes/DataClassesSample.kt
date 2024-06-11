package common.cs021_data_classes

import common.common_1.printSeparator
import java.util.UUID

data class User(val name: String, val age: Int, val city: String) {
    var userId: UUID = UUID.randomUUID()
}

fun main() {
    val kirill = User("Kirill", 23, "Gomel")
    // componentN() функции
    println("component1(): ${kirill.component1()}, " +
            "component2(): ${kirill.component2()}, " +
            "component3(): ${kirill.component3()}")
    printSeparator()

    // 2 переменных в одном месте
    val (userName, userAge) = kirill
    println(userName) // Kirill
    println(userAge)  // 23

    // можно пропускать переменные с помощью '_'
    val (name2, _, city) = kirill
    println(name2) // Kirill
    println(city)  // Gomel
    // val (name2, _, city, userId) = kirill
    // нельзя - userId не является автогенерируемым
    printSeparator()

    val users = listOf(User("Kirill", 23, "Gomel"), User("Alexander", 29, "Ratomka"))

    for((username, _, usercity) in users){
        println("$username lives in $usercity")
    }
    printSeparator()

    val serafima = kirill.copy(name = "Serafima")
    println("Copy obj: $serafima")
    println("initial userId: ${kirill.userId}, new userId: ${serafima.userId}")
}



