package clock;

import javax.swing.*;
import java.awt.*;

public class ClockControllerWindow extends JFrame {

    private JPanel panel = new JPanel();
    private JButton romanClockBtn = new JButton("Horloge romaine");
    private JButton arabClockBtn = new JButton("Horloge arabe");
    private JButton digitalClockBtn = new JButton("Horloge numérique");
    private JButton mixedClockBtn = new JButton("Horloge mixte");
    private JButton startBtn = new JButton("Démarrer");
    private JButton stopBtn = new JButton("Arreter");
    private JButton initBtn = new JButton("Réinitialiser");
    private JButton quitBtn = new JButton("Quitter");

    public ClockControllerWindow(){
        // Window settings
        this.setTitle("Clock Controller");
        this.setSize(200,50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Create the grid
        GridLayout layout = new GridLayout(2,4);
        layout.setHgap(10);
        layout.setVgap(10);

        // Add the grid to the panel
        panel.setLayout(layout);

        // Add buttons into the panel
        panel.add(romanClockBtn);
        panel.add(arabClockBtn);
        panel.add(digitalClockBtn);
        panel.add(mixedClockBtn);
        panel.add(startBtn);
        panel.add(stopBtn);
        panel.add(initBtn);
        panel.add(quitBtn);

        this.setContentPane(panel);
        this.setVisible(true);
    }

}
