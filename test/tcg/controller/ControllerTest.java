package tcg.controller;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.ElectricShock;
import tcg.Heal;
import tcg.electric.BasicElectricPokemon;
import tcg.electric.ElectricAttack;
import tcg.electric.PhaseOneElectricPokemon;
import tcg.electric.PhaseTwoElectricPokemon;
import tcg.fighting.FightingAttack;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireAttack;
import tcg.fire.PhaseOneFirePokemon;
import tcg.fire.PhaseTwoFirePokemon;
import tcg.grass.BasicGrassPokemon;
import tcg.grass.GrassAttack;
import tcg.grass.PhaseOneGrassPokemon;
import tcg.grass.PhaseTwoGrassPokemon;
import tcg.psychic.PsychicAttack;
import tcg.trainer.Trainer;
import tcg.trainerCard.objectCard.PotionCard;
import tcg.trainerCard.stadiumCard.LuckyStadium;
import tcg.trainerCard.supportCard.ProfessorCozmosDiscoveryCard;
import tcg.trainerCard.supportCard.ProfessorJuniperCard;
import tcg.water.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ControllerTest {
    private Controller controller;
    private ArrayList<ICard> hand;
    private Stack<ICard> discardPile;
    private ArrayList<IPokemon> bench;
    private IPokemon squirtle, wartortle, blastoise, charmander,charmeleon,charizard,mareep,flaaffy,ampharos,bulbasaur,ivysaur,venusaur;
    private ITrainerCard luckyStadium, professorCozmo, professorJuniper;
    private PotionCard potion;
    private IAbility waterAttack,electricAttack,electricShock,fightingAttack,heal,fireAttack,grassAttack,psychicAttack;

    @Before
    public void setUp(){
        waterAttack = new WaterAttack("Rain Blow", 30, 1, "It's raining!");
        controller = new Controller();
        potion = new PotionCard("Potion Card","Heals the pokemon");
        potion.setHeal(20);
        luckyStadium = new LuckyStadium("Lucky Stadium", "throw a coin, if it's head you can draw a card");
        professorCozmo = new ProfessorCozmosDiscoveryCard("Professor Cozmo's Discovery", "Throw a coin, if it's head draw the last 3 cards form the deck, if it's tails draw the 2 first.");
        professorJuniper = new ProfessorJuniperCard("Professor Juniper", "discard your hand and draw 7 cards from the deck");

        electricAttack = new ElectricAttack("Thunder",20,1,"The pokémon could be paralized!");
        heal = new Heal("Heal",30,0,"Heals your damage");
        electricShock = new ElectricShock("ElectricShock",30,2,"SHOOK");
        fightingAttack = new FightingAttack("Punch", 30, 1, "It hurts!");
        fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        grassAttack = new GrassAttack("Sharp Leaf", 30, 2, "It cuts the pokemon");
        psychicAttack = new PsychicAttack("Zen Force", 30, 2, "Ohmm");


        squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack,heal)));
        wartortle = new PhaseOneWaterPokemon(8, 90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        wartortle.setPreId(7);
        blastoise = new PhaseTwoWaterPokemon(9,150, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        blastoise.setPreId(8);

        charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charmeleon = new PhaseOneFirePokemon(5,90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charmeleon.setPreId(4);
        charizard = new PhaseTwoFirePokemon(6,180, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        charizard.setPreId(5);

        bulbasaur = new BasicGrassPokemon(1, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(grassAttack)));
        ivysaur = new PhaseOneGrassPokemon(2,90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(grassAttack,heal)));
        ivysaur.setPreId(1);
        venusaur = new PhaseTwoGrassPokemon(3,150,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(grassAttack,heal)));
        venusaur.setPreId(2);

        mareep = new BasicElectricPokemon(179,70,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        flaaffy = new PhaseOneElectricPokemon(180, 90,new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        flaaffy.setPreId(179);
        ampharos = new PhaseTwoElectricPokemon(181, 140, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(electricAttack,electricShock)));
        ampharos.setPreId(180);

        hand = new ArrayList<ICard>(Arrays.asList(wartortle,professorCozmo,potion,squirtle,blastoise,professorJuniper,luckyStadium));
    }


    @Test
    public void drawCardTest(){
        controller.drawCard();
        assertEquals(1,controller.currentTrainer().getHand().size());
        controller.drawCard();
        assertEquals(1,controller.currentTrainer().getHand().size());
    }

    @Test
    public void lookAtHandTest(){
        controller.currentTrainer().setHand();
        controller.lookAtHand();
        assertNotEquals(hand,controller.currentTrainer().getHand());
    }

    @Test
    public void lookAtGameTest(){
        controller.opponentTrainer().setActivePokemon(squirtle);
        assertEquals(controller.seeOpponentActivePokemon(),squirtle);

        controller.currentTrainer().setActivePokemon(charizard);
        assertEquals(charizard, controller.seeActivePokemon());

        controller.currentTrainer().setBench(new ArrayList<IPokemon>(Arrays.asList(bulbasaur,charmeleon,mareep)));
        assertEquals(new ArrayList<IPokemon>(Arrays.asList(bulbasaur,charmeleon,mareep)),controller.seeBench());

        controller.opponentTrainer().setBench(new ArrayList<IPokemon>(Arrays.asList(bulbasaur,charmeleon,mareep)));
        assertEquals(new ArrayList<IPokemon>(Arrays.asList(bulbasaur,charmeleon,mareep)),controller.seeOpponentBench());

        controller.opponentTrainer().addBenchPokemon(mareep);
        controller.opponentTrainer().addBenchPokemon(ivysaur);
        ArrayList<IPokemon> b = new ArrayList<IPokemon>(Arrays.asList(bulbasaur,charmeleon,mareep,mareep,ivysaur));
        assertEquals(b,controller.opponentTrainer().getBench());
    }

    @Test
    public void setSelectedPokemonTest(){
        controller.currentTrainer().setHand(hand);
        controller.playCard(3);
        assertEquals(squirtle, controller.currentTrainer().getActivePokemon());
        controller.currentTrainer().setSelectedPokemon(6);
        assertEquals(squirtle,controller.getSelectedPokemon());
    }

    @Test
    public void playEnergyCardTest(){
        hand.add(new WaterEnergy());
        controller.currentTrainer().setHand(hand);
        controller.currentTrainer().setActivePokemon(squirtle);
        controller.setSelectedPokemon(6);
        controller.playCard(7);
        EnergyCounter e = new EnergyCounter();
        e.setWaterEnergy(1);
        assertEquals(e.getEnergies(),controller.currentTrainer().getActivePokemon().getEnergies().getEnergies());
        hand.add(new WaterEnergy());
        controller.playCard(7);
        assertEquals(e.getEnergies(),controller.currentTrainer().getActivePokemon().getEnergies().getEnergies());
    }

    @Test
    public void playPotionCard(){

        assertEquals("Potion Card",potion.getName());
        assertEquals("Heals the pokemon",potion.getDescriptiveText());
        assertEquals(20,potion.getHeal());
        controller.currentTrainer().setActivePokemon(squirtle);
        controller.currentTrainer().getActivePokemon().setDamage(30);
        controller.setSelectedPokemon(6);
        controller.currentTrainer().setHand(hand);
        controller.playCard(2);
        assertEquals(10, controller.currentTrainer().getActivePokemon().getDamage());

    }

    @Test
    public void playProfessorCozmoCardTest(){
        controller.currentTrainer().setHand(hand);
        assertEquals(7,controller.currentTrainer().getHand().size());
        controller.playCard(1);
        assertNotEquals(7, controller.currentTrainer().getHand().size());
    }

    @Test
    public void playProfessorJuniperCardTest(){
        controller.currentTrainer().setHand(hand);
        controller.playCard(5);
        assertNotEquals(hand, controller.currentTrainer().getHand());
        assertEquals(7,controller.currentTrainer().getHand().size());
        assertEquals(7,controller.currentTrainer().getDiscardPile().size());
    }

    @Test
    public void luckyStadiumTest(){
        controller.currentTrainer().setHand(hand);
        controller.playCard(6);
    }

    @Test
    public void changeTrainerTest(){
        Trainer trainer =  controller.currentTrainer();
        Trainer trainer2 = controller.opponentTrainer();
        controller.changeCurrentTrainer();

        assertEquals(trainer,controller.opponentTrainer());
        assertEquals(trainer2, controller.currentTrainer());
        assertEquals(false,controller.isDrawCard());
        assertEquals(false,controller.isEnergyCard());
    }

    @Test
    public void useHealAbilityTest(){
        controller.currentTrainer().setActivePokemon(squirtle);
        controller.currentTrainer().getActivePokemon().setDamage(30);
        controller.setSelectedPokemon(6);
        assertEquals(2,controller.currentTrainer().getActivePokemon().getAttacks().size());
        controller.getSelectedPokemon().selectAttack(1);
        controller.setAttackedPokemon(controller.currentTrainer().getActivePokemon());
        controller.useAbility();
        assertTrue(controller.currentTrainer().getActivePokemon().getDamage()<=30);
    }

    @Test
    public void useElectricShockAbility(){
        controller.currentTrainer().setActivePokemon(flaaffy);
        controller.opponentTrainer().setActivePokemon(squirtle);
        controller.setSelectedPokemon(6);
        controller.getSelectedPokemon().selectAttack(1);
        controller.setAttackedPokemon(controller.opponentTrainer().getActivePokemon());
        controller.useAbility();
        assertTrue(squirtle.getDamage() <=60);
    }

}
