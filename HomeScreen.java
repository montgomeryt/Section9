//package PepStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreen implements ActionListener{
	private static Timer timer;
    final static JLabel lClock = new JLabel();
	
	public Component createComponents() {
		//make buttons
		JButton setTime = new JButton("Set Time");
		setTime.addActionListener(this);
		setTime.setActionCommand("setTime");
		JButton stopWatch = new JButton("Stopwatch");
		stopWatch.addActionListener(this);
		stopWatch.setActionCommand("stopWatch");
		
		//create JPanel, add buttons and labels, and add a border
		JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(lClock);
        pane.add(setTime);
        pane.add(stopWatch);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                30, //left
                10, //bottom
                30) //right
                );
        
        return pane;
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("setTime".equals(e.getActionCommand())) {
			//Opens Clock UI which allows the time to be updated
			Clock.createAndShowGUI();
        	lClock.setText(Clock.getTime());
		} else if ("stopWatch".equals(e.getActionCommand())) {
			//Open StopWatch application
			StopWatch.createAndShowGUI();
		}
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("HomeScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        HomeScreen app = new HomeScreen();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
        
        //Actions performed by timer
        ActionListener action = new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent event)
            {
            	//Update the time on the clocklabel
            	lClock.setText(Clock.getTime());
            }
        };
        //timer set to act once every second
        timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        timer.start();
        
        frame.pack();
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Clock.createTimer(); // This is needed to cause the clock to function properly on start-up
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
