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
        System.out.println("dedededeedeedede");
        this.seconds = this.clockTimer.getSeconds();
    }
}
