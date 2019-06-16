package tcg.electric;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IPhaseOnePokemon;
import visitor.Visitor;

import java.util.ArrayList;

/**
 * Class that represents a PhaseOneElectricPokemon
 * @author Catalina Rojas
 */
public class PhaseOneElectricPokemon extends AbstractElectricPokemon implements IPhaseOnePokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public PhaseOneElectricPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }


    @Override
    public void accept(Visitor v) {
        v.visitPhasePokemon(this);
    }

}
