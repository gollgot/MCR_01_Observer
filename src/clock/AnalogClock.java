package clock;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class AnalogClock extends Clock {

    private Image image;
    private final int IMG_WIDTH = 300;
    private final int IMG_HEIGHT = 300;
    private int xNeedleSeconds;
    private int yNeedleSeconds;
    private int xNeedleMinutes;
    private int yNeedleMinutes;
    private int xNeedleHours;
    private int yNeedleHours;

    AnalogClock(ClockTimer clockTimer, String windowTitle, String imgPath) {
        super(clockTimer, windowTitle);
        // Load the image file
        File file = new File(imgPath);
        this.image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        this.image = this.image.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);

        this.updateNeedlesPositions();
        this.loadPanel();
    }

    @Override
    void loadPanel(){
        // Create an anonymous class to be able to override the paint() method to draw our image / needles
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                Graphics2D g2 = (Graphics2D) g;

                // Draw the image
                g2.drawImage(AnalogClock.this.image, 0, 0, this);

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

        panel.setPreferredSize(new Dimension(IMG_WIDTH, IMG_HEIGHT));
        super.setPanel(panel);
    }

    /**
     * Img Width getter
     * @return The image width
     */
    int getImgWidth() {
        return this.IMG_WIDTH;
    }

    /**
     * Img Height getter
     * @return The image height
     */
    int getImgHeight() {
        return this.IMG_HEIGHT;
    }

    @Override
    public void update() {
        super.update();

        this.updateNeedlesPositions();

        super.getPanel().revalidate();
        super.getPanel().repaint();
    }

    /**
     * Update all the needles position relative to the clock image
     */
    private void updateNeedlesPositions(){
        this.xNeedleSeconds = (int) (Math.cos(super.getDisplayedSeconds() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.4) + IMG_WIDTH / 2);
        this.yNeedleSeconds = (int) (Math.sin(super.getDisplayedSeconds() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.4) + IMG_WIDTH / 2);
        this.xNeedleMinutes = (int) (Math.cos(super.getDisplayedMinutes() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.3) + IMG_WIDTH / 2);
        this.yNeedleMinutes = (int) (Math.sin(super.getDisplayedMinutes() * 3.14f / 30 - 3.14f / 2) * (IMG_WIDTH * 0.3) + IMG_WIDTH / 2);
        this.xNeedleHours = (int) (Math.cos((super.getDisplayedHours() * 30 + (float) super.getDisplayedMinutes() / 2) * 3.14f / 180 - 3.14f / 2) * (IMG_WIDTH * 0.2) + IMG_WIDTH / 2);
        this.yNeedleHours = (int) (Math.sin((super.getDisplayedHours() * 30 + (float) super.getDisplayedMinutes() / 2) * 3.14f / 180 - 3.14f / 2) * (IMG_WIDTH * 0.2) + IMG_WIDTH / 2);
    }
}



