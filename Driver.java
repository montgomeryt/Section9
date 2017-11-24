import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        boolean running = true;

        Mediator med = new SyncMediator();
        Sync sync = new Sync();
        HeartRate hr = new HeartRate();
        StepCount steps = new StepCount();
        Update cmd_update = new Update(med, sync, hr, steps);

        while(running)
        {
            cmd_update.new_hr(reader.nextInt());
            cmd_update.new_steps(reader.nextInt());
            cmd_update.execute();
            running = false;
        }
    }
}

