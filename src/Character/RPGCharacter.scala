package Character

import Character.Classes.{Cleric, CombatClass, Fighter, Ranger, Wizard}
import Character.Races.{Dwarf, Elf, Halfling, Human, Race}
import Character.PhysicalStates._

class RPGCharacter(thisName: String, thisRace: Race, thisClass: String, thisScores: List[Int]) {
//State Variables ------------------------------------------------------------------------------------------------------
  var state: State = new Normal(this)
  var charClass: CombatClass = new Fighter(this)
  this.setCharTraits()
  var race: Race = thisRace

  //Order: str, dex, con, int, wis, char
  var abilityScores: List[Int] = thisScores
  this.changeAbilityScores() //add racial increases/decreases
  var abilityScoreMods: List[Int] = List()
  this.abilityScoreModifiers() //calculate modifiers

  var name: String = thisName
  var HP: Int = this.charClass.startHP()
  var HPMax: Int = this.charClass.startHP()
  var level: Int = 1
  var nightVision: Boolean = this.race.hasNightVision()
  var languages: List[String] = this.race.languages()
  var movementSpeed: Int = this.race.movementSpeed()

  //Methods ------------------------------------------------------------------------------------------------------------
  //Add stat modifiers from race
  def changeAbilityScores(): Unit = {
    var newList: List[Int] = List()
    var temp = this.race.abilityScoreChanges()
    for(i <- 0 to 5){
      var temp2 = temp(i) + abilityScores(i)
      newList = newList :+ temp2
    }
    this.abilityScores = newList
  }

  //Set ability score modifiers based on value of ability score
  def abilityScoreModifiers(): Unit = {
    for(i <- 0 to 5){
      var score = this.abilityScores(i)
      if(score <= 1){
        this.abilityScoreMods = abilityScoreMods :+ -5
      }
      else if(score == 2 || score == 3){
        this.abilityScoreMods = abilityScoreMods :+ -4
      }
      else if(score == 4 || score == 5){
        this.abilityScoreMods = abilityScoreMods :+ -3
      }
      else if(score == 6 || score == 7){
        this.abilityScoreMods = abilityScoreMods :+ -2
      }
      else if(score == 8 || score == 9){
        this.abilityScoreMods = abilityScoreMods :+ -1
      }
      else if(score == 10 || score == 11){
        this.abilityScoreMods = abilityScoreMods :+ 0
      }
      else if(score == 12 || score == 13){
        this.abilityScoreMods = abilityScoreMods :+ 1
      }
      else if(score == 14 || score == 15){
        this.abilityScoreMods = abilityScoreMods :+ 2
      }
      else if(score == 16 || score == 17){
        this.abilityScoreMods = abilityScoreMods :+ 3
      }
      else if(score == 18 || score == 19){
        this.abilityScoreMods = abilityScoreMods :+ 4
      }
      else if(score == 20 || score == 21){
        this.abilityScoreMods = abilityScoreMods :+ 5
      }
      else if(score == 22 || score == 23){
        this.abilityScoreMods = abilityScoreMods :+ 6
      }
      else if(score == 24 || score == 25){
        this.abilityScoreMods = abilityScoreMods :+ 7
      }
      else if(score == 26 || score == 27){
        this.abilityScoreMods = abilityScoreMods :+ 8
      }
      else if(score == 28 || score == 29){
        this.abilityScoreMods = abilityScoreMods :+ 9
      }
      else if(score >= 30){
        this.abilityScoreMods = abilityScoreMods :+ 10
      }
    }
  }

  //Select class based on user input strings
  def setCharTraits(): Unit = {
    if(this.thisClass == "Fighter"){
      this.charClass = new Fighter(this)
    }
    else if(this.thisClass == "Cleric"){
      this.charClass = new Cleric(this)
    }
    else if(this.thisClass == "Wizard"){
      this.charClass = new Wizard(this)
    }
    else if(this.thisClass == "Ranger"){
      this.charClass = new Ranger(this)
    }
    else{
      println("Class not found. Character class set to fighter.")
    }
  }

  def checkHP(): Unit = {
    if(this.HP <= 0){
      this.state.becomeUnconscious()
    }
    if(this.HP > 0){
      this.state = new Normal(this)
    }
    if(this.HP > this.HPMax){
      this.HP = HPMax
    }
  }

}
