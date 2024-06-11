package common.cs025_value_classes

interface I

@JvmInline
value class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}
fun <T> id(x: T): T = x

fun main() {
    val f = Foo(42)

    asInline(f)    // unboxed: used as Foo itself
    asGeneric(f)   // boxed: used as generic type T
    asInterface(f) // boxed: used as type I
    asNullable(f)  // boxed: used as Foo?, which is different from Foo

    // Изначально 'f' упаковывается, когда передается в функцию 'id()',
    // а затем распаковывается при возвращении результата из функции.
    // В конце концов 'c' содержит raw-значение (просто '42'), как и 'f'
    val c = id(f)
}