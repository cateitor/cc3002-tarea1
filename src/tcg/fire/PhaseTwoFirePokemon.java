package tcg.fire;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPhaseTwoPokemon;
import tcg.Visitor;

import java.util.ArrayList;

/**
 * Class that represents a PhaseTwoFirePokemon
 * @author Catalina Rojas
 */
public class PhaseTwoFirePokemon extends AbstractFirePokemon implements IPhaseTwoPokemon {
    private int preId;
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public PhaseTwoFirePokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void accept(Visitor v) {
        v.visitPhaseTwoFirePokemon(this);
    }

}
