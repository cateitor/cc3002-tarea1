package tcg.trainer;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.ElectricShock;
import tcg.Heal;
import tcg.electric.*;
import tcg.fighting.*;
import tcg.fire.*;
import tcg.grass.*;
import tcg.psychic.*;
import tcg.water.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TrainerTest {
    private Trainer trainer, trainer2, trainer3;
    private ArrayList<ICard> hand;
    private ArrayList<IPokemon> bench;
    private IPokemon bulbasaur, squirtle, charmander, pikachu, abra, machop, raichu, ivysaur, venusaur;
    private IPokemon charmeleon,charizard,mareep,ampharos,flaaffy,wartortle,blastoise,kadabra,alakazam,machoke,machamp;
    private IEnergy grassEnergy, waterEnergy, fireEnergy, electricEnergy, psychicEnergy, fightingEnergy;
    private IAbility grassAttack, waterAttack, fireAttack, electricAttack, psychicAttack, fightingAttack, fireAttack2,heal,electricShock;
    private ArrayList<ICard> hand2;

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
        heal = new Heal("Heal",30,0,"Heals your damage");
        electricShock = new ElectricShock("ElectricShock",30,2,"SHOOK");

        charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack2)));
        bulbasaur = new BasicGrassPokemon(1, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        pikachu = new BasicElectricPokemon(25,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));
        abra = new BasicPsychicPokemon(63,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        machop = new BasicFightingPokemon(66,70,new EnergyCounter() ,new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        raichu = new PhaseOneElectricPokemon(26,120,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));

        ((PhaseOneElectricPokemon) raichu).setPreId(25);
        raichu.getEnergies().setElectricEnergy(0);

        ivysaur = new PhaseOneGrassPokemon(2,90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        ivysaur.setPreId(1);
        ivysaur.getEnergies().setGrassEnergy(2);
        venusaur = new PhaseTwoGrassPokemon(3,150,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        venusaur.setPreId(2);
        ivysaur.getEnergies().setGrassEnergy(0);

        bulbasaur.selectAttack(0);
        squirtle.selectAttack(0);
        abra.selectAttack(0);
        machop.selectAttack(0);

        charmander.getEnergies().setFireEnergy(2);
        bulbasaur.getEnergies().setGrassEnergy(2);
        squirtle.getEnergies().setWaterEnergy(2);
        abra.getEnergies().setPsychicEnergy(2);
        machop.getEnergies().setFightingEnergy(2);

        heal = new Heal("Heal",30,0,"Heals your damage");
        electricShock = new ElectricShock("ElectricShock",30,2,"SHOOK");


        charmeleon = new PhaseOneFirePokemon(5,90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charmeleon.setPreId(4);
        charizard = new PhaseTwoFirePokemon(6,180, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charizard.setPreId(5);

        wartortle = new PhaseOneWaterPokemon(8, 90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        wartortle.setPreId(7);
        blastoise = new PhaseTwoWaterPokemon(9,150, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        blastoise.setPreId(8);

        mareep = new BasicElectricPokemon(179,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack)));
        flaaffy = new PhaseOneElectricPokemon(180, 90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        flaaffy.setPreId(179);
        ampharos = new PhaseTwoElectricPokemon(181, 140, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        ampharos.setPreId(180);

        kadabra = new PhaseOnePsychicPokemon(64, 90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        kadabra.setPreId(63);
        alakazam = new PhaseTwoPsychicPokemon(65, 150, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(psychicAttack)));
        alakazam.setPreId(64);

        machoke = new PhaseOneFightingPokemon(67,90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        machoke.setPreId(66);
        machamp = new PhaseTwoFightingPokemon(68,150,new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fightingAttack)));
        machamp.setPreId(67);


       hand = new ArrayList<ICard>(Arrays.asList(bulbasaur,squirtle,pikachu,
               abra,machop,fireEnergy,grassEnergy,waterEnergy,electricEnergy,psychicEnergy,fightingEnergy));
       hand2 = new ArrayList<ICard>(Arrays.asList(abra,charmander));

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
    public void setPreIdBasicPokemonTest(){
        pikachu.setPreId(12);
        abra.setPreId(11);
        bulbasaur.setPreId(45);
        squirtle.setPreId(56);
        charmander.setPreId(76);
        machop.setPreId(44);

        assertEquals(0,pikachu.getPreId());
        assertEquals(0,abra.getPreId());
        assertEquals(0,bulbasaur.getPreId());
        assertEquals(0,squirtle.getPreId());
        assertEquals(0,charmander.getPreId());
        assertEquals(0,machop.getPreId());
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
        assertEquals(squirtle,trainer3.getBench().get(0));
        assertNotEquals(squirtle,trainer3.getHand().get(0));
        trainer3.play(0);
        assertEquals(pikachu,trainer3.getBench().get(1));
        trainer3.play(1);
        assertEquals(machop,trainer3.getBench().get(2));
        trainer3.setHand(hand2);
        trainer3.play(0);
        assertEquals(abra,trainer3.getBench().get(3));
        trainer3.play(0);
        assertEquals(charmander,trainer3.getBench().get(4));


    }

    @Test
    public void playEnergyTest(){
        Controller c = new Controller();
        trainer.setController(c);
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
    public void PlayPhaseOnePokemonTest(){
        trainer.setSelectedPokemon(6);
        assertTrue(!trainer.getSelectedPokemon().isDead());
        trainer.getSelectedPokemon().getEnergies().setElectricEnergy(2);
        trainer.getHand().add(raichu);
        trainer.play(11);
        assertEquals(raichu,trainer.getActivePokemon());
        EnergyCounter e = new EnergyCounter();
        e.setElectricEnergy(2);
        assertEquals(e.getEnergies(),trainer.getActivePokemon().getEnergies().getEnergies());

        trainer.addBenchPokemon(raichu);
        trainer.setSelectedPokemon(0);
        assertEquals(trainer.getSelectedPokemon(),raichu);

        ArrayList<IPokemon> bench2 = new ArrayList<>(Arrays.asList(abra,machop,squirtle,charmander,bulbasaur));
        ArrayList<ICard> hand3 = new ArrayList<>(Arrays.asList(kadabra,machoke,wartortle,charmeleon,ivysaur));
        trainer.setBench(bench2);
        trainer.setHand(hand3);
        trainer.setSelectedPokemon(0);
        assertEquals(abra,trainer.getSelectedPokemon());
        trainer.play(0);
        assertEquals(kadabra,trainer.getBench().get(0));
        trainer.setSelectedPokemon(1);
        assertEquals(machop,trainer.getSelectedPokemon());
        assertEquals(machoke,trainer.getHand().get(0));
        trainer.play(0);
        assertEquals(machoke,trainer.getBench().get(1));

        trainer.setSelectedPokemon(2);
        trainer.play(0);
        assertEquals(wartortle,trainer.getBench().get(2));

        trainer.setSelectedPokemon(3);
        trainer.play(0);
        assertEquals(charmeleon,trainer.getBench().get(3));

        trainer.setSelectedPokemon(4);
        trainer.play(0);
        assertEquals(ivysaur,trainer.getBench().get(4));




    }

    @Test
    public void PlayPhaseTwoPokemonTest(){
        ArrayList<IPokemon> bench3 = new ArrayList<>(Arrays.asList(kadabra,machoke,wartortle,charmeleon,ivysaur));
        ArrayList<ICard> hand4 = new ArrayList<>(Arrays.asList(alakazam,machamp,blastoise,charizard,venusaur));
        trainer.setBench(bench3);
        trainer.setHand(hand4);
        trainer.setSelectedPokemon(0);
        trainer.play(0);
        assertEquals(alakazam,trainer.getBench().get(0));
        trainer.setSelectedPokemon(1);
        trainer.play(0);
        assertEquals(machamp,trainer.getBench().get(1));
        trainer.setSelectedPokemon(2);
        trainer.play(0);
        assertEquals(blastoise,trainer.getBench().get(2));
        trainer.setSelectedPokemon(3);
        trainer.play(0);
        assertEquals(charizard,trainer.getBench().get(3));
        trainer.setSelectedPokemon(4);
        trainer.play(0);
        assertEquals(venusaur,trainer.getBench().get(4));

        trainer.setActivePokemon(flaaffy);
        trainer.setHand(new ArrayList<ICard>(Arrays.asList(ampharos)));
        trainer.setSelectedPokemon(6);
        trainer.play(0);
        assertEquals(ampharos,trainer.getActivePokemon());
    }



    @Test
    public void deckTest(){
        DeckForTest deck = new DeckForTest();
        DeckForTest deck2 = new DeckForTest();
        assertNotEquals(deck,deck2);
        trainer.setDeck(deck.getDeck());
        assertEquals(trainer.getDeck(),deck.getDeck());
        assertEquals(60,deck.getDeck().size());
        trainer.draw(0);
        assertEquals(12,trainer.getHand().size());
        trainer.draw(0);
        assertNotEquals(12,trainer.getHand().size());
    }

    @Test
    public void controllerTest(){
        Controller c = new Controller();
        trainer.setController(c);
        assertEquals(trainer.getController(),c);
    }

    @Test
    public void setHandTest(){
        DeckForTest deck = new DeckForTest();
        trainer.setDeck(deck.getDeck());
        trainer.setHand();
        assertNotEquals(trainer.getHand(),hand);
    }


}
