package by.solmed.assistant.core.service.staffService.requests;

public class FindStaffByFirstNameRequest {

    private String firstName;

    public FindStaffByFirstNameRequest(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}