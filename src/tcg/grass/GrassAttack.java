package tcg.grass;

import tcg.AbstractAbility;
import tcg.IPokemon;

/**
 * Class that represents a GrassAttack.
 * @author Catalina Rojas.
 */
public class GrassAttack extends AbstractAbility {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public GrassAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        aPokemon.receiveGrassAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GrassAttack && super.equals(obj);
    }
}
