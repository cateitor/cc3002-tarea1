package tcg.trainerCard.supportCard;

import tcg.*;
import tcg.Visitor;

/**
 * Class that Represents a Professor Juniper Card.
 * @author Catalina Rojas
 */
public class ProfessorJuniperCard extends AbstractTrainerCard implements ITrainerCard {

    /**
     * Constructor for the ProfessorJuniperCard
     * @param name the name of the card
     * @param descriptiveText the descriptive text of the card
     */
    public ProfessorJuniperCard(String name, String descriptiveText){
        super(name, descriptiveText);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitProfessorJuniperCard(this);
    }
}
