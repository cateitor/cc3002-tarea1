package tcg.trainerCard.stadiumCard;

import tcg.AbstractTrainerCard;
import tcg.Visitor;

/**
 * Class for a LuckyStadiumCard
 */
public class LuckyStadium extends AbstractTrainerCard {
    String name;
    String descriptiveText;

    public LuckyStadium(String name,String descriptiveText) {
        super(name,descriptiveText);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLuckyStadiumCard(this);
    }
}
