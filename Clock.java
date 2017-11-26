/**
 * Clock class
 * Keeps track of time and displays it on the HomeScreen
 * Contains UI which allows the user to update the time
 */
//package PepStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock implements ActionListener {
    private static Timer timer;
    private static int numMinutes = 0;
    private static int newMinutes;
    private static int newHours;
    final static JLabel label = new JLabel("00:00");


    /**
     * A method called by HomeScreen: Formats the current time to a String, then returns it
     * @return String time
     */
    public static String getTime(){
        int hours = numMinutes / 60;
        int minutes = numMinutes % 60;
        String time = String.format("%02d:%02d", hours, minutes);
        return time;
    }

    public Component createComponents() {
        //Create buttons
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
        pane.add(label);
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
            time = String.format("%02d:%02d", newHours, newMinutes);
            label.setText(time);
        } else if ("sm".equals(e.getActionCommand())) {  //Subtract a minute
            newMinutes--;
            if (newMinutes <= -1)
                newMinutes = 59;
            time = String.format("%02d:%02d", newHours, newMinutes);
            label.setText(time);
        } else if ("ah".equals(e.getActionCommand())) { //Add a hour
            newHours++;
            if (newHours >= 24)
                newHours = 0;
            time = String.format("%02d:%02d", newHours, newMinutes);
            label.setText(time);
        } else if ("sh".equals(e.getActionCommand())) { //Subtract a hour
            newHours--;
            if (newHours <= -1)
                newHours = 23;
            time = String.format("%02d:%02d", newHours, newMinutes);
            label.setText(time);
        } else if ("enter".equals(e.getActionCommand())) { //Submit changes, update numMinutes, and restart timer
            numMinutes = 60*newHours + newMinutes;
            timer.restart();
            Driver.resetWindow();
        }
    }

    /**
     * This method is called by the HomeScreen class when it starts up.
     */
    static void createTimer() {
        //Updates numMinutes every minute
        ActionListener action = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                numMinutes++;
                //Clock reaches 23:59 and resets to simulate a new day
                if (numMinutes == 1440)
                    numMinutes = 0;
            }
        };
        //Timer set to act every minute
        timer = new Timer(60000, action);
        timer.setInitialDelay(60000);
        timer.start();
    }
}
