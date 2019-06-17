package tcg.tests;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.BasicElectricPokemon;
import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.fighting.BasicFightingPokemon;
import tcg.fighting.FightingAttack;
import tcg.fighting.FightingEnergy;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.grass.BasicGrassPokemon;
import tcg.grass.GrassAttack;
import tcg.grass.GrassEnergy;
import tcg.psychic.BasicPsychicPokemon;
import tcg.psychic.PsychicAttack;
import tcg.psychic.PsychicEnergy;
import tcg.water.BasicWaterPokemon;
import tcg.water.WaterAttack;
import tcg.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PokemonTest {
    private IPokemon bulbasaur, pikachu, charmander, machop, abra, squirtle;
    private IAbility grassAttack, fireAttack, electricAttack, fightingAttack, psychicAttack, waterAttack;
    private IEnergy grassEnergy, electricEnergy, fireEnergy, fightingEnergy, psychicEnergy, waterEnergy;

    @Before
    public void setUp(){
        grassEnergy = new GrassEnergy();
        electricEnergy = new ElectricEnergy();
        fireEnergy = new FireEnergy();
        fightingEnergy = new FightingEnergy();
        psychicEnergy = new PsychicEnergy();
        waterEnergy = new WaterEnergy();

        fightingAttack = new FightingAttack("Punch", 30, 1, "It hurts!");
        electricAttack = new ElectricAttack("Thunder", 30, 2, "The pokemon is paralyzed!");
        fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        grassAttack = new GrassAttack("Sharp Leaf", 30, 2, "It cuts the pokemon");
        psychicAttack = new PsychicAttack("Zen Force", 30, 2, "Ohmm");
        waterAttack = new WaterAttack("Rain Blow", 30, 1, "It's raining!");

        charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        bulbasaur = new BasicGrassPokemon(1, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        pikachu = new BasicElectricPokemon(25,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));
        abra = new BasicPsychicPokemon(63,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        machop = new BasicFightingPokemon(66,70,new EnergyCounter() ,new ArrayList<IAbility>(Arrays.asList(fightingAttack)));

        charmander.selectAttack(0);
        bulbasaur.selectAttack(0);
        squirtle.selectAttack(0);
        abra.selectAttack(0);
        machop.selectAttack(0);

        charmander.getEnergies().setFireEnergy(2);
        bulbasaur.getEnergies().setGrassEnergy(2);
        squirtle.getEnergies().setWaterEnergy(2);
        pikachu.getEnergies().setElectricEnergy(2);
        abra.getEnergies().setPsychicEnergy(2);
        machop.getEnergies().setFightingEnergy(2);

    }

    @Test
    public void costructorTest(){
        EnergyCounter e = new EnergyCounter();
        e.setElectricEnergy(2);
        assertEquals(25,pikachu.getId());
        assertEquals(70,pikachu.getHp());
        assertEquals(e.getEnergies(),pikachu.getEnergies().getEnergies());
        assertEquals(1,pikachu.getAttacks().size());
        assertEquals(electricAttack,pikachu.getAttacks().get(0));
        assertNull(pikachu.getSelectedAttack());
    }

    @Test
    public void selectAttackTest(){
        pikachu.selectAttack(0);
        assertEquals(electricAttack,pikachu.getSelectedAttack());
    }

    @Test
    public void attackTest(){
        pikachu.selectAttack(0);
        pikachu.attack(charmander);
        assertEquals(40,charmander.getCurrentHp());
    }

    @Test
    public void receivePsychicAttackTest(){
        assertEquals(70,pikachu.getHp());
        abra.attack(pikachu);
        assertEquals(40,pikachu.getCurrentHp());
    }

    @Test
    public void receiveElectricAttackTest(){
        assertEquals(70,pikachu.getHp());
        pikachu.getAttacks().add(electricAttack);
        pikachu.selectAttack(0);
        pikachu.attack(pikachu);
        assertEquals(40,pikachu.getCurrentHp());
    }

    @Test
    public void receiveWaterAttackTest(){
        assertEquals(70,pikachu.getHp());
        squirtle.attack(pikachu);
        assertEquals(40,pikachu.getCurrentHp());
    }

    @Test
    public void receiveGrassAttackTest(){
        assertEquals(70,pikachu.getHp());
        bulbasaur.attack(pikachu);
        assertEquals(40,pikachu.getCurrentHp());
    }

    @Test
    public void receiveFightingAttackTest(){
        assertEquals(70,pikachu.getHp());
        machop.attack(pikachu);
        assertEquals(10,pikachu.getCurrentHp());
    }

    @Test
    public void receiveFireAttackTest(){
        assertEquals(70,pikachu.getHp());
        charmander.attack(pikachu);
        assertEquals(40,pikachu.getCurrentHp());
    }

    @Test
    public void isDead(){
        assertNotEquals(true,pikachu.isDead());
        machop.attack(pikachu);
        machop.attack(pikachu);
        assertEquals(true,pikachu.isDead());
    }

    @Test
    public void addAttack(){
        pikachu.addAttack(new ElectricAttack("Thunder Bolt",40,2,"Pokemon used Thunder Bolt!"));
        assertEquals(2,pikachu.getAttacks().size());
        assertEquals("Thunder Bolt", pikachu.getAttacks().get(1).getName());
        pikachu.addAttack(electricAttack);
        pikachu.addAttack(electricAttack);
        pikachu.addAttack(electricAttack);
        assertEquals(4,pikachu.getAttacks().size());
    }

    @Test
    public void setPreIdTest(){
        pikachu.setPreId(20);
        assertEquals(0,pikachu.getPreId());
        int id = pikachu.getPreId();
        assertEquals(0,id);
    }


}
