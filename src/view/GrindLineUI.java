package view;

import view.HomeUI.HomeUI;
import view.WorkoutsUI.WorkoutsUI;
import view.ProfileUI.ProfileUI;
import view.ProgressUI.ProgressUI;
import javax.swing.*;
import java.awt.*;

public class GrindLineUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public GrindLineUI() {
        setTitle("GrindLine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 900);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        NavigationBar navBar = new NavigationBar(this);
        mainPanel.add(navBar, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Color.WHITE);

        HomeUI homePanel = new HomeUI();
        WorkoutsUI workoutsPanel = new WorkoutsUI();
        ProgressUI progressPanel = new ProgressUI();
        ProfileUI profilePanel = new ProfileUI();

        contentPanel.add(homePanel, "Home");
        contentPanel.add(workoutsPanel, "Workouts");
        contentPanel.add(progressPanel, "Progress");
        contentPanel.add(profilePanel, "Profile");

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);

        showView("Home");
    }

    public void showView(String viewName) {
        cardLayout.show(contentPanel, viewName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GrindLineUI frame = new GrindLineUI();
            frame.setVisible(true);
        });
    }
}