package common.cs001

fun main() {

    println(mix(Color.RED, Color.YELLOW))
    println(mixNonOptimized(Color.BLUE, Color.VIOLET))

}

fun mix(c1: Color, c2: Color): Color {
    return when { // when без агрументов
        (c1 == Color.RED && c2 == Color.YELLOW)
                || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE)
                || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET)
                || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Грязный цвет")
    }
}

// не оч оптимально, т. к. вызов функции создает 1-2-3 сета
// но зато показательно с точки зрения произвольных выражений
fun mixNonOptimized(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Грязный цвет")
    }
