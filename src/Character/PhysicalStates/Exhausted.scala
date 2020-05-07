package Character.PhysicalStates

import Character.RPGCharacter

class Exhausted(char: RPGCharacter) extends State(char){
  //Mimics level 3 exhaustion
  //Must be manually given to a character (not reliant on HP)

  override def attack(enemy: RPGCharacter): Unit = {
    val rando = scala.util.Random
    val hit = rando.nextInt(2)
    if(hit == 0){
      var temp = char.charClass.meleeAttack()
      var temp2 = char.charClass.rangeAttack()
      println(char.name + " attacks " + enemy.name + " with a " + char.charClass.weapon() + " for " + math.max(temp,temp2) + " damage!")
      enemy.HP = enemy.HP - math.max(temp,temp2)
      enemy.checkHP()
    }
    else{
      println(char.name + " is exhausted and misses!")
    }
  }

  override def spellAttack(enemy: RPGCharacter): Unit = {
    val rando = scala.util.Random
    val hit = rando.nextInt(2)
    if(hit == 0){
      var temp = char.charClass.magicAttack()
      if(temp == 0){
        println(char.name + " has no spells!")
      }
      else{
        println(char.name + " attacks " + enemy.name + " with a spell for " + temp + " damage!")
        enemy.HP = enemy.HP - temp
        enemy.checkHP()
      }
    }
    else{
      println(char.name + " is exhausted and misses!")
    }
  }

  override def dash(): Int = {
    println(char.name + " is exhausted and moves up to " + char.race.movementSpeed() * 2 + " feet.")
    char.race.movementSpeed() /2
  }

  override def unarmedStrike(enemy: RPGCharacter): Unit = {
    val rando = scala.util.Random
    val hit = rando.nextInt(2)
    if(hit == 0){
      var temp = char.charClass.unarmedStrike()
      println(char.name + " punches " + enemy.name + " for " + temp + " damage!")
      enemy.HP = enemy.HP - temp
      enemy.checkHP()
    }
    else{
      println(char.name + " is exhausted and misses!")
    }
  }

  override def heal(ally: RPGCharacter): Unit = {
    var temp = char.charClass.heal()
    if(temp == 0){
      println(char.name + " can't heal!")
    }
    else{
      println(char.name + " heals " + ally.name + " for " + temp + " hit points!")
      ally.HP = ally.HP + temp
      ally.checkHP()
    }
  }

  override def becomeUnconscious(): Unit = {
    if(char.HP <= 0){
      println(char.name + " is unconscious!")
      char.state = new Unconscious(char)
    }
  }

  override def becomeNormal(): Unit = {
    println(char.name + " has returned to normal.")
    char.state = new Normal(char)
  }

  override def becomeExhausted(): Unit = {
    //Already exhausted
  }

  override def getState(): String = {
    "Exhausted"
  }
}
