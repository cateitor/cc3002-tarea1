package tcg;

/**
 * Common interface for IPokemon and IEnergy so both of them can be used as cards.
 * @author Catalina Rojas
 */
public interface ICard {

    /**
     * plays with a energy card.
     */
    void isPlayed(Trainer trainer);
}
