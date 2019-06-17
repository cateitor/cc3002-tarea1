package tcg.tests;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.ElectricEnergy;
import tcg.fighting.FightingEnergy;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.grass.GrassEnergy;
import tcg.psychic.PsychicEnergy;
import tcg.trainer.Trainer;
import tcg.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EnergyTest {
    private IEnergy electricEnergy;
    private IEnergy fireEnergy;
    private IEnergy grassEnergy;
    private IEnergy waterEnergy;
    private IEnergy psychicEnergy;
    private IEnergy fightingEnergy;

    @Before
    public void setUp(){
        electricEnergy = new ElectricEnergy();
        fireEnergy = new FireEnergy();
        grassEnergy = new GrassEnergy();
        waterEnergy = new WaterEnergy();
        psychicEnergy = new PsychicEnergy();
        fightingEnergy = new FightingEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(electricEnergy, new ElectricEnergy());
        assertEquals(fireEnergy,new FireEnergy());
        assertEquals(grassEnergy,new GrassEnergy());
        assertNotEquals(fireEnergy,electricEnergy);
        assertNotEquals(fightingEnergy,psychicEnergy);
        assertNotEquals(waterEnergy,grassEnergy);
        assertEquals(psychicEnergy,new PsychicEnergy());
    }

    @Test
    public void addEnergyToPokemonTest(){
        EnergyCounter energyCounter = new EnergyCounter();
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        energyCounter.setElectricEnergy(1);
        electricEnergy.addEnergyToPokemon(charmander);
        assertEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
        fireEnergy.addEnergyToPokemon(charmander);
        energyCounter.setFireEnergy(1);
        assertEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
        waterEnergy.addEnergyToPokemon(charmander);
        assertNotEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
        energyCounter.setWaterEnergy(1);
        grassEnergy.addEnergyToPokemon(charmander);
        energyCounter.setGrassEnergy(1);;
        assertEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
        energyCounter.setWaterEnergy(1);
        assertEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
        fightingEnergy.addEnergyToPokemon(charmander);
        psychicEnergy.addEnergyToPokemon(charmander);
        energyCounter.setFightingEnergy(2);
        energyCounter.setPsychicEnergy(1);
        assertEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
        fightingEnergy.addEnergyToPokemon(charmander);
        energyCounter.setFightingEnergy(2);
        assertEquals(energyCounter.getEnergies(),charmander.getEnergies().getEnergies());
    }

    @Test
    public void addEnergyFromHandTest(){
        Trainer t = new Trainer();
        Controller c = new Controller();
        t.setController(c);
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        t.setActivePokemon(charmander);
        t.setSelectedPokemon(6);
        assertEquals(charmander,t.getSelectedPokemon());
        ArrayList<ICard> hand = new ArrayList<ICard>();
        hand.add(new FireEnergy());
        t.setHand(hand);
        t.play(0);
        EnergyCounter e = new EnergyCounter();
        e.setFireEnergy(1);
        assertEquals(e.getEnergies(),charmander.getEnergies().getEnergies());
        hand.add(new FightingEnergy());
        t.setHand(hand);
        t.setSelectedPokemon(6);
        t.play(0);
        e.setFightingEnergy(1);
        assertNotEquals(e.getEnergies(),charmander.getEnergies().getEnergies());
    }

    @Test
    public void addFightingEnergyFromHand(){
        Trainer t = new Trainer();
        Controller c = new Controller();
        t.setController(c);
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        t.setActivePokemon(charmander);
        t.setSelectedPokemon(6);
        assertEquals(charmander,t.getSelectedPokemon());
        ArrayList<ICard> hand = new ArrayList<ICard>();
        hand.add(new FightingEnergy());
        t.setHand(hand);
        t.play(0);
        EnergyCounter e = new EnergyCounter();
        e.setFightingEnergy(1);
        assertEquals(e.getEnergies(),charmander.getEnergies().getEnergies());
    }

    @Test
    public void addGrassEnergyFromHand(){
        Trainer t = new Trainer();
        Controller c = new Controller();
        t.setController(c);
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        t.setActivePokemon(charmander);
        t.setSelectedPokemon(6);
        assertEquals(charmander,t.getSelectedPokemon());
        ArrayList<ICard> hand = new ArrayList<ICard>();
        hand.add(new GrassEnergy());
        t.setHand(hand);
        t.play(0);
        EnergyCounter e = new EnergyCounter();
        e.setGrassEnergy(1);
        assertEquals(e.getEnergies(),charmander.getEnergies().getEnergies());
    }

    @Test
    public void addPsychicEnergyFromHand(){
        Trainer t = new Trainer();
        Controller c = new Controller();
        t.setController(c);
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        t.setActivePokemon(charmander);
        t.setSelectedPokemon(6);
        assertEquals(charmander,t.getSelectedPokemon());
        ArrayList<ICard> hand = new ArrayList<ICard>();
        hand.add(new PsychicEnergy());
        t.setHand(hand);
        t.play(0);
        EnergyCounter e = new EnergyCounter();
        e.setPsychicEnergy(1);
        assertEquals(e.getEnergies(),charmander.getEnergies().getEnergies());
    }

}
