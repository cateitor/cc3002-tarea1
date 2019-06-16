package tcg;

/**
 * Base class for all the attacks. Contains the method to access the attack's properties: name, base damage,
 * descriptive text and the cost associated.
 *
 * @author Catalina Rojas
 */
public abstract class AbstractAbility implements IAbility {
    private int baseDamage;
    private String name;
    private EnergyCounter cost;
    private String descriptiveText;

    /**
     * Creates a new attack.
     * @param aName the name of the attack.
     * @param aBaseDamage the base damage of the attack.
     * @param aCost the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    protected AbstractAbility(String aName, int aBaseDamage, int aCost, String aDescriptiveText){
        baseDamage = aBaseDamage;
        name = aName;
        cost = new EnergyCounter();
        descriptiveText = aDescriptiveText;
    }


    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescriptiveText() {
        return descriptiveText;
    }

    @Override
    public EnergyCounter getCost() {
        return cost;
    }

    /**
     * Checks if this attack is equal to another.
     * @param obj Object to compare this attack.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IAbility && ((IAbility) obj).getBaseDamage() == baseDamage
                && ((IAbility) obj).getName().equals(name) && ((IAbility) obj).getCost().energies ==cost.energies
                && ((IAbility) obj).getDescriptiveText() == descriptiveText;
    }


}
