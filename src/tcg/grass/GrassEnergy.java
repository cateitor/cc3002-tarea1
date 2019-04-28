package tcg.grass;

import tcg.AbstractEnergy;
import tcg.IEnergy;
import tcg.Trainer;

/**
 * Class that represents a GrassEnergy.
 * @author Catalina Rojas.
 */
public class GrassEnergy extends AbstractEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GrassEnergy;
    }
}
