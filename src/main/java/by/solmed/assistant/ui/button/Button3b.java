package by.solmed.assistant.ui.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button3b extends JFrame {

    private static JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2"),
            b3 = new JButton("Button 3");

    private static JTextField txt = new JTextField(10);

    private static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };

    public Button3b() {
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }

}
