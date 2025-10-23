package view.AuthUI;
import view.GrindLineUI;

import javax.swing.*;
import java.awt.*;

public class AuthUI extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;

    public AuthUI() {
        setTitle("GrindLine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon("src/Resources/pngwing.com.png");
        Image image = logoIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(image);

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(createLoginPanel(),"login");
        mainPanel.add(createSignupPanel(),"signup");

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.setBackground(Color.WHITE);
        wrapper.add(Box.createVerticalStrut(60));
        wrapper.add(logoLabel);
        wrapper.add(Box.createVerticalStrut(40));
        wrapper.add(mainPanel);
        add(wrapper);

        cardLayout.show(mainPanel,"login");
    }



    private JPanel createLoginPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panel.setBackground(Color.white);

        JLabel title = new JLabel("Login",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField usernameField = new JTextField(15);
        usernameField.setMaximumSize(new Dimension(300, 40));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(new Dimension(300, 40));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.white);
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton signupSwitch = new JButton("Create Account");
        signupSwitch.setBorderPainted(false);
        signupSwitch.setForeground(new Color(9, 171, 73));
        signupSwitch.setBackground(Color.WHITE);
        signupSwitch.setFocusPainted(false);
        signupSwitch.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(usernameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(signupSwitch);

        signupSwitch.addActionListener(_ -> cardLayout.show(mainPanel,"signup"));
        loginButton.addActionListener(_ -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter username and password!");
            } else {
                SwingUtilities.invokeLater(() -> {
                    GrindLineUI home = new GrindLineUI();
                    home.setVisible(true);
                });
                dispose();
            }
        });
    return panel;
    }

    private JPanel createSignupPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Sign Up",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField usernameField = new JTextField(15);
        usernameField.setMaximumSize(new Dimension(300, 40));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        JTextField emailField = new JTextField(15);
        emailField.setMaximumSize(new Dimension(300, 40));
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));

        JTextField passwordField = new JTextField(15);
        passwordField.setMaximumSize(new Dimension(300, 40));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBackground(Color.blue);
        signupButton.setForeground(Color.white);
        signupButton.setFocusPainted(false);
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back to Login");
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.BLUE);
        backButton.setBackground(Color.white);
        backButton.setFocusPainted(false);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(usernameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(signupButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(backButton);

        backButton.addActionListener(_ -> cardLayout.show(mainPanel,"login"));
        signupButton.addActionListener(_ -> {
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            cardLayout.show(mainPanel, "login");
        });
        return panel;
    }
}
