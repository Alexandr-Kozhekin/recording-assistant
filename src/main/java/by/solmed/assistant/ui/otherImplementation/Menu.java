package by.solmed.assistant.ui.otherImplementation;

import by.solmed.assistant.ui.button.SaveClientButton;
import by.solmed.assistant.ui.window.SwingConsole;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private static JMenu menu = new JMenu();

    private static JMenuItem
            mi1 = new JMenuItem("Save client"),
            mi2 = new JMenuItem("Test2"),
            mi3 = new JMenuItem("Test3"),
            mi4 = new JMenuItem("Test4");

    public Menu() {

        menu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingConsole.run(new SaveClientButton(), 800, 600);
            }
        });

        setLayout(new FlowLayout());
        add(menu);
        add(mi1);
        add(mi2);
        add(mi3);
        add(mi4);
    }
}
