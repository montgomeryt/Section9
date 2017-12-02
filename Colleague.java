package com.csci360.healthmonitor.pepstep;
/**
 * @author Tyler Montgomery
 * Class to be extended by Sync and Update so that they can communicate via the mediator pattern
 */

abstract class Colleague
{
    abstract void send_hr();
    abstract void send_steps();
}
