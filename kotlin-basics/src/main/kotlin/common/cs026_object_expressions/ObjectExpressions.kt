package common.cs026_object_expressions

import common.common_1.printSeparator

fun main() {
    anonObjFromScratch()
    printSeparator()

    anonObjDerived()
    printSeparator()

    anonObjInternalPropsAccess()
    printSeparator()
}

fun anonObjFromScratch() {
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"
        // object expressions extend Any, so
        // `override` is required on `toString()`
        override fun toString() = "$hello $world"
    }

    println(helloWorld)
}

open class Car(x: Int) {
    public open var speed: Int = x
    public open var seats: Int = 4
    fun printInfo() = println("Car speed: $speed, seats num: $seats")
}

interface Truck {
    val liftingCapacity: Double // грузоподъемность
}

fun anonObjDerived() {
    val bus = object : Car(0) {
        override var seats = 24
    }
    bus.printInfo()
    bus.speed = 15
    bus.printInfo()

    val truck = object : Car(0), Truck {
        override val liftingCapacity: Double = 1500.0
        var filledCapacity: Double = 0.0
        fun supply(amount : Double) {
            if (amount < 0.0) {
                println("Negative amount validation!")
                return
            }
            var result = filledCapacity + amount;
            if (result <= liftingCapacity) {
                filledCapacity = result
                println("Truck now lift $filledCapacity kg")
            } else {
                println("Truck cannot lift more than $liftingCapacity kg")
            }
        }
    }
    truck.speed = 20
    truck.printInfo()
    truck.supply(700.0)
    truck.supply(-2.0)
    truck.supply(567.0)
    truck.supply(900.0)
}

class Parking {
    private fun callThePolice() = object: Car(100) {
        val weapon: MutableList<String> = mutableListOf("PM", "PP-19 Vityaz")
    }

    fun printPoliceInfo() {
        val policeCar = callThePolice()
        println("Police car has speed ${policeCar.speed} and is armoured with ${policeCar.weapon}")
    }

    fun getPoliceCar() : Car {
        return callThePolice()
    }
}

fun anonObjInternalPropsAccess() {
    val parking = Parking()
    parking.printPoliceInfo()
    val policeCar = parking.getPoliceCar()
    // policeCar.weapon.clear() // ERROR - нет доступа к переменной weapon

    val fireTruck = object: Car(70) {
        var waterVolume: Int = 0
    }
    fireTruck.waterVolume = 14 // Есть доступ к переменной weapon
    println("Fire truck has water volume ${fireTruck.waterVolume}")
}




