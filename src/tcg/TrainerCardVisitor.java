package tcg;

import tcg.trainerCard.objectCard.PotionCard;
import tcg.trainerCard.stadiumCard.LuckyStadium;
import tcg.trainerCard.supportCard.ProfessorCozmosDiscoveryCard;
import tcg.trainerCard.supportCard.ProfessorJuniperCard;

import java.util.ArrayList;

/**
 * Visitor for a TrainerCard
 * @author Catalina Rojas
 */
public class TrainerCardVisitor extends Visitor {

    /**
     * Discards trainer's hand and draws 7 cards from the deck
     * @param professorJuniperCard the card that does this
     */
    @Override
    public void visitProfessorJuniperCard(ProfessorJuniperCard professorJuniperCard){
        for(ICard card : professorJuniperCard.getTrainer().getHand()){
            professorJuniperCard.getTrainer().getDiscardPile().add(card);
        }
        professorJuniperCard.getTrainer().setHand(new ArrayList<ICard>());
        for(int i=0; i<7;i++){
            professorJuniperCard.getTrainer().getHand().add(professorJuniperCard.getTrainer().getDeck().get(0));
        }
        professorJuniperCard.getTrainer().getHand().remove(professorJuniperCard);
    }

    @Override
    public void visitPotionCard(PotionCard potionCard){
        potionCard.getTrainer().getActivePokemon().setDamage(potionCard.getTrainer().getActivePokemon().getDamage()-potionCard.getHeal());
        potionCard.getTrainer().getHand().remove(potionCard);
    }


    @Override
    public void visitProfessorCozmoCard(ProfessorCozmosDiscoveryCard professorCozmosDiscoveryCard){
        int size = professorCozmosDiscoveryCard.getTrainer().getDeck().size()-1;
        FlipCoin f = new FlipCoin();
        if(f.result == 0){
            for(int j = 0; j <3 ; j++){
                professorCozmosDiscoveryCard.getTrainer().getHand().add(professorCozmosDiscoveryCard.getTrainer().getDeck().get(0));
                professorCozmosDiscoveryCard.getTrainer().getDeck().remove(0);
            }
        }
        else{
            for(int i = 0; i<4; i++){
                professorCozmosDiscoveryCard.getTrainer().getHand().add(professorCozmosDiscoveryCard.getTrainer().getDeck().get(size-i));
                professorCozmosDiscoveryCard.getTrainer().getDeck().remove(size-i);
            }
        }
        professorCozmosDiscoveryCard.getTrainer().getHand().remove(professorCozmosDiscoveryCard);
    }

    @Override
    public void visitLuckyStadiumCard(LuckyStadium card){
        FlipCoin coin = new FlipCoin();
        if(coin.result ==1){
            card.getTrainer().getHand().add(card.getTrainer().getDeck().get(0));
            card.getTrainer().getDeck().remove(0);
        }
        card.getTrainer().getController().setLuckyStadium(true);
        card.getTrainer().getHand().remove(card);
    }
}
