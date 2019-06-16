package tcg.fire;

import tcg.AbstractAbility;
import tcg.IPokemon;

/**
 * Class for a FireAttack
 * @author Catalina Rojas
 */
public class FireAttack extends AbstractAbility {


    /**
     * Creates a new attack.
     *
     * @param aName the name of the attack.
     * @param aBaseDamage the base damage of the attack.
     * @param aCost the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public FireAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
        this.getCost().setFireEnergy(aCost);
    }


    @Override
    public void attack(IPokemon aPokemon) {
        aPokemon.receiveFireAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FireAttack && super.equals(obj);
    }
}
