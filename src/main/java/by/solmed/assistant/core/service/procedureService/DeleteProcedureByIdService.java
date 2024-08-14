package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.service.procedureService.requests.DeleteProcedureByIdRequest;
import by.solmed.assistant.core.service.procedureService.responses.DeleteProcedureByIdResponse;

public class DeleteProcedureByIdService {

    private ProcedureDatabase database;

    public DeleteProcedureByIdService(ProcedureDatabase database) {
        this.database = database;
    }

    public DeleteProcedureByIdResponse execute(DeleteProcedureByIdRequest request) {
        return new DeleteProcedureByIdResponse(database.deleteProcedureById(Long.parseLong(request.getId())));
    }

}
