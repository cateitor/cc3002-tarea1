package tcg.psychic;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPhaseOnePokemon;
import tcg.Visitor;

import java.util.ArrayList;

/**
 * Class for a PhaseOnePsychicPokemon
 * @author Catalina Rojas
 */
public class PhaseOnePsychicPokemon extends AbstractPsychicPokemon implements IPhaseOnePokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public PhaseOnePsychicPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void accept(Visitor v) {
        v.visitPhaseOnePsychicPokemon(this);
    }

}
