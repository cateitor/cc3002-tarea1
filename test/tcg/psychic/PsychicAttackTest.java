package tcg.psychic;

import org.junit.Before;
import org.junit.Test;
import tcg.electric.ElectricPokemon;
import tcg.fire.FirePokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.fighting.FightingPokemon;
import tcg.grass.GrassPokemon;
import tcg.water.WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PsychicAttackTest {
    private IAttack psychicAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        psychicAttack = new PsychicAttack("Zen Force", 30, 2, "Ohmm");
        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
    }

    @Test
    public void constructorTest(){
        assertEquals("Zen Force", psychicAttack.getName());
        assertEquals(30,psychicAttack.getBaseDamage());
        assertEquals(2, psychicAttack.getCost());
        assertEquals("Ohmm", psychicAttack.getDescriptiveText());
    }

    @Test
    public void attackTest(){
        psychicAttack.attack(charmander);
        psychicAttack.attack(bulbasaur);
        psychicAttack.attack(squirtle);
        psychicAttack.attack(pikachu);
        psychicAttack.attack(abra);
        psychicAttack.attack(machop);

        assertEquals(40, charmander.getHp());
        assertEquals(40, bulbasaur.getHp());
        assertEquals(40, squirtle.getHp());
        assertEquals(40,pikachu.getHp());
        assertEquals(10,abra.getHp());
        assertEquals(10,machop.getHp());
    }

    @Test
    public void equalsTest(){
        assertEquals(psychicAttack, new PsychicAttack("Zen Force", 30,2, "Ohmm"));
        assertNotEquals(psychicAttack, new PsychicAttack("Zen Force", 40,2, ""));
    }


}
