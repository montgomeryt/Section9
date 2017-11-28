/**
 * @author Tyler Montgomery
 */

public class Update implements Command
{
    private Mediator med = SyncMediator.getInstance();
    //new SyncMediator();
    //private Sync syn = Sync.getInstance();
    //private HeartRate hr;
    //private StepCount steps;
    private int hr;
    private int steps;

    public Update(int newHR, int newSteps)
    {
        hr = newHR;
        steps = newSteps;
    }

    public void execute()
    {
        //steps.incSteps();
        //hr.set_hr_rand();

        med.update_steps(steps);
        med.update_hr(hr);

        // Demonstrates that Sync is updating the hr and steps
        //syn.send_hr();
        //syn.send_steps();
    }
}
