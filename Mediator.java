/**
 * @author Tyler Montgomery
 */

public interface Mediator
{
    void update_hr(HeartRate u, Sync sync);
    void update_steps(StepCount s, Sync sync);
}
