package tcg.trainerCard.objectCard;

import tcg.AbstractTrainerCard;
import tcg.ITrainerCard;
import tcg.Visitor;

/**
 * Class for a Potion Card
 * @author Catalina Rojas
 */
public class PotionCard extends AbstractTrainerCard implements ITrainerCard {
    private int heal;

    /**
     * Constructor for the PotionCard
     * @param name the name of the card
     * @param  descriptiveText the descriptive text of the card
     */
    public PotionCard(String name, String descriptiveText){
        super(name, descriptiveText);

    }

    /**
     * Sets the amount of healing of the potion card.
     * @param heal the amount that can heal
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
