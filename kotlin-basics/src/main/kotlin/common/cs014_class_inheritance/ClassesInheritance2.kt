package common.cs014_class_inheritance

fun main() {
    val rect = FilledRectangle()
    rect.draw()
    println("vertexCount: ${rect.vertexCount}, " +
            "linesCount: ${rect.linesCount}, " +
            "edgesCount: ${rect.edgesCount}, " +
            "color: ${rect.color}, " +
            "lineThickness: ${rect.lineThickness}")
}

abstract class Shape {
    open val vertexCount: Int = 0
    open val linesCount: Int = 0
    open val edgesCount: Int = 0
    open var color: String = "Blank"
    abstract var lineThickness: UInt // абстрактная пропертя

    abstract fun fill() // абстрактный метод
}

open class Rectangle : Shape() {
    override val vertexCount = 4 // инициализатор - 4
    override val linesCount: Int // свойство val с get-методом
        get() = super.linesCount // инициализируется в базовом классе

    override var edgesCount: Int // переопределение val на var
        get() = super.edgesCount // для var нужны и get и set методы
        set(value) {}

    override var color: String = "White" // инициализатор - "White"

    override var lineThickness: UInt = 1U // абстрактная пропертя - переопределение

    open fun draw() { println("Drawing a rectangle") }
    override fun fill() {
        throw NotImplementedError()
    }
}

class FilledRectangle : Rectangle() {

    // переопределение метода с вызовом родительского
    override fun draw() {
        super.draw() // через keyword 'super'
        fill()
    }

    // переопределение метода из родителя родителя
    override fun fill() {
        println("Filling the rectangle with '${color}' color")
    }

}