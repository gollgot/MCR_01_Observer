package clock;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class ClockTimer implements Subject {

    private int seconds; // The subject state
    private Timer timer;
    private ArrayList<Observer> observers;

    ClockTimer(){
        this.observers = new ArrayList<>();
    }

    void setSeconds(int seconds) {
        this.seconds = seconds;
        notifyObserver();
    }

    int getSeconds() {
        return this.seconds;
    }

    void start() {
        this.timer = new Timer();

        // Set up the repeated task that will update the subject states (seconds)
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                setSeconds(seconds + 1);
            }
        };

        long delay  = 1000L;
        long period = 1000L;
        this.timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }

    void pause() {
        this.timer.cancel();
    }

    void reset() {
        this.setSeconds(0);
    }


    @Override
    public void attach(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : this.observers){
            o.update();
        }
    }

}
