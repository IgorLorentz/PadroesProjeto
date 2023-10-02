package Singleton;

import java.awt.Color;
import javax.swing.*;

public class Teste
{

    public static void main(String[] args) {
        String[] options = { "brownie", "pie", "cake" };

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.blue);
        frame.setBounds(300, 300, 500, 350);
        frame.setVisible(true);

        int dessert = JOptionPane.showOptionDialog(frame,
                "Which dessert would you like?", "Select a dessert",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("images/slime.png"),
                options, options[0]);

        if (dessert == 0) {
            JOptionPane.showMessageDialog(frame, "You chose a brownie.");
        }
        if (dessert == 1) {
            JOptionPane.showMessageDialog(frame, "You chose pie.");
        }
        if (dessert == 2) {
            JOptionPane.showMessageDialog(frame, "You chose cake.");
        }
    }
}