package tcg.water;

import tcg.EnergyCounter;
import tcg.IAbility;
import tcg.IBasicPokemon;
import visitor.Visitor;

import java.util.ArrayList;

public class BasicWaterPokemon extends AbstractWaterPokemon implements IBasicPokemon {
    /**
     * Creates a new Pokemon
     *
     * @param aId        the id of the pokemon.
     * @param anHp       health points of the pokemon.
     * @param anEnergies energies associated with the pokemon.
     * @param anAttacks  the types of attacks of the pokemon. Maximum of 4.
     */
    public BasicWaterPokemon(int aId, int anHp, EnergyCounter anEnergies, ArrayList<IAbility> anAttacks) {
        super(aId, anHp, anEnergies, anAttacks);
    }

    @Override
    public void accept(Visitor v) {
        v.visitBasicPokemon(this);
    }


    /**
     * A basic Pokemon does not have a pre evolution
     * @param id is set to 0.
     */
    @Override
    public void setPreId(int id){
        this.setPreId(0);
    }

    /**
     * A basic Pokemon does not have a pre evolution
     * @return 0.
     */
    @Override
    public int getPreId(){
        return 0;
    }
}
