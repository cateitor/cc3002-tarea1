package tcg;

import tcg.trainer.Trainer;

/**
 * Common interface for the cards.
 * @author Catalina Rojas
 */
public interface ICard extends Visitable {
    /**
     * Plays a card.
     */
    void play();

    /**
     * Sets the trainer of a card
     * @param trainer the trainer of the card
     */
    void setTrainer(Trainer trainer);

    /**
     * Gets the trainer of a card
     * @return trainer
     */
    Trainer getTrainer();
}
