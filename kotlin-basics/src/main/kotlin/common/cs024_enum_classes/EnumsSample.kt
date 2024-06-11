package common.cs024_enum_classes

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
        override fun isActive() = false
    },

    TALKING {
        override fun signal() = WAITING
        // дефолтное поведение isActive()
    };

    abstract fun signal(): ProtocolState
    open fun isActive() = true
}

enum class IntArithmetics :
    BinaryOperator<Int>, IntBinaryOperator {

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}