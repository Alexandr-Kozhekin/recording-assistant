package by.solmed.assistant.core.service.procedureService.responses;

import by.solmed.assistant.core.domain.Procedure;

public class SaveProcedureResponse {

    private Procedure procedure;

    public SaveProcedureResponse(Procedure procedure) {
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }
}
