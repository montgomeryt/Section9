class StepCount
{
    private int step_count;

    public StepCount()
    {
        step_count = 0;
    }

    protected int getSteps()
    {
        return step_count;
    }

    protected void setSteps(int new_steps)
    {
        step_count = new_steps;
    }
}
