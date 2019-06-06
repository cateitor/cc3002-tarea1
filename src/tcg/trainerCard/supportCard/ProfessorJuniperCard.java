package tcg.trainerCard.supportCard;

import tcg.ICard;
import tcg.ITrainerCard;
import tcg.Trainer;

public class ProfessorJuniperCard implements ITrainerCard {
    @Override
    public void isPlayed(Trainer trainer) {
        for(ICard card : trainer.getHand()){
            trainer.getDiscardPile().add(card);
        }
        for(int i=0; i<7;i++){
            trainer.drawCard();
        }
    }
}
