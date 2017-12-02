package com.csci360.healthmonitor.pepstep;
/**
 * @author Tyler Montgomery, Nicholas Foster, Dylan Cowden
 * is a colleague that communicates with Sync
 */

public class Update extends Colleague
{
    private static Update instance = null;
    private Mediator med;
    private int hr;
    private int steps;

    private Update() {
    	hr = 0;
    	steps = 0;
    	med = SyncMediator.getInstance();
    }
    
    //Singleton
    public static Update getInstance() {
    	if(instance == null) instance = new Update();
    	return instance;
    }
    
    //sends both heart rate and steps to Sync thru mediator
    public void sendInfo() {
    	send_hr();
    	send_steps();
    }
    
    public void set_info(int h, int s) {
    	set_hr(h);
    	set_steps(s);
    }
    
	@Override
	public void send_hr() {
		med.update_hr(hr);
		
	}
	@Override
	public void send_steps() {
		med.update_steps(steps);
		
	}
    
    public void set_hr(int h) {
    	hr = h;
    }
    
    public void set_steps(int s) {
    	steps = s;
    }
    
    public int getSyncSteps() {
    	return med.getSteps();
    }
    
    public int getSyncHR() {
    	return med.getHR();
    }
}
