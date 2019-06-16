import controller.Controller;
import org.junit.Before;
import org.junit.Test;
import tcg.DeckForTest;
import tcg.ICard;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    private Controller controller;
    private ArrayList<ICard> deckTest;

    @Before
    public void setUp(){
        //trainer1.setDeck();
        controller = new Controller();
        deckTest = new DeckForTest().getDeck();
        controller.currentTrainer().setDeck(deckTest);
        controller.opponentTrainer().setDeck(deckTest);

    }

    @Test
    public void DrawCardTest(){
        controller.drawCard();
        assertEquals(1,controller.currentTrainer().getHand().size());
    }
}
