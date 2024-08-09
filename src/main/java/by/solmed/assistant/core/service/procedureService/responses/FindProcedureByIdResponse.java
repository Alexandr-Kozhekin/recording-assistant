package by.solmed.assistant.core.service.procedureService.responses;

import by.solmed.assistant.core.domain.Procedure;

public class FindProcedureByIdResponse {

    private Procedure procedure;

    public FindProcedureByIdResponse(Procedure procedure) {
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }

}
