package com.csci360.healthmonitor.pepstep;
/**
 * @author Tyler Montgomery, Dylan Cowden
 */

import java.util.Random;

class HeartRate
{
	private static HeartRate instance = null;
	
    private int heart_rate;

    // private since only one instance
    private HeartRate()
    {
        heart_rate = 0;
    }
    public static HeartRate getInstance() {
    	if (instance == null) instance = new HeartRate();
    	return instance;
    }


    public void set_hr_rand()
    {
        Random rand = new Random();
        int x = rand.nextInt(2) + 85;
        set_hr(x);
    }

    public int get_hr()
    {
        return heart_rate;
    }

    public void set_hr(int new_hr)
    {
        heart_rate = new_hr;
    }
}
