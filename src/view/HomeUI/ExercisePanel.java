package view.HomeUI;

import javax.swing.*;
import java.awt.*;

class ExercisesPanel extends JPanel {

    public ExercisesPanel() {
        setLayout(new BorderLayout(0, 15));
        setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Recommended Exercises");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel exercisesList = new JPanel();
        exercisesList.setLayout(new BoxLayout(exercisesList, BoxLayout.Y_AXIS));
        exercisesList.setBackground(Color.WHITE);

        exercisesList.add(new ExerciseRow("Pull-ups", "3 × 10"));
        exercisesList.add(Box.createVerticalStrut(10));
        exercisesList.add(new ExerciseRow("Bent Over Rows", "4 × 12"));
        exercisesList.add(Box.createVerticalStrut(10));
        exercisesList.add(new ExerciseRow("Lat Pulldowns", "3 × 15"));
        exercisesList.add(Box.createVerticalStrut(10));
        exercisesList.add(new ExerciseRow("Deadlifts", "4 × 8"));

        add(titleLabel, BorderLayout.NORTH);
        add(exercisesList, BorderLayout.CENTER);
    }
}
