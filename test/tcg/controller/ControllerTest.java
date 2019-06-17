package tcg.controller;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;
import tcg.*;
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

public class ControllerTest {
    private Controller controller;
    private ArrayList<ICard> hand;
    private Stack<ICard> discardPile;
    private ArrayList<IPokemon> bench;
    private IPokemon squirtle, wartortle, blastoise;
    private ITrainerCard potion, luckyStadium, professorCozmo, professorJuniper;

    @Before
    public void setUp(){
        WaterAttack waterAttack = new WaterAttack("Rain Blow", 30, 1, "It's raining!");
        controller = new Controller();
        potion = new PotionCard("Potion Card","Heals the pokemon");
        ((PotionCard) potion).setHeal(20);
        luckyStadium = new LuckyStadium("Lucky Stadium", "throw a coin, if it's head you can draw a card");
        professorCozmo = new ProfessorCozmosDiscoveryCard("Professor Cozmo's Discovery", "Throw a coin, if it's head draw the last 3 cards form the deck, if it's tails draw the 2 first.");
        professorJuniper = new ProfessorJuniperCard("Professor Juniper", "discard your hand and draw 7 cards from the deck");
        squirtle = new BasicWaterPokemon(7, 70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        wartortle = new PhaseOneWaterPokemon(8, 90, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        wartortle.setPreId(7);
        blastoise = new PhaseTwoWaterPokemon(9,150, new EnergyCounter(),new ArrayList<IAbility>(Arrays.asList(waterAttack)));
        blastoise.setPreId(8);
        hand = new ArrayList<ICard>(Arrays.asList(wartortle,professorCozmo,potion,squirtle,blastoise,professorJuniper,luckyStadium));
    }

    @Test
    public void drawCardTest(){
        controller.drawCard();
        assertEquals(1,controller.currentTrainer().getHand().size());
    }

    @Test
    public void lookAtHand(){
        controller.currentTrainer().setHand();
        controller.lookAtHand();
        assertNotEquals(hand,controller.currentTrainer().getHand());
    }
}
