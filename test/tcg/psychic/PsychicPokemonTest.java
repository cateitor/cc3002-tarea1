package tcg.psychic;

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
import tcg.water.WaterAttack;
import tcg.water.WaterEnergy;
import tcg.water.WaterPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PsychicPokemonTest {
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
        assertEquals(63,abra.getId());
        assertEquals(70,abra.getHp());
        assertEquals(2,abra.numberOfEnergies());
        assertEquals(1,abra.getAttacks().size());
        assertEquals(psychicAttack,abra.getAttacks().get(0));
    }

    @Test
    public void selectAttackTest(){
        abra.selectAttack(0);
        assertEquals(psychicAttack,abra.getSelectedAttack());
    }

    @Test
    public void attackTest(){
        abra.selectAttack(0);
        abra.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receivePsychicAttackTest(){
        assertEquals(70,abra.getHp());
        abra.attack(abra);
        assertEquals(10,abra.getHp());
    }

    @Test
    public void receiveElectricAttackTest(){
        assertEquals(70,abra.getHp());
        pikachu.attack(abra);
        assertEquals(40,abra.getHp());
    }

    @Test
    public void receiveWaterAttackTest(){
        assertEquals(70,abra.getHp());
        squirtle.attack(abra);
        assertEquals(40,abra.getHp());
    }

    @Test
    public void receiveGrassAttackTest(){
        assertEquals(70,abra.getHp());
        bulbasaur.attack(abra);
        assertEquals(40,abra.getHp());
    }

    @Test
    public void receiveFightingAttackTest(){
        assertEquals(70,abra.getHp());
        machop.attack(abra);
        assertEquals(70,abra.getHp());
    }

    @Test
    public void receiveFireAttackTest(){
        assertEquals(70,abra.getHp());
        charmander.attack(abra);
        assertEquals(40,abra.getHp());
    }

    @Test
    public void isDead(){
        assertNotEquals(true,abra.isDead());
        charmander.attack(abra);
        charmander.attack(abra);
        charmander.attack(abra);
        assertEquals(true,abra.isDead());
    }

    @Test
    public void addAttack(){
        abra.addAttack(new GrassAttack("Beam",10,1,"It's not very effective..."));
        assertEquals(2,abra.getAttacks().size());
        assertEquals("Beam", abra.getAttacks().get(1).getName());
        abra.addAttack(psychicAttack);
        abra.addAttack(psychicAttack);
        abra.addAttack(psychicAttack);
        assertEquals(4,abra.getAttacks().size());
    }

    @Test
    public void addEnergy(){
        abra.addEnergy(psychicEnergy);
        assertEquals(3,abra.getEnergies().size());
        assertEquals(new PsychicEnergy(),abra.getEnergies().get(2));
    }

}


