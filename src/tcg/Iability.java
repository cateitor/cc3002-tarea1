package tcg;
/**
 * Common interface for all the attacks. Every attack have a name,
 * base damage, descriptive text and a cost
 * @author Catalina Rojas
 */
public interface IAbility {

    /**
     * An attack damages a Pokemon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     * @param aPokemon the tcg that receives the attack
     */
    void attack(IPokemon aPokemon);

    /**
     * Getter for the base damage of an attack
     * @return Base damage of the attack
     */
    int getBaseDamage();

    /**
     * Getter for the name of the attack
     * @return the name of the attack
     */
    String getName();

    /***
     * Getter for the descriptive text of an attack
     * @return the descriptive text of the attack
     */
    String getDescriptiveText();

    /**
     * Getter for the cost of the attack. Every attack have a cost that must be paid with energy cards
     * stipulated.
     * @return the amount of energy cards
     */
    int getCost();
}
