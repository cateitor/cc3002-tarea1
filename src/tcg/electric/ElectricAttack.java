package tcg.electric;

import tcg.AbstractAbility;
import tcg.EnergyCounter;
import tcg.IPokemon;

/**
 * Class that represents an ElectricAttack
 * @author Catalina Rojas
 */
public class ElectricAttack extends AbstractAbility {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public ElectricAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
        this.getCost().setElectricEnergy(aCost);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        aPokemon.receiveElectricAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricAttack && super.equals(obj);
    }
}
