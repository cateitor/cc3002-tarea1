package tcg.trainerCard.objectCard;

import tcg.AbstractTrainerCard;
import tcg.ITrainerCard;
import visitor.Visitor;

/**
 * Class for a Potion Card
 * @author Catalina Rojas
 */
public class PotionCard extends AbstractTrainerCard implements ITrainerCard {
    private int heal;
    private String name;

    /**
     * Constructor for the PotionCard
     * @param name the name of the card
     * @param healing the amount of healing of the card.
     */
    public PotionCard(String name, int healing){
        this.name = name;
        heal = healing;
    }

    /**
     * Sets the amount of healing of the potion card.
     * @param heal
     */
    public void setHeal(int heal){
        this.heal= heal;
    }

    /**
     * Gets the amount of healing of the card
     * @return heal
     */
    public int getHeal(){
        return heal;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPotionCard(this);
    }
}
