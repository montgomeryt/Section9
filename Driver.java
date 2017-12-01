/**
 * @author Tyler Montgomery, Nicholas Foster, Dylan Cowden
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver implements ActionListener
{
	private static Timer timer;
	
    private static JFrame frame = new JFrame("PepStep");
    private static JLabel time = new JLabel();
    private static JLabel hr = new JLabel();
    
    private static JLabel steps = new JLabel();
    private static AppDelegate apps = new AppDelegate();
    //private static Clock clock = new Clock();
    //private static StepCount stepCount = new StepCount();
    
    public void actionPerformed(ActionEvent e)
    {
        //Clock clock = new Clock();
        
        //StopWatch stopWatch = new StopWatch();
        if ("setTime".equals(e.getActionCommand()))
        {
            //Opens Clock UI which allows the time to be updated
        	apps.stopClockTime();//h
            frame.getContentPane().removeAll();
            time.setText("Time: " + apps.clock.getTime());
            //frame.getContentPane().add(apps.clock.createComponents());
            frame.getContentPane().add(apps.clockCreate());
            apps.startClockTime();
        }
        else if ("stopWatch".equals(e.getActionCommand()))
        {
            //Open StopWatch application
            frame.getContentPane().removeAll();
            apps.setupStopWatch();
            //frame.getContentPane().add(apps.stopWatch.createComponents());
            frame.getContentPane().add(apps.stopWatchCreate());
        }
        else if ("resetSteps".equals(e.getActionCommand()))
        {
            //Open StopWatch application
        	apps.resetSteps();
        	steps.setText("Steps Taken: "+apps.getSteps());
        	hr.setText("Heart Rate: " + apps.getHR());
        }
        frame.revalidate();
        frame.repaint();
    }
    private Component createComponents()
    {
        //make buttons
        JButton setTime = new JButton("Set Time");
        setTime.addActionListener(this);
        setTime.setActionCommand("setTime");

        JButton stopWatch = new JButton("Stopwatch");
        stopWatch.addActionListener(this);
        stopWatch.setActionCommand("stopWatch");
        
        JButton resetSteps = new JButton("Reset Steps");
        resetSteps.addActionListener(this);
        resetSteps.setActionCommand("resetSteps");

        //create JPanel, add buttons and labels, and add a border
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(time);
        pane.add(steps);
        pane.add(hr);
        pane.add(setTime);
        pane.add(stopWatch);
        pane.add(resetSteps);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                30, //left
                10, //bottom
                30) //right
        );
        return pane;
    }

    private static void createWindow(JFrame frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(250, 300);
        frame.setLocationRelativeTo(null);
        frame.setLocation((int)((dimension.getWidth() - frame.getWidth()) / 2), (int)(dimension.getHeight() - frame.getHeight()) / 2);
        frame.setVisible(true);
    }

    public static void resetWindow()
    {
        frame.getContentPane().removeAll();
        Driver main = new Driver();
        time.setText("Time: " + apps.clockGetTime());
        //DTC
        steps.setText("Steps Taken: " + apps.getSteps());
        hr.setText("Heart Rate: " + apps.getHR());

        frame.getContentPane().add(main.createComponents());
        frame.revalidate();
        frame.repaint();
    }
    
    public static void runDriver() {
    	apps.clockTimer();
    	createWindow(frame);
        resetWindow();
        
        ActionListener timeAction = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		// for heart rate and step count
        		apps.checkStepsHeartRate();
        		
                Update cmd_update = new Update(apps.getHR(),
                							   apps.getSteps());
                cmd_update.sendInfo();

        		time.setText("Time: " + apps.clockGetTime());
        		steps.setText("Steps Taken: " + apps.getSteps());
        		hr.setText("Heart Rate: " + apps.getHR());
        		frame.revalidate();
        		frame.repaint();
        	}
        };
        
        timer = new Timer(1000, timeAction);
        timer.setInitialDelay(0);
        timer.start();
    }

    public static void main(String[] args)
    {
        runDriver();
    }
}
