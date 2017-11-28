/**
 * @author Nicholas Foster
 * @modified Tyler Montgomery, Dylan Cowden
 *
 * Clock class
 * Keeps track of time and displays it on the HomeScreen
 * Contains UI which allows the user to update the time
 */
//package PepStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock implements ActionListener {
	
	private static Clock instance = null;
	
    private static Timer timer;
    private int numSeconds;
    private int numMinutes;
    private int newMinutes;
    private int newHours;
    private String sTime = "00:00:00";
    final static JLabel label = new JLabel("00:00:00");
    final static JLabel labeltmp = new JLabel("00:00:00");


    private Clock() {
    	numSeconds = 0;
    	numMinutes = 0;
    	newMinutes = 0;
    	newHours = 0;
    	sTime = "00:00:00";
    }
    /*
     * Only one instance of Clock is ever needed so we use the Singleton pattern
     */
    public static Clock getInstance() {
    	if(instance == null) instance = new Clock();
    	return instance;
    }
    
    /**
     * A method called by HomeScreen: Formats the current time to a String, then returns it
     * @return String time
     */
    public String getTime(){
        /*int hours = numSeconds / 60 / 60;
        int minutes = numSeconds /60 % 60;
        int seconds = numSeconds % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);*/
        return sTime;
    }

    public Component createComponents() {
        //Create buttons
    	labeltmp.setText(sTime);
        JButton addMinute = new JButton("+Minute");
        addMinute.addActionListener(this);
        addMinute.setActionCommand("am");
        JButton subMinute = new JButton("-Minute");
        subMinute.addActionListener(this);
        subMinute.setActionCommand("sm");
        JButton addHour = new JButton("+Hour");
        addHour.addActionListener(this);
        addHour.setActionCommand("ah");
        JButton subHour = new JButton("-Hour");
        subHour.addActionListener(this);
        subHour.setActionCommand("sh");
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        enter.setActionCommand("enter");

        //Add buttons and labels
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(addHour);
        pane.add(subHour);
        pane.add(labeltmp);
        pane.add(addMinute);
        pane.add(subMinute);
        pane.add(enter);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30,
                30,
                10,
                30)
        );

        return pane;
    }

    /**
     * Perform an action when a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        String time;
        if ("am".equals(e.getActionCommand())) { //Add a minute
            newMinutes++;
            if (newMinutes >= 60)
                newMinutes = 0;
            time = String.format("%02d:%02d:%02d", newHours, newMinutes, numSeconds%60);
            labeltmp.setText(time);
        } else if ("sm".equals(e.getActionCommand())) {  //Subtract a minute
            newMinutes--;
            if (newMinutes <= -1)
                newMinutes = 59;
            time = String.format("%02d:%02d:%02d", newHours, newMinutes, numSeconds%60);
            labeltmp.setText(time);
        } else if ("ah".equals(e.getActionCommand())) { //Add a hour
            newHours++;
            if (newHours >= 24)
                newHours = 0;
            time = String.format("%02d:%02d:%02d", newHours, newMinutes, numSeconds%60);
            labeltmp.setText(time);
        } else if ("sh".equals(e.getActionCommand())) { //Subtract a hour
            newHours--;
            if (newHours <= -1)
                newHours = 23;
            time = String.format("%02d:%02d:%02d", newHours, newMinutes, numSeconds%60);
            labeltmp.setText(time);
        } else if ("enter".equals(e.getActionCommand())) { //Submit changes, update numMinutes, and restart timer
            numMinutes = 60*newHours + newMinutes;
            numSeconds = numMinutes * 60;
            
            timer.restart();
            sTime =  String.format("%02d:%02d:%02d",
                				  numMinutes/60, numMinutes%60, numSeconds%60);
            label.setText(sTime);
            Driver.resetWindow();
        }
    }

    /**
     * This method is called by the HomeScreen class when it starts up.
     */
    protected void createTimer() {
        //Updates numMinutes every minute
        ActionListener action = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                numSeconds++;
                //timeS++;
                //Clock reaches 23:59 and resets to simulate a new day
                if (numSeconds == 86400)
                    numSeconds = 0;
                if (numSeconds%60 == 0) {
                	numMinutes++;// = numSeconds/60%60;
                }
                sTime = String.format("%02d:%02d:%02d",
                					  numMinutes/60, numMinutes%60, numSeconds%60);
                label.setText(sTime);
            }
        };
        //Timer set to act every minute
        timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        timer.start();
    }
    
    protected void startTime() {
    	timer.start();
    }
    
    protected void stopTime() {
    	timer.stop();
    }
    
    
}
