package tcg;

import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.fighting.FightingAttack;
import tcg.fighting.FightingEnergy;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.grass.GrassAttack;
import tcg.grass.GrassEnergy;
import tcg.psychic.PsychicAttack;
import tcg.psychic.PsychicEnergy;
import tcg.water.WaterAttack;
import tcg.water.WaterEnergy;

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
     * @return energyCounter
     */
    EnergyCounter getEnergies();

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


    //I THINK I DONT NEED THIS
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
     * Use ability over adversary's active pokemon.
     * @param adversary the adversary trainer.
     */
    void useAbility(Trainer adversary);


    void addElectricEnergy(ElectricEnergy electricEnergy);

    void addFightingEnergy(FightingEnergy energy);

    void addFireEnergy(FireEnergy energy);

    void addGrassEnergy(GrassEnergy energy);

    void addPsychicEnergy(PsychicEnergy energy);

    void addWaterEnergy(WaterEnergy energy);
}
