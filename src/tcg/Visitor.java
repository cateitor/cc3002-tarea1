package tcg;

import controller.Controller;
import tcg.*;
import tcg.electric.BasicElectricPokemon;
import tcg.electric.ElectricEnergy;
import tcg.electric.PhaseOneElectricPokemon;
import tcg.electric.PhaseTwoElectricPokemon;
import tcg.fighting.BasicFightingPokemon;
import tcg.fighting.FightingEnergy;
import tcg.fighting.PhaseOneFightingPokemon;
import tcg.fighting.PhaseTwoFightingPokemon;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireEnergy;
import tcg.fire.PhaseOneFirePokemon;
import tcg.fire.PhaseTwoFirePokemon;
import tcg.grass.BasicGrassPokemon;
import tcg.grass.GrassEnergy;
import tcg.grass.PhaseOneGrassPokemon;
import tcg.grass.PhaseTwoGrassPokemon;
import tcg.psychic.BasicPsychicPokemon;
import tcg.psychic.PhaseOnePsychicPokemon;
import tcg.psychic.PhaseTwoPsychicPokemon;
import tcg.psychic.PsychicEnergy;
import tcg.trainer.Trainer;
import tcg.trainerCard.objectCard.PotionCard;
import tcg.trainerCard.stadiumCard.LuckyStadium;
import tcg.trainerCard.supportCard.ProfessorCozmosDiscoveryCard;
import tcg.trainerCard.supportCard.ProfessorJuniperCard;
import tcg.water.BasicWaterPokemon;
import tcg.water.PhaseOneWaterPokemon;
import tcg.water.PhaseTwoWaterPokemon;
import tcg.water.WaterEnergy;

/**
 * Visitor Class
 * @author Catalina Rojas
 */
public abstract class Visitor {

    /**
     * Visits a WaterEnergy
     * @param energy the energy visited
     */
    public void visitWaterEnergy(WaterEnergy energy) {
    }

    /**
     * Visits a FireEnergy
     * @param energy the energy visited
     */
    public void visitFireEnergy(FireEnergy energy){
    }

    /**
     * Visits a ElectricEnergy
     * @param electricEnergy the energy visited
     */
    public void visitElectricEnergy(ElectricEnergy electricEnergy){}

    /**
     * Visits a FightingEnergy
     * @param energy the energy visited
     */
    public void visitFightingEnergy(FightingEnergy energy) {
    }

    /**
     * Visits a GrassEnergy
     * @param energy the energy visited
     */
    public void visitGrassEnergy(GrassEnergy energy) {
    }

    /**
     * Visits a PsychicEnergy
     * @param energy the energy visited
     */
    public void visitPsychicEnergy(PsychicEnergy energy) {
    }

    /**
     * Visits a ProfessorJuniperCard
     * @param professorJuniperCard the card visites
     */
    public void visitProfessorJuniperCard(ProfessorJuniperCard professorJuniperCard) {
    }

    /**
     * Visits a PotionCard
     * @param potionCard the card visited
     */
    public void visitPotionCard(PotionCard potionCard) {
    }

    /**
     * Visits a ProfessorCozmoCard
     * @param professorCozmosDiscoveryCard the card visited
     */
    public void visitProfessorCozmoCard(ProfessorCozmosDiscoveryCard professorCozmosDiscoveryCard) {
    }

    /**
     * Visits a StadiumCard
     * @param luckyStadium the stadium
     */
    public void visitLuckyStadiumCard(LuckyStadium luckyStadium) {
    }

    /**
     * visits a basic fighting pokemon
     * @param basicFightingPokemon the visited pokemon
     */
    public void visitBasicFightingPokemon(BasicFightingPokemon basicFightingPokemon) {
    }

    /**
     * visits a phase one electric pokemon
     * @param phaseOneElectricPokemon the visited pokemon
     */
    public void visitPhaseOneElectricPokemon(PhaseOneElectricPokemon phaseOneElectricPokemon) {
    }

