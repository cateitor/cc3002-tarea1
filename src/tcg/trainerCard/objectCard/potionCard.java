package tcg.trainerCard.objectCard;

import tcg.ITrainerCard;
import tcg.Trainer;

public class potionCard implements ITrainerCard {

    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().setDamage(trainer.getActivePokemon().getDamage()-30);
    }
}
