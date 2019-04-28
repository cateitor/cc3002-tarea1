package tcg.fire;

import org.junit.Before;
import org.junit.Test;
import tcg.IEnergy;
import tcg.grass.GrassEnergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FireEnergyTest {
    private IEnergy fireEnergy;

    @Before
    public void setUp(){
        fireEnergy = new FireEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(fireEnergy, new FireEnergy());
        assertNotEquals(fireEnergy, new GrassEnergy());
    }
}
