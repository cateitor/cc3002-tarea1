package tcg;

import tcg.electric.ElectricEnergy;
import tcg.fighting.FightingEnergy;
import tcg.fire.FireEnergy;
import tcg.grass.GrassEnergy;
import tcg.psychic.PsychicEnergy;
import tcg.water.WaterEnergy;

/**
 * Visitor for different types of EnergyCards
 * @author Catalina Rojas
 */
public class EnergyVisitor extends Visitor {

    @Override
    public void visitWaterEnergy(WaterEnergy energy){
        energy.getTrainer().getSelectedPokemon().addWaterEnergy(energy);
    }

    @Override
    public void visitFireEnergy(FireEnergy energy){
        energy.getTrainer().getSelectedPokemon().addFireEnergy(energy);
    }

    @Override
    public void visitElectricEnergy(ElectricEnergy energy){
        energy.getTrainer().getSelectedPokemon().addElectricEnergy(energy);
        energy.getTrainer().getHand().remove(energy);
    }

    @Override
    public void visitFightingEnergy(FightingEnergy energy){
        energy.getTrainer().getSelectedPokemon().addFightingEnergy(energy);
        energy.getTrainer().getHand().remove(energy);
    }

    @Override
    public void visitGrassEnergy(GrassEnergy energy) {
        energy.getTrainer().getSelectedPokemon().addGrassEnergy(energy);
        energy.getTrainer().getHand().remove(energy);
    }

    @Override
    public void visitPsychicEnergy(PsychicEnergy energy) {
        energy.getTrainer().getSelectedPokemon().addPsychicEnergy(energy);
        energy.getTrainer().getHand().remove(energy);
    }
}
