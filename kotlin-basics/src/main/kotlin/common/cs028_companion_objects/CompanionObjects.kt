package common.cs028_companion_objects

import java.lang.IllegalArgumentException
import org.apache.commons.lang3.StringUtils

open class Gun(val model: String, var pistols: Int, var side: String) {
    fun fire() {

        println("$model shoot $pistols pistols: B${ StringUtils.repeat('O', pistols/10) }M...")
    }
}

class MachineGun(model: String, pistols: Int, side: String) : Gun(model, pistols, side) {
    companion object Factory {
        fun create(name: String = "DP-27") =
            when (name) {
                "DP-27" -> MachineGun("DP-27", 47, "USSR")
                "MG-34" -> MachineGun("MG-34", 200, "Germany")
                "DSHK" -> MachineGun("DSHK", 50, "USSR")
                else -> {
                    throw IllegalArgumentException("Cannot create mashine gun with name $name")
                }
            }
    }
}

class SubmachineGun(model: String, pistols: Int, side: String) : Gun(model, pistols, side) {
    // объект-компаньон без имени имеет имя 'Companion'
    companion object {
        fun create(name: String = "PPSh-41") =
            when (name) {
                "PPSh-41" -> SubmachineGun("PPSh-41", 71, "USSR")
                "PPS-43" -> SubmachineGun("PPS-43", 35, "USSR")
                "MP-40" -> SubmachineGun("MP-40", 32, "Germany")
                else -> {
                    throw IllegalArgumentException("Cannot create submashine gun with name $name")
                }
            }
    }
}

fun main() {
    val mgInstance = MachineGun.create() // создать объект фабрикой
    val mgFactory = MachineGun.Factory // объект фабрики
    // объект фабрики можно получить, просто вызвав класс, содержащий компаньон
    val mgFactory2 = MachineGun // потому что компаньон может быть только 1

    val smgInstance = SubmachineGun.create() // создать объект фабрикой
    val smgFactory = SubmachineGun.Companion // объект-компаньон без имени
    val smgFactory2 = SubmachineGun // объект фабрики

    var guns = listOf(
        mgInstance,
        mgFactory.create("MG-34"),
        mgFactory2.create("DSHK"),
        smgInstance,
        smgFactory.create("PPS-43"),
        smgFactory2.create("MP-40")
    )

    guns.forEach(Gun::fire)
}
