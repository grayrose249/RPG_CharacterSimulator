package Character.Races

import Character.RPGCharacter

class Elf extends Race() {
  override def hasNightVision(): Boolean = {
    true
  }

  override def movementSpeed(): Int = {
    30
  }

  override def abilityScoreChanges(): List[Int] = {
    //Str, dex, con, int, wis, char
    List(0,2,0,0,0,0)
  }

  override def languages(): List[String] = {
    List("Common","Elvish")
  }

}
