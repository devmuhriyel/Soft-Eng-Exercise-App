package view.HomeUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class ExerciseRow extends JPanel {

    public ExerciseRow(String name, String sets) {
        setLayout(new BorderLayout(10, 0));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(240, 240, 240), 1, true),
                new EmptyBorder(12, 15, 12, 15)
        ));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel setsLabel = new JLabel(sets);
        setsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        setsLabel.setForeground(Color.GRAY);

        add(nameLabel, BorderLayout.CENTER);
        add(setsLabel, BorderLayout.EAST);
    }
}
