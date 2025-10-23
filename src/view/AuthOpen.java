package view;

import view.AuthUI.AuthUI;

import javax.swing.*;

public class AuthOpen {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            AuthUI frame = new AuthUI();
            frame.setVisible(true);
        });
    }
}
