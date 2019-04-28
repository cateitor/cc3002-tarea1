package tcg.fighting;

import org.junit.Before;
import org.junit.Test;
import tcg.electric.ElectricPokemon;
import tcg.fire.FirePokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.grass.GrassPokemon;
import tcg.psychic.PsychicPokemon;
import tcg.water.WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FightingAttackTest {
    private IAttack fightingAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        fightingAttack = new FightingAttack("Punch", 30, 1, "It hurts!");
        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
    }

    @Test
    public void constructorTest(){
        assertEquals("Punch", fightingAttack.getName());
        assertEquals(30,fightingAttack.getBaseDamage());
        assertEquals(1, fightingAttack.getCost());
        assertEquals("It hurts!", fightingAttack.getDescriptiveText());
    }

    @Test
    public void attackTest(){
        fightingAttack.attack(charmander);
        fightingAttack.attack(bulbasaur);
        fightingAttack.attack(squirtle);
        fightingAttack.attack(pikachu);
        fightingAttack.attack(abra);
        fightingAttack.attack(machop);

        assertEquals(40, charmander.getHp());
        assertEquals(40, bulbasaur.getHp());
        assertEquals(70, squirtle.getHp());
        assertEquals(10,pikachu.getHp());
        assertEquals(70,abra.getHp());
        assertEquals(40,machop.getHp());
    }

    @Test
    public void equalsTest(){
        assertEquals(fightingAttack, new FightingAttack("Punch", 30,1, "It hurts!"));
        assertNotEquals(fightingAttack, new FightingAttack("Punch", 40,1, ""));
    }


}
