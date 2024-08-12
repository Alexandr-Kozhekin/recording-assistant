package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.service.clientService.requests.DeleteClientByIdRequest;
import by.solmed.assistant.core.service.clientService.responses.DeleteClientByIdResponse;
import by.solmed.assistant.core.service.validators.CoreError;
import by.solmed.assistant.core.service.validators.DeleteClientByIdValidator;

import java.util.List;

public class DeleteClientByIdService {

    private ClientDatabase database;
    private DeleteClientByIdValidator validator;

    public DeleteClientByIdService(ClientDatabase database) {
        this.database = database;
        validator = new DeleteClientByIdValidator(database);
    }

    public DeleteClientByIdResponse execute(DeleteClientByIdRequest request) {

        List<CoreError> errorList = validator.validate(request);

        if(!errorList.isEmpty()) {
            return new DeleteClientByIdResponse(errorList);
        }

        return new DeleteClientByIdResponse(database.deleteClientById(request.getId()));
    }
}
