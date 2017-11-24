class StepCount
{
    private int step_count;

    public StepCount()
    {
        step_count = 0;
    }

    protected int get_steps()
    {
        return step_count;
    }

    protected void set_steps(int new_steps)
    {
        step_count = new_steps;
    }
}
