class HeartRate
{
    private int heart_rate;

    public HeartRate()
    {
        heart_rate = 0;
    }

    protected int get_hr()
    {
        return heart_rate;
    }

    protected void set_hr(int new_hr)
    {
        heart_rate = new_hr;
    }
}
