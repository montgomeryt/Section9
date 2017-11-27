/**
 * @author Tyler Montgomery
 */

public class SyncMediator implements Mediator
{
    private int hr;
    private int steps;

    public void update_hr(HeartRate hr, Sync sync)
    {
        this.hr = hr.get_hr();
        sync.set_hr(this.hr);

    }

    public void update_steps(StepCount s, Sync sync)
    {
        this.steps = s.getSteps();
        sync.set_steps(this.steps);
    }
}
