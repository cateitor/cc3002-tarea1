package tcg.electric;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.fighting.FightingAttack;
import tcg.fighting.FightingEnergy;
import tcg.fighting.FightingPokemon;
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

public class ElectricPokemonTest {
    private IPokemon bulbasaur, pikachu, charmander, machop, abra, squirtle;
    private IAttack grassAttack, fireAttack, electricAttack, fightingAttack, psychicAttack, waterAttack;
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

        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(Arrays.asList(fireEnergy,fireEnergy)), new ArrayList<IAttack>(Arrays.asList(fireAttack)));
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(Arrays.asList(grassEnergy,grassEnergy)), new ArrayList<IAttack>(Arrays.asList(grassAttack)));
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(Arrays.asList(waterEnergy,waterEnergy)), new ArrayList<IAttack>(Arrays.asList(waterAttack)));
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(Arrays.asList(electricEnergy,electricEnergy)),new ArrayList<IAttack>(Arrays.asList(electricAttack)));
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(Arrays.asList(psychicEnergy,psychicEnergy)),new ArrayList<IAttack>(Arrays.asList(psychicAttack)));
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(Arrays.asList(fightingEnergy,fightingEnergy)),new ArrayList<IAttack>(Arrays.asList(fightingAttack)));

        charmander.selectAttack(0);
        bulbasaur.selectAttack(0);
        squirtle.selectAttack(0);
        abra.selectAttack(0);
        machop.selectAttack(0);

    }

    @Test
    public void costructorTest(){
        assertEquals(25,pikachu.getId());
        assertEquals(70,pikachu.getHp());
        assertEquals(2,pikachu.numberOfEnergies());
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
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receivePsychicAttackTest(){
        assertEquals(70,pikachu.getHp());
        abra.attack(pikachu);
        assertEquals(40,pikachu.getHp());
    }

    @Test
    public void receiveElectricAttackTest(){
        assertEquals(70,pikachu.getHp());
        pikachu.getAttacks().add(electricAttack);
        pikachu.selectAttack(0);
        pikachu.attack(pikachu);
        assertEquals(40,pikachu.getHp());
    }

    @Test
    public void receiveWaterAttackTest(){
        assertEquals(70,pikachu.getHp());
        squirtle.attack(pikachu);
        assertEquals(40,pikachu.getHp());
    }

    @Test
    public void receiveGrassAttackTest(){
        assertEquals(70,pikachu.getHp());
        bulbasaur.attack(pikachu);
        assertEquals(40,pikachu.getHp());
    }

    @Test
    public void receiveFightingAttackTest(){
        assertEquals(70,pikachu.getHp());
        machop.attack(pikachu);
        assertEquals(10,pikachu.getHp());
    }

    @Test
    public void receiveFireAttackTest(){
        assertEquals(70,pikachu.getHp());
        charmander.attack(pikachu);
        assertEquals(40,pikachu.getHp());
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
    public void addEnergy(){
        pikachu.addEnergy(electricEnergy);
        assertEquals(3,pikachu.getEnergies().size());
        assertEquals(new ElectricEnergy(),pikachu.getEnergies().get(2));
    }

}
