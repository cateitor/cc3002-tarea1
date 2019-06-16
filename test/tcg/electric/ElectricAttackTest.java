package tcg.electric;

import org.junit.Before;
import org.junit.Test;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPokemon;
import tcg.fighting.BasicFightingPokemon;
import tcg.fire.BasicFirePokemon;
import tcg.grass.BasicGrassPokemon;
import tcg.psychic.BasicPsychicPokemon;
import tcg.water.BasicWaterPokemon;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ElectricAttackTest {
    private IAbility electricAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        electricAttack = new ElectricAttack("Thunder", 30, 2, "The pokemon is paralyzed!");
        charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>());
        bulbasaur = new BasicGrassPokemon(1, 70, new EnergyCounter(), new ArrayList<IAbility>());
        squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>());
        pikachu = new BasicElectricPokemon(25,70,new EnergyCounter(),new ArrayList<IAbility>());
        abra = new BasicPsychicPokemon(63,70,new EnergyCounter(),new ArrayList<IAbility>());
        machop = new BasicFightingPokemon(66,70,new EnergyCounter(),new ArrayList<IAbility>());
    }

    @Test
    public void constructorTest(){
        EnergyCounter e = new EnergyCounter();
        e.setElectricEnergy(2);
        assertEquals("Thunder", electricAttack.getName());
        assertEquals(30,electricAttack.getBaseDamage());
        assertEquals(e.getEnergies(),electricAttack.getCost().getEnergies());
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

        assertEquals(40, charmander.getCurrentHp());
        assertEquals(40, bulbasaur.getCurrentHp());
        assertEquals(10, squirtle.getCurrentHp());
        assertEquals(40,pikachu.getCurrentHp());
        assertEquals(40,abra.getCurrentHp());
        assertEquals(40,machop.getCurrentHp());
    }


}
