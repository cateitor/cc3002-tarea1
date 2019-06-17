package tcg;

/**
 * Abstract class of a EnergyCard
 */
public abstract class AbstractEnergyCard extends AbstractCard implements IEnergy{


    @Override
    public void play() {
        EnergyVisitor v = new EnergyVisitor();
        if(!(this.getTrainer().getController().isEnergyCard())){
            this.accept(v);
            this.getTrainer().getController().setEnergyCard(true);
        }
    }


}
