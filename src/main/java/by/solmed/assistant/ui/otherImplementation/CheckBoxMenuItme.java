package by.solmed.assistant.ui.otherImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxMenuItme extends JFrame {

    private static JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem();

    public CheckBoxMenuItme() {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setLayout(new FlowLayout());
        add(menuItem);
    }
}
