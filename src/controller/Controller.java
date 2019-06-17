package controller;

import tcg.DeckForTest;
import tcg.ICard;
import tcg.IPokemon;
import tcg.trainer.Trainer;

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
    private IPokemon attackedPokemon;
    private boolean drawCard = false;
    private boolean energyCard = false;
    private boolean luckyStadium = false;

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
        drawCard = false;
        energyCard = false;
    }

    /**
     * Sets the selected pokemon
     * @param index if the index is 6 the selectedPokemon is the active pokemon, else if is a number between 0 and 5
     *              the selectedPokemon is one from the bench
     */
    public void setSelectedPokemon(int index) {
        currentTrainer.setSelectedPokemon(index);
    }

    /**
     * Gets the selected pokemon
     * @return selectedPokemon
     */
    public IPokemon getSelectedPokemon(){
        return currentTrainer.getSelectedPokemon();
    }

    /**
     * Draws a card from the deck
     */
    public void drawCard(){
        if(!isDrawCard()){
            currentTrainer.getHand().add(currentTrainer.getDeck().get(0));
            currentTrainer.getDeck().remove(0);
        }
        drawCard = true;
    }

    /**
     * sees if a card was drawn
     * @return true if its was drawn, false otherwise
     */
    public boolean isDrawCard(){
        return drawCard;
    }

    /**
     * Sees if an Energy Card was already played
     * @return true if it was played, false otherwise
     */
    public boolean isEnergyCard(){
        return energyCard;
    }

    /**
     * Sees if a LuckyStadiumCard was played
     * @return true if it was played, false otherwise
     */
    public boolean isLuckyStadium(){
        return luckyStadium;
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
        currentTrainer.play(index);
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

    /**
     * Sets if the EnergyCard was played or not
     * @param b true if it was played, false otherwise
     */
    public void setEnergyCard(boolean b) {
        energyCard = b;
    }

    /**
     * Sets if a LuckyStadiumCard was Played
     * @param b true if it was played, false otherwise.
     */
    public void setLuckyStadium(boolean b) {
        luckyStadium = b;
    }

    /**
     * Uses the selectedAbility.
     */
    public void useAbility(){
        currentTrainer.getActivePokemon().getSelectedAttack().attack(currentTrainer.getSelectedPokemon());
    }

    /**
     * Sets the pokemon that the ability will be used.
     * @param pokemon the pokemon that the ability is used
     */
    public void setAttackedPokemon(IPokemon pokemon) {
        attackedPokemon = pokemon;
    }

    /**
     * Returns the selected atacked Pokemon
     * @return attacked pokemon
     */
    public IPokemon getAttackedPokemon(){
        return attackedPokemon;
    }
}
