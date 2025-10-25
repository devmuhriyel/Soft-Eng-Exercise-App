package view.ProgressUI;

import javax.swing.*;
import java.awt.*;

public class ProgressUI extends JPanel {

    public ProgressUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        JLabel placeholderLabel = new JLabel("Progress View");
        placeholderLabel.setFont(new Font("Arial", Font.BOLD, 32));
        placeholderLabel.setForeground(new Color(150, 150, 150));

        JLabel subtitleLabel = new JLabel("Coming Soon");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(180, 180, 180));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setBackground(Color.WHITE);

        placeholderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelPanel.add(placeholderLabel);
        labelPanel.add(Box.createVerticalStrut(10));
        labelPanel.add(subtitleLabel);

        centerPanel.add(labelPanel);
        add(centerPanel, BorderLayout.CENTER);
    }
}