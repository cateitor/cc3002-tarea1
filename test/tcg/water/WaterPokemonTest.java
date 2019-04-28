package tcg.water;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.electric.ElectricPokemon;
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

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WaterPokemonTest {
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
        assertEquals(7,squirtle.getId());
        assertEquals(70,squirtle.getHp());
        assertEquals(2,squirtle.numberOfEnergies());
        assertEquals(1, squirtle.getAttacks().size());
        assertEquals(waterAttack,squirtle.getAttacks().get(0));
    }

    @Test
    public void selectAttackTest(){
        squirtle.selectAttack(0);
        assertEquals(waterAttack,squirtle.getSelectedAttack());
    }

    @Test
    public void attackTest(){
        squirtle.selectAttack(0);
        squirtle.attack(machop);
        assertEquals(40,machop.getHp());
    }

    @Test
    public void receivePsychicAttackTest(){
        assertEquals(70,squirtle.getHp());
        abra.attack(squirtle);
        assertEquals(40,squirtle.getHp());
    }

    @Test
    public void receiveElectricAttackTest(){
        assertEquals(70,squirtle.getHp());
        pikachu.attack(squirtle);
        assertEquals(10,squirtle.getHp());
    }

    @Test
    public void receiveWaterAttackTest(){
        assertEquals(70,squirtle.getHp());
        squirtle.attack(squirtle);
        assertEquals(40,squirtle.getHp());
    }

    @Test
    public void receiveGrassAttackTest(){
        assertEquals(70,squirtle.getHp());
        bulbasaur.attack(squirtle);
        assertEquals(10,squirtle.getHp());
    }

    @Test
    public void receiveFightingAttackTest(){
        assertEquals(70,squirtle.getHp());
        machop.attack(squirtle);
        assertEquals(70,squirtle.getHp());
    }

    @Test
    public void receiveFireAttackTest(){
        assertEquals(70,squirtle.getHp());
        charmander.attack(squirtle);
        assertEquals(40,squirtle.getHp());
    }

    @Test
    public void isDead(){
        assertNotEquals(true,squirtle.isDead());
        bulbasaur.attack(squirtle);
        bulbasaur.attack(squirtle);
        assertEquals(true,squirtle.isDead());
    }

    @Test
    public void addAttack(){
        squirtle.addAttack(new WaterAttack("Bubbles",30,2,"GLUP"));
        assertEquals(2,squirtle.getAttacks().size());
        assertEquals("Bubbles", squirtle.getAttacks().get(1).getName());
        squirtle.addAttack(waterAttack);
        squirtle.addAttack(waterAttack);
        squirtle.addAttack(waterAttack);
        assertEquals(4,squirtle.getAttacks().size());
    }

    @Test
    public void addEnergy(){
        squirtle.addEnergy(waterEnergy);
        assertEquals(3,squirtle.getEnergies().size());
        assertEquals(new WaterEnergy(),squirtle.getEnergies().get(2));
    }

}


