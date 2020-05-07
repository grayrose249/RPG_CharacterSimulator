package Tests

import Character.Classes.{CombatClass, Fighter}
import Character.Races.{Dwarf, Elf, Human}
import Character._
import org.scalatest.FunSuite

class TestCharacter extends FunSuite{

  test("Test Character"){

    var Guts2 = new RPGCharacter("Guts2",new Human(),"Artificer",List(10,10,10,10,10,10)) //class DNE, auto set to fighter
    var Guts = new RPGCharacter("Guts",new Human(),"Fighter",List(10,10,10,10,10,10))

    assert(Guts2.abilityScores == List(11,11,11,11,11,11),Guts2.abilityScores)
    assert(Guts2.abilityScoreMods == List(0,0,0,0,0,0),Guts2.abilityScoreMods)
    assert(Guts2.movementSpeed == 30,Guts2.movementSpeed)
    assert(Guts2.nightVision == false,Guts2.nightVision)
    assert(Guts2.languages == List("Common"),Guts2.languages)
    assert(Guts2.HP == 10,Guts2.HP)

    assert(Guts.abilityScores == List(11,11,11,11,11,11),Guts.abilityScores)
    assert(Guts.abilityScoreMods == List(0,0,0,0,0,0),Guts.abilityScoreMods)
    assert(Guts.movementSpeed == 30,Guts.movementSpeed)
    assert(Guts.nightVision == false,Guts.nightVision)
    assert(Guts.languages == List("Common"),Guts.languages)
    assert(Guts.HP == 10,Guts.HP)

  }

  test("Test Combat in Normal State"){
    var Roana = new RPGCharacter("Roana",new Elf(), "Cleric",List(12,12,12,12,12,12))
    assert(Roana.abilityScores == List(12,14,12,12,12,12),Roana.abilityScores)
    assert(Roana.abilityScoreMods == List(1,2,1,1,1,1),Roana.abilityScoreMods)

    var Killi = new RPGCharacter("Killi",new Dwarf(),"Ranger", List(12,12,12,12,12,12))
    assert(Killi.abilityScores == List(12,12,14,12,12,12),Killi.abilityScores)
    assert(Killi.abilityScoreMods == List(1,1,2,1,1,1),Killi.abilityScoreMods)

    //Roana attacks Killi
    assert(Killi.HP == 12)
    Roana.state.attack(Killi)
    assert(Killi.HP < 12)
    var newHP = Killi.HP
    Roana.state.spellAttack(Killi)
    assert(Killi.HP < newHP)

    //Roana Heals Killi
    newHP = Killi.HP
    Roana.state.heal(Killi)
    assert(Killi.HP > newHP)

    //Killi attacks Roana
    assert(Roana.HP == 9)
    Killi.state.attack(Roana)
    assert(Roana.HP < 9)
    var newHP2 = Roana.HP
    Killi.state.spellAttack(Roana) //no spells
    assert(Roana.HP == newHP2)
    Killi.state.unarmedStrike(Roana)
    assert(Roana.HP < newHP2)

    //Killi tries to heal Roana
    newHP2 = Roana.HP
    Killi.state.heal(Roana) //cant heal
    assert(Roana.HP == newHP2)

    //Test Dash
    assert(Killi.movementSpeed == 25)
    Killi.state.dash()
    assert(Killi.movementSpeed * 2 == 50)

  }

  test("Test Combat with States"){
    var Roran = new RPGCharacter("Roran",new Elf(), "Cleric",List(12,12,12,12,12,12))
    var Filli = new RPGCharacter("Filli",new Dwarf(),"Ranger", List(12,12,12,12,12,12))

    Filli.state.attack(Roran)
    Filli.state.attack(Roran)
    Filli.state.attack(Roran)
    Filli.state.attack(Roran)
    Filli.state.attack(Roran) //Roran is unconscious (usually)

    Roran.state.attack(Filli)
    Roran.state.spellAttack(Filli)
    assert(Filli.HP == 12)

    Roran.state.becomeExhausted()
    assert(Roran.HP == 1)

    //Attack 10 times, should miss about ~5
    var misses = 0
    for(i <- 0 to 10){
      var filliBefore = Filli.HP
      Roran.state.attack(Filli)
      if(filliBefore == Filli.HP){
        misses += 1
      }
    }
    assert(misses > 0, misses)

    //Heal Killi, should auto switch states to normal
    //HP shouldn't go past max
    Roran.state.becomeNormal()
    for(i <- 0 to 10){
      Roran.state.heal(Filli)
      println("Filli's HP: " + Filli.HP)
    }
    assert(Filli.HP == 12)
    assert(Filli.state.getState() == "Normal")

  }

}
