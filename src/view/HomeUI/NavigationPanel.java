package view.HomeUI;

import javax.swing.*;
import java.awt.*;

class NavigationPanel extends JPanel {

    public NavigationPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        setBackground(Color.WHITE);

        add(createNavButton(" Home"));
        add(createNavButton(" Workouts"));
        add(createNavButton(" Progress"));
        add(createNavButton(" Profile"));
    }

    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        return btn;
    }
}
