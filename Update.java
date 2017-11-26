public class Update implements Command
{
    private Mediator med;
    private Sync syn;
    private HeartRate hr;
    private StepCount steps;

    public Update(Mediator med, Sync syn, HeartRate hr, StepCount steps)
    {
        this.med = med;
        this.syn = syn;
        this.hr = hr;
        this.steps = steps;
    }

    public void execute()
    {
        med.update_hr(hr, syn);
        med.update_steps(steps, syn);
        syn.send_hr();
        syn.send_steps();
    }

    protected void new_hr(int hr)
    {
        this.hr.set_hr(hr);
    }

    protected void new_steps(int steps)
    {
        this.steps.setSteps(steps);
    }
}
