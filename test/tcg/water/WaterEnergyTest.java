package tcg.water;

import org.junit.Before;
import org.junit.Test;
import tcg.IEnergy;
import tcg.fighting.FightingEnergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WaterEnergyTest {
    private IEnergy waterEnergy;

    @Before
    public void setUp(){
        waterEnergy = new WaterEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(waterEnergy, new WaterEnergy());
        assertNotEquals(waterEnergy, new FightingEnergy());
    }
}
