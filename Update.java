/**
 * @author Tyler Montgomery
 */

public class Update extends Colleague
{
    private Mediator med;
    //new SyncMediator();
    //private Sync syn = Sync.getInstance();
    //private HeartRate hr;
    //private StepCount steps;
    private int hr;
    private int steps;

    public Update() {
    	hr = 0;
    	steps = 0;
    	med = SyncMediator.getInstance();
    }
    public Update(int newHR, int newSteps)
    {
        hr = newHR;
        steps = newSteps;
        med = SyncMediator.getInstance();
    }
    
    public void sendInfo() {
    	send_hr();
    	send_steps();
    }
    
	@Override
	public void send_hr() {
		med.update_hr(hr);
		
	}
	@Override
	public void send_steps() {
		med.update_steps(steps);
		
	}
    
    

   /* public void execute()
    {
        //steps.incSteps();
        //hr.set_hr_rand();

        med.update_steps(steps);
        med.update_hr(hr);

        // Demonstrates that Sync is updating the hr and steps
        //syn.send_hr();
        //syn.send_steps();
    }*/
}
