package tcg;

/**
 * Base class for all the attacks. Contains the method to access the attack's properties: name, base damage,
 * descriptive text and the cost associated.
 *
 * @author Catalina Rojas
 */
public abstract class AbstractAttack implements IAttack {
    private int baseDamage;
    private String name;
    private int cost;
    private String descriptiveText;

    /**
     * Creates a new attack.
     * @param aName the name of the attack.
     * @param aBaseDamage the base damage of the attack.
     * @param aCost the energy cost of the attack.
     * @param aDescriptiveText the descriptive text of the attack.
     */
    protected AbstractAttack(String aName, int aBaseDamage, int aCost, String aDescriptiveText){
        baseDamage = aBaseDamage;
        name = aName;
        cost = aCost;
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
    public int getCost() {
        return cost;
    }

    /**
     * Checks if this attack is equal to another.
     * @param obj Object to compare this attack.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
                && ((IAttack) obj).getName().equals(name) && ((IAttack) obj).getCost() ==cost
                && ((IAttack) obj).getDescriptiveText() == descriptiveText;
    }


}
