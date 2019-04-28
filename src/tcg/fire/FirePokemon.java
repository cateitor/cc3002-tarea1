package tcg.fire;

import tcg.AbstractPokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.water.WaterAttack;

import java.util.ArrayList;

/**
 * Class that represents a Fire Pokemon.
 * @author Catalina Rojas
 */
public class FirePokemon extends AbstractPokemon {

    /**
     * Creates a new Fire Pokemon.
     * @param aId the id of the pokemon.
     * @param anHp hp of the pokemon.
     * @param anEnergies energies associated to the pokeomon.
     * @param anAttacks attacks associated to the pokemon, maximum of 4.
     */
    public FirePokemon(int aId, int anHp, ArrayList<IEnergy> anEnergies, ArrayList<IAttack> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveWaterAttack(WaterAttack waterAttack){
        receiveWeaknessAttack(waterAttack);
    }
}
