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
        //syn = Sync.getInstance();
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
    	upd.set_hr(83);
    	upd.send_hr();//.set_hr(83);
    	syn = Sync.getInstance();
        assertEquals(83, upd.med.get_s());
    }
    @Test
    public void testSyncHr()
    {
        upd.set_steps(10);
        upd.send_steps();
        //syn = Sync.getInstance();
        assertEquals(10, upd.med.get_hr());//syn.getSteps());
    }

}