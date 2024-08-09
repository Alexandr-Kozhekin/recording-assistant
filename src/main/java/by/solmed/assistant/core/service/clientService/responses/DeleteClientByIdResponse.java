package by.solmed.assistant.core.service.clientService.responses;

public class DeleteClientByIdResponse {

    private boolean response;

    public DeleteClientByIdResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
