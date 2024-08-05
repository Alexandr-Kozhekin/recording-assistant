package by.solmed.assistant.ui.button;

import by.solmed.assistant.ui.window.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class Button extends JFrame {

    private JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");

    public Button() {
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button(), 200, 100);
    }
}
