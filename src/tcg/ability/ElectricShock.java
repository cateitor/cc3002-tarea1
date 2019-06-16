package tcg.ability;

import tcg.AbstractAbility;
import tcg.FlipCoin;
import tcg.IPokemon;
import tcg.electric.ElectricAttack;

public class ElectricShock extends ElectricAttack {
    /**
     * Creates a new attack.
     *
     * @param aName            the name of the attack.
     * @param aBaseDamage      the base damage of the attack.
     * @param aCost            the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    public ElectricShock(String aName, int aBaseDamage, int aCost, String aDescriptiveText) {
        super(aName, aBaseDamage, aCost, aDescriptiveText);
    }

    @Override
    public void attack(IPokemon aPokemon) {
        FlipCoin coin = new FlipCoin();
        if(coin.result == 0){
            aPokemon.receiveElectricAttack(this);
        }
        aPokemon.getTrainer().getController().endTurn();
    }
}
