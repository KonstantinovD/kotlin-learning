package common.cs015_class_properties

import common.common_1.printSeparator

fun main() {

    val late1 = LateInitClass()
    println("street: ${late1.street}, version: ${late1.version}, modif: ${late1.modifier}")
    if (late1.checkInit()) {
        println("переменная инициализирована: ${late1.town}")
    } else {
        println("переменная не инициализирована")
    }

    late1.town = "Minsk"
    println("street: ${late1.street}, version: ${late1.version}, modif: ${late1.modifier}")
    println("переменная инициализирована: ${late1.town}")
    printSeparator()

    var child1 = LateInit2("Grodno")
    println("street: ${child1.street}, version: ${child1.version}, modif: ${child1.modifier}")
    println("переменная инициализирована: ${child1.town}")

    var child2 = LateInit2()
    println("street: ${child2.street}, version: ${child2.version}, modif: ${child2.modifier}")
    // kotlin.UninitializedPropertyAccessException: lateinit property town has not been initialized
    println("переменная инициализирована: ${child2.town}")
}

// компилятор Kotlin генерирует setter/getter для свойства 'headers'.
// Под капотом Kotlin будет использовать поле Java для хранения значений свойств.
// Эти поля Java известны в Kotlin как 'backing fields' (вспомогательные поля).
data class HttpResponse(val body: String, var headers: Map<String, String>) {
    // 1) Для headers и body будут созданы backing fields,
    // поскольку они используют методы доступа по умолчанию

    // 2) Геттер hasBody возвращает true, если тело не пустое. Поскольку Kotlin
    // может вычислить значение hasBody из свойства body,
    // он не будет генерировать для него backing field.
    val hasBody: Boolean
        get() = body.isNotBlank()

    var statusCode: Int = 100 // 3) the initializer assigns the backing field directly
        set(value) {
            if (value in 100..599)
                field = value // правильно
                /* statusCode = value */
                // нельзя, потому что statusCode - это сеттер, и мы просто
                // устроим рекурсию, вызывая сеттер setStatusCode()
        }

}

// lateinit недоступен для пропертей в основном конструкторе
open class LateInitClass(val street: String="Kobykina") {
    lateinit var town: String

    // lateinit недоступен для пропертей примитмвного типа
    var modifier: Double = 11.5

    // lateinit недоступен для пропертей с геттером или инициализатором
    open var version: String = "1.0"
        get() {
            if (!this::town.isInitialized) {
                return "NO_INIT"
            }
            return field // backing field содержит "1.0" - значение из инициализатора
        }
        set(value) { field=value }

    fun checkInit() : Boolean {
        return this::town.isInitialized
    }
}

class LateInit2 : LateInitClass {
    override var version = "1.1" // переопределен инициализатор

    constructor(town: String) : super() {
        this.town = town
    }

    constructor() : super() {
    }
}