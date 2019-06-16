package visitor;

import tcg.IEnergy;
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
public class EnergyVisitor extends Visitor{

    @Override
    public void visitWaterEnergy(WaterEnergy energy){
        //si no se ha jugado ninguna otra carta de energia
        energy.getTrainer().getSelectedPokemon().addWaterEnergy(energy);
    }

    @Override
    public void visitFireEnergy(FireEnergy energy){
        energy.getTrainer().getSelectedPokemon().addFireEnergy(energy);
    }

    @Override
    public void visitElectricEnergy(ElectricEnergy energy){
        energy.getTrainer().getSelectedPokemon().addElectricEnergy(energy);
    }

    @Override
    public void visitFightingEnergy(FightingEnergy energy){
        energy.getTrainer().getSelectedPokemon().addFightingEnergy(energy);
    }

    @Override
    public void visitGrassEnergy(GrassEnergy energy) {
        energy.getTrainer().getSelectedPokemon().addGrassEnergy(energy);
    }

    @Override
    public void visitPsychicEnergy(PsychicEnergy energy) {
        energy.getTrainer().getSelectedPokemon().addPsychicEnergy(energy);
    }
}
