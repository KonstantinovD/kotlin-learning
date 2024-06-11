package common.cs023_generics

fun main() {

}

interface Source<out T> {
    fun nextT(): T

    // Нельзя, потому что тип T стоит на in-позиции,
    // но объявлен как out
    // fun setT(vl : T): Boolean
}

fun demo(strs: Source<String>) {
    // OK, потому что T это out-parameter
    val objects: Source<Any> = strs

}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int

    // Нельзя, потому что тип T стоит на out-позиции,
    //fun getT() : T
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}

fun copy(from: Array<out Number>, to: Array<in Number>) {
    for (i in from.indices) {
        to[i] = from[i]

        val c1 = from.get(0)
        val c2 = to.get(0)

        to.component1()
        from.component1()

        // ERROR - expected type Nothing
        // from[i] = 12.0
        // ERROR - Type mismatch. Required: Number, Found: Any?
        // var temp : Number = to[i]
    }
}

fun <T> copyWhenGreater(list: List<T>, threshold: T):
        List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}
