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

    private static HeartRate heartRate = new HeartRate();
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
        	apps.clock.stopTime();
            frame.getContentPane().removeAll();
            time.setText("Time: " + apps.clock.getTime());
            frame.getContentPane().add(apps.clock.createComponents());
            apps.clock.startTime();
        }
        else if ("stopWatch".equals(e.getActionCommand()))
        {
            //Open StopWatch application
            frame.getContentPane().removeAll();
            apps.stopWatch.createAndShowGUI();
            frame.getContentPane().add(apps.stopWatch.createComponents());
        }
        else if ("resetSteps".equals(e.getActionCommand()))
        {
            //Open StopWatch application
        	apps.stepCount.resetSteps();
        	steps.setText("Steps Taken: "+apps.stepCount.getSteps());
        	hr.setText("Heart Rate: " + heartRate.get_hr());
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
        time.setText("Time: " + apps.clock.getTime());
        //DTC
        steps.setText("Steps Taken: " + apps.stepCount.getSteps());
        hr.setText("Heart Rate: " + heartRate.get_hr());

        frame.getContentPane().add(main.createComponents());
        frame.revalidate();
        frame.repaint();
    }
    
    public static void runDriver() {
    	apps.clock.createTimer();
    	createWindow(frame);
        resetWindow();
        
        ActionListener timeAction = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
                Update cmd_update = new Update(heartRate, apps.stepCount);
                cmd_update.execute();

        		time.setText("Time: " + apps.clock.getTime());
        		steps.setText("Steps Taken: " + apps.stepCount.getSteps());
        		hr.setText("Heart Rate: " + heartRate.get_hr());
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
