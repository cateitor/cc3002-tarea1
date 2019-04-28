package tcg.fighting;

import tcg.AbstractPokemon;
import tcg.IAttack;
import tcg.IEnergy;
import tcg.grass.GrassAttack;
import tcg.psychic.PsychicAttack;

import java.util.ArrayList;

/**
 * Class that represents a FightingPokemon.
 * @author Catalina Rojas
 */
public class FightingPokemon extends AbstractPokemon {

    /**
     * Creates a new Fighting Pokemon.
     * @param aId id of the pokemon.
     * @param anHp hp of the pokemon.
     * @param anEnergies energies associates to the pokemon.
     * @param anAttacks attacks of the pokemon, maximum of 4.
     */
    public FightingPokemon(int aId, int anHp, ArrayList<IEnergy> anEnergies, ArrayList<IAttack> anAttacks) {
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
