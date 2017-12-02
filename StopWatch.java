package com.csci360.healthmonitor.pepstep;
/**
 * @author Nicholas Foster
 * @modified Tyler Montgomery, Dylan Cowden
 * Class for StopWatch. keeps time and can be paused. 
 * Pauses automatically at max time and switching apps
 */

//package PepStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch implements ActionListener {
	
	//For Singleton pattern
	private static StopWatch instance = null;
	
    private Timer timer;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    final static JLabel label = new JLabel();
    private static String time;

    private StopWatch() {
    	
    }
    /*
     * Only one instance of Clock is ever needed so we use the Singleton pattern
     */
    public static StopWatch getInstance() {
    	if(instance == null) instance = new StopWatch();
    	return instance;
    }
    
    public Component createComponents() {
        //make buttons
        JButton start = new JButton("Start Timer");
        start.addActionListener(this);
        start.setActionCommand("start");
        JButton pause = new JButton("Pause Timer");
        pause.addActionListener(this);
        pause.setActionCommand("pause");
        JButton reset = new JButton("Reset Timer");
        reset.addActionListener(this);
        reset.setActionCommand("reset");
        JButton back = new JButton("Back");
        back.addActionListener(this);
        back.setActionCommand("back");

        //create JPanel, add buttons to it, and add a border
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(label);
        pane.add(start);
        pane.add(pause);
        pane.add(reset);
        pane.add(back);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                30, //left
                10, //bottom
                30) //right
        );

        return pane;
    }

    /**
     * Perform an action when a button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if ("start".equals(e.getActionCommand()))
            //If start button is clicked, start timer
            timer.start();
        else if ("pause".equals(e.getActionCommand()))
            //If pause button is clicked, pause timer
            pause();
        else if ("reset".equals(e.getActionCommand())){
            //If reset button is clicked, pause timer, reset h/m/s and update display
            timer.stop();
            seconds = 0;
            minutes = 0;
            hours = 0;
            time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            label.setText(time);
        }
        else {
            timer.stop();
            Driver.resetWindow();
        }
    }

    /*
     * Create what is needed for UI associated with stopwatch. also creates timer
     */
    public void createAndShowGUI() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        label.setText(time);

        //Action performed by timer
        ActionListener action = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }

                //Stop stopwatch once it reaches the maximum limit (99 hours)
                if (hours == 99) {
                    if (minutes == 59) {
                        if (seconds == 59)
                            timer.stop();
                    }
                }
                time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                label.setText(time);
            }
        };

        //timer set to act once every second
        timer = new Timer(1000, action);
        timer.setInitialDelay(0);

    }
    
    public int getSec() {
    	return seconds;
    }
    
    public int getMin() {
    	return minutes;
    }
    
    public int getHour() {
    	return hours;
    }
    
    public void pause() {
    	timer.stop();
    }
    
    // for testing purposes only
    public void startTimer() {
    	timer.start();
    }
    // for testing purposes only
    public void stopTimer() {
    	timer.stop();
    }
    
    public void reset() {
        seconds = 0;
        minutes = 0;
        hours = 0;
        time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        label.setText(time);
    }
}