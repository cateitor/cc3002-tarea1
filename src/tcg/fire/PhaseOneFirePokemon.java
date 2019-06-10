package tcg.fire;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPhaseOnePokemon;

import java.util.ArrayList;

public class PhaseOneFirePokemon extends AbstractFirePokemon implements IPhaseOnePokemon {
    private int preId;
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public PhaseOneFirePokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

}
