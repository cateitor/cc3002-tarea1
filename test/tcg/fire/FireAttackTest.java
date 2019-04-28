package tcg.fire;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.ElectricPokemon;
import tcg.fighting.FightingPokemon;
import tcg.grass.GrassPokemon;
import tcg.psychic.PsychicPokemon;
import tcg.water.WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FireAttackTest {
    private IAttack fireAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
    }

    @Test
    public void constructorTest(){
        assertEquals("Ember", fireAttack.getName());
        assertEquals(30,fireAttack.getBaseDamage());
        assertEquals(1, fireAttack.getCost());
        assertEquals("Discard a Fire Energy attached to Pokemon", fireAttack.getDescriptiveText());
    }

    @Test
    public void attackTest(){
        fireAttack.attack(charmander);
        fireAttack.attack(bulbasaur);
        fireAttack.attack(squirtle);
        fireAttack.attack(pikachu);
        fireAttack.attack(abra);
        fireAttack.attack(machop);

        assertEquals(40, charmander.getHp());
        assertEquals(10, bulbasaur.getHp());
        assertEquals(40, squirtle.getHp());
        assertEquals(40,pikachu.getHp());
        assertEquals(40,abra.getHp());
        assertEquals(40,machop.getHp());
    }

    @Test
    public void equalsTest(){
        assertEquals(fireAttack, new FireAttack("Ember", 30,1, "Discard a Fire Energy attached to Pokemon"));
        assertNotEquals(fireAttack, new FireAttack("Ember", 40,1, ""));
    }


}
