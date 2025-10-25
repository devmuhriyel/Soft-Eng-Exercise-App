package view.WorkoutsUI;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    public NavigationPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        setBackground(Color.WHITE);

        add(createNavButton("GrindLine Workouts", true));
        add(createNavButton("My Workouts", false));
    }

    private JButton createNavButton(String text, boolean isActive) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFont(new Font("Arial", isActive ? Font.BOLD : Font.PLAIN, 14));
        if (isActive) {
            btn.setForeground(new Color(37, 99, 235));
        }
        return btn;
    }
}