package tcg.fire;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.water.WaterAttack;

import java.util.ArrayList;

/**
 * Abstract Class for a FirePokemon
 * @author Catalina Rojas
 */
public abstract class AbstractFirePokemon extends AbstractPokemon implements IFirePokemon {

    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractFirePokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveWaterAttack(WaterAttack waterAttack){
        receiveWeaknessAttack(waterAttack);
    }


}
