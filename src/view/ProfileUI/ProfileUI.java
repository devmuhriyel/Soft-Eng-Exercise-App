package view.ProfileUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ProfileUI extends JPanel {

    private JLabel nameLabel, levelLabel, goalLabel;
    private JLabel totalWorkoutsLabel, totalHoursLabel, caloriesBurnedLabel;
    private JTextArea bioArea;
    private JButton editProfileButton;

    public ProfileUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250)); // light gray-blue for a modern look

        // ===== HEADER =====
        JLabel titleLabel = new JLabel("Your Fitness Profile", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 32));
        titleLabel.setForeground(new Color(30, 60, 114));
        titleLabel.setBorder(new EmptyBorder(20, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // ===== MAIN CONTENT PANEL =====
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(20, 40, 40, 40));
        mainPanel.setBackground(new Color(245, 247, 250));

        // ==== LEFT: Profile Info ====
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(25, 25, 25, 25)
        ));
        profilePanel.setPreferredSize(new Dimension(400, 700));

        JLabel profilePic = new JLabel();
        profilePic.setPreferredSize(new Dimension(150, 150));
        profilePic.setOpaque(true);
        profilePic.setBackground(new Color(200, 210, 255));
        profilePic.setBorder(new LineBorder(new Color(180, 190, 240), 2, true));
        profilePic.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(profilePic);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        nameLabel = new JLabel("John Doe", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(nameLabel);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        levelLabel = new JLabel("Level: Intermediate", SwingConstants.CENTER);
        levelLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        levelLabel.setForeground(new Color(80, 80, 80));
        levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(levelLabel);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        goalLabel = new JLabel("Goal: Build Muscle", SwingConstants.CENTER);
        goalLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        goalLabel.setForeground(new Color(80, 80, 80));
        goalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(goalLabel);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 25)));

        JLabel bioLabel = new JLabel("Bio:", SwingConstants.LEFT);
        bioLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        bioLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        profilePanel.add(bioLabel);

        bioArea = new JTextArea("Fitness enthusiast focused on strength and endurance.\nLoves running, lifting, and challenging limits!");
        bioArea.setWrapStyleWord(true);
        bioArea.setLineWrap(true);
        bioArea.setEditable(false);
        bioArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        bioArea.setForeground(new Color(70, 70, 70));
        bioArea.setBackground(Color.WHITE);
        bioArea.setBorder(new EmptyBorder(10, 0, 10, 0));
        profilePanel.add(bioArea);

        editProfileButton = new JButton("Edit Profile");
        editProfileButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        editProfileButton.setBackground(new Color(30, 100, 255));
        editProfileButton.setForeground(Color.WHITE);
        editProfileButton.setFocusPainted(false);
        editProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editProfileButton.setBorder(new EmptyBorder(10, 25, 10, 25));
        editProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profilePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        profilePanel.add(editProfileButton);

        // ==== RIGHT: Stats and Achievements ====
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(245, 247, 250));

        // Stats section
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        statsPanel.setBackground(new Color(245, 247, 250));

        totalWorkoutsLabel = createStatCard("Total Workouts", "45");
        totalHoursLabel = createStatCard("Hours Trained", "120");
        caloriesBurnedLabel = createStatCard("Calories Burned", "15,200");

        statsPanel.add(totalWorkoutsLabel);
        statsPanel.add(totalHoursLabel);
        statsPanel.add(caloriesBurnedLabel);
        rightPanel.add(statsPanel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Achievements section
        JPanel achievementPanel = new JPanel();
        achievementPanel.setLayout(new GridLayout(2, 3, 15, 15));
        achievementPanel.setBackground(Color.WHITE);
        achievementPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        for (int i = 1; i <= 6; i++) {
            JLabel badge = new JLabel("🏅 Badge " + i, SwingConstants.CENTER);
            badge.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            badge.setOpaque(true);
            badge.setBackground(new Color(245, 247, 255));
            badge.setBorder(new LineBorder(new Color(220, 220, 240), 1, true));
            achievementPanel.add(badge);
        }

        rightPanel.add(achievementPanel);
        mainPanel.add(profilePanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private JLabel createStatCard(String title, String value) {
        JLabel card = new JLabel("<html><div style='text-align:center;'>" +
                "<h2 style='color:#1E3C72; font-family:Segoe UI;'>" + value + "</h2>" +
                "<p style='color:#555; font-size:16px;'>" + title + "</p></div></html>", SwingConstants.CENTER);
        card.setOpaque(true);
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));
        return card;
    }

    // ==== Accessors for MVC ====
    public JButton getEditProfileButton() { return editProfileButton; }

    public void setProfileInfo(String name, String level, String goal, String bio) {
        nameLabel.setText(name);
        levelLabel.setText("Level: " + level);
        goalLabel.setText("Goal: " + goal);
        bioArea.setText(bio);
    }
}
