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
		clock = Clock.getInstance();
		heartRate = new HeartRate();
		stepCount = StepCount.getInstance();
		syncMed = new SyncMediator();
		stopWatch = StopWatch.getInstance();
	}
	
	/* Final product would have a pedometer	<-----Delete method
	 * Here a step is taken every second
	 */
	//private void pedCommunication() {
	//	int j = clock.getRawTime();
	//	stepCount.setSteps(j);
	//}
}
