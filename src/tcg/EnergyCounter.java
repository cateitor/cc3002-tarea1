package tcg;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class for the EnergyCounter.
 * @author Catalina Rojas
 */
public class EnergyCounter {
    Map<EnergyType, Integer> energies = new EnumMap<>(EnergyType.class);

    /**
     * Constructor for the EnergyCounter
     */
    public EnergyCounter() {
        for (EnergyType type : EnergyType.values()) {
            energies.put(type, 0);
        }
    }

    /**
     * Sets the number of GrassEnergy
     * @param value the number of GrassEnergy to be added.
     */
    public void setGrassEnergy(int value) {
        energies.put(EnergyType.GRASS, value);
    }

    /**
     * Gets the number of GrassEnergy
     * @return number of GrassEnergy
     */
    public int getGrassEnergy() {
        return energies.get(EnergyType.GRASS);
    }

    /**
     * Sets the number of ElectricEnergy
     * @param value the number of ElectricEnergy to be added.
     */
    public void setElectricEnergy(int value) {
        energies.put(EnergyType.ELECTRIC, value);
    }
    /**
     * Gets the number of ElectricEnergy
     * @return number of ElectricEnergy
     */
    public int getElectricEnergy() {
        return energies.get(EnergyType.ELECTRIC);
    }

    /**
     * Sets the number of FightingEnergy
     * @param value the number of FightingEnergy to be added.
     */
    public void setFightingEnergy(int value) {
        energies.put(EnergyType.FIGHTING, value);
    }

    /**
     * Gets the number of FightingEnergy
     * @return number of FightingEnergy
     */
    public int getFightingEnergy() {
        return energies.get(EnergyType.FIGHTING);
    }

    /**
     * Sets the number of FireEnergy
     * @param value the number of FireEnergy to be added.
     */
    public void setFireEnergy(int value) {
        energies.put(EnergyType.FIRE, value);
    }

    /**
     * Gets the number of FireEnergy
     * @return number of FireEnergy
     */
    public int getFireEnergy() {
        return energies.get(EnergyType.FIRE);
    }

    /**
     * Sets the number of PsychicEnergy
     * @param value the number of PsychicEnergy to be added.
     */
    public void setPsychicEnergy(int value) {
        energies.put(EnergyType.PSYCHIC, value);
    }


    /**
     * Gets the number of PsychicEnergy
     * @return number of PsychicEnergy
     */
    public int getPsychicEnergy() {
        return energies.get(EnergyType.PSYCHIC);
    }

    /**
     * Sets the number of WaterEnergy
     * @param value the number of WaterEnergy to be added.
     */
    public void setWaterEnergy(int value) {
        energies.put(EnergyType.WATER, value);
    }

    /**
     * Gets the number of WaterEnergy
     * @return number of WaterEnergy
     */
    public int getWaterEnergy() {
        return energies.get(EnergyType.WATER);
    }

    /**
     * Sees if the amount of energies is greater than the other
     * @param other the other EnergyCounter
     * @return
     */
    public boolean greaterThan(EnergyCounter other) {
        for (EnergyType type : EnergyType.values()) {
            if (energies.get(type) < other.energies.get(type)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the amount of energies
     * @return energies
     */
    public Map<EnergyType,Integer> getEnergies(){
        return energies;
    }

    /**
     * checks if a EnergyCounter equals another
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        return obj instanceof EnergyCounter && ((EnergyCounter) obj).energies == energies;
    }
}
