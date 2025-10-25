package view.WorkoutsUI;

import model.Workout;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class WorkoutCard extends JPanel {
    private Workout workout;

    public WorkoutCard(Workout workout) {
        this.workout = workout;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        setPreferredSize(new Dimension(400, 500));

        JPanel headerPanel = createHeaderPanel();
        JPanel imagePanel = createImagePanel();
        JPanel detailsPanel = createDetailsPanel();

        add(headerPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        add(detailsPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(workout.getHeaderColor());
        header.setBorder(BorderFactory.createEmptyBorder(12, 15, 12, 15));

        JLabel titleLabel = new JLabel(workout.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setOpaque(false);

        JButton shareButton = new JButton("Share");
        shareButton.setForeground(Color.WHITE);
        shareButton.setFont(new Font("Arial", Font.PLAIN, 11));
        shareButton.setOpaque(false);
        shareButton.setContentAreaFilled(false);
        shareButton.setBorderPainted(false);
        shareButton.setFocusPainted(false);
        shareButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton infoButton = new JButton("ⓘ");
        infoButton.setForeground(Color.WHITE);
        infoButton.setFont(new Font("Arial", Font.BOLD, 16));
        infoButton.setOpaque(false);
        infoButton.setContentAreaFilled(false);
        infoButton.setBorderPainted(false);
        infoButton.setFocusPainted(false);
        infoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        rightPanel.add(shareButton);
        rightPanel.add(infoButton);

        JPanel badgesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        badgesPanel.setOpaque(false);

        JLabel difficultyBadge = createBadge(workout.getDifficulty());
        JLabel categoryBadge = createBadge(workout.getCategory());

        badgesPanel.add(difficultyBadge);
        badgesPanel.add(categoryBadge);

        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setOpaque(false);
        topRow.add(titleLabel, BorderLayout.WEST);
        topRow.add(rightPanel, BorderLayout.EAST);

        header.add(topRow, BorderLayout.NORTH);
        header.add(badgesPanel, BorderLayout.SOUTH);

        return header;
    }

    private JLabel createBadge(String text) {
        JLabel badge = new JLabel(text);
        badge.setFont(new Font("Arial", Font.PLAIN, 10));
        badge.setForeground(Color.WHITE);
        badge.setOpaque(true);
        badge.setBackground(new Color(0, 0, 0, 50));
        badge.setBorder(BorderFactory.createEmptyBorder(3, 8, 3, 8));
        return badge;
    }

    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(245, 245, 245));
        imagePanel.setPreferredSize(new Dimension(400, 250));

        JLabel placeholderLabel = new JLabel("Workout Image", SwingConstants.CENTER);
        placeholderLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        placeholderLabel.setForeground(Color.GRAY);

        imagePanel.add(placeholderLabel, BorderLayout.CENTER);

        return imagePanel;
    }

    private JPanel createDetailsPanel() {
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setBackground(Color.WHITE);
        details.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel equipmentPanel = new JPanel(new BorderLayout(10, 5));
        equipmentPanel.setBackground(Color.WHITE);

        JLabel equipmentLabel = new JLabel("Equipment");
        equipmentLabel.setFont(new Font("Arial", Font.BOLD, 12));
        equipmentLabel.setForeground(Color.GRAY);

        JPanel equipmentIcons = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        equipmentIcons.setBackground(Color.WHITE);
        for (String item : workout.getEquipment()) {
            JLabel icon = new JLabel("🏋️");
            icon.setToolTipText(item);
            equipmentIcons.add(icon);
        }

        equipmentPanel.add(equipmentLabel, BorderLayout.NORTH);
        equipmentPanel.add(equipmentIcons, BorderLayout.CENTER);

        JPanel musclePanel = new JPanel(new BorderLayout());
        musclePanel.setBackground(new Color(250, 250, 250));
        musclePanel.setBorder(new LineBorder(new Color(230, 230, 230), 1));
        musclePanel.setPreferredSize(new Dimension(350, 100));

        JLabel muscleDiagram = new JLabel("Muscle Diagram", SwingConstants.CENTER);
        muscleDiagram.setFont(new Font("Arial", Font.PLAIN, 11));
        muscleDiagram.setForeground(Color.GRAY);
        musclePanel.add(muscleDiagram, BorderLayout.CENTER);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 12));
        descriptionLabel.setForeground(Color.GRAY);
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        details.add(equipmentPanel);
        details.add(Box.createVerticalStrut(15));
        details.add(musclePanel);
        details.add(descriptionLabel);

        return details;
    }
}