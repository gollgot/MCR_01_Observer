package clock;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class ClockTimer implements Subject {

    private int seconds;
    private Timer timer;
    private ArrayList<Observer> observers;

    private ClockTimer(){
        this.observers = new ArrayList<>();

        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setSeconds(seconds + 1);
            }
        }, 1000);
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
