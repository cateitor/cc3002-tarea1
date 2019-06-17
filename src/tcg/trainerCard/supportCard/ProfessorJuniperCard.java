package tcg.trainerCard.supportCard;

import tcg.*;
import tcg.Visitor;

/**
 * Class that Represents a Professor Juniper Card.
 * @author Catalina Rojas
 */
public class ProfessorJuniperCard extends AbstractTrainerCard implements ITrainerCard {

    /**
     * Constructor for the ProfessorJuniperCard;
     */
    public ProfessorJuniperCard(String name, String descriptiveText){
        super(name, descriptiveText);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitProfessorJuniperCard(this);
    }
}
