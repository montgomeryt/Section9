/**
 * @author Dylan Cowden
 */

class StepCount
{
	//for Singleton
	private static StepCount instance = null;
	
	private int stepCount;
    private final int MAXCOUNT = 99999;

    private StepCount()
    {
        stepCount = 0;
    }
    /*
     * Only one instance of StepCount is ever needed so we use the Singleton pattern
     */
    public static StepCount getInstance() {
    	if(instance == null) instance = new StepCount();
    	return instance;
    }
    

    protected int getSteps()
    {
        return stepCount;
    }

    
    protected void setSteps(int new_steps)
    {
        stepCount = new_steps;
        if (stepCount > MAXCOUNT) stepCount = stepCount % MAXCOUNT;
        else if (stepCount < 0) stepCount = 0;
    }
    
    public void resetSteps() {
    	setSteps(0);
    }
    
    public void incSteps() {
    	setSteps(stepCount+1);
    }
}
