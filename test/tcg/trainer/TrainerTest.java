package tcg.trainer;

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
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TrainerTest {
    private Trainer trainer, trainer2, trainer3;
    private ArrayList<ICard> hand;
    private ArrayList<IPokemon> bench;
    private IPokemon bulbasaur, squirtle, charmander, pikachu, abra, machop;
    private IEnergy grassEnergy, waterEnergy, fireEnergy, electricEnergy, psychicEnergy, fightingEnergy;
    private IAttack grassAttack, waterAttack, fireAttack, electricAttack, psychicAttack, fightingAttack, fireAttack2;

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

        charmander = new FirePokemon(4,70, new ArrayList<IEnergy>(Arrays.asList(fireEnergy,fireEnergy)), new ArrayList<IAttack>(Arrays.asList(fireAttack,fireAttack2)));
        bulbasaur = new GrassPokemon(1, 70, new ArrayList<IEnergy>(Arrays.asList(grassEnergy,grassEnergy)), new ArrayList<IAttack>(Arrays.asList(grassAttack)));
        squirtle = new WaterPokemon(7, 70, new ArrayList<IEnergy>(Arrays.asList(waterEnergy,waterEnergy)), new ArrayList<IAttack>(Arrays.asList(waterAttack)));
        pikachu = new ElectricPokemon(25,70,new ArrayList<IEnergy>(Arrays.asList(electricEnergy,electricEnergy)),new ArrayList<IAttack>(Arrays.asList(electricAttack)));
        abra = new PsychicPokemon(63,70,new ArrayList<IEnergy>(Arrays.asList(psychicEnergy,psychicEnergy)),new ArrayList<IAttack>(Arrays.asList(psychicAttack)));
        machop = new FightingPokemon(25,70,new ArrayList<IEnergy>(Arrays.asList(fightingEnergy,fightingEnergy)),new ArrayList<IAttack>(Arrays.asList(fightingAttack)));


        bulbasaur.selectAttack(0);
        squirtle.selectAttack(0);
        abra.selectAttack(0);
        machop.selectAttack(0);


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
        trainer2.selectActivePokemonAttack(1);
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
        trainer.addCard(new WaterPokemon(258,70,new ArrayList<IEnergy>(Arrays.asList(waterEnergy,waterEnergy)),new ArrayList<IAttack>(Arrays.asList(waterAttack))));
        assertEquals(13,trainer.getHand().size());

    }

    @Test
    public void playPokemonTest(){
        trainer3 = new Trainer();
        trainer3.setHand(hand);
        trainer3.setBench(bench);
        trainer3.play(trainer.getCard(0));
        assertEquals(bulbasaur,trainer3.getActivePokemon());
        trainer3.play(trainer.getCard(0));
        assertEquals(1,trainer3.getBench().size());
        assertNotEquals(squirtle,trainer3.getHand().get(0));
    }

    @Test
    public void playEnergyTest(){
        trainer.play(trainer.getCard(8));
        assertEquals(3,trainer.getActivePokemon().numberOfEnergies());
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
        machop.attack(trainer.getActivePokemon());
        assertEquals(true, trainer.getActivePokemon().isDead());
        trainer.changeActivePokemon();
        assertEquals(bulbasaur,trainer.getActivePokemon());
    }



}
