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

        // ===== Header =====
        titleLabel = new JLabel("Progress Summary", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
        titleLabel.setForeground(new Color(30, 60, 114));
        titleLabel.setBorder(new EmptyBorder(30, 0, 30, 0));
        add(titleLabel, BorderLayout.NORTH);

        // ===== Center Content =====
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBorder(new EmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Exercise count
        exerciseCountLabel = new JLabel("Total Exercises: 0", SwingConstants.CENTER);
        exerciseCountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        exerciseCountLabel.setForeground(new Color(50, 50, 50));
        exerciseCountLabel.setOpaque(true);
        exerciseCountLabel.setBackground(Color.WHITE);
        exerciseCountLabel.setPreferredSize(new Dimension(800, 60));
        exerciseCountLabel.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(10, 15, 10, 15)
        ));
        centerPanel.add(exerciseCountLabel, gbc);

        // Goal label
        gbc.gridy++;
        goalLabel = new JLabel("Goal Progress:", SwingConstants.CENTER);
        goalLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        goalLabel.setForeground(new Color(80, 80, 80));
        centerPanel.add(goalLabel, gbc);

        // Progress bar
        gbc.gridy++;
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(65);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        progressBar.setForeground(new Color(80, 140, 255));
        progressBar.setBackground(new Color(230, 230, 230));
        progressBar.setBorderPainted(false);
        progressBar.setPreferredSize(new Dimension(800, 40));
        centerPanel.add(progressBar, gbc);

        // Statistics text area
        gbc.gridy++;
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
        scrollPane.setPreferredSize(new Dimension(800, 200));
        centerPanel.add(scrollPane, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom Buttons =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        bottomPanel.setBackground(Color.WHITE);

        refreshButton = new JButton("Recheck Progress");
        refreshButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        refreshButton.setFocusPainted(false);
        refreshButton.setBackground(new Color(30, 100, 255));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshButton.setBorder(new EmptyBorder(12, 30, 12, 30));
        refreshButton.setBorder(new LineBorder(new Color(20, 80, 220), 1, true));
        refreshButton.setOpaque(true);

        bottomPanel.add(refreshButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ===== Public Methods (for MVC) =====
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
