package tcg;

import visitor.EnergyVisitor;
import visitor.Visitor;

/**
 * Abstract class of a EnergyCard
 */
public abstract class AbstractEnergyCard extends AbstractCard implements IEnergy{


    @Override
    public void play() {
        EnergyVisitor v = new EnergyVisitor();
        this.accept(v);
    }


}
