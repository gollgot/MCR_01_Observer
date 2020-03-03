import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

abstract class Clock extends Observer {

    private int seconds;
    private ClockTimer clockTimer;
    private String windowTitle;
    private JPanel panel;

    Clock(ClockTimer clockTimer, String windowTitle){
        this.clockTimer = clockTimer;
        this.windowTitle = windowTitle;
    }

    JPanel getPanel() {
        return this.panel;
    }

    int getDisplayedHours(){
        return this.seconds / 3600;
    }

    int getDisplayedMinutes() {
        return (this.seconds % 3600) / 60;
    }

    int getDisplayedSeconds(){
        return (this.seconds % 3600) % 60;
    }

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

    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }

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
