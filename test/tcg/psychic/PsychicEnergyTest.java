package tcg.psychic;

import org.junit.Before;
import org.junit.Test;
import tcg.electric.ElectricEnergy;
import tcg.IEnergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PsychicEnergyTest {
    private IEnergy psychicEnergy;

    @Before
    public void setUp(){
        psychicEnergy = new PsychicEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(psychicEnergy,new PsychicEnergy());
        assertNotEquals(psychicEnergy, new ElectricEnergy());
    }
}
