/**
 * StopWatch class
 * Contains UI for a stopwatch
 */

//package PepStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch implements ActionListener {
	private static Timer timer;
	private static int seconds = 0;
	private static int minutes = 0;
	private static int hours = 0;
    final static JLabel label = new JLabel();
    private static String time;
	
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
		
		//create JPanel, add buttons to it, and add a border
		JPanel pane = new JPanel(new GridLayout(0, 1));
		pane.add(label);
        pane.add(start);
        pane.add(pause);
        pane.add(reset);
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
			timer.stop();
		else {
			//If reset button is clicked, pause timer, reset h/m/s and update display
			timer.stop();
			seconds = 0;
			minutes = 0;
			hours = 0;
			time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            label.setText(time);
		}
	}
	
	public static void createAndShowGUI() {
		time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        label.setText(time);
		JFrame frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        StopWatch app = new StopWatch();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
        
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
        
        frame.pack();
        frame.setVisible(true);
	}
	
	/**
	 * This method is only used for debugging purposes.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });		
	}

}