package view.HomeUI;
import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JPanel topBar = createTopBar();
        JPanel welcomePanel = createWelcomePanel();

        add(topBar, BorderLayout.NORTH);
        add(welcomePanel, BorderLayout.SOUTH);
    }

    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);

        JLabel logo = new JLabel(" GrindLine");
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        logo.setForeground(new Color(37, 99, 235));

        NavigationPanel navPanel = new NavigationPanel();

        JButton startButton = new JButton("Start Workout");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setFont(new Font("Arial", Font.BOLD, 12));
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topBar.add(logo, BorderLayout.WEST);
        topBar.add(navPanel, BorderLayout.CENTER);
        topBar.add(startButton, BorderLayout.EAST);

        return topBar;
    }

    private JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(Color.WHITE);
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JLabel welcomeLabel = new JLabel("Welcome back, Alex!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));

        JLabel subtitleLabel = new JLabel("Ready to crush your fitness goals today?");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.GRAY);

        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomePanel.add(subtitleLabel, BorderLayout.CENTER);

        return welcomePanel;
    }
}
