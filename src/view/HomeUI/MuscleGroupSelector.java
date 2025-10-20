package view.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MuscleGroupSelector extends JPanel {
    private String selectedGroup;
    private List<JButton> buttons;
    private Consumer<String> onSelectionChange;

    public MuscleGroupSelector(String initialSelection, Consumer<String> onSelectionChange) {
        this.selectedGroup = initialSelection;
        this.onSelectionChange = onSelectionChange;
        this.buttons = new ArrayList<>();

        setLayout(new BorderLayout(0, 10));
        setBackground(Color.WHITE);

        JLabel selectorLabel = new JLabel("Select Muscle Group");
        selectorLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonsPanel.setBackground(Color.WHITE);

        String[] groups = {"Chest", "Back", "Shoulders", "Arms", "Core", "Legs", "Full Body"};
        for (String group : groups) {
            JButton btn = createMuscleButton(group);
            buttons.add(btn);
            buttonsPanel.add(btn);
        }

        add(selectorLabel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
    }

    private JButton createMuscleButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.PLAIN, 20));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        updateButtonStyle(btn, text.equals(selectedGroup));

        btn.addActionListener(e -> {
            selectedGroup = text;
            onSelectionChange.accept(text);
        });

        return btn;
    }

    public void updateSelection(String newSelection) {
        selectedGroup = newSelection;
        for (JButton btn : buttons) {
            updateButtonStyle(btn, btn.getText().equals(selectedGroup));
        }
    }

    private void updateButtonStyle(JButton btn, boolean isSelected) {
        if (isSelected) {
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.WHITE);
            btn.setBorderPainted(false);
        } else {
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
            btn.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1));
        }
    }
}
