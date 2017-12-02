package com.csci360.healthmonitor.pepstep;
/**
 * @author Tyler Montgomery, Dylan Cowden
 * This is the mediator for the mediator pattern to be implemented by SyncMediator
 */

public interface Mediator
{
    void update_hr(int u);
    void update_steps(int s);
    int getHR();
    int getSteps();
}
