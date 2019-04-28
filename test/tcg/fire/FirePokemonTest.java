package tcg.fire;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.electric.ElectricPokemon;
import tcg.fighting.FightingAttack;
import tcg.fighting.FightingEnergy;
import tcg.fighting.FightingPokemon;
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


public class FirePokemonTest {
    private IPokemon bulbasaur, pikachu, charmander, machop, abra, squirtle;
    private IAttack grassAttack, fireAttack, electricAttack, fightingAttack, psychicAttack, waterAttack;
    private IEnergy grassEnergy, electricEnergy, fireEnergy, fightingEnergy, psychicEnergy, waterEnergy;

    @Before
    public void setUp() {

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
        assertEquals(4,charmander.getId());
        assertEquals(70,charmander.getHp());
        assertEquals(2,charmander.numberOfEnergies());
        assertEquals(1,charmander.getAttacks().size());
        assertEquals(fireAttack,charmander.getAttacks().get(0));
    }

    @Test
    public void selectAttackTest(){
        charmander.selectAttack(0);
        assertEquals(fireAttack,charmander.getSelectedAttack());
    }

    @Test
    public void attackTest(){
        charmander.selectAttack(0);
        charmander.attack(abra);
        assertEquals(40,abra.getHp());
    }

    @Test
    public void receivePsychicAttackTest(){
        assertEquals(70,charmander.getHp());
        abra.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receiveElectricAttackTest(){
        assertEquals(70,charmander.getHp());
        pikachu.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receiveWaterAttackTest(){
        assertEquals(70,charmander.getHp());
        squirtle.attack(charmander);
        assertEquals(10,charmander.getHp());
    }

    @Test
    public void receiveGrassAttackTest(){
        assertEquals(70,charmander.getHp());
        bulbasaur.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receiveFightingAttackTest(){
        assertEquals(70,charmander.getHp());
        machop.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void receiveFireAttackTest(){
        assertEquals(70,charmander.getHp());
        charmander.attack(charmander);
        assertEquals(40,charmander.getHp());
    }

    @Test
    public void isDead(){
        assertNotEquals(true,charmander.isDead());
        squirtle.attack(charmander);
        squirtle.attack(charmander);
        assertEquals(true,charmander.isDead());
    }

    @Test
    public void addAttack(){
        charmander.addAttack(new FireAttack("Fire Ball",40,2,"A fire ball"));
        assertEquals(2,charmander.getAttacks().size());
        assertEquals("Fire Ball", charmander.getAttacks().get(1).getName());
        charmander.addAttack(fireAttack);
        charmander.addAttack(fireAttack);
        charmander.addAttack(fireAttack);
        assertEquals(4,charmander.getAttacks().size());
    }

    @Test
    public void addEnergy(){
        charmander.addEnergy(fireEnergy);
        assertEquals(3,charmander.getEnergies().size());
        assertEquals(new FireEnergy(),charmander.getEnergies().get(2));
    }

}
