package by.solmed.assistant.core.service.compoundService.requests;

public class DeleteCompoundByIdRequest {

    private String id;

    public DeleteCompoundByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
