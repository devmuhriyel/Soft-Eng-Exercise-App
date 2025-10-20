package view.HomeUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class BodyDiagramPanel extends JPanel {

    public BodyDiagramPanel() {
        setBackground(new Color(250, 250, 250));
        setPreferredSize(new Dimension(300, 400));
        setBorder(new LineBorder(new Color(230, 230, 230), 1));

        JLabel diagramLabel = new JLabel("Body Diagram");
        diagramLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        diagramLabel.setForeground(Color.GRAY);
        add(diagramLabel);
    }
}
