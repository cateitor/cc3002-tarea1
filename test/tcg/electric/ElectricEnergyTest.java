package tcg.electric;

import org.junit.Before;
import org.junit.Test;
import tcg.*;
import tcg.fire.BasicFirePokemon;
import tcg.fire.FireAttack;
import tcg.fire.FireEnergy;
import tcg.trainer.Trainer;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ElectricEnergyTest {
    private IEnergy electricEnergy;
    private IEnergy fireEnergy;

    @Before
    public void setUp(){
        electricEnergy = new ElectricEnergy();
        fireEnergy = new FireEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(electricEnergy, new ElectricEnergy());
        assertNotEquals(fireEnergy,electricEnergy);
    }

    @Test
    public void addEnergy(){
        Trainer t = new Trainer();
        FireAttack fireAttack = new FireAttack("Ember", 30, 1, "Discard a Fire Energy attached to Pokemon");
        BasicFirePokemon charmander = new BasicFirePokemon(4,70, new EnergyCounter(), new ArrayList<IAbility>(Arrays.asList(fireAttack)));
        t.setActivePokemon(charmander);
        t.setSelectedPokemon(6);
        assertEquals(charmander,t.getSelectedPokemon());
        ArrayList<ICard> hand = new ArrayList<ICard>();
        hand.add(new FireEnergy());
        t.setHand(hand);
        t.play(0);
        EnergyCounter e = new EnergyCounter();
        e.setFireEnergy(1);
        assertEquals(e.getEnergies(),charmander.getEnergies().getEnergies());
    }
}
