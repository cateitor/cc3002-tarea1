package tcg.grass;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.fire.FireAttack;
import tcg.water.WaterAttack;

import java.util.ArrayList;

public abstract class AbstractGrassPokemon extends AbstractPokemon implements IGrassPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractGrassPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
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
