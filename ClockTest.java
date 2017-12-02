/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class ClockTest
{
    private Clock clk;

    @Before
    public void setUp() throws Exception
    {
        clk = Clock.getInstance();
    }

    @Test
    public void testCreateTimer()
    {
        clk.createTimer();
        assertEquals("00:00:00", clk.getTime());
    }
    
    
    /*
     * Setting clock is within action listeners and commands are as follows:
     * am - add minute
     * sm - subtract minute
     * ah - add hour
     * sh - subtract hour
     * enter - submit time
     */
    @Test
    public void clockSetTime() {
    	clk.createTimer();
    	
    	ActionEvent am = new ActionEvent(new Object(), 0, "am");
    	ActionEvent sm = new ActionEvent(new Object(), 0, "sm");
    	ActionEvent ah = new ActionEvent(new Object(), 0, "ah");
    	ActionEvent sh = new ActionEvent(new Object(), 0, "sh");
    	ActionEvent e = new ActionEvent(new Object(), 0, "enter");
    	
    	clk.actionPerformed(am);
    	clk.actionPerformed(e);
    	assertEquals("00:01:00", clk.getTime());
    }
}
