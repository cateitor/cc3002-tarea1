package visitor;

import tcg.IPokemon;
import tcg.trainer.Trainer;

/**
 * Visitor for different Phases of Pokemon
 * @author Catalina Rojas
 */
public class PokemonVisitor extends Visitor {

    @Override
    public void visitBasicPokemon(IPokemon pokemon){
        if(pokemon.getTrainer().getActivePokemon()==null){
            pokemon.getTrainer().setActivePokemon(pokemon);
        }
        else{
            pokemon.getTrainer().addBenchPokemon(pokemon);
        }
        pokemon.getTrainer().getHand().remove(pokemon);
    }

    @Override
    public void visitPhasePokemon(IPokemon pokemon){
        Trainer trainer = pokemon.getTrainer();
        if(trainer.getSelectedPokemon().getId() == pokemon.getPreId()){
            trainer.getDiscardPile().add(trainer.getSelectedPokemon());
            pokemon.setEnergyCounter(trainer.getSelectedPokemon().getEnergies());
            if(trainer.getActivePokemon()==trainer.getSelectedPokemon()){
                trainer.setActivePokemon(pokemon);
            }
            else{
                trainer.getBench().remove(trainer.getSelectedPokemon());
                trainer.getBench().add(pokemon);
            }
        }
    }
}
