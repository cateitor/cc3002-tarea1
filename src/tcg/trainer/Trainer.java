package tcg.trainer;

import controller.Controller;
import tcg.IAbility;
import tcg.ICard;
import tcg.IPokemon;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that represents a Trainer.
 * Contains the constructor and methods to access the Trainer's properties such as activePokemon, hand and bench.
 * @author Catalina Rojas
 */
public class Trainer {
    private Controller controller;
    private IPokemon activePokemon;
    private ArrayList<ICard> hand;
    private ArrayList<IPokemon> bench;
    private ArrayList<ICard> deck;
    private Stack<ICard> discardPile;
    private IPokemon selectedPokemon;

    /**
     * Creates a new Trainer
     */
    public Trainer(){
        activePokemon = null;
        hand = new ArrayList<ICard>();
        bench= new ArrayList<IPokemon>();
        discardPile= new Stack<ICard>();
        deck = new ArrayList<ICard>();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public Controller getController(){
        return controller;
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
     * Sets the deck of the Trainer.
     * @param aDeck the deck of the trainer.
     */
    public void setDeck(ArrayList<ICard> aDeck){
        deck= aDeck;
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
     * Gets the deck of the trainer.
     * @return deck.
     */
    public ArrayList<ICard> getDeck() {
        return deck;
    }

    /**
     * select the ability of the active pokemon
     * @param index the index of the attack to be selected.
     */
    public void selectAbility(int index){
        activePokemon.selectAttack(index);
    }


    /**
     * Plays a card from the hand.
     * @param index the index of the card that is played.
     */
    public void play(int index){
        this.getCard(index).setTrainer(this);
        this.getCard(index).play();
        hand.remove(this.getCard(index));
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
    public IAbility getSelectedAttack() {
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
     * Gets the discard pile of the trainer.
     * @return discardPile.
     */
    public Stack<ICard> getDiscardPile(){
        return discardPile;
    }


    /**
     * If the active pokemon is out of combat, select the first pokemon of the bench.
     */
    public void changeActivePokemon(){
        if(activePokemon.isDead()){
            discardPile.add(activePokemon);
            setActivePokemon(bench.get(0));
            bench.remove(bench.get(0));
        }
    }

    /**
     * Uses ability to adversary
     * @param adversary the adversary of the current trainer
     */
    public void useAbility(Trainer adversary){
        activePokemon.useAbility(adversary);
    }


    /**
     * Accepts a TrainerVisitor.
     * @param v the visitor accepted.
     */
    public void accept(Visitor v){
        v.visitTrainer(this);
    }

    /**
     * Sets the selected pokemon.
     * @param index the index of the pokemon, if the index is 6 the pokemon selected is the active pokemon,
     *              else if the index is between 0 and 4, the selected pokemon is one from the bench.
     */
    public void setSelectedPokemon(int index) {
        if (index == 6) {
            selectedPokemon = activePokemon;
        } else {
            selectedPokemon = bench.get(index);
        }
    }

    /**
     * Gets the selectedPokemon
     * @return selectedPokemon
     */
    public IPokemon getSelectedPokemon(){
        return selectedPokemon;
    }


    /**
     * Draws card from a part of the deck
     * @param index index of the card
     */
    public void draw(int index){
        deck.get(index);
        deck.remove(index);
    }
}
