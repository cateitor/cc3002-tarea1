package tcg.trainerCard.supportCard;

import tcg.AbstractTrainerCard;
import tcg.ITrainerCard;
import visitor.Visitor;

public class ProfessorCozmosDiscoveryCard extends AbstractTrainerCard implements ITrainerCard {


    @Override
    public void accept(Visitor visitor) {
        visitor.visitProfessorCozmoCard(this);
    }
}
