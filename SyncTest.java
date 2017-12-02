/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SyncTest
{
    private Sync syn;
    private Update upd;

    @Before
    public void setUp() throws Exception
    {
        upd = new Update();
    }
    @Test
    public void testSyncHR()
    {
    	upd.set_hr(83);
    	upd.send_hr();
        assertEquals(83, upd.getSyncHR());
    }
    @Test
    public void testSyncSteps()
    {
        upd.set_steps(10);
        upd.send_steps();
        assertEquals(10,upd.getSyncSteps());
    }
    
    @Test
    public void testSyncSingleton() {
    	upd.set_steps(10);
        upd.send_steps();
        assertEquals(10,upd.getSyncSteps());
        upd.set_hr(83);
    	upd.send_hr();
        assertEquals(83, upd.getSyncHR());
        
        syn = Sync.getInstance();
        assertEquals(10, syn.getSteps());
        assertEquals(83, syn.getHr());
    }

}