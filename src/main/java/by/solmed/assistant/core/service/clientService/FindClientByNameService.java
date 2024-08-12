package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.requests.FindClientByNameRequest;
import by.solmed.assistant.core.service.clientService.responses.FindClientByNameResponse;
import by.solmed.assistant.core.service.validators.CoreError;
import by.solmed.assistant.core.service.validators.FindClientValidator;

import java.util.List;
import java.util.Optional;

public class FindClientByNameService {

    private ClientDatabase database;
    private FindClientValidator validator;

    public FindClientByNameService(ClientDatabase database) {
        this.database = database;
        validator = new FindClientValidator(database);
    }

    public FindClientByNameResponse execute(FindClientByNameRequest request) {

        List<CoreError> errorList = validator.validate(request);

        if(!errorList.isEmpty()) {
            return new FindClientByNameResponse(errorList);
        }

        Optional<Client> client = database.findClientByFirstName(request.getFirstName());

        return client.map(FindClientByNameResponse::new).orElse(null);
    }
}
