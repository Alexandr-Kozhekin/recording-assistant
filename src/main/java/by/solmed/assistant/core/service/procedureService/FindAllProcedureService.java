package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.service.procedureService.responses.FindAllProcedureResponse;

public class FindAllProcedureService {

    private ProcedureDatabase database;

    public FindAllProcedureService(ProcedureDatabase database) {
        this.database = database;
    }

    public FindAllProcedureResponse execute() {
        return new FindAllProcedureResponse(database.findAllProcedures());
    }
}
