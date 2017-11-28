/**
 * @author Dylan Cowden
 * AppDelegate is meant to act as a mediator between the applications and the UI
 */

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
		stepCount.incSteps();
        heartRate.set_hr_rand();
	}
	
}
