package Character.Classes

import Character.RPGCharacter

class Wizard(char: RPGCharacter) extends CombatClass(char){
  //Casting Ability: INT

  override def unarmedStrike(): Int = {
    1 + char.abilityScoreMods(0) //1 + strength
  }

  override def magicAttack(): Int = {
    //Magic Missile
    val rando = scala.util.Random
    var a = rando.nextInt(5) + 1
    var b = rando.nextInt(5) + 1
    var c = rando.nextInt(5) + 1
    //1d4 + 1 three times
    a + b + c
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
    rando.nextInt(7) + char.abilityScoreMods(2) //1d6 + con
  }

  override def weapon(): String = {
    "Quarterstaff"
  }

  override def startHP(): Int = {
    6 + char.abilityScoreMods(2) //max on a d6 + con
  }

  override def heal(): Int = {
    0
  }
}
