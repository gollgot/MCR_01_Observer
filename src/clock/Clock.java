package clock;

import javax.swing.*;
import java.awt.*;

abstract class Clock extends JPanel implements Observer {

    private int seconds;
    private ClockTimer clockTimer;

    Clock(ClockTimer clockTimer){
        this.clockTimer = clockTimer;
    }

    abstract void display();

    int getSeconds() {
        return this.seconds;
    }

    @Override
    public void update() {
        // Update our seconds from the subject state (seconds)
        this.seconds = this.clockTimer.getSeconds();
    }
}
