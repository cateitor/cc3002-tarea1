package tcg;

/**
 * Interface that defines what class is visitable if it is implemented.
 */
public interface Visitable {

    /**
     * Accepts a type of visitor
     * @param visitor the visitor accepted
     */
    public void accept(Visitor visitor);

}
