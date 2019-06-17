package tcg.grass;

import tcg.*;
import tcg.Visitor;

/**
 * Class that represents a GrassEnergy.
 * @author Catalina Rojas.
 */
public class GrassEnergy extends AbstractEnergyCard implements IEnergy{



    @Override
    public boolean equals(Object obj) {
        return obj instanceof GrassEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addGrassEnergy(this);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitGrassEnergy(this);
    }
}
