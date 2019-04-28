package tcg.fighting;

import org.junit.Before;
import org.junit.Test;
import tcg.IEnergy;
import tcg.water.WaterEnergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FightingEnergyTest {
    private IEnergy fightingEnergy;

    @Before
    public void setUp(){
        fightingEnergy = new FightingEnergy();
    }

    @Test
    public void energyTest(){
        assertEquals(fightingEnergy, new FightingEnergy());
        assertNotEquals(fightingEnergy, new WaterEnergy());

    }
}
