/**
 * @author Tyler Montgomery
 */

import java.util.Random;

class HeartRate
{
    private static int heart_rate;

    public HeartRate()
    {
        heart_rate = 0;
    }


    protected void set_hr_rand()
    {
        Random rand = new Random();
        int x = rand.nextInt(2) + 85;
        set_hr(x);
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
