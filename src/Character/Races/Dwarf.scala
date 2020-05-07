package Character.Races

import Character.RPGCharacter

class Dwarf extends Race() {

  override def hasNightVision(): Boolean = {
    true
  }

  override def movementSpeed(): Int = {
    25
  }

  override def abilityScoreChanges(): List[Int] = {
    //Str, dex, con, int, wis, char
    List(0,0,2,0,0,0)
  }

  override def languages(): List[String] = {
    List("Common","Dwarvish")
  }
}
