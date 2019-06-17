package tcg.trainerCard.supportCard;

import tcg.AbstractTrainerCard;
import tcg.ITrainerCard;
import tcg.Visitor;

/**
 * Class for a ProfessorCozmosDiscoveryCard
 * @author Catalina Rojas
 */
public class ProfessorCozmosDiscoveryCard extends AbstractTrainerCard implements ITrainerCard {


    /**
     * Constructor of the TrainerCard
     *
     * @param name            the name of the card
     * @param descriptiveText the descriptive text of the card
     */
    public ProfessorCozmosDiscoveryCard(String name, String descriptiveText) {
        super(name, descriptiveText);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitProfessorCozmoCard(this);
    }
}
