package by.solmed.assistant.core.service.clientService.responses;

import by.solmed.assistant.core.domain.Client;

public class FindClientByNameResponse {

    private Client client;

    public FindClientByNameResponse(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
