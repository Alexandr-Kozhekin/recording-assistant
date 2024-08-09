package by.solmed.assistant.ui.otherImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox extends JFrame {

    private static JCheckBox jCheckBox = new JCheckBox();

    public CheckBox() {
        jCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setLayout(new FlowLayout());
        add(jCheckBox);
    }

}
