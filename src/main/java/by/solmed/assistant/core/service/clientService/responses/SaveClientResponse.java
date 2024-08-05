package by.solmed.assistant.core.service.clientService.responses;

import by.solmed.assistant.core.domain.Client;

public class SaveClientResponse {

    public Client client;

    public SaveClientResponse(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
