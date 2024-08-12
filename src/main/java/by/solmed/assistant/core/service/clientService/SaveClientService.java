package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;
import by.solmed.assistant.core.service.clientService.responses.SaveClientResponse;
import by.solmed.assistant.core.service.validators.CoreError;
import by.solmed.assistant.core.service.validators.SaveClientValidator;

import java.util.List;

public class SaveClientService {

    private ClientDatabase clientDatabase;
    private SaveClientValidator validator = new SaveClientValidator();

    public SaveClientService(ClientDatabase database) {
        this.clientDatabase = database;
    }

    public SaveClientResponse execute(SaveClientRequest request) {

        List<CoreError> errorList = validator.validate(request);

        if(!errorList.isEmpty()) {
            return new SaveClientResponse(errorList);
        }

        Client client = new Client(request.getFirstName(), request.getLastName(), request.getGender(), request.getAge(),
                request.getPhoneNumber(), request.getEmail(), request.getState(), request.getCity(), request.getStreet(),
                request.getZip());

        clientDatabase.saveClient(client);

        return new SaveClientResponse(client);
    }
}
