package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.service.procedureService.requests.FindProcedureByIdRequest;
import by.solmed.assistant.core.service.procedureService.responses.FindProcedureByIdResponse;

import java.util.Optional;

public class FindProcedureByIdService {

    private ProcedureDatabase database;

    public FindProcedureByIdService(ProcedureDatabase database) {
        this.database = database;
    }

    public FindProcedureByIdResponse execute(FindProcedureByIdRequest request) {

        Optional<Procedure> procedure = database.findProcedureById(Long.parseLong(request.getId()));

        return procedure.map(FindProcedureByIdResponse::new).orElse(null);
    }
}
