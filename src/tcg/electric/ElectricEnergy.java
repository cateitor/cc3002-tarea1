package tcg.electric;

import tcg.*;
import visitor.EnergyVisitor;
import visitor.Visitor;

/**
 *Class that represent an ElectricEnergy.
 * @author Catalina Rojas.
 */
public class ElectricEnergy extends AbstractEnergyCard implements IEnergy {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricEnergy;
    }

    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addElectricEnergy(this);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitElectricEnergy(this);
    }
}
