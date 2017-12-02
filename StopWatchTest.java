package com.csci360.healthmonitor.test;
/**
 * @author Tyler Montgomery, Nicholas Foster, Dylan Cowden
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.csci360.healthmonitor.pepstep.AppDelegate;
import com.csci360.healthmonitor.pepstep.StopWatch;

public class StopWatchTest {
    private AppDelegate apps;
    private StopWatch sw;

    @Before
    public void setUp() throws Exception
    {
    	apps = new AppDelegate();
        apps.setupStopWatch();
        sw = StopWatch.getInstance();
    }
    
    //lets the stop watch run for a second and makes sure reset works
    @Test
    public void testSW() {
    	assertEquals(0,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	sw.startTimer();
    	try        
    	{
    	    Thread.sleep(1000);
    	} 
    	catch(InterruptedException ex) 
    	{
    	    Thread.currentThread().interrupt();
    	}
    	
    	sw.stopTimer();
    	assertEquals(1,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	// reset should set all to 0
    	sw.reset();
    	assertEquals(0,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    }
    
    // makes sure pause works
    @Test
    public void testSWPause() {
    	System.out.println("Don't worry. Stop watch is just letting some time pass. Should take less than 10 seconds.");
    	
    	assertEquals(0,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	//run one second
    	sw.startTimer();
    	try {Thread.sleep(1000);} 
    	catch(InterruptedException e) {Thread.currentThread().interrupt();}
    	
    	sw.pause();
    	assertEquals(1,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	//wait 2 seconds
    	try {Thread.sleep(2000);} 
    	catch(InterruptedException e) {Thread.currentThread().interrupt();}
    	//see if time changed
    	assertEquals(1,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	//let stopwatch run for 2 more seconds to see if resume works
    	sw.startTimer();
    	try {Thread.sleep(2000);} 
    	catch(InterruptedException e) {Thread.currentThread().interrupt();}
    	sw.pause();
    	
    	//make sure time was added on
    	assertEquals(3,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	sw.reset();
    }
    
    /*
     * Proves that the stepcounter continues to work while in stopwatch
     */
    @Test
    public void testWithSteps() {
    	apps.resetSteps(); 
    	assertEquals(0,apps.getSteps());
    	assertEquals(0,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	//starts time and takes 10 steps
    	sw.startTimer();
    	for (int i = 0; i < 9; i++) apps.incSteps();
    	try        
    	{
    	    Thread.sleep(1000);
    	} 
    	catch(InterruptedException ex) 
    	{
    	    Thread.currentThread().interrupt();
    	}
    	apps.incSteps();
    	
    	sw.stopTimer();
    	assertEquals(10,apps.getSteps());
    	assertEquals(1,sw.getSec());
    	assertEquals(0,sw.getMin());
    	assertEquals(0,sw.getHour());
    	
    	// reset should set all to 0
    	sw.reset();
    }
}