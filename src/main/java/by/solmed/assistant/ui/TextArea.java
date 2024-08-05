package by.solmed.assistant.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TextArea extends JFrame {

    private JButton
        b1 = new JButton("Add Data"),
        b2 = new JButton("Clear Data");

    private JTextArea textArea = new JTextArea(20, 40);
    private Map<String, String> m = new HashMap<>();

    public TextArea() {

        m.put("Test1", "test1");
        m.put("Test2", "test2");
        m.put("Test3", "test3");
        m.put("Test4", "test4");
        m.put("Test5", "test5");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry me : m.entrySet()) {
                    textArea.append(me.getKey() + ": " + me.getValue() + "\n");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(b1);
        add(b2);
    }

}
