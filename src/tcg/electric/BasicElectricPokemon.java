package tcg.electric;

import tcg.Visitor;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IBasicPokemon;

import java.util.ArrayList;

/**
 * The class that represents a BasicElectricPokemon
 * @author Catalina Rojas
 */
public class BasicElectricPokemon extends AbstractElectricPokemon implements IBasicPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public BasicElectricPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
        setPreId(0);
    }

    /**
     * A basic Pokemon does not have a pre evolution
     * @return 0.
     */
    @Override
    public int getPreId(){
        return 0;
    }

    @Override
    public void accept(Visitor v) {
        v.visitBasicElectricPokemon(this);
    }

}
