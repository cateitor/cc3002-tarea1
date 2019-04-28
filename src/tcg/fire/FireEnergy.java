package tcg.fire;

import tcg.AbstractEnergy;
import tcg.IEnergy;
import tcg.Trainer;

/**
 * Class that represents a Fire Energy.
 * @author Catalina Rojas
 */
public class FireEnergy extends AbstractEnergy {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FireEnergy;
    }

}
