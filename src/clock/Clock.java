package clock;

abstract class Clock implements Observer {

    private int seconds;
    private ClockTimer clockTimer;

    Clock(ClockTimer clockTimer){
        this.clockTimer = clockTimer;
    }

    int getSeconds() {
        return this.seconds;
    }

    @Override
    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }
}
