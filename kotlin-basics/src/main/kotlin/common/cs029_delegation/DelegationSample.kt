package common.cs029_delegation

import common.common_1.printSeparator

fun main() {
    delegatedGun()
    printSeparator()

    delegatedNoOverrideProperty()
    printSeparator()
}

interface Gun {
    fun fire()
    fun reload()
}

class GunImpl(var shell: String) : Gun {
    override fun fire() = println("Fire from gun with $shell shell")
    override fun reload() = println("Reload in 10 seconds")
}

class Tank(gun: Gun) : Gun by gun {
    override fun reload() = println("Reload in 14 seconds from tank ammunition rack")
}

fun delegatedGun() {
    val atGun = GunImpl("HE")
    atGun.fire()
    atGun.reload()

    val tankGun = GunImpl("AP")
    val tank = Tank(tankGun)
    tank.fire()
    tankGun.shell = "APC"
    tank.reload()
    tank.fire()
}

interface Engine{
    var hp: Double
    fun start()
}

class BaseEngine() : Engine {
    override var hp = 67.0
    override fun start() { println("Запуск двигателя с мощностью $hp лс") }
}

class Truck(e: Engine) : Engine by e {
    // не окажет влияние на мощность двигателя
    override var hp = 240.0
}

fun delegatedNoOverrideProperty() {
    var engine = BaseEngine()
    engine.start()

    var truckEngine = BaseEngine()
    var truck = Truck(truckEngine)
    truck.start()
    truck.hp = 300.0
    truck.start()
    truckEngine.hp = 280.0
    truck.start()
}
