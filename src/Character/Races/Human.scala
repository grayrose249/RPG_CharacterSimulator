package Character.Races

import Character._

class Human () extends Race(){

  override def hasNightVision(): Boolean = {
    false
  }

  override def movementSpeed(): Int = {
    30
  }

  override def abilityScoreChanges(): List[Int] = {
    //Str, dex, con, int, wis, char
    List(1,1,1,1,1,1)
  }

  override def languages(): List[String] = {
    List("Common")
  }

}
