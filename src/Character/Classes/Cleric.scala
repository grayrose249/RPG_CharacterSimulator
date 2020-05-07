package Character.Classes

import Character.RPGCharacter

class Cleric(char: RPGCharacter) extends CombatClass(char: RPGCharacter){
  //Casting Ability: WIS

  override def unarmedStrike(): Int = {
    1 + char.abilityScoreMods(0) //1 + strength
  }

  override def magicAttack(): Int = {
    //Sacred Flame
    val rando = scala.util.Random
    rando.nextInt(9) + char.abilityScoreMods(4) //1d8 + wis
  }

  override def meleeAttack(): Int = {
    val rando = scala.util.Random
    rando.nextInt(7) + char.abilityScoreMods(0) //1d6 + strength
  }

  override def rangeAttack(): Int = {
    0
  }

  override def hitDie(): Int = {
    val rando = scala.util.Random
    rando.nextInt(9) + char.abilityScoreMods(2) //1d8 + con
  }

  override def weapon(): String = {
    "Mace"
  }

  override def startHP(): Int = {
    8 + char.abilityScoreMods(2) //max on a d8 + con
  }

  override def heal(): Int = {
    //Cure Wounds
    val rando = scala.util.Random
    rando.nextInt(9) + char.abilityScoreMods(4) //1d8 + wis
  }
}
