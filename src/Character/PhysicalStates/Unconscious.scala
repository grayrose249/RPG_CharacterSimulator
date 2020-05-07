package Character.PhysicalStates

import Character.RPGCharacter

class Unconscious(char: RPGCharacter) extends State(char){
  override def attack(enemy: RPGCharacter): Unit = {
    println(char.name + " is unconscious and can't attack!")
  }

  override def spellAttack(enemy: RPGCharacter): Unit = {
    println(char.name + " is unconscious and can't cast spells!")
  }

  override def dash(): Int = {
    println(char.name + " is unconscious and can't dash!")
    0
  }

  override def unarmedStrike(enemy: RPGCharacter): Unit = {
    println(char.name + " is unconscious and can't attack!")
  }

  override def heal(ally: RPGCharacter): Unit = {
    println(char.name + " is unconscious and can't heal!")
  }

  override def becomeUnconscious(): Unit = {
    //Already unconscious
  }

  override def becomeNormal(): Unit = {
    println(char.name + " has returned to normal.")
    char.state = new Normal(char)
  }

  override def becomeExhausted(): Unit = {
    println(char.name + " is now exhausted.")
    char.state = new Exhausted(char)
    char.HP = 1
  }

  override def getState(): String = {
    "Unconscious"
  }
}
