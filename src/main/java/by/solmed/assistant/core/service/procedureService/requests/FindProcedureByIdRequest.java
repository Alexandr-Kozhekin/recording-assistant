package by.solmed.assistant.core.service.procedureService.requests;

public class FindProcedureByIdRequest {

    private String id;

    public FindProcedureByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
