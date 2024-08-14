package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ClientDatabaseImpl implements ClientDatabase {

    private long clientId = 0L;
    private List<Client> clients = new ArrayList<>();
    private final String FILE_NAME = "src/main/java/by/solmed/assistant/saves/client_save.out";

    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            clients = (List<Client>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveClient(Client client) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            clientId++;
            client.setId(clientId);
            clients.add(client);
            oos.writeObject(clients);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean deleteClientById(long id) {
        boolean result = clients.removeIf(c -> c.getId() == id);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(clients);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Client> findClientByFirstName(String firstName) {
        return clients.stream()
                .filter(c -> c.getFirstName().equals(firstName))
                .findFirst();
    }

    @Override
    public List<Client> findAllClient() {
        return clients;
    }
}
