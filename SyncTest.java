package com.csci360.healthmonitor.test;
/**
 * @author Tyler Montgomery, Nicholas Foster, Dylan Cowden
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.csci360.healthmonitor.pepstep.Sync;
import com.csci360.healthmonitor.pepstep.Update;

public class SyncTest
{
    private Sync syn;
    private Update upd;

    @Before
    public void setUp() throws Exception
    {
        upd = Update.getInstance();
    }
    
    /*
     * Test to see if sync receives updates thru the Update object
     */
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
    
    /*
     * This is a test to make sure the Singleton pattern was correctly implemented.
     * Should mean grabbing an instance of sync after update has sent info thru mediator
     * results in having the only sync object
     */
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