package view;

import view.HomeUI.*;
import javax.swing.*;
import java.awt.*;

public class GrindLineUI extends JFrame {

    public GrindLineUI() {
        setTitle("GrindLine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        HeaderPanel headerPanel = new HeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout(0, 30));
        contentPanel.setBackground(Color.WHITE);

        StatsPanel statsPanel = new StatsPanel();
        contentPanel.add(statsPanel, BorderLayout.NORTH);

        MuscleGroupPanel musclePanel = new MuscleGroupPanel();
        contentPanel.add(musclePanel, BorderLayout.CENTER);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GrindLineUI frame = new GrindLineUI();
            frame.setVisible(true);
        });
    }
}