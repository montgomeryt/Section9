package com.csci360.healthmonitor.pepstep;
/**
 * @author Tyler Montgomery, Dylan Cowden
 * This would be where we added a way for communication with external device. 
 * Is colleague of Update and is mediated by SyncMediator
 */

public class Sync extends Colleague
{
	private static Sync instance = null;
	
    private int hr;
    private int steps;

    //should be singleton. testing
    private Sync() {
    	hr = 0;
    	steps = 0;
    }
    public static Sync getInstance() {
    	if (instance == null) instance = new Sync();
    	return instance;
    }
    public void set_hr(int hr)
    {
        this.hr = hr;
    }

    public void set_steps(int steps)
    {
        this.steps = steps;
    }

    // Would be to device
    public void send_hr()
    {
        System.out.println(hr);
    }

    //Meant to be sent to device
    public void send_steps()
    {
        System.out.println(steps);
    }

    public int getHr()
    {
        return hr;
    }

    public int getSteps()
    {
        return steps;
    }
}
