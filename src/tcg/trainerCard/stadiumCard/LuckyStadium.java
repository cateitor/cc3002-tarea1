package tcg.trainerCard.stadiumCard;

import tcg.AbstractTrainerCard;
import visitor.Visitor;

public class LuckyStadium extends AbstractTrainerCard {


    @Override
    public void accept(Visitor visitor) {
        visitor.visitLuckyStadiumCard(this);
    }
}
