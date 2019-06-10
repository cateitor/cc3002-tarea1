package tcg.electric;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.fighting.FightingAttack;

import java.util.ArrayList;

public abstract class AbstractElectricPokemon extends AbstractPokemon implements IElectricPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractElectricPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveFightingAttack(FightingAttack figthingAttack){
        receiveWeaknessAttack(figthingAttack);
    }
}
