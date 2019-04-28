package tcg.water;

import org.junit.Before;
import org.junit.Test;
import tcg.electric.ElectricPokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.fighting.FightingPokemon;
import tcg.fire.FirePokemon;
import tcg.grass.GrassPokemon;
import tcg.psychic.PsychicPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WaterAttackTest {
    private IAttack waterAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        waterAttack = new WaterAttack("Rain Blow", 30, 1, "It's raining!");
        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
    }

    @Test
    public void constructorTest(){
        assertEquals("Rain Blow", waterAttack.getName());
        assertEquals(30,waterAttack.getBaseDamage());
        assertEquals(1, waterAttack.getCost());
        assertEquals("It's raining!", waterAttack.getDescriptiveText());
    }

    @Test
    public void attackTest(){
        waterAttack.attack(charmander);
        waterAttack.attack(bulbasaur);
        waterAttack.attack(squirtle);
        waterAttack.attack(pikachu);
        waterAttack.attack(abra);
        waterAttack.attack(machop);

        assertEquals(10, charmander.getHp());
        assertEquals(70, bulbasaur.getHp());
        assertEquals(40, squirtle.getHp());
        assertEquals(40,pikachu.getHp());
        assertEquals(40,abra.getHp());
        assertEquals(40,machop.getHp());
    }

    @Test
    public void equalsTest(){
        assertEquals(waterAttack, new WaterAttack("Rain Blow", 30,1, "It's raining!"));
        assertNotEquals(waterAttack, new WaterAttack("Rain Blow", 40,1, ""));
    }


}
