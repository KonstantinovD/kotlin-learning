package common.cs020_extensions

import common.common_1.printSeparator

fun main() {
    val intList = mutableListOf(1, -2, 3, 4, 0)
    intList.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
    println("After swap: $intList")
    intList.negate()
    println("After negate: $intList")
    val strList = mutableListOf("Hello", "World")
    strList.swap(0, 1)
    println("After swap: $strList")
    printSeparator()

    Connection(Host("kotl.in"), 443).connect()
    //Host("kotl.in").printConnectionString()
    // error, the extension function is unavailable outside Connection
}

fun MutableList<Int>.negate() = this.replaceAll { if (it > 0) -it else it }

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

class Host(val hostname: String) {
    fun printHostname() { print(hostname) }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }

    fun Host.printConnectionString() {
        printHostname()   // calls Host.printHostname()
        print(":")
        printPort()   // calls Connection.printPort()
        println()

        // calls Host.toString() - приоритет имеет расширяемый класс
        println(toString()) // common.cs020_extensions.Host@506e1b77
        // calls Connection.toString() - явный вызов метода класса,
        //  владеющего расширяемым классом
        println(this@Connection.toString()) // common.cs020_extensions.Connection@4fca772d
    }

    fun connect() {
        /*...*/
        host.printConnectionString()   // calls the extension function
    }
}