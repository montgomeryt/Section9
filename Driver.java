import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver implements ActionListener
{
    private static JFrame frame = new JFrame("PepStep");
    private static JLabel time = new JLabel();

    public void actionPerformed(ActionEvent e)
    {
        Clock clock = new Clock();
        Clock.createTimer();
        StopWatch stopWatch = new StopWatch();
        if ("setTime".equals(e.getActionCommand()))
        {
            //Opens Clock UI which allows the time to be updated
            frame.getContentPane().removeAll();
            time.setText(Clock.getTime());
            frame.getContentPane().add(clock.createComponents());
        }
        else if ("stopWatch".equals(e.getActionCommand()))
        {
            //Open StopWatch application
            frame.getContentPane().removeAll();
            StopWatch.createAndShowGUI();
            frame.getContentPane().add(stopWatch.createComponents());
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

        //create JPanel, add buttons and labels, and add a border
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(time);
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
        time.setText(Clock.getTime());
        frame.getContentPane().add(main.createComponents());
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args)
    {
        createWindow(frame);
        resetWindow();
    }
}
