package by.solmed.assistant.core.service.procedureService.requests;

public class DeleteProcedureByIdRequest {

    private long id;

    public DeleteProcedureByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
