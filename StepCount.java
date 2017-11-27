class StepCount
{
    private int stepCount;
    private final int MAXCOUNT = 99999;

    public StepCount()
    {
        stepCount = 0;
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
