package controller;

import view.*;
import view.WorkoutsUI.WorkoutsUI;

import javax.swing.*;
import java.awt.*;

public class GrindLineUI extends JFrame {
    public GrindLineUI() {
        setTitle("FitTrack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 900);
        setLocationRelativeTo(null);

        // Main container
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Add WorkoutsUI
        WorkoutsUI workoutsUI = new WorkoutsUI();
        mainPanel.add(workoutsUI, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            view.GrindLineUI frame = new view.GrindLineUI();
            frame.setVisible(true);
        });
    }
}
