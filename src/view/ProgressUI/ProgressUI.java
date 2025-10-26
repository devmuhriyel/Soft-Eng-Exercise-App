package view.ProgressUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ProgressUI extends JPanel {

    private JLabel titleLabel;
    private JLabel exerciseCountLabel;
    private JLabel goalLabel;
    private JProgressBar progressBar;
    private JTextArea statisticsArea;
    private JButton refreshButton;

    public ProgressUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ===== HEADER =====
        titleLabel = new JLabel("Progress Summary", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
        titleLabel.setForeground(new Color(30, 60, 114));
        titleLabel.setBorder(new EmptyBorder(30, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // ===== CENTER CONTENT =====
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(new EmptyBorder(20, 200, 20, 200)); // fits nicely on 1200x800

        // Exercise Count Label
        exerciseCountLabel = new JLabel("Total Exercises: 0", SwingConstants.CENTER);
        exerciseCountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        exerciseCountLabel.setForeground(new Color(50, 50, 50));
        exerciseCountLabel.setOpaque(true);
        exerciseCountLabel.setBackground(Color.WHITE);
        exerciseCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        exerciseCountLabel.setMaximumSize(new Dimension(800, 60));
        exerciseCountLabel.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(10, 15, 10, 15)
        ));
        centerPanel.add(exerciseCountLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Goal Label
        goalLabel = new JLabel("Goal Progress:", SwingConstants.CENTER);
        goalLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        goalLabel.setForeground(new Color(80, 80, 80));
        goalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(goalLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Progress Bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(65);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        progressBar.setForeground(new Color(80, 140, 255));
        progressBar.setBackground(new Color(230, 230, 230));
        progressBar.setBorderPainted(false);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressBar.setMaximumSize(new Dimension(800, 40));
        centerPanel.add(progressBar);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Statistics Area
        statisticsArea = new JTextArea(8, 25);
        statisticsArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        statisticsArea.setForeground(new Color(70, 70, 70));
        statisticsArea.setEditable(false);
        statisticsArea.setText(
                "No statistics yet.\n\n" +
                        "Once you complete a routine, your progress summary\n" +
                        "and performance stats will be displayed here."
        );
        statisticsArea.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));
        JScrollPane scrollPane = new JScrollPane(statisticsArea);
        scrollPane.setBorder(null);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setMaximumSize(new Dimension(800, 200));
        centerPanel.add(scrollPane);

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM BUTTON =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        bottomPanel.setBackground(Color.WHITE);

        refreshButton = new JButton("Recheck Progress");
        refreshButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        refreshButton.setFocusPainted(false);
        refreshButton.setBackground(new Color(30, 100, 255));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshButton.setBorder(new LineBorder(new Color(20, 80, 220), 1, true));
        refreshButton.setOpaque(true);
        refreshButton.setPreferredSize(new Dimension(220, 45));

        bottomPanel.add(refreshButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ===== MVC Accessors =====
    public void setExerciseCount(int count) {
        exerciseCountLabel.setText("Total Exercises: " + count);
    }

    public void setProgress(int percent) {
        progressBar.setValue(percent);
    }

    public void setStatistics(String text) {
        statisticsArea.setText(text);
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }
}
