package tcg.water;

import tcg.*;
import tcg.Visitor;

/**
 * Class that represents a Water Energy.
 * @author Catalina Rojas.
 */
public class WaterEnergy extends AbstractEnergyCard implements IEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WaterEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addWaterEnergy(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitWaterEnergy(this);
    }
}
