package tcg;

public abstract class AbstractEnergy implements IEnergy{
    @Override
    public void isPlayed(Trainer trainer) {
        trainer.getActivePokemon().addEnergy(this);
        trainer.getHand().remove(this);
    }
}
