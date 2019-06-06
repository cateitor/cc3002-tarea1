package tcg.water;

import tcg.AbstractEnergy;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a Water Energy.
 * @author Catalina Rojas.
 */
public class WaterEnergy extends AbstractEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WaterEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addWaterEnergy(this);
    }
}
