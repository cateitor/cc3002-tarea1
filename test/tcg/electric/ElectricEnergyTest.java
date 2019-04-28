package tcg.electric;

import org.junit.Before;
import org.junit.Test;
import tcg.fire.FireEnergy;
import tcg.IEnergy;

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
}
