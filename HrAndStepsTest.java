/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HrAndStepsTest
{
    private AppDelegate apps;

    @Before
    public void setUp() throws Exception
    {
        apps = new AppDelegate();
    }

    @Test
    public void testSetHR()
    {
        apps.heartRate.set_hr(83);
        assertEquals(83, apps.heartRate.get_hr());
    }

    @Test
    public void testSetSteps()
    {
        apps.stepCount.setSteps(10);
        assertEquals(10, apps.stepCount.getSteps());
    }
}