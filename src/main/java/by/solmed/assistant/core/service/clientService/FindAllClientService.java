package by.solmed.assistant.core.service.clientService;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.service.clientService.responses.FindAllClientResponse;

public class FindAllClientService {

    private ClientDatabase database;

    public FindAllClientService(ClientDatabase database) {
        this.database = database;
    }

    public FindAllClientResponse execute() {
        return new FindAllClientResponse(database.findAllClient());
    }
}
