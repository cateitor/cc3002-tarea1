package tcg.fighting;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.grass.GrassAttack;
import tcg.psychic.PsychicAttack;

import java.util.ArrayList;

/**
 * Abstract class for a FightingPokemon
 * @author Catalina Rojas
 */
public abstract class AbstractFightingPokemon extends AbstractPokemon implements IFightingPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractFightingPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receiveGrassAttack(GrassAttack grassAttack){
        receiveWeaknessAttack(grassAttack);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack psychicAttack){
        receiveWeaknessAttack(psychicAttack);
    }
}
