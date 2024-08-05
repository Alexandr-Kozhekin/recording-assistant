package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Client;

import java.util.*;

public class ClientDatabaseImpl implements ClientDatabase {

    private long clientId = 0L;
    private List<Client> clients;

    {
        clients = new ArrayList<>();
        clients.add(new Client(1L, "Test1", "Test1", "Test1", 13));
        clients.add(new Client(2L, "Test2", "Test2", "Test2", 15));
        clientId = clients.size();
    }

    @Override
    public void saveClient(Client client) {
        clientId++;
        client.setId(clientId);
        clients.add(client);
    }

    @Override
    public boolean deleteClientById(long id) {
        return clients.removeIf(c -> c.getId() == id);
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
