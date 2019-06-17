package tcg.psychic;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IBasicPokemon;
import tcg.Visitor;

import java.util.ArrayList;

/**
 * Class for a BasicPsychicPokemon
 * @author Catalina Rojas
 */
public class BasicPsychicPokemon extends AbstractPsychicPokemon implements IBasicPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public BasicPsychicPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void accept(Visitor v) {
        v.visitBasicPsychicPokemon(this);
    }

    /**
     * A basic Pokemon does not have a pre evolution
     * @return 0.
     */
    @Override
    public int getPreId(){
        return 0;
    }
}
