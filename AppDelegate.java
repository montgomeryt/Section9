/**
 * @author Dylan Cowden
 */

public class AppDelegate {
	Clock clock;
	HeartRate heartRate;
	StepCount stepCount;
	SyncMediator syncMed;
	StopWatch stopWatch;
	
	public AppDelegate() {
		clock = new Clock();
		heartRate = new HeartRate();
		stepCount = new StepCount();
		syncMed = new SyncMediator();
		stopWatch = new StopWatch();
	}
	
	/* Final product would have a pedometer	<-----Delete method
	 * Here a step is taken every second
	 */
	private void pedCommunication() {
		int j = clock.getRawTime();
		stepCount.setSteps(j);
	}
}
