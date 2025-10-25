package view.WorkoutsUI;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel topBar = createTopBar();
        JPanel filterBar = createFilterBar();

        add(topBar, BorderLayout.NORTH);
        add(filterBar, BorderLayout.SOUTH);
    }

    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));



        NavigationPanel navPanel = new NavigationPanel();

        JButton buildButton = new JButton("Build your own workout!");
        buildButton.setBackground(new Color(37, 99, 235));
        buildButton.setForeground(Color.WHITE);
        buildButton.setFocusPainted(false);
        buildButton.setBorderPainted(false);
        buildButton.setFont(new Font("Arial", Font.BOLD, 12));
        buildButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topBar.add(navPanel, BorderLayout.WEST);
        topBar.add(buildButton, BorderLayout.EAST);

        return topBar;
    }

    private JPanel createFilterBar() {
        JPanel filterBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        filterBar.setBackground(Color.WHITE);
        filterBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

        JLabel sortLabel = new JLabel("Sort:");
        sortLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JComboBox<String> sortCombo = new JComboBox<>(new String[]{"Default", "Difficulty", "Duration"});
        sortCombo.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"All", "Full Body", "Upper Body", "Lower Body"});
        categoryCombo.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel difficultyLabel = new JLabel("Difficulty:");
        difficultyLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JComboBox<String> difficultyCombo = new JComboBox<>(new String[]{"All", "Beginner", "Novice", "Intermediate"});
        difficultyCombo.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel musclesLabel = new JLabel("Muscles:");
        musclesLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JComboBox<String> musclesCombo = new JComboBox<>(new String[]{"All", "Chest", "Back", "Legs", "Arms"});
        musclesCombo.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel goalsLabel = new JLabel("Goals:");
        goalsLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JComboBox<String> goalsCombo = new JComboBox<>(new String[]{"All", "Build Muscle", "Lose Weight", "Gain Strength"});
        goalsCombo.setFont(new Font("Arial", Font.PLAIN, 12));

        filterBar.add(sortLabel);
        filterBar.add(sortCombo);
        filterBar.add(Box.createHorizontalStrut(10));
        filterBar.add(categoryLabel);
        filterBar.add(categoryCombo);
        filterBar.add(Box.createHorizontalStrut(10));
        filterBar.add(difficultyLabel);
        filterBar.add(difficultyCombo);
        filterBar.add(Box.createHorizontalStrut(10));
        filterBar.add(musclesLabel);
        filterBar.add(musclesCombo);
        filterBar.add(Box.createHorizontalStrut(10));
        filterBar.add(goalsLabel);
        filterBar.add(goalsCombo);

        return filterBar;
    }
}
