package by.solmed.assistant.core.service.compoundService;

import by.solmed.assistant.core.db.CompoundDatabase;
import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.service.compoundService.requests.DeleteCompoundByIdRequest;
import by.solmed.assistant.core.service.compoundService.responses.DeleteCompoundByIdResponse;

public class DeleteCompoundByIdService {

    private CompoundDatabase database;

    public DeleteCompoundByIdService(CompoundDatabase database) {
        this.database = database;
    }

    public DeleteCompoundByIdResponse execute(DeleteCompoundByIdRequest request) {
        return new DeleteCompoundByIdResponse(database.deleteCompoundById((Long.parseLong(request.getId()))));
    }

}
