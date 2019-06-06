package tcg.electric;

import tcg.*;
import tcg.fighting.FightingAttack;

import java.util.ArrayList;

/**
 * Class that represents an ElectricPokemon.
 * @author Catalina Rojas.
 */
public class ElectricPokemon extends AbstractPokemon {

    /**
     * Creates a new Electric Pokemon.
     * @param aId Id of the pokemon.
     * @param anHp hp of the pokemon.
     * @param anEnergies energies associated to the pokemon.
     * @param anAttacks attacks associated to the pokemon, maximum of 4.
     */
    public ElectricPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAttack> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveFightingAttack(FightingAttack figthingAttack){
        receiveWeaknessAttack(figthingAttack);
    }

}
