package tcg.water;

import tcg.AbstractAttack;
import tcg.IPokemon;

/**
 * Class that represents a Water Attack.
 * @author Catalina Rojas.
 */
public class WaterAttack extends AbstractAttack {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public WaterAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        aPokemon.receiveWaterAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WaterAttack && super.equals(obj);
    }
}
