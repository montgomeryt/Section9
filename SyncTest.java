/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SyncTest
{
    private Sync syn;
    private AppDelegate apps;
    private Update upd;

    @Before
    public void setUp() throws Exception
    {
        syn = new Sync();
        apps = new AppDelegate();
        upd = new Update();
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

    @Test
    public void testSyncSteps()
    {
        syn.set_hr(83);
        assertEquals(83, syn.getHr());
    }
    @Test
    public void testSyncHr()
    {
        syn.set_steps(10);
        assertEquals(10, syn.getSteps());
    }

}