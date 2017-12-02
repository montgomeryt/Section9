package com.csci360.healthmonitor.test;
/**
 * Created by Tyler Montgomery
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.csci360.healthmonitor.pepstep.AppDelegate;

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
        apps.setHR(83);
        assertEquals(83, apps.getHR());
    }

    @Test
    public void testSetSteps()
    {
    	//tests set
        apps.setSteps(10);
        assertEquals(10, apps.getSteps());
        
        //and increment
        for(int i=0; i<10; i++) apps.incSteps();
        assertEquals(20, apps.getSteps());
    }
}