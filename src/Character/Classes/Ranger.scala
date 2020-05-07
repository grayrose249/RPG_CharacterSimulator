package Character.Classes

import Character.RPGCharacter

class Ranger(char: RPGCharacter) extends CombatClass(char){

  override def unarmedStrike(): Int = {
    1 + char.abilityScoreMods(0) //1 + strength
  }

  override def magicAttack(): Int = {
    0
  }

  override def meleeAttack(): Int = {
    0
  }

  override def rangeAttack(): Int = {
    val rando = scala.util.Random
    rando.nextInt(9) + char.abilityScoreMods(1) //1d8 + dex
  }

  override def hitDie(): Int = {
    val rando = scala.util.Random
    rando.nextInt(11) + char.abilityScoreMods(2) //1d10 + con
  }

  override def weapon(): String = {
    "Longbow"
  }

  override def startHP(): Int = {
    10 + char.abilityScoreMods(2) //max on a d10 + con
  }

  override def heal(): Int = {
    0
  }
}
