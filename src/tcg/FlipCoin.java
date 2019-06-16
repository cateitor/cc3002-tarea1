package tcg;

/**
 * Class that represents the flip of a coin
 * @author Catalina Rojas
 */
public class FlipCoin {
    public int result;

    /**
     * The FlipCoin constructor
     * if the result if below 0.5 returns 1 (head) else returns 0 (tails)
     */
    public FlipCoin(){
        if(Math.random()<0.5){
            result = 1;
        }
        else{
            result = 0;
        }
    }
}
