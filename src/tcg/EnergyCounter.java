package tcg;

import java.util.EnumMap;
import java.util.Map;

public class EnergyCounter {
    Map<EnergyType, Integer> energies = new EnumMap<>(EnergyType.class);

    public EnergyCounter() {
        for (EnergyType type : EnergyType.values()) {
            energies.put(type, 0);
        }
    }

    //GRASS
    public void setGrassEnergy(int value) {
        energies.put(EnergyType.GRASS, value);
    }

    public int getGrassEnergy() {
        return energies.get(EnergyType.GRASS);
    }

    //ELECTRIC
    public void setElectricEnergy(int value) {
        energies.put(EnergyType.ELECTRIC, value);
    }

    public int getElectricEnergy() {
        return energies.get(EnergyType.ELECTRIC);
    }

    //FIGHTING
    public void setFightingEnergy(int value) {
        energies.put(EnergyType.FIGHTING, value);
    }

    public int getFightingEnergy() {
        return energies.get(EnergyType.FIGHTING);
    }

    //FIRE
    public void setFireEnergy(int value) {
        energies.put(EnergyType.FIRE, value);
    }

    public int getFireEnergy() {
        return energies.get(EnergyType.FIRE);
    }

    //PSYCHIC
    public void setPsychicEnergy(int value) {
        energies.put(EnergyType.PSYCHIC, value);
    }

    public int getPsychicEnergy() {
        return energies.get(EnergyType.PSYCHIC);
    }

    //WATER
    public void setWaterEnergy(int value) {
        energies.put(EnergyType.WATER, value);
    }

    public int getWaterEnergy() {
        return energies.get(EnergyType.WATER);
    }

    public boolean greaterThan(EnergyCounter other) {
        for (EnergyType type : EnergyType.values()) {
            if (energies.get(type) < other.energies.get(type)) {
                return false;
            }
        }
        return true;
    }
}
