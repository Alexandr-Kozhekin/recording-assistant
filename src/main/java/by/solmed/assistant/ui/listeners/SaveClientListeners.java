package by.solmed.assistant.ui.listeners;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.db.ClientDatabaseImpl;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.DeleteClientByIdService;
import by.solmed.assistant.core.service.clientService.FindClientByNameService;
import by.solmed.assistant.core.service.clientService.SaveClientService;
import by.solmed.assistant.core.service.clientService.requests.DeleteClientByIdRequest;
import by.solmed.assistant.core.service.clientService.requests.FindClientByNameRequest;
import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;
import by.solmed.assistant.core.service.clientService.responses.DeleteClientByIdResponse;
import by.solmed.assistant.core.service.clientService.responses.FindClientByNameResponse;
import by.solmed.assistant.core.service.clientService.responses.SaveClientResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static by.solmed.assistant.ui.window.SwingConsole.run;

public class SaveClientListeners extends JFrame {

    private final ClientDatabase database = new ClientDatabaseImpl();
    private final SaveClientService saveClientService = new SaveClientService(database);
    private final FindClientByNameService findClientByNameService = new FindClientByNameService(database);
    private final DeleteClientByIdService deleteClientByIdService = new DeleteClientByIdService(database);

    private List<Client> list = new ArrayList<>();

    private JTextField
            firstName = new JTextField(10),
            lastName = new JTextField(10),
            gender = new JTextField(10),
            age = new JTextField(10),
            phoneNumber = new JTextField(10),
            email = new JTextField(10),
            state = new JTextField(10),
            city = new JTextField(10),
            street = new JTextField(10),
            zip = new JTextField(10);

    private JTextField
            findClient = new JTextField(10),
            deleteClient = new JTextField(10);

    private JTextField resultClient = new JTextField(80);

    private JButton saveClient = new JButton("Добавить");
    private JTextArea clientsList = new JTextArea(20, 15);


    class SaveClientL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            SaveClientRequest request = new SaveClientRequest(firstName.getText(), lastName.getText(), gender.getText(),
                    Integer.parseInt(age.getText()), phoneNumber.getText(), email.getText(),
                    state.getText(), city.getText(), street.getText(), zip.getText());
            SaveClientResponse response = saveClientService.execute(request);

            if(response != null && response.client != null) {
                list.add(response.getClient());

                clientsList.append(response.getClient().getId() + "| " + response.getClient().getFirstName()
                        + " " + response.getClient().getLastName() + " " + response.getClient().getGender()
                        + " " + response.getClient().getAge() + "\n");
            }
        }

    }

    class FindClientsL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FindClientByNameRequest request = new FindClientByNameRequest(findClient.getText());
            FindClientByNameResponse response = findClientByNameService.execute(request);

            if(response != null && response.getClient() != null) {
                resultClient.setText(response.getClient().toString());
            }

        }
    }

    class DeleteClientL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteClientByIdRequest request = new DeleteClientByIdRequest(Long.parseLong(deleteClient.getText()));
            DeleteClientByIdResponse response = deleteClientByIdService.execute(request);

            if (response != null && response.isResponse()) {
                list.removeIf(c -> c.getId() == request.getId());
            }
        }
    }

    public SaveClientListeners() {
        SaveClientL saveClientL = new SaveClientL();
        FindClientsL findClientsL = new FindClientsL();
        DeleteClientL deleteClientL = new DeleteClientL();

        saveClient.addActionListener(saveClientL);
        deleteClient.addActionListener(deleteClientL);
        findClient.addActionListener(findClientsL);

        list = database.findAllClient();
        clientsList.setText("");
        if(!list.isEmpty())
            for(Client client : list)
                clientsList.append(client.getId() + "| " + client.getFirstName() + " " + client.getLastName()
                        + " " + client.getGender() + " " + client.getAge() + "\n");

        setLayout(new FlowLayout());
        add(new Label("Имя"));
        add(firstName);
        add(new Label("Фамилия"));
        add(lastName);
        add(new Label("Пол"));
        add(gender);
        add(new Label("Возраст"));
        add(age);
        add(new Label("Номер телефона"));
        add(phoneNumber);
        add(new Label("Электронная почта"));
        add(email);
        add(new Label("Страна"));
        add(state);
        add(new Label("Город"));
        add(city);
        add(new Label("Улица"));
        add(street);
        add(new Label("Почтовый индекс"));
        add(zip);

        add(BorderLayout.CENTER, saveClient);
        add(new Label("Найти"));
        add(BorderLayout.CENTER, findClient);
        add(new Label("Удалить"));
        add(BorderLayout.CENTER, deleteClient);

        add(BorderLayout.CENTER, resultClient);

        add(BorderLayout.SOUTH, clientsList);

    }

    public static void main(String[] args) {
        run(new SaveClientListeners(), 1024, 500);
    }

}
