package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Procedure;

import java.util.Optional;

public class FindProcedureByIdService {

    private ProcedureDatabase database;

    public FindProcedureByIdService(ProcedureDatabase database) {
        this.database = database;
    }

    public Procedure execute(long id) {

        Optional<Procedure> procedure = database.findProcedureById(id);

        return procedure.isPresent() ? procedure.get() : null;
    }
}
