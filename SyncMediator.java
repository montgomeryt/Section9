/**
 * @author Tyler Montgomery
 */

public class SyncMediator implements Mediator
{
    private int hr;
    private int steps;
    private Sync sync;
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
}
