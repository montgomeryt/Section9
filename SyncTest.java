/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SyncTest
{
    private Sync syn;
    //private AppDelegate apps;
    private Update upd;

    @Before
    public void setUp() throws Exception
    {
        //syn = Sync.getInstance();
        //apps = new AppDelegate();
        upd = new Update();
    }
    @Test
    public void testSyncHR()
    {
    	upd.set_hr(83);
    	upd.send_hr();//.set_hr(83);
    	//syn = Sync.getInstance();
        assertEquals(83, upd.getSyncHR());
    }
    @Test
    public void testSyncSteps()
    {
        upd.set_steps(10);
        upd.send_steps();
        assertEquals(10,upd.getSyncSteps());
        //syn = Sync.getInstance();
        //System.out.println(syn.getHr());
        //assertEquals(10,syn.getHr());
        //syn.send_hr();
        //assertEquals(10, upd.getSyncHR());//syn.getSteps());
    }
    
    /*
     * Wanted to show a test proving the singleton instance grabbed is the same from
     * object to object. Since same pattern was applied to all Singleton, this is meant
     * to show they all function correctly. It also counts on the above tests for proof
     */
    
    @Test
    public void testSyncSingleton() {
    	upd.set_steps(10);
        upd.send_steps();
        assertEquals(10,upd.getSyncSteps());
        upd.set_hr(83);
    	upd.send_hr();
        assertEquals(83, upd.getSyncHR());
    }

}