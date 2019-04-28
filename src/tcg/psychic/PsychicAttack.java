package tcg.psychic;

import tcg.AbstractAttack;
import tcg.IPokemon;

/**
 * Class that represents a Psychic Attack.
 * @author Catalina Rojas.
 */
public class PsychicAttack extends AbstractAttack {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public PsychicAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        aPokemon.receivePsychicAttack(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PsychicAttack && super.equals(obj);
    }
}
