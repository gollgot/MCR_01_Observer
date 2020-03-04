package clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockControllerWindow extends JFrame {

    // The concrete subject
    private ClockTimer clockTimer = new ClockTimer();

    private final String ROMAN_CLOCK_TXT = "Horloge romaine";
    private final String ARAB_CLOCK_TXT = "Horloge arabe";
    private final String DIGITAL_CLOCK_TXT = "Horloge numérique";
    private final String ROMAN_CLOCK_IMG_PATH = "assets/roman_clock.jpg";
    private final String ARAB_CLOCK_IMG_PATH = "assets/arab_clock.jpg";

    // Buttons
    private JButton romanClockBtn = new JButton(ROMAN_CLOCK_TXT);
    private JButton arabClockBtn = new JButton(ARAB_CLOCK_TXT);
    private JButton digitalClockBtn = new JButton(DIGITAL_CLOCK_TXT);
    private JButton mixedClockBtn = new JButton("Horloge mixte");
    private JButton startBtn = new JButton("Démarrer");
    private JButton stopBtn = new JButton("Arreter");
    private JButton resetBtn = new JButton("Réinitialiser");
    private JButton quitBtn = new JButton("Quitter");

    public ClockControllerWindow(){
        linkButtonsAction();
        displayWindow();
    }

    /**
     * Link all buttons with their own ActionListener
     */
    private void linkButtonsAction() {

        digitalClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DigitalClock digitalClock = new DigitalClock(clockTimer, DIGITAL_CLOCK_TXT);
                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(digitalClock);
                digitalClock.displayOnWindow();
            }
        });

        arabClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AnalogClock arabClock = new AnalogClock(clockTimer, ARAB_CLOCK_TXT, ARAB_CLOCK_IMG_PATH);
                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(arabClock);
                arabClock.displayOnWindow();
            }
        });

        romanClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AnalogClock romanClock = new AnalogClock(clockTimer, ROMAN_CLOCK_TXT, ROMAN_CLOCK_IMG_PATH);
                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(romanClock);
                romanClock.displayOnWindow();
            }
        });

        mixedClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Create our clocks
                AnalogClock arabClock = new AnalogClock(clockTimer, ARAB_CLOCK_TXT, ARAB_CLOCK_IMG_PATH);
                AnalogClock romanClock = new AnalogClock(clockTimer, ROMAN_CLOCK_TXT, ROMAN_CLOCK_IMG_PATH);
                DigitalClock digitalClock = new DigitalClock(clockTimer, DIGITAL_CLOCK_TXT);

                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(arabClock);
                clockTimer.attach(romanClock);
                clockTimer.attach(digitalClock);

                // Create the specific window (mixed clock)
                JFrame window = new JFrame();
                FlowLayout flowLayout = new FlowLayout(); // flowLayout to be able to have a nice responsive placement
                window.setLayout(flowLayout);

                // Fetch all clock panel to integrate them into the window
                int clockImgWidth = arabClock.getImgWidth();
                int clockImgHeight = arabClock.getImgHeight();
                JPanel arabPanel = arabClock.getPanel();
                JPanel romanPanel = romanClock.getPanel();
                JPanel digitalPanel = digitalClock.getPanel();
                arabPanel.setPreferredSize(new Dimension(clockImgWidth, clockImgHeight));
                romanPanel.setPreferredSize(new Dimension(clockImgWidth, clockImgHeight));
                digitalPanel.setPreferredSize(new Dimension(clockImgWidth, 100));

                // Window settings
                window.setTitle("Horloge Mixte");
                window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                window.setLocationRelativeTo(null);
                window.add(arabPanel);
                window.add(romanPanel);
                window.add(digitalPanel);
                window.pack();
                window.setVisible(true);
            }
        });

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clockTimer.start();
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clockTimer.pause();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clockTimer.reset();
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }

    /**
     * Display the window
     */
    private void displayWindow() {
        // Window settings
        this.setTitle("clock.Clock Controller");
        this.setSize(800,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Create the grid
        GridLayout layout = new GridLayout(2,4);
        layout.setHgap(10);
        layout.setVgap(10);

        // Add the grid to the panel
        JPanel panel = new JPanel();
        panel.setLayout(layout);

        // Add buttons into the panel
        panel.add(romanClockBtn);
        panel.add(arabClockBtn);
        panel.add(digitalClockBtn);
        panel.add(mixedClockBtn);
        panel.add(startBtn);
        panel.add(stopBtn);
        panel.add(resetBtn);
        panel.add(quitBtn);

        this.setContentPane(panel);
        this.setVisible(true);
    }

}
