package clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockControllerWindow extends JFrame {

    private ClockTimer clockTimer = new ClockTimer();

    private JButton romanClockBtn = new JButton("Horloge romaine");
    private JButton arabClockBtn = new JButton("Horloge arabe");
    private JButton digitalClockBtn = new JButton("Horloge numérique");
    private JButton mixedClockBtn = new JButton("Horloge mixte");
    private JButton startBtn = new JButton("Démarrer");
    private JButton stopBtn = new JButton("Arreter");
    private JButton resetBtn = new JButton("Réinitialiser");
    private JButton quitBtn = new JButton("Quitter");

    public ClockControllerWindow(){
        linkButtonsAction();
        displayWindow();
    }

    private void linkButtonsAction() {

        digitalClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DigitalClock digitalClock = new DigitalClock(clockTimer, "Horloge Numérique");
                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(digitalClock);
            }
        });

        arabClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AnalogClock arabClock = new AnalogClock(clockTimer, "Horloge Arabe", "assets/arab_clock.jpg");
                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(arabClock);
            }
        });

        romanClockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AnalogClock romanClock = new AnalogClock(clockTimer, "Horloge Romaine", "assets/roman_clock.jpg");
                // Dont forgot to attach the observer to the subject to be able to be notify
                clockTimer.attach(romanClock);
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

    private void displayWindow() {
        // Window settings
        this.setTitle("Clock Controller");
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
