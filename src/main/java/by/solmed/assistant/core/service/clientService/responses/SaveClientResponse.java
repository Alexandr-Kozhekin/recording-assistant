package by.solmed.assistant.core.service.clientService.responses;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.validators.CoreError;
import by.solmed.assistant.core.service.validators.CoreResponse;

import java.util.List;

public class SaveClientResponse extends CoreResponse {

    public Client client;

    public SaveClientResponse(List<CoreError> errorList) {
        super(errorList);
    }

    public SaveClientResponse(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