    /**
     * visits a basicElectricPokemon
     * @param pokemon the visited pokemon
     */
    public void visitBasicElectricPokemon(BasicElectricPokemon pokemon) {
    }

    /**
     * visits a PhaseTwoElectricPokemon
     * @param phaseTwoElectricPokemon the visitedPokemon
     */
    public void visitPhaseTwoElectricPokemon(PhaseTwoElectricPokemon phaseTwoElectricPokemon) {
    }

    /**
     * visits a PhaseOneFightingPokemon
     * @param phaseOneFightingPokemon the visited pokemon
     */
    public void visitPhaseOneFightingPokemon(PhaseOneFightingPokemon phaseOneFightingPokemon) {
    }

    /**
     * visits a PhaseTwoFightingPokemon
     * @param phaseTwoFightingPokemon the pokemon visited
     */
    public void visitPhaseTwoFightingPokemon(PhaseTwoFightingPokemon phaseTwoFightingPokemon) {
    }

    /**
     * visits a BasicFirePokemon
     * @param basicFirePokemon the pokemon visited
     */
    public void visitBasicFirePokemon(BasicFirePokemon basicFirePokemon) {
    }

    /**
     * visits a PhaseOneFirePokemon
     * @param phaseOneFirePokemon the visited pokemon
     */
    public void visitPhaseOneFirePokemon(PhaseOneFirePokemon phaseOneFirePokemon) {
    }

    /**
     * visits a PhaseTwoFirePokemon
     * @param phaseTwoFirePokemon the visited pokemon
     */
    public void visitPhaseTwoFirePokemon(PhaseTwoFirePokemon phaseTwoFirePokemon) {
    }


    /**
     * visits a BasicGrassPokemon
     * @param basicGrassPokemon the visited pokemon
     */
    public void visitBasicGrassPokemon(BasicGrassPokemon basicGrassPokemon) {
    }

    /**
     * visits a PhaseOneGrassPokemon
     * @param phaseOneGrassPokemon the visited pokemon
     */
    public void visitPhaseOneGrassPokemon(PhaseOneGrassPokemon phaseOneGrassPokemon) {
    }

    /**
     * Visits a PhaseTwoGrassPokemon
     * @param phaseTwoGrassPokemon the visited pokemon
     */
    public void visitPhaseTwoGrassPokemon(PhaseTwoGrassPokemon phaseTwoGrassPokemon) {
    }

    /**
     * Visits a BasisPsychicPokemon
     * @param basicPsychicPokemon the visited pokemon
     */
    public void visitBasicPsychicPokemon(BasicPsychicPokemon basicPsychicPokemon) {
    }

    /**
     * Visits a PhaseOnePsychicPokemon
     * @param phaseOnePsychicPokemon the visited pokemon
     */
    public void visitPhaseOnePsychicPokemon(PhaseOnePsychicPokemon phaseOnePsychicPokemon) {
    }

    /**
     * Visits a PhaseTwoPsychicPokemon
     * @param phaseTwoPsychicPokemon the visited pokemon
     */
    public void visitPhaseTwoPsychicPokemon(PhaseTwoPsychicPokemon phaseTwoPsychicPokemon) {
    }

    /**
     * Visits a BasicWaterPokemon
     * @param basicWaterPokemon the visited pokemon
     */
    public void visitBasicWaterPokemon(BasicWaterPokemon basicWaterPokemon) {
    }

    /**
     * Visits a PhaseOneWaterPokemon
     * @param phaseOneWaterPokemon the visited pokemon
     */
    public void visitPhaseOneWaterPokemon(PhaseOneWaterPokemon phaseOneWaterPokemon) {
    }

    /**
     * Visits a PhaseTwoWaterPokemon
     * @param phaseTwoWaterPokemon the visited pokemon
     */
    public void visitPhaseTwoWaterPokemon(PhaseTwoWaterPokemon phaseTwoWaterPokemon) {
    }
}
