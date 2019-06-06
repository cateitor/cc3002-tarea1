package tcg.grass;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAttack;
import tcg.fire.FireAttack;
import tcg.water.WaterAttack;

import java.util.ArrayList;

/**
 * Class that represents a GrassPokemon.
 * @author Catalina Rojas
 */
public class GrassPokemon extends AbstractPokemon {

    /**
     * Creates a new Fire Pokemon.
     * @param aId the id of the pokemon.
     * @param anHp hp of the pokemon.
     * @param anEnergies energies associated to the pokeomon.
     * @param anAttacks attacks associated to the pokemon, maximum of 4.
     */
    public GrassPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAttack> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveFireAttack(FireAttack fireAttack){
        receiveWeaknessAttack(fireAttack);
    }

    @Override
    public void receiveWaterAttack(WaterAttack waterAttack){
        receiveResistantAttack(waterAttack);
    }
}
