package Character.Classes

import scala.util.Random
import Character.RPGCharacter

class Fighter(char: RPGCharacter) extends CombatClass(char: RPGCharacter) {

  override def unarmedStrike(): Int = {
    1 + char.abilityScoreMods(0) //1 + strength
  }

  override def magicAttack(): Int = {
    0
  }

  override def meleeAttack(): Int = {
    val rando = scala.util.Random
    rando.nextInt(9) + char.abilityScoreMods(0) //1d8 + strength
  }

  override def rangeAttack(): Int = {
    0
  }

  override def hitDie(): Int = {
    val rando = scala.util.Random
    rando.nextInt(11) + char.abilityScoreMods(2) //1d10 + con
  }

  override def weapon(): String = {
    "Longsword"
  }

  override def startHP(): Int = {
    10 + char.abilityScoreMods(2) //max on a d10 + con
  }

  override def heal(): Int = {
    0
  }
}
