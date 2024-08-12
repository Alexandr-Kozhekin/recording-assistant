package by.solmed.assistant.core.service.clientService.responses;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.validators.CoreError;
import by.solmed.assistant.core.service.validators.CoreResponse;

import java.util.List;

public class FindClientByNameResponse extends CoreResponse {

    private Client client;

    public FindClientByNameResponse(List<CoreError> errorList) {
        super(errorList);
    }

    public FindClientByNameResponse(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
