package clock;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class ArabianClock extends Clock {

    private Image image;

    ArabianClock(ClockTimer clockTimer, String windowTitle, String imgPath) {
        super(clockTimer);
        // Load the image file
        File file = new File(imgPath);
        this.image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
    }

    @Override
    void display() {
        JFrame window = new JFrame();

        window.setTitle("Horloge Arabe");
        window.setSize(300,100);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(this);
        window.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image
        g.drawImage(this.image, 0, 0, null);
    }
}
