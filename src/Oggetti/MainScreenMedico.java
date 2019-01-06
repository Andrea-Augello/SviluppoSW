package Oggetti;

import javax.swing.*;

public class MainScreenMedico extends MainScreen {
    private JList list1;
    private JPanel panel;

    public MainScreenMedico() {
        JFrame frame = new JFrame("SPRINT");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
