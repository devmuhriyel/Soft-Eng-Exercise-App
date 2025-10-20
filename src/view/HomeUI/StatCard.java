package view.HomeUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class StatCard extends JPanel {

    public StatCard(String title, String value, String subtitle, String icon) {
        setLayout(new BorderLayout(10, 5));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        JPanel contentPanel = new JPanel(new BorderLayout(0, 5));
        contentPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        titleLabel.setForeground(Color.GRAY);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 11));
        subtitleLabel.setForeground(new Color(34, 197, 94));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(valueLabel, BorderLayout.CENTER);
        contentPanel.add(subtitleLabel, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);
        add(iconLabel, BorderLayout.EAST);
    }
}
