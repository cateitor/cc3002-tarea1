package tcg.psychic;

import tcg.AbstractPokemon;
import tcg.EnergyCounter;
import tcg.IAttack;
import tcg.fighting.FightingAttack;

import java.util.ArrayList;

/**
 * Class taht represent a Psychic Pokemon.
 */
public class PsychicPokemon extends AbstractPokemon {

    /**
     * Creates a new Fire Pokemon.
     * @param aId the id of the pokemon.
     * @param anHp hp of the pokemon.
     * @param anEnergies energies associated to the pokeomon.
     * @param anAttacks attacks associated to the pokemon, maximum of 4.
     */
    public PsychicPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAttack> anAttacks) {
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
