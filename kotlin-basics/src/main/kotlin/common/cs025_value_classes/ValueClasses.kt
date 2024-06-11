package common.cs025_value_classes

class Cat(val name: String,
          var weight: Weight, var length: Length)
class CatOld(val name: String,
           var weight: Double, var length: Double)

@JvmInline
value class Weight(val value: Double)
@JvmInline
value class Length(val value: Double)

fun main() {
    val catMonster = CatOld("Barsik", 70.0, 5.0)
    val cat = Cat("Murzik", Weight(5.0), Length(70.0))
    val name = Name("Kotlin")
    println(name.prettyPrint()) // Still called as a static method
}

interface Printable {
    fun prettyPrint(): String
}

@JvmInline
value class Name(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}
