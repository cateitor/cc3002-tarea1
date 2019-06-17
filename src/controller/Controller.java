package controller;

import tcg.DeckForTest;
import tcg.ICard;
import tcg.IPokemon;
import tcg.trainer.Trainer;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Controller class of the game.
 * @author Catalina Rojas
 */
public class Controller {
    //private State state;
    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer currentTrainer;
    private Trainer opponent;
    private IPokemon selectedPokemon;

    /**
     * The constructor for the Controller
     */
    public Controller(){
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        DeckForTest deck1 = new DeckForTest();
        DeckForTest deck2 = new DeckForTest();
        currentTrainer= trainer1;
        opponent = trainer2;
        trainer1.setController(this);
        trainer2.setController(this);
        trainer1.setDeck(deck1.getDeck());
        trainer2.setDeck(deck2.getDeck());
    }


    /**
     * Gets the current trainer
     * @return currentTrainer
     */
    public Trainer currentTrainer(){
        return currentTrainer;
    }

    /**
     * Changes the current trainer
     */
    public void changeCurrentTrainer(){
        Trainer trainer = currentTrainer;
        currentTrainer = opponent;
        opponent = trainer;
    }

    /**
     * Sets the selected pokemon
     * @param index if the index is 6 the selectedPokemon is the active pokemon, else if is a number between 0 and 5
     *              the selectedPokemon is one from the bench
     */
    public void setSelectedPokemon(int index) {
        if (index == 6) {
            selectedPokemon = currentTrainer.getActivePokemon();
        } else if (index <6) {
            selectedPokemon = currentTrainer.getBench().get(index);
        }
    }

    /**
     * Gets the selected pokemon
     * @return selectedPokemon
     */
    public IPokemon getSelectedPokemon(){
        return selectedPokemon;
    }

    /**
     * Draws a card from the deck
     */
    public void drawCard(){
        currentTrainer.getHand().add(currentTrainer.getDeck().get(0));
        currentTrainer.getDeck().remove(0);

    }

    /**
     * See the cards of the currentTrainer's hand
     * @return hand of currentTrainer
     */
    public ArrayList<ICard> lookAtHand(){
        return currentTrainer.getHand();
    }

    /**
     * Plays a card from the hand
     * @param index the index of the card played
     */
    public void playCard(int index){
        currentTrainer.getHand().get(index).play();
    }

    /**
     * Sees the bench of the current Trainer
     * @return bench of the currentTrainer
     */
    public ArrayList<IPokemon> seeBench(){
        return currentTrainer.getBench();
    }

    /**
     * Sees the opponent's bench
     * @return the opponent's bench
     */
    public ArrayList<IPokemon> seeOpponentBench(){
        return opponent.getBench();
    }

    /**
     * sees the active pokemon of the currentTrainer
     * @return active pokemon of the currentTrainer
     */
    public IPokemon seeActivePokemon(){
        return currentTrainer.getActivePokemon();
    }

    /**
     * sees the active pokemon of the opponent
     * @return opponent's active pokemon
     */
    public IPokemon seeOpponentActivePokemon(){
        return opponent.getActivePokemon();
    }


    /**
     * Gesta the opponent trainer
     * @return opponent
     */
    public Trainer opponentTrainer() {
        return opponent;
    }
}
