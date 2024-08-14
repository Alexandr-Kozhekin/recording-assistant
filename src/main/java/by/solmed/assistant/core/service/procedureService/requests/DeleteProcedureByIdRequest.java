package by.solmed.assistant.core.service.procedureService.requests;

public class DeleteProcedureByIdRequest {

    private String id;

    public DeleteProcedureByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
