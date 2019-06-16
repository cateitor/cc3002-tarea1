package tcg.trainerCard.supportCard;

import tcg.*;
import visitor.Visitor;

/**
 * Class that Represents a Professor Juniper Card.
 */
public class ProfessorJuniperCard extends AbstractTrainerCard implements ITrainerCard {
    String name;

    /**
     * Constructor for the ProfessorJuniperCard;
     */
    public ProfessorJuniperCard(){
        name = "Professor Juniper Card";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitProfessorJuniperCard(this);
    }
}
