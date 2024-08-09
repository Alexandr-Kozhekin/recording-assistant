package by.solmed.assistant.core.service.clientService.requests;

public class FindClientByNameRequest {

    private String firstName;

    public FindClientByNameRequest(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}