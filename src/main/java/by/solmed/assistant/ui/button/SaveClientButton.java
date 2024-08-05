package by.solmed.assistant.ui.button;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.db.ClientDatabaseImpl;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.FindAllClientService;
import by.solmed.assistant.core.service.clientService.SaveClientService;
import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveClientButton extends JFrame {

    private static ClientDatabase database = new ClientDatabaseImpl();
    private static SaveClientService saveClientService = new SaveClientService(database);
    private static FindAllClientService findAllClientService = new FindAllClientService(database);

    private static JButton b1 = new JButton("Save client");
    private static JButton b2 = new JButton("Get clients");

    private static JTextField
            f1 = new JTextField(15),
            f2 = new JTextField(15),
            f3 = new JTextField(15),
            f4 = new JTextField(15);

    private static JTextArea textArea = new JTextArea(20, 50);

    public SaveClientButton() {

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SaveClientRequest request = new SaveClientRequest(f1.getText(), f2.getText(),
                        f3.getText(), Integer.parseInt(f4.getText()));

                saveClientService.execute(request);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Client c : findAllClientService.execute().getClients()) {
                    textArea.append(c.getId() + " | " + c.getFirstName() + " " + c.getLastName() + " " + c.getAge() + "\n");
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(b1);
        add(b2);
        add(f1);
        add(f2);
        add(f3);
        add(f4);
    }

}
