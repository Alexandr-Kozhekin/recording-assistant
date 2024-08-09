package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.service.clientService.requests.DeleteClientByIdRequest;
import by.solmed.assistant.core.service.clientService.responses.DeleteClientByIdResponse;

public class DeleteClientByIdService {

    private ClientDatabase database;

    public DeleteClientByIdService(ClientDatabase database) {
        this.database = database;
    }

    public DeleteClientByIdResponse execute(DeleteClientByIdRequest request) {
        return new DeleteClientByIdResponse(database.deleteClientById(request.getId()));
    }
}
