package clock;

import ObserverPattern.Subject;

import java.util.Timer;
import java.util.TimerTask;

class ClockTimer extends Subject {

    private int seconds; // The subject state
    private Timer timer;
    private boolean isRunning;

    /**
     * Seconds setter and notify all observer that the state has changed
     * @param seconds The new seconds state
     */
    void setSeconds(int seconds) {
        this.seconds = seconds;
        notifyObservers();
    }

    /**
     * Seconds setter
     * @return The current seconds
     */
    int getSeconds() {
        return this.seconds;
    }

    /**
     * isRunning setter
     * @return The current isRunning state
     */
    boolean isRunning() {
        return isRunning;
    }

    /**
     * Start the timer
     */
    void start() {
        this.isRunning = true;

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

    /**
     * Pause the timer
     */
    void pause() {
        this.isRunning = false;
        this.timer.cancel();
    }

    /**
     * Reset the timer
     */
    void reset() {
        this.setSeconds(0);
    }

}
