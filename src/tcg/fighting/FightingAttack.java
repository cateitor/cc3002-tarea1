package tcg.fighting;

import tcg.AbstractAbility;
import tcg.IPokemon;

/**
 * Class that represent an Fighting attack
 * @author Catalina Rojas
 */
public class FightingAttack extends AbstractAbility {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public FightingAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        aPokemon.receiveFightingAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FightingAttack && super.equals(obj);
    }
}
