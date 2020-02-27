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
        String strLabel = super.getDisplayedHours() + "h " + super.getDisplayedMinutes() + "m " + super.getDisplayedSeconds() + "s ";
        timeLabel.setText(strLabel);
    }
}
