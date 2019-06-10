package tcg.psychic;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.fighting.FightingAttack;

import java.util.ArrayList;

public abstract class AbstractPsychicPokemon extends AbstractPokemon implements IPsychicPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public AbstractPsychicPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack psychicAttack){
        receiveWeaknessAttack(psychicAttack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack fightingAttack){
        receiveResistantAttack(fightingAttack);
    }
}
