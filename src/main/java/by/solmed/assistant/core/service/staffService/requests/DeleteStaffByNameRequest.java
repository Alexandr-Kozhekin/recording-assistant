package by.solmed.assistant.core.service.staffService.requests;

public class DeleteStaffByNameRequest {

    private String firstName;

    public DeleteStaffByNameRequest(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
