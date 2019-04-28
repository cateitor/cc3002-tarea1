package tcg.water;

import tcg.AbstractPokemon;
import tcg.electric.ElectricAttack;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.fighting.FightingAttack;
import tcg.grass.GrassAttack;

import java.util.ArrayList;

/**
 * Class that represents a Water Pokemon.
 */
public class WaterPokemon extends AbstractPokemon {

    /**
     * Creates a new Fire Pokemon.
     * @param aId the id of the pokemon.
     * @param anHp hp of the pokemon.
     * @param anEnergies energies associated to the pokeomon.
     * @param anAttacks attacks associated to the pokemon, maximum of 4.
     */
    public WaterPokemon(int aId, int anHp, ArrayList<IEnergy> anEnergies, ArrayList<IAttack> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveGrassAttack(GrassAttack grassAttack){
        receiveWeaknessAttack(grassAttack);
    }

    public void receiveElectricAttack(ElectricAttack electricAttack){
        receiveWeaknessAttack(electricAttack);
    }

    public void receiveFightingAttack(FightingAttack figthingAttack){
        receiveResistantAttack(figthingAttack);
    }
}
