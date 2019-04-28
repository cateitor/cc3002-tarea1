package tcg.grass;

import org.junit.Before;
import org.junit.Test;
import tcg.electric.ElectricPokemon;
import tcg.fire.FirePokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.fighting.FightingPokemon;
import tcg.psychic.PsychicPokemon;
import tcg.water.WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GrassAttackTest {
    private IAttack grassAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        grassAttack = new GrassAttack("Sharp Leaf", 30, 2, "It cuts the pokemon");
        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(), new ArrayList<IAttack>());
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
        machop = new FightingPokemon(66,70,new ArrayList<IEnergy>(),new ArrayList<IAttack>());
    }

    @Test
    public void constructorTest(){
        assertEquals("Sharp Leaf", grassAttack.getName());
        assertEquals(30,grassAttack.getBaseDamage());
        assertEquals(2, grassAttack.getCost());
        assertEquals("It cuts the pokemon", grassAttack.getDescriptiveText());
    }

    @Test
    public void attackTest(){
        grassAttack.attack(charmander);
        grassAttack.attack(bulbasaur);
        grassAttack.attack(squirtle);
        grassAttack.attack(pikachu);
        grassAttack.attack(abra);
        grassAttack.attack(machop);

        assertEquals(40, charmander.getHp());
        assertEquals(40, bulbasaur.getHp());
        assertEquals(10, squirtle.getHp());
        assertEquals(40,pikachu.getHp());
        assertEquals(40,abra.getHp());
        assertEquals(10,machop.getHp());
    }

    @Test
    public void equalsTest(){
        assertEquals(grassAttack, new GrassAttack("Sharp Leaf", 30,2, "It cuts the pokemon"));
        assertNotEquals(grassAttack, new GrassAttack("Sharp Leaf", 40,1, ""));
    }


}
