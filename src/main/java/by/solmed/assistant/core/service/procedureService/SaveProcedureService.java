package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.service.procedureService.requests.SaveProcedureRequest;

public class SaveProcedureService {

    private ProcedureDatabase database;

    public SaveProcedureService(ProcedureDatabase database) {
        this.database = database;
    }

    public void execute(SaveProcedureRequest request) {
        database.saveProcedure(request.getProcedure());
    }

}
