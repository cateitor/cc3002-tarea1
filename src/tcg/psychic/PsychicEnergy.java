package tcg.psychic;

import tcg.*;
import tcg.Visitor;

/**
 * Class that represents a PsychicEnergy.
 * @author Catalina Rojas.
 */
public class PsychicEnergy extends AbstractEnergyCard implements IEnergy {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicEnergy;
    }


    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addPsychicEnergy(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPsychicEnergy(this);
    }
}
