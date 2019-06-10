package tcg.electric;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPhaseTwoPokemon;

import java.util.ArrayList;

public class PhaseTwoElectricPokemon extends AbstractElectricPokemon implements IPhaseTwoPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public PhaseTwoElectricPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }


}
