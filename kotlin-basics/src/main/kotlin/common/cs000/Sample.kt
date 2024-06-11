package common.cs000

//Import kotlin.Scanner

import java.util.Scanner

fun main() {
    for (i in 1..10) {
        if (i == 5) continue
        print("$i ")
        if (i == 8) break
    }
}

//fun main() {
//    val scanner = Scanner(System.`in`)
//    val line1 = scanner.nextLine()
//    val line2 = scanner.nextLine()
//
//    println(line2)
//    println(line1)
//}

//fun main() {
//    val scanner = Scanner(System."in")
//    val name = scanner.nextInt()
//    val age = scanner.next'Int'()
//    val answer = console.Next()
//}
