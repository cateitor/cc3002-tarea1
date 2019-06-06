package tcg.grass;

import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a GrassEnergy.
 * @author Catalina Rojas.
 */
public class GrassEnergy implements IEnergy{



    @Override
    public boolean equals(Object obj) {
        return obj instanceof GrassEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addGrassEnergy(this);
    }

    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addGrassEnergy(this);
    }
}
