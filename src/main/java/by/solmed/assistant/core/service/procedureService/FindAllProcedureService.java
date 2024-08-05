package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Procedure;

import java.util.List;

public class FindAllProcedureService {

    private ProcedureDatabase database;

    public FindAllProcedureService(ProcedureDatabase database) {
        this.database = database;
    }

    public List<Procedure> execute() {
        return database.findAllProcedures();
    }
}
