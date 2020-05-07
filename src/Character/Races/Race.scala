package Character.Races

import Character._

abstract class Race() {

  def hasNightVision(): Boolean

  def movementSpeed(): Int

  def abilityScoreChanges(): List[Int]

  def languages(): List[String]

}
