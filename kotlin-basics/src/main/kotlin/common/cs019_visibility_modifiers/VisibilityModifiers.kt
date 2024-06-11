package common.cs019_visibility_modifiers

fun main() {

}

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // public by default

    protected open var v1 = 5
    internal open var v2 = 6

    protected class Nested {
        public val e: Int = 5
    }
}


class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
    override val c = 7   // 'c' is internal

    // можно повышать уровень видимости до public (protected -> public)
    public override var v1 = 70 // protected -> public
    public override var v2 = 72
    // нельзя менять с protected на internal и наоборот
    // нельзя понижать уровень видимости
    // private override var v2 = 70 // protected -> private - нельзя
}