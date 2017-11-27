/**
 * @author Dylan Cowden
 */

public class AppDelegate {
	private Clock clock;
	private HeartRate heartRate;
	private StepCount stepCount;
	private SyncMediator syncMed;
	
	public AppDelegate() {
		clock = new Clock();
		heartRate = new HeartRate();
		stepCount = new StepCount();
		syncMed = new SyncMediator();
	}
	
	/* Final product would have a pedometer
	 * Here a step is taken every second
	 */
	private void pedCommunication() {
		int j = clock.getRawTime();
		stepCount.setSteps(j);
	}

	public static void main(String args[]) {
		long i = System.currentTimeMillis()/1000/60/60;
		i = i%24;// - (i/24);
		System.out.println(i);
		return;
	}
}
