package tcg.fighting;

import tcg.AbstractEnergy;
import tcg.ICard;
import tcg.IEnergy;
import tcg.Trainer;

/**
 * Class that represents a FightingEnergy.
 */
public class FightingEnergy extends AbstractEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FightingEnergy;
    }

}
