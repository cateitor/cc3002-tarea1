package tcg.fighting;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.electric.ElectricPokemon;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.fire.FirePokemon;
import tcg.grass.GrassAttack;
import tcg.grass.GrassEnergy;
import tcg.grass.GrassPokemon;
import tcg.psychic.PsychicAttack;
import tcg.psychic.PsychicEnergy;
import tcg.psychic.PsychicPokemon;
import tcg.water.WaterAttack;
import tcg.water.WaterEnergy;
import tcg.water.WaterPokemon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class FightingPokemonTest {
    private IPokemon bulbasaur, pikachu, charmander, machop, abra, squirtle;
    private IAttack grassAttack, fireAttack, electricAttack, fightingAttack, psychicAttack, waterAttack;
    private IEnergy grassEnergy, electricEnergy, fireEnergy, fightingEnergy, psychicEnergy, waterEnergy;

    @Before
    public void setUp() {

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

        charmander = new FirePokemon(4, 70, new ArrayList<IEnergy>(Arrays.asList(fireEnergy, fireEnergy)), new ArrayList<IAttack>(Arrays.asList(fireAttack)));
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(Arrays.asList(grassEnergy, grassEnergy)), new ArrayList<IAttack>(Arrays.asList(grassAttack)));
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(Arrays.asList(waterEnergy, waterEnergy)), new ArrayList<IAttack>(Arrays.asList(waterAttack)));
        pikachu = new ElectricPokemon(25, 70, new ArrayList<IEnergy>(Arrays.asList(electricEnergy, electricEnergy)), new ArrayList<IAttack>(Arrays.asList(electricAttack)));
        abra = new PsychicPokemon(63, 70, new ArrayList<IEnergy>(Arrays.asList(psychicEnergy, psychicEnergy)), new ArrayList<IAttack>(Arrays.asList(psychicAttack)));
        machop = new FightingPokemon(66, 70, new ArrayList<IEnergy>(Arrays.asList(fightingEnergy, fightingEnergy)), new ArrayList<IAttack>(Arrays.asList(fightingAttack)));

        charmander.selectAttack(0);
        bulbasaur.selectAttack(0);
        squirtle.selectAttack(0);
        abra.selectAttack(0);
        machop.selectAttack(0);
        pikachu.selectAttack(0);

    }

    @Test
    public void costructorTest(){
        assertEquals(66,machop.getId());
        assertEquals(70,machop.getHp());
        assertEquals(2,machop.numberOfEnergies());
        assertEquals(1,machop.getAttacks().size());
        assertEquals(fightingAttack,machop.getAttacks().get(0));
    }

    @Test
    public void selectAttackTest(){
        pikachu.selectAttack(0);
        assertEquals(fightingAttack,machop.getSelectedAttack());
    }

    @Test
    public void attackTest(){
        machop.selectAttack(0);
        machop.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receivePsychicAttackTest(){
        assertEquals(70,machop.getHp());
        abra.attack(machop);
        assertEquals(10,machop.getHp());
    }

    @Test
    public void receiveElectricAttackTest(){
        assertEquals(70,machop.getHp());
        pikachu.attack(machop);
        assertEquals(40,machop.getHp());
    }

    @Test
    public void receiveWaterAttackTest(){
        assertEquals(70,machop.getHp());
        squirtle.attack(machop);
        assertEquals(40,machop.getHp());
    }

    @Test
    public void receiveGrassAttackTest(){
        assertEquals(70,machop.getHp());
        bulbasaur.attack(machop);
        assertEquals(10,machop.getHp());
    }

    @Test
    public void receiveFightingAttackTest(){
        assertEquals(70,machop.getHp());
        machop.attack(machop);
        assertEquals(40,machop.getHp());
    }

    @Test
    public void receiveFireAttackTest(){
        assertEquals(70,machop.getHp());
        charmander.attack(machop);
        assertEquals(40,machop.getHp());
    }

    @Test
    public void isDead(){
        assertNotEquals(true,machop.isDead());
        bulbasaur.attack(machop);
        bulbasaur.attack(machop);
        assertEquals(true,machop.isDead());
    }

    @Test
    public void addAttack(){
        machop.addAttack(new FightingAttack("Kick",40,2,"High Kick!"));
        assertEquals(2,machop.getAttacks().size());
        assertEquals("Kick", machop.getAttacks().get(1).getName());
        machop.addAttack(fightingAttack);
        machop.addAttack(fightingAttack);
        machop.addAttack(fightingAttack);
        assertEquals(4,machop.getAttacks().size());
    }

    @Test
    public void addEnergy(){
        machop.addEnergy(fightingEnergy);
        assertEquals(3,machop.getEnergies().size());
        assertEquals(new FightingEnergy(),machop.getEnergies().get(2));
    }

}
