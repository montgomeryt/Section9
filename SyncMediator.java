/**
 * @author Tyler Montgomery
 */

public class SyncMediator implements Mediator
{
    public int hr;
    public int steps;
    //private junit purpose
    public Sync sync;
    private static SyncMediator instance = null;
    
    private SyncMediator() {
    	hr = 0;
    	steps = 0;
    	sync = Sync.getInstance();
    }
    
    public static SyncMediator getInstance() {
    	if (instance == null) instance = new SyncMediator();
    	return instance;
    }

    public void update_hr(int newHR)
    {
        hr = newHR;
        sync.set_hr(hr);

    }

    public void update_steps(int s)
    {
        steps = s;
        sync.set_steps(steps);
    }

	@Override
	/*
	 * Gets heart rate from sync
	 */
	public int getHR() {
		return sync.getHr();//hr;
	}

	@Override
	public int getSteps() {
		return sync.getSteps();//steps;
	}
}
