/**
 * @author Dylan Cowden
 * AppDelegate is meant to act as a mediator between the applications and the UI
 */

import java.awt.Component;

public class AppDelegate {
	public Clock clock;
	public HeartRate heartRate;
	public StepCount stepCount;
	public StopWatch stopWatch;
	
	public AppDelegate() {
		clock = Clock.getInstance();
		heartRate = HeartRate.getInstance();
		stepCount = StepCount.getInstance();
		stopWatch = StopWatch.getInstance();
	}
	
	/* Idea is that final product would have this check the hardware for steps and HR
	 * Here heart rate is random and steps increment every second for demonstration purposes
	 */
	public void checkStepsHeartRate() {
		//stepCount.incSteps();
		incSteps();
        //heartRate.set_hr_rand();
		randHR();
	}
	
	/*
	 * The following few methods are for accessing the Clock
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
	
}
