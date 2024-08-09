package by.solmed.assistant.core.service.procedureService.responses;

public class DeleteProcedureByIdResponse {

    private boolean response;

    public DeleteProcedureByIdResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
