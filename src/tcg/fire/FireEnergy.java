package tcg.fire;

import tcg.*;
import tcg.Visitor;

/**
 * Class that represents a Fire Energy.
 * @author Catalina Rojas
 */
public class FireEnergy extends AbstractEnergyCard implements IEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FireEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addFireEnergy(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFireEnergy(this);
    }
}
