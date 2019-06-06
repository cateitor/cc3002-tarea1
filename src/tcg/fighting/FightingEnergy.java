package tcg.fighting;

import tcg.*;

/**
 * Class that represents a FightingEnergy.
 */
public class FightingEnergy implements IEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FightingEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addFightingEnergy(this);
    }

    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addFightingEnergy(this);
    }
}
