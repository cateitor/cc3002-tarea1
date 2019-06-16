package tcg;

import tcg.electric.BasicElectricPokemon;
import tcg.electric.ElectricAttack;
import tcg.electric.ElectricEnergy;
import tcg.fighting.FightingEnergy;
import tcg.fire.FireEnergy;
import tcg.grass.GrassEnergy;
import tcg.psychic.PsychicEnergy;
import tcg.water.WaterEnergy;

import java.util.ArrayList;

/**
 * Class to create a Deck, used in Test classes.
 */
public class DeckForTest {
    private ArrayList<ICard> deck;

    /**
     * The constructor of the deck.
     */
    public void DeckForTest(){
        ElectricAttack electricAttack = new ElectricAttack("Thunder",20,1,"The pokémon could be paralized!");
        //BasicElectricPokemon mareep = new BasicElectricPokemon(179,"60",new EnergyCounter(),)

        for(int i=0;i<2;i++){
            deck.add(new FireEnergy());
            deck.add(new WaterEnergy());
            deck.add(new ElectricEnergy());
            deck.add(new FightingEnergy());
            deck.add(new GrassEnergy());
            deck.add(new PsychicEnergy());
        }

    }
     public ArrayList<ICard> getDeck(){
        return deck;
     }

}
