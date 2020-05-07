package Character.Classes

import Character._

abstract class CombatClass(char: RPGCharacter) {

  def unarmedStrike(): Int

  def magicAttack(): Int

  def meleeAttack(): Int

  def rangeAttack(): Int

  def hitDie(): Int

  def weapon(): String

  def startHP(): Int

  def heal(): Int

}
