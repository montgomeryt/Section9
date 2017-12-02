package com.csci360.healthmonitor.pepstep;
/**
 * @author Tyler Montgomery, Dylan Cowden
 * 
 * Mediates between Sync and Update. For now it is mostly one-way, but we used this pattern
 * with the idea that we might add more back-and-forth
 */

public class SyncMediator implements Mediator
{
    public int hr;
    public int steps;
    public Sync sync;
    private static SyncMediator instance = null;
    
    /*
     * can't be accessed except by Singleton method
     */
    private SyncMediator() {
    	hr = 0;
    	steps = 0;
    	sync = Sync.getInstance();
    }
    
    /*
     * Singleton method for grabbing a mediator
     */
    public static SyncMediator getInstance() {
    	if (instance == null) instance = new SyncMediator();
    	return instance;
    }

    /*
     * sends hr to update sync
     */
    public void update_hr(int newHR)
    {
        hr = newHR;
        sync.set_hr(hr);

    }

    /*
     * sends new steps to update sync
     */
    public void update_steps(int s)
    {
        steps = s;
        sync.set_steps(steps);
    }

	@Override
	/*
	 * Gets heart rate from sync
	 */
	public int getHR() {
		return sync.getHr();
	}

	@Override
	/*
	 * gets steps from sync
	 */
	public int getSteps() {
		return sync.getSteps();
	}
}
