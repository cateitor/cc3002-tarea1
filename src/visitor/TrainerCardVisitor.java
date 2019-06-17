package visitor;

import tcg.FlipCoin;
import tcg.ICard;
import tcg.ITrainerCard;
import tcg.trainerCard.objectCard.PotionCard;
import tcg.trainerCard.stadiumCard.LuckyStadium;
import tcg.trainerCard.supportCard.ProfessorCozmosDiscoveryCard;
import tcg.trainerCard.supportCard.ProfessorJuniperCard;

/**
 * Visitor for a TrainerCard
 * @author Catalina Rojas
 */
public class TrainerCardVisitor extends Visitor{

    /**
     * Discards trainer's hand and draws 7 cards from the deck
     * @param professorJuniperCard the card that does this
     */
    @Override
    public void visitProfessorJuniperCard(ProfessorJuniperCard professorJuniperCard){
        for(ICard card : professorJuniperCard.getTrainer().getHand()){
            professorJuniperCard.getTrainer().getDiscardPile().add(card);
        }
        for(int i=0; i<7;i++){
            professorJuniperCard.getTrainer().getHand().add(professorJuniperCard.getTrainer().getDeck().get(0));
            professorJuniperCard.getTrainer().getDeck().remove(0);
        }
    }

    @Override
    public void visitPotionCard(PotionCard potionCard){
        potionCard.getTrainer().getActivePokemon().setDamage(potionCard.getTrainer().getActivePokemon().getDamage()-potionCard.getHeal());
    }

    @Override
    public void visitProfessorCozmoCard(ProfessorCozmosDiscoveryCard professorCozmosDiscoveryCard){
        int size = professorCozmosDiscoveryCard.getTrainer().getDeck().size();
        FlipCoin f = new FlipCoin();
        if(f.result == 0){
            professorCozmosDiscoveryCard.getTrainer().draw(0);
            professorCozmosDiscoveryCard.getTrainer().draw(0);
        }
        else{
            professorCozmosDiscoveryCard.getTrainer().draw(size-1);
            professorCozmosDiscoveryCard.getTrainer().draw(size-2);
            professorCozmosDiscoveryCard.getTrainer().draw(size-3);
        }
    }

    @Override
    public void visitLuckyStadiumCard(LuckyStadium card){
        FlipCoin coin = new FlipCoin();
        if(coin.result ==1){
            card.getTrainer().draw(0);
        }
    }
}
