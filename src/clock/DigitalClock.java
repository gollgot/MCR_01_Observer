package clock;

import javax.swing.*;

class DigitalClock extends Clock {

    private JLabel timeLabel = new JLabel();

    DigitalClock(ClockTimer clockTimer, String windowTitle){
        super(clockTimer, windowTitle);
    }

    @Override
    void display(){
        JFrame window = new JFrame();
        JPanel panel = new JPanel();

        this.timeLabel.setText("00h 00m 00s");
        panel.add(this.timeLabel);

        window.setTitle(super.getWindowTitle());
        window.setSize(super.getWINDOW_WIDTH(),super.getWINDOW_HEIGHT());
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(panel);
        window.setVisible(true);
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
