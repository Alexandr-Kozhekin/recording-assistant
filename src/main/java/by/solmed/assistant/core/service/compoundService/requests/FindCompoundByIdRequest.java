package by.solmed.assistant.core.service.compoundService.requests;

public class FindCompoundByIdRequest {

    private String id;

    public FindCompoundByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
