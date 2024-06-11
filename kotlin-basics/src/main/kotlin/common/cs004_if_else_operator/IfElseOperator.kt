package common.cs004_if_else_operator

import java.util.Scanner

fun main() {
    // проверка на то, валидный ли комментарий, или нет
    // (коммент должен начинаться с "// ")
    val scanner = Scanner(System.`in`)
    val comment = scanner.nextLine()
    val result = if (comment.startsWith("// ")) "Valid" else "Invalid"
    println(result)
}