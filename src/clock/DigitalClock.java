package clock;

import javax.swing.*;

class DigitalClock extends Clock {

    private JLabel timeLabel = new JLabel();

    DigitalClock(ClockTimer clockTimer){
        super(clockTimer);
    }

    @Override
    void display(){
        JFrame window = new JFrame();
        JPanel panel = new JPanel();

        this.timeLabel.setText("00h 00m 00s");
        panel.add(this.timeLabel);

        window.setTitle("Horloge Numérique");
        window.setSize(300,100);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(panel);
        window.setVisible(true);
    }


    @Override
    public void update() {
        super.update();
        System.out.println("UPDATE");
        int currentSeconds = super.getSeconds();

        // Decompose currentSeconds into hours / minutes / seconds
        int hour = currentSeconds / 3600;

        currentSeconds %= 3600;
        int minutes = currentSeconds / 60 ;

        currentSeconds %= 60;
        int seconds = currentSeconds;

        String strLabel = hour + "h " + minutes + "m " + seconds + "s ";

        timeLabel.setText(strLabel);
    }
}
