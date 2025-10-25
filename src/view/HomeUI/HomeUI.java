package view.HomeUI;

import javax.swing.*;
import java.awt.*;

public class HomeUI extends JPanel {

    public HomeUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JPanel contentPanel = new JPanel(new BorderLayout(0, 30));
        contentPanel.setBackground(Color.WHITE);

        StatsPanel statsPanel = new StatsPanel();
        contentPanel.add(statsPanel, BorderLayout.NORTH);

        MuscleGroupPanel musclePanel = new MuscleGroupPanel();
        contentPanel.add(musclePanel, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);
    }
}