package tcg;

import tcg.trainer.Trainer;
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

    int getCurrentHp();

    void setDamage(int current);

    int getDamage();

    void setEnergyCounter(EnergyCounter energies);

    Trainer getTrainer();
    /**
     * Return the energies that are associated to the pokemon.
     * @return energyCounter
     */
    EnergyCounter getEnergies();

    /**
     * Return the attacks of the pokemon
     * @return attacks
     */
    ArrayList<IAbility> getAttacks();

    /**
     * Returns the selected attacks of the pokemon.
     * @return selectedAttack
     */
    IAbility getSelectedAttack();

    /**
     * Adds an attack to the pokemon
     * @param attack the attacks to be added.
     */
    void addAttack(IAbility attack);


    /**
     * Use ability over adversary's active pokemon.
     * @param adversary the adversary trainer.
     */
    void useAbility(Trainer adversary);


    /**
     * Adds an ElectricEnergy.
     * @param electricEnergy the energy added.
     */
    void addElectricEnergy(ElectricEnergy electricEnergy);

    /**
     * Adds a FightingEnergy.
     * @param energy the energy added.
     */
    void addFightingEnergy(FightingEnergy energy);

    /**
     * Adds a FireEnergy
     * @param energy the energy added.
     */
    void addFireEnergy(FireEnergy energy);

    /**
     * Adds a GrassEnergy
     * @param energy the energy added
     */
    void addGrassEnergy(GrassEnergy energy);

    /**
     * Adds a PsychicEnergy
     * @param energy the energy added
     */
    void addPsychicEnergy(PsychicEnergy energy);

    /**
     * Adds a WaterEnergy
     * @param energy the energy added
     */
    void addWaterEnergy(WaterEnergy energy);

    /**
     * Accepts a visitor
     * @param v the visitor accepted
     */
    void accept(Visitor v);

    /**
     * Gets the preId of the pokemon
     * @return preId
     */
    int getPreId();

    /**
     * Sets the preId of a Pokemon
     * @param id the preId
     */
    void setPreId(int id);
}
