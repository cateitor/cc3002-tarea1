package tcg.electric;

import tcg.*;

/**
 *Class that represent an ElectricEnergy.
 * @author Catalina Rojas.
 */
public class ElectricEnergy implements IEnergy {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addElectricEnergy(this);
    }

    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addElectricEnergy(this);
    }
}
