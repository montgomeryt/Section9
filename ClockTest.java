/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;
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
}
