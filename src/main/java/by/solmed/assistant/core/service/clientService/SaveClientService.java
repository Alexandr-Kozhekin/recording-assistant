package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;
import by.solmed.assistant.core.service.clientService.responses.SaveClientResponse;

public class SaveClientService {

    private ClientDatabase clientDatabase;

    public SaveClientService(ClientDatabase database) {
        this.clientDatabase = database;
    }

    public SaveClientResponse execute(SaveClientRequest request) {

        Client client = new Client(request.getFirstName(), request.getLastName(), request.getGender(), request.getAge(),
                request.getPhoneNumber(), request.getEmail(), request.getState(), request.getCity(), request.getStreet(),
                request.getZip());

        clientDatabase.saveClient(client);

        return new SaveClientResponse(client);
    }
}
