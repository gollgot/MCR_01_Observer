package clock;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.PreparedStatement;

class AnalogClock extends Clock {

    private Image image;
    private final int IMG_WIDTH = 400;
    private final int IMG_HEIGHT = 400;
    private int xNeedleSeconds;
    private int yNeedleSeconds;
    private int xNeedleMinutes;
    private int yNeedleMinutes;
    private int xNeedleHours;
    private int yNeedleHours;

    private JPanel panel;

    AnalogClock(ClockTimer clockTimer, String windowTitle, String imgPath) {
        super(clockTimer, windowTitle);
        // Load the image file
        File file = new File(imgPath);
        this.image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        this.image = this.image.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);

        this.updateNeedlesPositions();
    }

    @Override
    void display() {
        JFrame window = new JFrame();

        // Create an anonymous class to be able to override the paint() method to draw our image / needles
        this.panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                Graphics2D g2 = (Graphics2D) g;

                // Draw the image
                g2.drawImage(AnalogClock.this.image, 0, 0, null);

                // Draw hours needle
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(4));
                g2.drawLine(IMG_WIDTH / 2, IMG_WIDTH / 2, xNeedleHours, yNeedleHours);

                // Draw minutes needle
                g2.setColor(Color.BLUE);
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(IMG_WIDTH / 2, IMG_WIDTH / 2, xNeedleMinutes, yNeedleMinutes);

                // Draw seconds needle
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(IMG_WIDTH / 2, IMG_WIDTH / 2, xNeedleSeconds, yNeedleSeconds);
            }
        };

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

        this.updateNeedlesPositions();

        this.panel.revalidate();
        this.panel.repaint();
    }

    private void updateNeedlesPositions(){
        this.xNeedleSeconds = (int) (Math.cos(super.getDisplayedSeconds() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.4) + IMG_WIDTH / 2);
        this.yNeedleSeconds = (int) (Math.sin(super.getDisplayedSeconds() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.4) + IMG_WIDTH / 2);
        this.xNeedleMinutes = (int) (Math.cos(super.getDisplayedMinutes() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.3) + IMG_WIDTH / 2);
        this.yNeedleMinutes = (int) (Math.sin(super.getDisplayedMinutes() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.3) + IMG_WIDTH / 2);
        this.xNeedleHours = (int) (Math.cos((super.getDisplayedHours() * 30 + (float) super.getDisplayedMinutes() / 2) * 3.14f / 180 - 3.14f / 2) * (IMG_WIDTH * 0.2) + IMG_WIDTH / 2);
        this.yNeedleHours = (int) (Math.sin((super.getDisplayedHours() * 30 + (float) super.getDisplayedMinutes() / 2) * 3.14f / 180 - 3.14f / 2) * (IMG_WIDTH * 0.2) + IMG_WIDTH / 2);
    }
}



