package tcg.grass;

import org.junit.Before;
import org.junit.Test;
import tcg.IEnergy;
import tcg.psychic.PsychicEnergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GrassEnergyTest {
    private IEnergy grassEnergy;

    @Before
    public void setUp(){
        grassEnergy = new GrassEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(grassEnergy, new GrassEnergy());
        assertNotEquals(grassEnergy, new PsychicEnergy());
    }
}
