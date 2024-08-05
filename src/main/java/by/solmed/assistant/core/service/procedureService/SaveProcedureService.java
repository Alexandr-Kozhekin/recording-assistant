package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Procedure;

public class SaveProcedureService {

    private ProcedureDatabase database;

    public SaveProcedureService(ProcedureDatabase database) {
        this.database = database;
    }

    public void execute(Procedure procedure) {
        database.saveProcedure(procedure);
    }

}
