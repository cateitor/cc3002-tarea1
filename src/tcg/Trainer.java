package tcg;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Class that represents a Trainer.
 * Contains the constructor and methods to access the Trainer's properties such as activePokemon, hand and bench.
 * @author Catalina Rojas
 */
public class Trainer {
    private IPokemon activePokemon;
    private ArrayList<ICard> hand;
    private ArrayList<IPokemon> bench;

    /**
     * Creates a new Trainer
     */
    public Trainer(){
        activePokemon = null;
        hand = new ArrayList<ICard>();
        bench= new ArrayList<IPokemon>();
    }

    /**
     * Set an active pokemon for the trainer. This will be the one used for attack the opponent.
     * @param activePokemon the active pokemon.
     */
    public void setActivePokemon(IPokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    /**
     * Sets the hand of the Trainer.
     * @param aHand the hand of the Trainer.
     */
    public void setHand(ArrayList<ICard> aHand){
        hand = aHand;
    }

    /**
     * Sets the bench of the Trainer.
     * @param aBench the bench of the Trainer.
     */
    public void setBench(ArrayList<IPokemon> aBench){
        bench= aBench;
    }

    /**
     * Adds a pokemon to the Trainer's bench, maximum of 5.
     * @param pokemon the pokemon added to the bench.
     */
    public void addBenchPokemon(IPokemon pokemon){
        if(bench.size()<5){
            bench.add(pokemon);
        }
    }

    /**
     * Adds a card to the hand of the Trainer.
     * @param card the card to be added.
     */
    public void addCard(ICard card){
        hand.add(card);
    }

    /**
     * Gets the hand of the trainer.
     * @return hand.
     */
    public ArrayList<ICard> getHand(){
        return hand;
    }

    /**
     * Gets the bench of the trainer.
     * @return bench.
     */
    public ArrayList<IPokemon> getBench(){
        return bench;
    }

    /**
     * select the ability of the active pokemon
     * @param index the index of the attack to be selected.
     */
    public void selectAbility(int index){
        activePokemon.selectAttack(index);
    }


    //HAY QUE EDITAR ESTE MÉTODO.
    /**
     * Plays a card from the hand.
     * @param card the card that is played.
     */
    public void play(ICard card){
        card.isPlayed(this);
    }

    /**
     * Gets a card from the hand of the trainer.
     * @param index the index of the card to get.
     * @return the card.
     */
    public ICard getCard(int index){
        return hand.get(index);
    }

    /**
     * See if the active pokemon of the trainer is out of combat
     * @return true if the pokemon is dead, false otherwise.
     */
    public boolean isDead(){
        return activePokemon.isDead();
    }


    /**
     * Gets the current selected attack for the active pokemon.
     * @return the selected attack.
     */
    public IAttack getSelectedAttack() {
        return activePokemon.getSelectedAttack();
    }

    /**
     * Gets the current active pokemon.
     * @return active pokemon.
     */
    public IPokemon getActivePokemon() {
        return activePokemon;
    }


    /**
     * If the active pokemon is out of combat, select the first pokemon of the bench.
     */
    public void changeActivePokemon(){
        if(activePokemon.isDead()){
            setActivePokemon(bench.get(0));
            bench.remove(bench.get(0));
        }
    }

    public void useAbility(Trainer adversary){
        activePokemon.useAbility(adversary);
    }

}
