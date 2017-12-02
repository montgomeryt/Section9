package com.csci360.healthmonitor.pepstep;
/**
 * @author Dylan Cowden
 * AppDelegate is meant to act as a mediator between the applications and the UI
 */

import java.awt.Component;
/*
 * App Delegate is meant to decrease all the coupling into the Driver by creating the app
 * instances and providing access to their data
 */
public class AppDelegate {
	private Clock clock;
	private HeartRate heartRate;
	private StepCount stepCount;
	private StopWatch stopWatch;
	private Update update;
	
	public AppDelegate() {
		clock = Clock.getInstance();
		heartRate = HeartRate.getInstance();
		stepCount = StepCount.getInstance();
		stopWatch = StopWatch.getInstance();
		update = Update.getInstance();
	}
	
	/* Idea is that final product would have this check the hardware for steps and HR
	 * Here heart rate is random and steps increment every second for demonstration purposes
	 */
	public void checkStepsHeartRate() {
		incSteps();
		randHR();
	}
	
	/*
	 * The following few methods are for accessing the Clock. 
	 * All should be self explanatory. Just meant so all apps can be accessed 
	 * thru one source
	 */
	public void stopClockTime() {
		clock.stopTime();
	}
	
	public void startClockTime() {
		clock.startTime();
	}
	
	public void clockTimer() {
		clock.createTimer();
	}
	
	public String clockGetTime() {
		return clock.getTime();
	}
	
	public Component clockCreate() {
		return clock.createComponents();
	}
	
	/*
	 * StopWatch
	 */
	
	public void setupStopWatch() {
		stopWatch.createAndShowGUI();
	}
	
	public Component stopWatchCreate() {
		return stopWatch.createComponents();
	}
	
	/*
	 * StepCount
	 */
	
	public void resetSteps() {
		stepCount.resetSteps();
	}
	
	public int getSteps() {
		return stepCount.getSteps();
	}
	
	public int setSteps(int s) {
		stepCount.setSteps(s);
		return stepCount.getSteps();
	}
	
	public int incSteps() {
		stepCount.incSteps();
		return stepCount.getSteps();
	}
	
	/*
	 * heartRate
	 */
	
	public int getHR() {
		return heartRate.get_hr();
	}
	
	public int randHR() {
		heartRate.set_hr_rand();
		return getHR();
	}
	
	public int setHR(int h) {
		heartRate.set_hr(h);
		return getHR();
	}
	
	/*
	 * Update object
	 */
	
	// no args since all needed info is in appDelegate
	public void updateInfo() {
		updateInfo(getHR(), getSteps());
	}
	public void updateInfo(int h, int s) {
		update.set_info(h, s);
		update.sendInfo();
	}
}
