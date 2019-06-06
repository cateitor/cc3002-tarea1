package tcg.fighting;

import tcg.*;

/**
 * Class that represents a FightingEnergy.
 */
public class FightingEnergy extends AbstractEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FightingEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addFightingEnergy(this);
    }
}
