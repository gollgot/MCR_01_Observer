package clock;

abstract class Clock extends Observer {

    private int seconds;
    private ClockTimer clockTimer;

    Clock(ClockTimer clockTimer){
        this.clockTimer = clockTimer;
    }

    abstract void display();

    int getSeconds() {
        return this.seconds;
    }

    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }
}
