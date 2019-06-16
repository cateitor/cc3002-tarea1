package controller;

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
    private State state;
    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer currentTrainer;
    private Trainer opponent;
    private boolean drawCard;
    private IPokemon selectedPokemon;

    /**
     * The constructor for the Controller
     */
    public Controller(){
        this.setState(new Turn());
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        currentTrainer= trainer1;
        opponent = trainer2;
        trainer1.setController(this);
        trainer2.setController(this);
    }

    /**
     * Sets the current state for the controller
     * @param aState the state
     */
    public void setState(State aState){
        state = aState;
        state.setController(this);
    }

    /**
     * State turn
     */
    public void turn(){
        state.turn();
    }

    /**
     * State when a Energy card is played
     */
    public void playEnergy(){
        state.playEnergy();
    }

    /**
     * State when a StadiumCard is Played
     */
    public void playStadium(){
        state.playStadium();
    }

    /**
     * State when a ability of a pokemon is used
     */
    public void useAbility(){
        currentTrainer.getActivePokemon().getSelectedAttack().attack(opponent.getActivePokemon());
        state.useAbility();
    }

    /**
     * State when the turn of the current player ends
     */
    public void endTurn(){
        state.endTurn();
    }

    /**
     * See if a card was drawn
     * @return Returns true if a card was drawn, false otherwise
     */
    public boolean isDrawCard(){
        return state.isDrawCard();
    }

    /**
     * See if is the trainers turn
     * @return true if its the turn of the player, false otherwise
     */
    public boolean isTurn(){
        return state.isTurn();
    }

    /**
     * Sees if a EnergyCard was played
     * @return true if a energy card was played, false otherwise
     */
    public boolean isPlayEnergy(){
        return state.isPlayEnergy();
    }

    /**
     * See if a StadiumCard was played
     * @return true if a stadium card was played, false otherwise
     */
    public boolean isPlayStadium(){
        return state.isPlayStadium();
    }

    /**
     * Sees if the ability of a pokemon was used
     * @return true if an ability was used, false otherwise
     */
    public boolean isUseAbility(){
        return state.isUseAbility();
    }

    /**
     * sees if the turn of the trainer ended
     * @return true if the turn ended, false otherwise
     */
    public boolean isEndTurn(){
        return state.isEndTurn();
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
        state.drawCard();
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
     * Sees ALL the pokemons in the game
     * @return all the pokemons
     */
    public ArrayList<IPokemon> seeAllPokemon(){
        ArrayList<IPokemon> playedPokemon = new ArrayList<IPokemon>();
        playedPokemon.add(currentTrainer.getActivePokemon());
        playedPokemon.add(opponent.getActivePokemon());
        playedPokemon.addAll(currentTrainer.getBench());
        playedPokemon.addAll(opponent.getBench());
        return playedPokemon;
    }


    /**
     * Gesta the opponent trainer
     * @return opponent
     */
    public Trainer opponentTrainer() {
        return opponent;
    }
}
