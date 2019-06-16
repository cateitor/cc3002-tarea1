package visitor;

import controller.Controller;
import tcg.*;
import tcg.electric.ElectricEnergy;
import tcg.fighting.FightingEnergy;
import tcg.fire.FireEnergy;
import tcg.grass.GrassEnergy;
import tcg.psychic.PsychicEnergy;
import tcg.trainer.Trainer;
import tcg.trainerCard.objectCard.PotionCard;
import tcg.trainerCard.stadiumCard.LuckyStadium;
import tcg.trainerCard.supportCard.ProfessorCozmosDiscoveryCard;
import tcg.trainerCard.supportCard.ProfessorJuniperCard;
import tcg.water.WaterEnergy;

/**
 * Visitor Class
 * @author Catalina Rojas
 */
public abstract class Visitor {

    /**
     * Visits a Trainer
     * @param trainer the trainer visited
     */
    public void visitTrainer(Trainer trainer){}

    /**
     * Visits the Controller
     * @param controller the controller
     */
    public void visitController(Controller controller) {}

    /**
     * Visits a BasicPokemon
     * @param pokemon the pokemon visited
     */
    public void visitBasicPokemon(IPokemon pokemon){}

    /**
     * Visits a PhasePokemon (one or two)
     * @param pokemon the pokemon visited
     */
    public void visitPhasePokemon(IPokemon pokemon) {
    }

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
     * @param luckyStadium
     */
    public void visitLuckyStadiumCard(LuckyStadium luckyStadium) {
    }
}
