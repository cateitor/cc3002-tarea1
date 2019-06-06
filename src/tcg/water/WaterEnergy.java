package tcg.water;

import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a Water Energy.
 * @author Catalina Rojas.
 */
public class WaterEnergy implements IEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WaterEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addWaterEnergy(this);
    }

    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addWaterEnergy(this);
    }
}
