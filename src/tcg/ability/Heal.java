package tcg.ability;

import tcg.AbstractAbility;
import tcg.FlipCoin;
import tcg.IPokemon;

public class Heal extends AbstractAbility {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public Heal(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, 0, aDescriptiveText);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        FlipCoin coin = new FlipCoin();
        if(coin.result == 1){
            aPokemon.setDamage(aPokemon.getDamage()-10);
        }
    }
}
