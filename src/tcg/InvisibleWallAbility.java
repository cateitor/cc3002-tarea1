package tcg;

public class InvisibleWallAbility extends AbstractAbility {

    /**
     * Constructor of the Invisible Wall ability.
     */
    protected InvisibleWallAbility() {
        super("Invisible Wall", 0, 2, "When an attacks give 30 or more damage to the pokemon, it does not have effect.");
    }

    @Override
    public void attack(IPokemon aPokemon) {
    }
}
