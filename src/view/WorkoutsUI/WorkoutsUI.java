package view.WorkoutsUI;

import javax.swing.*;
import java.awt.*;

public class WorkoutsUI extends JPanel {

    public WorkoutsUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        HeaderPanel headerPanel = new HeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        WorkoutListPanel workoutListPanel = new WorkoutListPanel();

        JScrollPane scrollPane = new JScrollPane(workoutListPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}