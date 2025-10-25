package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NavigationBar extends JPanel {
    private GrindLineUI controller;
    private JButton homeButton;
    private JButton workoutsButton;
    private JButton progressButton;
    private JButton profileButton;

    public NavigationBar(GrindLineUI controller) {
        this.controller = controller;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JLabel logo = new JLabel("GrindLine");
        logo.setFont(new Font("Arial", Font.BOLD, 22));
        logo.setForeground(new Color(37, 99, 235));

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));
        navPanel.setBackground(Color.WHITE);

        homeButton = createNavButton("Home", "Home");
        workoutsButton = createNavButton("Workouts", "Workouts");
        progressButton = createNavButton("Progress", "Progress");
        profileButton = createNavButton("Profile", "Profile");

        navPanel.add(homeButton);
        navPanel.add(workoutsButton);
        navPanel.add(progressButton);
        navPanel.add(profileButton);

        JButton startButton = new JButton("Start Workout");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setFont(new Font("Arial", Font.BOLD, 13));
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setPreferredSize(new Dimension(140, 35));

        add(logo, BorderLayout.WEST);
        add(navPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.EAST);

        setActiveButton(homeButton);
    }

    private JButton createNavButton(String text, String viewName) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFont(new Font("Arial", Font.PLAIN, 15));
        btn.setForeground(new Color(100, 100, 100));

        btn.addActionListener((ActionEvent e) -> {
            controller.showView(viewName);
            setActiveButton(btn);
        });

        return btn;
    }

    private void setActiveButton(JButton activeButton) {
        homeButton.setFont(new Font("Arial", Font.PLAIN, 15));
        homeButton.setForeground(new Color(100, 100, 100));
        workoutsButton.setFont(new Font("Arial", Font.PLAIN, 15));
        workoutsButton.setForeground(new Color(100, 100, 100));
        progressButton.setFont(new Font("Arial", Font.PLAIN, 15));
        progressButton.setForeground(new Color(100, 100, 100));
        profileButton.setFont(new Font("Arial", Font.PLAIN, 15));
        profileButton.setForeground(new Color(100, 100, 100));

        activeButton.setFont(new Font("Arial", Font.BOLD, 15));
        activeButton.setForeground(new Color(37, 99, 235));
    }
}