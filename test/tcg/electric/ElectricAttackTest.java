package tcg.electric;

import org.junit.Before;
import org.junit.Test;
import tcg.fire.FirePokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.fighting.FightingPokemon;
import tcg.grass.GrassPokemon;
import tcg.psychic.PsychicPokemon;
import tcg.water.WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ElectricAttackTest {
    private IAttack electricAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        electricAttack = new ElectricAttack("Thunder", 30, 2, "The pokemon is paralyzed!");
        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
    }

    @Test
    public void constructorTest(){
        assertEquals("Thunder", electricAttack.getName());
        assertEquals(30,electricAttack.getBaseDamage());
        assertEquals(2, electricAttack.getCost());
        assertEquals("The pokemon is paralyzed!", electricAttack.getDescriptiveText());
    }

    @Test
    public void attackTest(){
        electricAttack.attack(charmander);
        electricAttack.attack(bulbasaur);
        electricAttack.attack(squirtle);
        electricAttack.attack(pikachu);
        electricAttack.attack(abra);
        electricAttack.attack(machop);

        assertEquals(40, charmander.getHp());
        assertEquals(40, bulbasaur.getHp());
        assertEquals(10, squirtle.getHp());
        assertEquals(40,pikachu.getHp());
        assertEquals(40,abra.getHp());
        assertEquals(40,machop.getHp());
    }

    @Test
    public void equalsTest(){
        assertEquals(electricAttack, new ElectricAttack("Thunder", 30,2, "The pokemon is paralyzed!"));
        assertNotEquals(electricAttack, new ElectricAttack("Thunder", 40,1, ""));
    }


}
