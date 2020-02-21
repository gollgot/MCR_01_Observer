package clock;

import javax.swing.*;

class DigitalClock extends Clock {

    private JLabel timeLabel = new JLabel();

    DigitalClock(ClockTimer clockTimer){
        super(clockTimer);
    }

    void display(){
        JFrame window = new JFrame();
        JPanel panel = new JPanel();

        this.timeLabel.setText("0");
        panel.add(this.timeLabel);

        window.setTitle("Horloge Arabe");
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
        timeLabel.setText(Integer.toString(super.getSeconds()));
    }
}
