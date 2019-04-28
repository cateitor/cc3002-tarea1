package tcg;

/**
 * Common interface for IPokemon and IEnergy so both of them can be used as cards.
 * @author Catalina Rojas
 */
public interface ICard {

    /**
     * Plays a card.
     * @param trainer the trainer that plays the card.
     */
    void isPlayed(Trainer trainer);
}
