package clock;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class ClockTimer implements Subject {

    private int seconds;
    private Timer timer;
    private ArrayList<Observer> observers;

    ClockTimer(){
        this.observers = new ArrayList<>();

        this.timer = new Timer();

        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                setSeconds(seconds + 1);
            }
        };

        long delay  = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }


    void setSeconds(int seconds) {
        this.seconds = seconds;
        notifyObserver();
    }

    int getSeconds() {
        return this.seconds;
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
