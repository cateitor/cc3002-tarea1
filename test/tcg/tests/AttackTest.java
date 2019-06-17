package tcg.tests;

import org.junit.Before;
import org.junit.Test;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPokemon;
import tcg.electric.BasicElectricPokemon;
import tcg.electric.ElectricAttack;
import tcg.fighting.BasicFightingPokemon;
import tcg.fighting.FightingAttack;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireAttack;
import tcg.grass.BasicGrassPokemon;
import tcg.grass.GrassAttack;
import tcg.psychic.BasicPsychicPokemon;
import tcg.psychic.PsychicAttack;
import tcg.water.BasicWaterPokemon;
import tcg.water.WaterAttack;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AttackTest {
    private IAbility electricAttack, fireAttack,fightingAttack,waterAttack,grassAttack,psychicAttack;
    private IPokemon charmander, bulbasaur, squirtle,pikachu,abra,machop;

    @Before
    public void setUp(){
        fightingAttack = new FightingAttack("Punch", 30, 1, "It hurts!");
        electricAttack = new ElectricAttack("Thunder", 30, 2, "The pokemon is paralyzed!");
        fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        grassAttack = new GrassAttack("Sharp Leaf", 30, 2, "It cuts the pokemon");
        psychicAttack = new PsychicAttack("Zen Force", 30, 2, "Ohmm");
        waterAttack = new WaterAttack("Rain Blow", 30, 1, "It's raining!");

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
    public void ElectricAttackTest(){
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

    @Test
    public void FireAttackTest(){
        fireAttack.attack(charmander);
        fireAttack.attack(bulbasaur);
        fireAttack.attack(squirtle);
        fireAttack.attack(pikachu);
        fireAttack.attack(abra);
        fireAttack.attack(machop);

        assertEquals(40, charmander.getCurrentHp());
        assertEquals(10, bulbasaur.getCurrentHp());
        assertEquals(40, squirtle.getCurrentHp());
        assertEquals(40,pikachu.getCurrentHp());
        assertEquals(40,abra.getCurrentHp());
        assertEquals(40,machop.getCurrentHp());
    }

    @Test
    public void WaterAttackTest(){
        waterAttack.attack(charmander);
        waterAttack.attack(bulbasaur);
        waterAttack.attack(squirtle);
        waterAttack.attack(pikachu);
        waterAttack.attack(abra);
        waterAttack.attack(machop);

        assertEquals(10, charmander.getCurrentHp());
        assertEquals(70, bulbasaur.getCurrentHp());
        assertEquals(40, squirtle.getCurrentHp());
        assertEquals(40,pikachu.getCurrentHp());
        assertEquals(40,abra.getCurrentHp());
        assertEquals(40,machop.getCurrentHp());
    }

    @Test
    public void GrassAttackTest(){
        grassAttack.attack(charmander);
        grassAttack.attack(bulbasaur);
        grassAttack.attack(squirtle);
        grassAttack.attack(pikachu);
        grassAttack.attack(abra);
        grassAttack.attack(machop);

        assertEquals(40, charmander.getCurrentHp());
        assertEquals(40, bulbasaur.getCurrentHp());
        assertEquals(10, squirtle.getCurrentHp());
        assertEquals(40,pikachu.getCurrentHp());
        assertEquals(40,abra.getCurrentHp());
        assertEquals(10,machop.getCurrentHp());
    }

    @Test
    public void FightingAttackTest(){
        fightingAttack.attack(charmander);
        fightingAttack.attack(bulbasaur);
        fightingAttack.attack(squirtle);
        fightingAttack.attack(pikachu);
        fightingAttack.attack(abra);
        fightingAttack.attack(machop);

        assertEquals(40, charmander.getCurrentHp());
        assertEquals(40, bulbasaur.getCurrentHp());
        assertEquals(70, squirtle.getCurrentHp());
        assertEquals(10,pikachu.getCurrentHp());
        assertEquals(70,abra.getCurrentHp());
        assertEquals(40,machop.getCurrentHp());
    }

    @Test
    public void PsychicAttackTest(){
        psychicAttack.attack(charmander);
        psychicAttack.attack(bulbasaur);
        psychicAttack.attack(squirtle);
        psychicAttack.attack(pikachu);
        psychicAttack.attack(abra);
        psychicAttack.attack(machop);

        assertEquals(40, charmander.getCurrentHp());
        assertEquals(40, bulbasaur.getCurrentHp());
        assertEquals(40, squirtle.getCurrentHp());
        assertEquals(40,pikachu.getCurrentHp());
        assertEquals(10,abra.getCurrentHp());
        assertEquals(10,machop.getCurrentHp());
    }




}
