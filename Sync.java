public class Sync extends Colleague
{
    private int hr;
    private int steps;

    protected void set_hr(int hr)
    {
        this.hr = hr;
    }

    protected void set_steps(int steps)
    {
        this.steps = steps;
    }

    public void send_hr()
    {
        System.out.println(hr);
    }

    public void send_steps()
    {
        System.out.println(steps);
    }
}
