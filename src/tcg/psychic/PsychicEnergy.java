package tcg.psychic;

import tcg.IEnergy;
import tcg.IPokemon;
import tcg.Trainer;

/**
 * Class that represents a PsychicEnergy.
 * @author Catalina Rojas.
 */
public class PsychicEnergy implements IEnergy {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicEnergy;
    }


    @Override
    public void addEnergyToPokemon(IPokemon pokemon) {
        pokemon.addPsychicEnergy(this);
    }


    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addPsychicEnergy(this);
    }
}
