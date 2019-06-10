package tcg.fighting;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IBasicPokemon;

import java.util.ArrayList;

public class BasicFightingPokemon extends AbstractFightingPokemon implements IBasicPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public BasicFightingPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }
}
