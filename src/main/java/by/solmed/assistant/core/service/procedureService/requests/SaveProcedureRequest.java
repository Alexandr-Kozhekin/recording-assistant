package by.solmed.assistant.core.service.procedureService.requests;

import by.solmed.assistant.core.domain.Procedure;

public class SaveProcedureRequest {

    private Procedure procedure;

    public SaveProcedureRequest(Procedure procedure) {
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }
}