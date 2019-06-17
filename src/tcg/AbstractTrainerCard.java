package tcg;

/**
 * Abstract class for the TrainerCard
 * When played, this card alters the game stats.
 * @author Catalina Rojas
 */
public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {
    String name;
    String descriptiveText;

    /**
     * Constructor of the TrainerCard
     * @param name the name of the card
     * @param descriptiveText the descriptive text of the card
     */
    public AbstractTrainerCard(String name, String descriptiveText){
        this.name=name;
        this.descriptiveText=descriptiveText;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDescriptiveText(){
        return descriptiveText;
    }

    @Override
    public void play(){
        TrainerCardVisitor visitor = new TrainerCardVisitor();
        this.accept(visitor);
    }

}
