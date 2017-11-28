/**
 * @author Dylan Cowden
 * AppDelegate is meant to act as a mediator between the applications and the UI
 */

public class AppDelegate {
	Clock clock;
	HeartRate heartRate;
	StepCount stepCount;
	StopWatch stopWatch;
	//SyncMediator syncMed;
	
	public AppDelegate() {
		clock = Clock.getInstance();
		heartRate = HeartRate.getInstance();
		stepCount = StepCount.getInstance();
		stopWatch = StopWatch.getInstance();
		//syncMed = new SyncMediator();
	}
}
