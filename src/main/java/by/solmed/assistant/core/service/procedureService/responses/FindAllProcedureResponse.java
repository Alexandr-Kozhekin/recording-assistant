package by.solmed.assistant.core.service.procedureService.responses;

import by.solmed.assistant.core.domain.Procedure;

import java.util.List;

public class FindAllProcedureResponse {

    private List<Procedure> procedures;

    public FindAllProcedureResponse(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }
}
