import javax.swing.*;

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
    }

    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }

    public void displayOnWindow(){
        JFrame window = new JFrame();
        window.setTitle(windowTitle);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(this.panel);
        window.pack(); // Window's size will be pack relative to it's preferredSize components.
        window.setVisible(true);
    }
}
