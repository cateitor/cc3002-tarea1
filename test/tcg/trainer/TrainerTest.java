package tcg.trainer;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.electric.BasicElectricPokemon;
import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.electric.PhaseOneElectricPokemon;
import tcg.fighting.BasicFightingPokemon;
import tcg.fighting.FightingAttack;
import tcg.fighting.FightingEnergy;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.grass.BasicGrassPokemon;
import tcg.grass.GrassAttack;
import tcg.grass.GrassEnergy;
import tcg.psychic.BasicPsychicPokemon;
import tcg.psychic.PsychicAttack;
import tcg.psychic.PsychicEnergy;
import tcg.water.BasicWaterPokemon;
import tcg.water.WaterAttack;
import tcg.water.WaterEnergy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TrainerTest {
    private Trainer trainer, trainer2, trainer3;
    private ArrayList<ICard> hand;
    private ArrayList<IPokemon> bench;
    private IPokemon bulbasaur, squirtle, charmander, pikachu, abra, machop, raichu;
    private IEnergy grassEnergy, waterEnergy, fireEnergy, electricEnergy, psychicEnergy, fightingEnergy;
    private IAbility grassAttack, waterAttack, fireAttack, electricAttack, psychicAttack, fightingAttack, fireAttack2;

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
        fireAttack2 = new FireAttack("Burn",20,1,"It burned the pokemon!");

        charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack2)));
        bulbasaur = new BasicGrassPokemon(1, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        pikachu = new BasicElectricPokemon(25,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));
        abra = new BasicPsychicPokemon(63,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        machop = new BasicFightingPokemon(66,70,new EnergyCounter() ,new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        raichu = new PhaseOneElectricPokemon(26,120,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));

        ((PhaseOneElectricPokemon) raichu).setPreId(25);
        raichu.getEnergies().setElectricEnergy(0);

        bulbasaur.selectAttack(0);
        squirtle.selectAttack(0);
        abra.selectAttack(0);
        machop.selectAttack(0);

        charmander.getEnergies().setFireEnergy(2);
        bulbasaur.getEnergies().setGrassEnergy(2);
        squirtle.getEnergies().setWaterEnergy(2);
        abra.getEnergies().setPsychicEnergy(2);
        machop.getEnergies().setFightingEnergy(2);


       hand = new ArrayList<ICard>(Arrays.asList(bulbasaur,squirtle,pikachu,
               abra,machop,fireEnergy,grassEnergy,waterEnergy,electricEnergy,psychicEnergy,fightingEnergy));

       bench = new ArrayList<IPokemon>();

        trainer = new Trainer();
        trainer.setHand(hand);
        trainer.setActivePokemon(pikachu);
        trainer.setBench(bench);

    }

    @Test
    public void setTrainerTest(){
        trainer2= new Trainer();
        trainer2.setActivePokemon(charmander);
        assertEquals(charmander,trainer2.getActivePokemon());
        trainer2.setHand(hand);
        assertEquals(hand,trainer2.getHand());
        assertEquals(pikachu,trainer.getCard(2));
        trainer2.getActivePokemon().selectAttack(0);
        assertEquals(fireAttack2,trainer2.getSelectedAttack());
        trainer2.setBench(bench);
        assertEquals(0,trainer.getBench().size());
        trainer2.addBenchPokemon(machop);
        assertEquals(machop,trainer.getBench().get(0));
        assertNotEquals(true,trainer2.getActivePokemon().isDead());

    }

    @Test
    public void addCardToHandTest(){
        trainer.addCard(new WaterEnergy());
        assertEquals(new WaterEnergy(),trainer.getHand().get(trainer.getHand().size()-1));
        trainer.addCard(new BasicWaterPokemon(258,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(waterAttack))));
        assertEquals(13,trainer.getHand().size());

    }

    @Test
    public void playBasicPokemonTest(){
        trainer3 = new Trainer();
        trainer3.setHand(hand);
        trainer3.setBench(bench);
        trainer3.play(0);
        assertEquals(bulbasaur,trainer3.getActivePokemon());
        trainer3.play(0);
        assertEquals(1,trainer3.getBench().size());
        assertNotEquals(squirtle,trainer3.getHand().get(0));
    }

    @Test
    public void playEnergyTest(){
        FireEnergy f = new FireEnergy();
        trainer.setSelectedPokemon(6);
        trainer.play(8);
        EnergyCounter e = new EnergyCounter();
        e.setElectricEnergy(1);
        assertEquals(e.getEnergies(),trainer.getActivePokemon().getEnergies().getEnergies());
    }


    @Test
    public void selectAttackTest(){
        trainer.selectAbility(0);
        assertEquals(electricAttack,trainer.getSelectedAttack());
    }

    @Test
    public void changeActivePokemonTest(){
        trainer.getBench().add(bulbasaur);
        trainer.getBench().add(squirtle);
        assertNotEquals(true, trainer.getActivePokemon().isDead());
        machop.attack(trainer.getActivePokemon());
        assertNotEquals(true,trainer.getActivePokemon().isDead());
        assertEquals(10,trainer.getActivePokemon().getCurrentHp());
        machop.attack(trainer.getActivePokemon());
        assertEquals(true, trainer.getActivePokemon().isDead());
        trainer.changeActivePokemon();
        assertEquals(bulbasaur,trainer.getActivePokemon());
    }

    @Test
    public void PlayPhasePokemonTest(){
        trainer.setSelectedPokemon(6);
        trainer.getSelectedPokemon().getEnergies().setElectricEnergy(2);
        trainer.getHand().add(raichu);
        trainer.play(11);
        assertEquals(raichu,trainer.getActivePokemon());
        EnergyCounter e = new EnergyCounter();
        e.setElectricEnergy(2);
        assertEquals(e.getEnergies(),trainer.getActivePokemon().getEnergies().getEnergies());
    }


}
