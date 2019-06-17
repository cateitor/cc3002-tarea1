package tcg;

import tcg.electric.BasicElectricPokemon;
import tcg.electric.PhaseOneElectricPokemon;
import tcg.electric.PhaseTwoElectricPokemon;
import tcg.fighting.BasicFightingPokemon;
import tcg.fighting.PhaseOneFightingPokemon;
import tcg.fighting.PhaseTwoFightingPokemon;
import tcg.fire.BasicFirePokemon;
import tcg.fire.PhaseOneFirePokemon;
import tcg.fire.PhaseTwoFirePokemon;
import tcg.grass.BasicGrassPokemon;
import tcg.grass.PhaseOneGrassPokemon;
import tcg.grass.PhaseTwoGrassPokemon;
import tcg.psychic.BasicPsychicPokemon;
import tcg.psychic.PhaseOnePsychicPokemon;
import tcg.psychic.PhaseTwoPsychicPokemon;
import tcg.trainer.Trainer;
import tcg.water.BasicWaterPokemon;
import tcg.water.PhaseOneWaterPokemon;
import tcg.water.PhaseTwoWaterPokemon;

/**
 * Visitor for different Phases of Pokemon
 * @author Catalina Rojas
 */
public class PokemonVisitor extends Visitor {


    public void visitBasicPokemon(IPokemon pokemon){
        if(!pokemon.getTrainer().isActivePokemon()){
            pokemon.getTrainer().setActivePokemon(pokemon);
        }
        else{
            pokemon.getTrainer().addBenchPokemon(pokemon);
        }
        pokemon.getTrainer().getHand().remove(pokemon);
    }


    public void visitPhasePokemon(IPokemon pokemon){
        Trainer trainer = pokemon.getTrainer();
        int index = trainer.getBench().indexOf(trainer.getSelectedPokemon());
        if(trainer.getSelectedPokemon().getId() == pokemon.getPreId()){
            trainer.getDiscardPile().add(trainer.getSelectedPokemon());
            pokemon.setEnergyCounter(trainer.getSelectedPokemon().getEnergies());
            if(trainer.getActivePokemon()==trainer.getSelectedPokemon()){
                trainer.setActivePokemon(pokemon);
            }
            else{
                trainer.getBench().set(index,pokemon);
            }
        }
        pokemon.getTrainer().getHand().remove(pokemon);
    }

    @Override
    public void visitBasicFightingPokemon(BasicFightingPokemon pokemon){
        this.visitBasicPokemon(pokemon);
    }

    @Override
    public void visitPhaseOneElectricPokemon(PhaseOneElectricPokemon phaseOneElectricPokemon) {
        this.visitPhasePokemon(phaseOneElectricPokemon);
    }

    @Override
    public void visitBasicElectricPokemon(BasicElectricPokemon pokemon) {
        this.visitBasicPokemon(pokemon);
    }

    @Override
    public void visitPhaseTwoElectricPokemon(PhaseTwoElectricPokemon phaseTwoElectricPokemon) {
        this.visitPhasePokemon(phaseTwoElectricPokemon);
    }

    @Override
    public void visitPhaseOneFightingPokemon(PhaseOneFightingPokemon phaseOneFightingPokemon) {
        this.visitPhasePokemon(phaseOneFightingPokemon);
    }

    @Override
    public void visitPhaseTwoFightingPokemon(PhaseTwoFightingPokemon phaseTwoFightingPokemon) {
        this.visitPhasePokemon(phaseTwoFightingPokemon);
    }

    @Override
    public void visitBasicFirePokemon(BasicFirePokemon basicFirePokemon) {
        this.visitBasicPokemon(basicFirePokemon);
    }

    @Override
    public void visitPhaseOneFirePokemon(PhaseOneFirePokemon phaseOneFirePokemon) {
        this.visitPhasePokemon(phaseOneFirePokemon);
    }

    @Override
    public void visitPhaseTwoFirePokemon(PhaseTwoFirePokemon phaseTwoFirePokemon) {
        this.visitPhasePokemon(phaseTwoFirePokemon);
    }

    @Override
    public void visitBasicGrassPokemon(BasicGrassPokemon basicGrassPokemon) {
        this.visitBasicPokemon(basicGrassPokemon);
    }

    @Override
    public void visitPhaseOneGrassPokemon(PhaseOneGrassPokemon phaseOneGrassPokemon) {
        this.visitPhasePokemon(phaseOneGrassPokemon);
    }

    @Override
    public void visitPhaseTwoGrassPokemon(PhaseTwoGrassPokemon phaseTwoGrassPokemon) {
        this.visitPhasePokemon(phaseTwoGrassPokemon);
    }

    @Override
    public void visitBasicPsychicPokemon(BasicPsychicPokemon basicPsychicPokemon) {
        this.visitBasicPokemon(basicPsychicPokemon);
    }

    @Override
    public void visitPhaseOnePsychicPokemon(PhaseOnePsychicPokemon phaseOnePsychicPokemon) {
        this.visitPhasePokemon(phaseOnePsychicPokemon);
    }

    @Override
    public void visitPhaseTwoPsychicPokemon(PhaseTwoPsychicPokemon phaseTwoPsychicPokemon) {
        this.visitPhasePokemon(phaseTwoPsychicPokemon);
    }

    @Override
    public void visitBasicWaterPokemon(BasicWaterPokemon basicWaterPokemon) {
        visitBasicPokemon(basicWaterPokemon);
    }

    @Override
    public void visitPhaseOneWaterPokemon(PhaseOneWaterPokemon phaseOneWaterPokemon) {
        this.visitPhasePokemon(phaseOneWaterPokemon);
    }

    public void visitPhaseTwoWaterPokemon(PhaseTwoWaterPokemon phaseTwoWaterPokemon) {
        this.visitPhasePokemon(phaseTwoWaterPokemon);
    }
}
