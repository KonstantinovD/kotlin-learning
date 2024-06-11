package common.cs027_object_declarations

import common.cs027_object_declarations.WeaponConstants.AK_74
import common.cs027_object_declarations.WeaponConstants.MOSIN_NAGAN
import common.cs027_object_declarations.WeaponConstants.PP_19
import common.cs027_object_declarations.WeaponConstants.SKS

object WeaponConstants { // можно использовать как класс утилит
    const val PM = "PM"
    const val PP_19 =  "PP-19 Vityaz"
    const val AK_74 =  "AK-74"
    const val MOSIN_NAGAN =  "Mosin-Nagan"
    const val SKS =  "SKS"
}

@JvmInline
value class Weapon(val value: String) {
    fun fire() {
        println("Fire from $value: BOOOM...")
    }
}

object Arsenal {
    val weapons = mutableListOf<Weapon>()

    fun addWeapon(weapon : Weapon) {
        weapons.add(weapon)
    }

    fun getWeapon(weapon : Weapon) : Weapon? {
        // вариант циклов номер 1
        /*
        for (i in weapons.indices) {
            if (weapons[i].equals(weapon)) {
                val res = weapons[i]
                weapons.removeAt(i)
                return res
            }
        }*/

        // вариант циклов номер 2 - более лаконичный
        for ((index, value) in weapons.withIndex()) {
            if (value.equals(weapon)) {
                weapons.removeAt(index)
                return value
            }
        }
        return null
    }

    fun listWeapons() {
        println("All weapons in arsenal: ${weapons}")
    }
}

fun main() {

    Arsenal.addWeapon(Weapon(AK_74))
    Arsenal.addWeapon(Weapon(PP_19))
    Arsenal.addWeapon(Weapon(PP_19))
    Arsenal.addWeapon(Weapon(SKS))
    Arsenal.listWeapons()

    Arsenal.getWeapon(Weapon(MOSIN_NAGAN))?.fire()
    Arsenal.listWeapons()

    Arsenal.getWeapon(Weapon(PP_19))?.fire()
    Arsenal.listWeapons()
    Arsenal.getWeapon(Weapon(SKS))?.fire()
    Arsenal.listWeapons()
}