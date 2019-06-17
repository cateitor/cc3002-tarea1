package tcg;

/**
 * Common interface for all the energies. The energies are a kind of Card without methods.
 * @author Catalina Rojas
 */
public interface IEnergy extends ICard{

    /**
     * Plays a energy card over Trainer's active Pokemon
     * @param pokemon the pokemon that the energy is added
     */
    public void addEnergyToPokemon(IPokemon pokemon);

}
