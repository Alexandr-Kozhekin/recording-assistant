package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.domain.Client;

import java.util.Optional;

public class FindClientByNameService {

    private ClientDatabase database;

    public FindClientByNameService(ClientDatabase database) {
        this.database = database;
    }

    public Client execute(String firstName) {

        Optional<Client> client = database.findClientByFirstName(firstName);

        return client.isPresent() ? client.get() : null;
    }
}
