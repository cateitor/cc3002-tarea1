package tcg.electric;

import tcg.AbstractEnergy;
import tcg.ICard;
import tcg.IEnergy;
import tcg.Trainer;

/**
 *Class that represent an ElectricEnergy.
 * @author Catalina Rojas.
 */
public class ElectricEnergy extends AbstractEnergy {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricEnergy;
    }

}
