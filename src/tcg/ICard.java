package tcg;

/**
 * Common interface for the cards.
 * @author Catalina Rojas
 */
public interface ICard {

    /**
     * Plays a card.
     * @param trainer the trainer that plays the card.
     */
    void isPlayed(Trainer trainer);
}
