package tcg;

import tcg.trainer.Trainer;

/**
 * The abstract class for a card
 * @author Catalina Rojas
 */
public abstract class AbstractCard implements ICard {
    private Trainer trainer;

    @Override
    public void setTrainer(Trainer trainer) {
        this.trainer=trainer;
    }

    @Override
    public Trainer getTrainer(){
        return trainer;
    }
}
