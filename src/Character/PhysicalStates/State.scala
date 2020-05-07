package Character.PhysicalStates

import Character.RPGCharacter

abstract class State(char: RPGCharacter){

  def getState(): String

  def attack(enemy: RPGCharacter): Unit

  def spellAttack(enemy: RPGCharacter): Unit

  def dash(): Int

  def unarmedStrike(enemy: RPGCharacter): Unit

  def heal(ally: RPGCharacter): Unit

  def becomeUnconscious(): Unit

  def becomeNormal(): Unit

  def becomeExhausted(): Unit

}
