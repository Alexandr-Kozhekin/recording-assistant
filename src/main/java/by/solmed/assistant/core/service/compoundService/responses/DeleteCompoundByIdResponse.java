package by.solmed.assistant.core.service.compoundService.responses;

public class DeleteCompoundByIdResponse {

    private boolean response;

    public DeleteCompoundByIdResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
