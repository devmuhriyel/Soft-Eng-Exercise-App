package view.HomeUI;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {

    public StatsPanel() {
        setLayout(new GridLayout(1, 3, 20, 0));
        setBackground(Color.WHITE);

        add(new StatCard("Workouts", "24", "This month", ""));
        add(new StatCard("Streak", "7 days", "Keep it up!", ""));
        add(new StatCard("Goal Progress", "68%", "Monthly goal", ""));
    }
}
