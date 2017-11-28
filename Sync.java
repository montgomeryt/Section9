/**
 * @author Tyler Montgomery
 */

public class Sync extends Colleague
{
	private static Sync instance = null;
	
    private int hr;
    private int steps;

    private Sync() {
    	hr = 0;
    	steps = 0;
    }
    public static Sync getInstance() {
    	if (instance == null) instance = new Sync();
    	return instance;
    }
    public void set_hr(int hr)
    {
        this.hr = hr;
    }

    public void set_steps(int steps)
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

    public int getHr()
    {
        return hr;
    }

    public int getSteps()
    {
        return steps;
    }
}
