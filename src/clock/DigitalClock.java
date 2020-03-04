package clock;

import javax.swing.*;
import java.awt.*;

class DigitalClock extends Clock {

    private JLabel timeLabel = new JLabel();

    DigitalClock(ClockTimer clockTimer, String windowTitle){
        super(clockTimer, windowTitle);
        this.loadPanel();
    }

    private void loadPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200,100));
        this.timeLabel.setText("00h 00m 00s");
        panel.add(this.timeLabel);
        super.setPanel(panel);
    }

    @Override
    public void update() {
        super.update();
        String strLabel = intOnTwoDigits(super.getDisplayedHours()) + "h " + intOnTwoDigits(super.getDisplayedMinutes()) + "m " + intOnTwoDigits(super.getDisplayedSeconds()) + "s ";
        timeLabel.setText(strLabel);
    }

    /**
     * Converts an int on a two digits String (6 -> 06, 42 -> 42)
     * @param value the integer to be converted
     * @return the String on two digits
     */
    private String intOnTwoDigits(int value) {
        return String.format("%02d", value);
    }
}
