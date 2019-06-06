package tcg.psychic;

import tcg.AbstractEnergy;
import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a PsychicEnergy.
 * @author Catalina Rojas.
 */
public class PsychicEnergy extends AbstractEnergy {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicEnergy;
    }


    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addPsychicEnergy(this);
    }
}
