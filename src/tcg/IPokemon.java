package tcg;

import tcg.electric.ElectricAttack;
import tcg.fighting.FightingAttack;
import tcg.fire.FireAttack;
import tcg.grass.GrassAttack;
import tcg.psychic.PsychicAttack;
import tcg.water.WaterAttack;

import java.util.ArrayList;

/**
 * Common interface for all the types of Pokemon. Every Pokemon have an Id, hp, energies and attacks associated.
 * @author Catalina Rojas
 */
public interface IPokemon extends ICard{

    /**
     *Attacks another Pokemon.
     * @param aPokemon the attacked Pokemon.
     */
    void attack(IPokemon aPokemon);

    /**
     * Select an attack from the attacks array.
     * @param index the index of the attack to be selected.
     */
    void selectAttack(int index);

    /**
     * Receives a fire attack.
     * @param fireAttack the attack.
     */
    void receiveFireAttack(FireAttack fireAttack);

    /**
     * Receives a electric attack.
     * @param electricAttack the attack.
     */
    void receiveElectricAttack(ElectricAttack electricAttack);

    /**
     * Receives a fighting attack.
     * @param figthingAttack the attack.
     */
    void receiveFightingAttack(FightingAttack figthingAttack);

    /**
     * Receives a grass attack.
     * @param grassAttack the attack.
     */
    void receiveGrassAttack(GrassAttack grassAttack);

    /**
     * Receives a psychic attack.
     * @param psychicAttack the attack.
     */
    void receivePsychicAttack(PsychicAttack psychicAttack);

    /**
     * Receives a water attack.
     * @param waterAttack the attack.
     */
    void receiveWaterAttack(WaterAttack waterAttack);

    /**
     * Get the pokemon health points.
     * @return the hp.
     */
    int getHp();

    /**
     * Checks if a pokemon is out of combat.
     * @return true if the hp is less or equal to cero, false otherwise.
     */
    boolean isDead();

    /**
     * Gets the id associated with the pokemon.
     * @return Id.
     */
    int getId();

    /**
     * Return the energies that are associated to the pokemon.
     * @return energies
     */
    ArrayList<IEnergy> getEnergies();

    /**
     * Return the attacks of the pokemon
     * @return attacks
     */
    ArrayList<IAttack> getAttacks();

    /**
     * Returns the selected attacks of the pokemon.
     * @return selectedAttack
     */
    IAttack getSelectedAttack();

    /**
     * Return the total number of energies
     * @return numberOfEnergies
     */
    int numberOfEnergies();

    /**
     * Adds an attack to the pokemon
     * @param attack the attacks to be added.
     */
    void addAttack(IAttack attack);

    /**
     * Adds a new energy to the pokemon.
     * @param energy the added energy
     */
    void addEnergy(IEnergy energy);


}
