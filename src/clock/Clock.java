package clock;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ObserverPattern.Observer;

abstract class Clock extends Observer {

    private int seconds;
    private ClockTimer clockTimer;
    private String windowTitle;
    private JPanel panel;

    Clock(ClockTimer clockTimer, String windowTitle){
        this.clockTimer = clockTimer;
        this.windowTitle = windowTitle;
    }

    /**
     * Panel getter
     * @return The current clock panel
     */
    JPanel getPanel() {
        return this.panel;
    }

    /**
     * Return the hours that will be displayed (relative to seconds variable)
     * @return The hours to display
     */
    int getDisplayedHours(){
        return this.seconds / 3600;
    }

    /**
     *
     * Return the minutes that will be displayed (relative to seconds variable)
     * @return The minutes to display
     */
    int getDisplayedMinutes() {
        return (this.seconds % 3600) / 60;
    }

    /**
     *
     * Return the seconds that will be displayed (relative to seconds variable)
     * @return The seconds to display
     */
    int getDisplayedSeconds(){
        return (this.seconds % 3600) % 60;
    }

    /**
     * Panel setter and add mouse listener on it to be able to run or pause the timer with a click
     * @param panel The panel to set
     */
    void setPanel(JPanel panel) {
        this.panel = panel;
        // Add a mouse liestener on the fly for the new panel. This way we can start / stop
        // the timer with a clic into the panel.
        this.panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(!Clock.this.clockTimer.isRunning()){
                    Clock.this.clockTimer.start();
                }else{
                    Clock.this.clockTimer.pause();
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }

    /**
     * Update the seconds from the subject state (seconds)
     */
    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }

    /**
     * Load the panel for the current clock and draw all things we'll need for it
     */
    abstract void loadPanel();

    /**
     * Display the current window
     */
    void displayOnWindow(){
        JFrame window = new JFrame();
        window.setTitle(windowTitle);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(this.panel);
        window.pack(); // Window's size will be pack relative to it's preferredSize components.
        window.setVisible(true);
    }
}
