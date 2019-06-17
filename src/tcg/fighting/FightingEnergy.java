package tcg.fighting;

import tcg.*;
import tcg.Visitor;

/**
 * Class that represents a FightingEnergy.
 */
public class FightingEnergy extends AbstractEnergyCard implements IEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FightingEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addFightingEnergy(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFightingEnergy(this);
    }
}
