package clock;

abstract class Clock extends Observer {

    private int seconds;
    private ClockTimer clockTimer;
    private String windowTitle;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;

    Clock(ClockTimer clockTimer, String windowTitle){
        this.clockTimer = clockTimer;
        this.windowTitle = windowTitle;
    }

    abstract void display();

    int getSeconds() {
        return this.seconds;
    }

    int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    String getWindowTitle() {
        return windowTitle;
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

    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }
}
