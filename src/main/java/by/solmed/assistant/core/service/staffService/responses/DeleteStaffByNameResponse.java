package by.solmed.assistant.core.service.staffService.responses;

public class DeleteStaffByNameResponse {

    private boolean response;

    public DeleteStaffByNameResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
