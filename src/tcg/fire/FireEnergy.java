package tcg.fire;

import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a Fire Energy.
 * @author Catalina Rojas
 */
public class FireEnergy implements IEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FireEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addFireEnergy(this);
    }

    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addFireEnergy(this);
    }
}
