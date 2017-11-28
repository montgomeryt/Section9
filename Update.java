/**
 * @author Tyler Montgomery
 */

public class Update implements Command
{
    private Mediator med = new SyncMediator();
    private Sync syn = new Sync();
    private HeartRate hr;
    private StepCount steps;

    public Update(HeartRate hr, StepCount steps)
    {
        this.hr = hr;
        this.steps = steps;
    }

    /*
     * In the final product it would communicate with the hardware for step count and
     * heart rate. Here heart rate is random for now and steps increment every second
     */
    public void execute()
    {
        steps.incSteps();
        hr.set_hr_rand();

        med.update_steps(steps, syn);
        med.update_hr(hr, syn);

        // Demonstrates that Sync is updating the hr and steps
        //syn.send_hr();
        //syn.send_steps();
    }
}
