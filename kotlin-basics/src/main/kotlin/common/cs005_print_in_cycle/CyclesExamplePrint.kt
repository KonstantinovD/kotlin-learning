package common.cs005_print_in_cycle

fun main() {
    for (i in 1..6) {
        // for (j = 0 ; j < i; j++) - не работает такой тип for
        var j = 0
        while (j < i) {
            j++
            print('#')
        }
        println()
    }
}