package by.solmed.assistant.ui.button;

import by.solmed.assistant.ui.window.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2 extends JFrame {

    private JButton
        b1 = new JButton("Button 1"),
        b2 = new JButton("Button 2");

    private JTextField txt = new JTextField(10);

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            txt.setText(name);
        }
    }

    private ButtonListener buttonListener = new ButtonListener();

    public Button2() {
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2(), 200, 150);
    }
}
