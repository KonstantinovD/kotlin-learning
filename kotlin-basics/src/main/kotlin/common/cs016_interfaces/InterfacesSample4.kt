package common.cs016_interfaces

fun main() {
    var obj = Child()
    obj.foo()
    obj.bar("aklm")
}

interface MyInterface {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() { // не абстрактная
        println(prop)
    }


    fun bar(str: String) // абстрактная по дефолту как функция без тела
}

class Child : MyInterface {
    override val prop: Int = 29
    override fun bar(str: String) {
        println("bar $str")
    }
}