package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.requests.FindClientByNameRequest;
import by.solmed.assistant.core.service.clientService.responses.FindClientByNameResponse;

import java.util.Optional;

public class FindClientByNameService {

    private ClientDatabase database;

    public FindClientByNameService(ClientDatabase database) {
        this.database = database;
    }

    public FindClientByNameResponse execute(FindClientByNameRequest request) {

        Optional<Client> client = database.findClientByFirstName(request.getFirstName());

        return client.map(FindClientByNameResponse::new).orElse(null);
    }
}
