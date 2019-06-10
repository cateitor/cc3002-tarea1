package tcg.water;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.electric.ElectricAttack;
import tcg.fighting.FightingAttack;
import tcg.grass.GrassAttack;

import java.util.ArrayList;

public abstract class AbstractWaterPokemon extends AbstractPokemon implements IWaterPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractWaterPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
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
