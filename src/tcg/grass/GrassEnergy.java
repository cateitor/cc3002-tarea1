package tcg.grass;

import tcg.AbstractEnergy;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a GrassEnergy.
 * @author Catalina Rojas.
 */
public class GrassEnergy extends AbstractEnergy implements IEnergy{



    @Override
    public boolean equals(Object obj) {
        return obj instanceof GrassEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addGrassEnergy(this);
    }
}
