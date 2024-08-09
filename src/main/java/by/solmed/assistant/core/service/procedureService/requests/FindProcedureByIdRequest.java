package by.solmed.assistant.core.service.procedureService.requests;

public class FindProcedureByIdRequest {

    private long id;

    public FindProcedureByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
