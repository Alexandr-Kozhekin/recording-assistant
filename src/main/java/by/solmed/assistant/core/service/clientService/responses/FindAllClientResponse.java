package by.solmed.assistant.core.service.clientService.responses;

import by.solmed.assistant.core.domain.Client;

import java.util.List;

public class FindAllClientResponse {

    private List<Client> clients;

    public FindAllClientResponse(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
}
