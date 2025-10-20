package view.HomeUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MuscleGroupPanel extends JPanel {
    private String selectedMuscleGroup = "Back";
    private MuscleGroupSelector selector;

    public MuscleGroupPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(30, 30, 30, 30)
        ));

        JPanel headerPanel = createHeaderPanel();
        JPanel contentArea = createContentArea();

        add(headerPanel, BorderLayout.NORTH);
        add(contentArea, BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Target Muscle Groups");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel subtitleLabel = new JLabel("Select a muscle group to see recommended exercises");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLabel.setForeground(Color.GRAY);

        headerPanel.add(titleLabel, BorderLayout.NORTH);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);

        return headerPanel;
    }

    private JPanel createContentArea() {
        JPanel contentArea = new JPanel(new BorderLayout(30, 0));
        contentArea.setBackground(Color.WHITE);
        contentArea.setBorder(new EmptyBorder(30, 0, 0, 0));

        BodyDiagramPanel diagramPanel = new BodyDiagramPanel();

        JPanel rightPanel = new JPanel(new BorderLayout(0, 20));
        rightPanel.setBackground(Color.WHITE);

        selector = new MuscleGroupSelector(selectedMuscleGroup, this::onMuscleGroupSelected);
        ExercisesPanel exercisesPanel = new ExercisesPanel();

        rightPanel.add(selector, BorderLayout.NORTH);
        rightPanel.add(exercisesPanel, BorderLayout.CENTER);

        contentArea.add(diagramPanel, BorderLayout.WEST);
        contentArea.add(rightPanel, BorderLayout.CENTER);

        return contentArea;
    }

    private void onMuscleGroupSelected(String muscleGroup) {
        selectedMuscleGroup = muscleGroup;
        selector.updateSelection(muscleGroup);
    }
}
