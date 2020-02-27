package clock;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class AnalogClock extends Clock {

    private Image image;
    private final int IMG_WIDTH = 200;
    private final int IMG_HEIGHT = 200;

    AnalogClock(ClockTimer clockTimer, String windowTitle, String imgPath) {
        super(clockTimer, windowTitle);
        // Load the image file
        File file = new File(imgPath);
        this.image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        this.image = this.image.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);
    }

    @Override
    void display() {
        JFrame window = new JFrame();

        // Create an anonymous class to be able to override the paint() method to draw our image / needles
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(AnalogClock.this.image, 0, 0, null);
                g.setColor(Color.BLACK);
                g.drawLine(100, 100, 100, 200);
            }
        };

        window.setTitle(super.getWindowTitle());
        window.setSize(super.getWINDOW_WIDTH(),super.getWINDOW_HEIGHT());
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(panel);
        window.setVisible(true);
    }

}